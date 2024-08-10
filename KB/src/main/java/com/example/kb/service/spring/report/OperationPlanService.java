package com.example.kb.service.spring.report;

import com.example.kb.dto.spring.GptRequest;
import com.example.kb.dto.spring.GptResponse;
import com.example.kb.entity.spring.report.OperationPlan;
import com.example.kb.repository.primary.report.OperationPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OperationPlanService {

    @Value("${chatGptApiUrl}")
    private String chatGptApiUrl;

    @Value("${chatGptApiKey}")
    private String chatGptApiKey;

    private final RestTemplate restTemplate;
    private final OperationPlanRepository operationPlanRepository;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OperationPlanService(@Qualifier("primaryJdbcTemplate")JdbcTemplate jdbcTemplate, OperationPlanRepository operationPlanRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.restTemplate = new RestTemplate();
        this.operationPlanRepository = operationPlanRepository;
    }

    public String generateAndSaveOperationPlan(String fundName, String operationPeriod, List<String> newsSummaries) throws IOException {
        String planPrompt = createOperationPlanPrompt(fundName, operationPeriod, newsSummaries);
        String planDetails = requestGptResponse(planPrompt);
        saveOperationPlan(fundName, operationPeriod, planDetails);
        return planDetails;
    }

    private String getPreviousOperationPlanFromDB(String fundName, String operationPeriod) {
        // 데이터베이스에서 쿼리 실행하여 결과 가져오기
        String sql = "SELECT Plan_Details FROM operation_plan WHERE Fund_Name = ? AND Operation_Period != ?;";
        return jdbcTemplate.queryForObject(sql, new Object[]{fundName, operationPeriod}, String.class);
    }

    private String requestGptResponse(String prompt) throws IOException {
        GptRequest gptRequest = new GptRequest("gpt-4o", prompt);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + chatGptApiKey);
        headers.set("Content-Type", "application/json");

        HttpEntity<GptRequest> requestEntity = new HttpEntity<>(gptRequest, headers);
        ResponseEntity<GptResponse> responseEntity = restTemplate.exchange(
                chatGptApiUrl + "/chat/completions",
                HttpMethod.POST,
                requestEntity,
                GptResponse.class
        );

        if (responseEntity.getStatusCode().is2xxSuccessful() && responseEntity.getBody() != null) {
            return responseEntity.getBody().getChoices().get(0).getMessage().getContent().trim();
        } else {
            throw new IOException("Unexpected response status: " + responseEntity.getStatusCode());
        }
    }

    private String createOperationPlanPrompt(String fundName, String operationPeriod, List<String> newsSummaries) {
        String articlesText = newsSummaries.stream().collect(Collectors.joining("\n"));
        String plan = getPreviousOperationPlanFromDB(fundName, operationPeriod);
        return String.format(
                "펀드 이름: %s\n운용 기간: %s\n관련 뉴스 요약:\n%s\n 이전 버전의 운용계획은 %s \n위 정보를 바탕으로 펀드의 향후 운용 계획을 작성해 주세요.",
                fundName, operationPeriod, articlesText, plan
        );

//                String prompt = String.format(
//                "펀드 이름: %s\n운용 기간: %s\n관련 뉴스 요약:\n%s\n 이전 버전의 운용계획은 %s \n위 정보를 바탕으로 펀드의 향후 운용 계획을 작성해 주세요.",
//                fundName, operationPeriod, articlesText, plan
//        );
//
//        // 생성된 프롬프트를 콘솔에 출력
//        System.out.println("생성된 프롬프트:\n" + prompt);
//
//        return prompt;
    }

    private void saveOperationPlan(String fundName, String operationPeriod, String planDetails) {
        OperationPlan plan = new OperationPlan();
        plan.setFundName(fundName);
        plan.setOperationPeriod(operationPeriod);
        plan.setPlanDetails(planDetails);
        operationPlanRepository.save(plan);
    }
}
