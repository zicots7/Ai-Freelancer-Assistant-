package com.freelancerMilestoneRiskPredictor.MilestoneRiskPredictor.Service;

import com.freelancerMilestoneRiskPredictor.MilestoneRiskPredictor.Dtos.MilestoneRiskPredictRequest;
import com.freelancerMilestoneRiskPredictor.MilestoneRiskPredictor.Dtos.MilestoneRiskPredictResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class MilestoneRiskPredictService {
    private final ChatClient chatClient;
    public MilestoneRiskPredictService(ChatClient.Builder chatClientBuilder){
        this.chatClient = chatClientBuilder.build();
    }
    public MilestoneRiskPredictResponse Predict(MilestoneRiskPredictRequest request){
        String systemInstruction = "You are an expert project management office (PMO) controller and risk analyst. Analyze the provided metrics and return a structured JSON response matching the fields exactly.";

        String userPromptTemplate = """
            Perform a critical risk analysis for the project milestone tracking under these active constraints:
            - Project Unique Identifier: {projectId}
            - Historical Client Payment Delays: {clientPaymentHistory}
            - Target Hard Deadline: {currentMilestoneDeadline}
            - Real Development Progress Complete: {completionPercentage}%
            - Days Spent So Far: {daysElapsed} out of {totalDays} total days
            - Delays Encountered on Previous Milestones: {previousMilestoneDelays}
            
            Mathematically calculate the severity of risk on a scale of 0-100 (riskScore) by comparing the fraction of time elapsed vs work finished.
            Isolate the 'primaryRiskFactors' and supply clear actionable 'recommendation' and 'escalationAdvice' strategies.
            """;
        return chatClient.prompt()
                .system(systemInstruction)
                .user(userSpec -> userSpec
                        .text(userPromptTemplate)
                        .param("projectId", request.getProjectId())
                        .param("clientPaymentHistory", request.getClientPaymentHistory())
                        .param("currentMilestoneDeadline", request.getCurrentMilestoneDeadline())
                        .param("completionPercentage", request.getCompletionPercentage())
                        .param("daysElapsed", request.getDaysElapsed())
                        .param("totalDays", request.getTotalDays())
                        .param("previousMilestoneDelays", request.getPreviousMilestoneDelays())
                )
                .call()
                .entity(MilestoneRiskPredictResponse.class);
    }
}
