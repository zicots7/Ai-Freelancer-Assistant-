package com.freelancerSmartProposal.SmartProposal.proposalController;
import com.freelancerSmartProposal.SmartProposal.ProposalRequestDto;
import com.freelancerSmartProposal.SmartProposal.ProposalResponseDto;
import com.freelancerSmartProposal.SmartProposal.ProposalService.ProposalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/ai")
@Tag(name = "AI Proposal Generator", description = "Endpoints for interacting with Gemini LLM to generate freelance documentation")
public class ProposalController {
    private final ProposalService proposalService;
    public ProposalController(ProposalService proposalService) {
        this.proposalService= proposalService;
    }
    @PostMapping("/generateProposal")
    @Operation(
            summary = "Generate a structured freelance proposal",
            description = "Accepts project parameters from Django and feeds them into Gemini to build a fully structured, multi-phase project proposal object."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Proposal successfully generated and formatted into a structured response schema.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ProposalResponseDto.class)) }
            ),
            @ApiResponse(responseCode = "400", description = "Invalid client payload. Required request attributes are missing.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Upstream AI processing timeout or schema parsing failure.", content = @Content)
    })
    public ResponseEntity<ProposalResponseDto>generateProposal(@RequestBody ProposalRequestDto request){
    ProposalResponseDto response = proposalService.generateProposalWithAi(request);
    return  ResponseEntity.ok(response);
    }

}
