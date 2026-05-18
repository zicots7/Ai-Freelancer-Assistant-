package com.freelancerMilestoneRiskPredictor.MilestoneRiskPredictor.Controller;

import com.freelancerMilestoneRiskPredictor.MilestoneRiskPredictor.Dtos.MilestoneRiskPredictRequest;
import com.freelancerMilestoneRiskPredictor.MilestoneRiskPredictor.Dtos.MilestoneRiskPredictResponse;
import com.freelancerMilestoneRiskPredictor.MilestoneRiskPredictor.Service.MilestoneRiskPredictService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai/risk")
public class MilestoneRiskPredictController {
    private final MilestoneRiskPredictService milestoneRiskPredictService;
    public MilestoneRiskPredictController(MilestoneRiskPredictService milestoneRiskPredictService) {
        this.milestoneRiskPredictService = milestoneRiskPredictService;
    }
    @Operation(
            summary = "Calculate active project delivery risk metrics",
            description = "Compares elapsed milestone timelines against development metrics via Gemini AI to formulate automated project health risk assessments."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Risk tracking metrics computed successfully.",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = MilestoneRiskPredictResponse.class)) }
            ),
            @ApiResponse(responseCode = "400", description = "Invalid telemetry inputs provided.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal processing engine breakdown.", content = @Content)
    })
    @PostMapping("/predictRisk")
    public ResponseEntity<MilestoneRiskPredictResponse>CreateResponse(@RequestBody MilestoneRiskPredictRequest request) {
        MilestoneRiskPredictResponse response =  milestoneRiskPredictService.Predict(request);
        return ResponseEntity.ok(response);
    }
}
