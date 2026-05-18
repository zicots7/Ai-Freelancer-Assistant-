package com.freelancerSmartProposal.SmartProposal.ProposalService;
import com.freelancerSmartProposal.SmartProposal.ProposalRequestDto;
import com.freelancerSmartProposal.SmartProposal.ProposalResponseDto;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ProposalService {
    private final ChatClient chatClient;


    public ProposalService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public ProposalResponseDto generateProposalWithAi(ProposalRequestDto request) {
        String systemInstruction = "You are an expert freelance technical writer. Respond strictly in structured JSON matching the requested fields.";

        String userPromptTemplate = """
                Generate a comprehensive freelance project proposal using these criteria:
                - Project Domain: {projectType}
                - Functional Requirements: {clientRequirements}
                - Target Technology Stack: {techStack}
                - Developer Professional Experience: {freelancerExperience}
                
                Provide a realistic phase breakdown inside the timeline map based on the technology complexity.
                Offer an estimated cost bracket appropriate for the regional market and experience level.
                """;

        return chatClient.prompt()
                .system(systemInstruction)
                .user(userSpec ->userSpec
                                .text(userPromptTemplate)
                                .param("projectType",request.getProjectType())
                                .param("clientRequirements",request.getClientRequirements())
                                .param("techStack",request.getTechStack())
                                .param("freelancerExperience",request.getFreelancerExperience())
                )
                .call()
                .entity(ProposalResponseDto.class);
    }
}

