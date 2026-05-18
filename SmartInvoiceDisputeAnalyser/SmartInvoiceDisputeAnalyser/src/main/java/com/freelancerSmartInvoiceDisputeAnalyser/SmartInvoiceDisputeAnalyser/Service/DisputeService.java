package com.freelancerSmartInvoiceDisputeAnalyser.SmartInvoiceDisputeAnalyser.Service;

import com.freelancerSmartInvoiceDisputeAnalyser.SmartInvoiceDisputeAnalyser.Dtos.DisputeRequestDto;
import com.freelancerSmartInvoiceDisputeAnalyser.SmartInvoiceDisputeAnalyser.Dtos.DisputeResponseDto;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class DisputeService {
    private final ChatClient chatClient;
    public DisputeService(ChatClient.Builder chatClientBuilder){
        this.chatClient = chatClientBuilder.build();
    }
    public DisputeResponseDto ResolveDispute(DisputeRequestDto request){
        String systemInstruction = "You are an expert freelance legal advisor, mediator, and contract specialist. Analyze the conflict and return a structured JSON response matching the fields exactly.";
        String userPromptTemplate = """
        Analyze this freelance contract dispute and provide an objective evaluation:
        - Project Scope/Details: {projectDetails}
        - Total Agreed Amount: ₹{agreedAmount}
        - Official Scope Deliverables: {deliverables}
        - Client's Stated Dispute/Complaint: {clientDispute}
        
        Evaluate the 'disputeValidity' on a scale of 1-10 (where 10 means the client is completely right, and 1 means the client is making excuses).
        Identify any 'redFlags' where the client is being subjective or making demands outside the listed deliverables.
        Provide a strategic 'suggestedResponse' and 'negotiationStrategy' to settle this professionally.
        """;
        return chatClient.prompt()
                .system(systemInstruction)
                .user(userSpec -> userSpec
                        .text(userPromptTemplate)
                        .param("projectDetails", request.getProjectDetails())
                        .param("agreedAmount", request.getAgreedAmount())
                        .param("deliverables", request.getDeliverables())
                        .param("clientDispute", request.getClientDispute())
                )
                .call()
                .entity(DisputeResponseDto.class);
    }
}
