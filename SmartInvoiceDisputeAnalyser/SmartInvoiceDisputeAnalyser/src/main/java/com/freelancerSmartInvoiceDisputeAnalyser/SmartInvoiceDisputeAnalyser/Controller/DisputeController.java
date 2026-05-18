package com.freelancerSmartInvoiceDisputeAnalyser.SmartInvoiceDisputeAnalyser.Controller;

import com.freelancerSmartInvoiceDisputeAnalyser.SmartInvoiceDisputeAnalyser.Dtos.DisputeRequestDto;
import com.freelancerSmartInvoiceDisputeAnalyser.SmartInvoiceDisputeAnalyser.Dtos.DisputeResponseDto;
import com.freelancerSmartInvoiceDisputeAnalyser.SmartInvoiceDisputeAnalyser.Service.DisputeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ai/dispute")
@Tag(name = "Invoice Dispute Resolver", description = "AI legal analysis endpoints for handling independent contract disagreements")
public class DisputeController {
    private final DisputeService disputeService;
    public DisputeController(DisputeService disputeService) {
        this.disputeService = disputeService;
    }
    @Operation(
            summary = "Analyse contract dispute via Gemini",
            description = "Processes a client's payment-withholding argument against original contractual scope items. Returns actionable liability insights and messaging templates."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Dispute successfully processed and parsed by AI engine.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = DisputeResponseDto.class)) }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid payload configuration. Missing mandatory evaluation fields.",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Upstream AI service communication failure or JSON parsing exception.",
                    content = @Content
            )
    })
    @PostMapping("/sendDispute")
    public ResponseEntity<DisputeResponseDto>SendResponse(@RequestBody DisputeRequestDto request){
        DisputeResponseDto disputeResponseDto = disputeService.ResolveDispute(request);
        return ResponseEntity.ok(disputeResponseDto);
    }
}
