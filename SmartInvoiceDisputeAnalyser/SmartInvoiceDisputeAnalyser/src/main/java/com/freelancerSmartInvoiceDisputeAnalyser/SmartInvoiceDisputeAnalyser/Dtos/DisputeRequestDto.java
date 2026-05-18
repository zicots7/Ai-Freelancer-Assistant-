package com.freelancerSmartInvoiceDisputeAnalyser.SmartInvoiceDisputeAnalyser.Dtos;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Payload containing project details and client objections for AI dispute evaluation")
public class DisputeRequestDto {
    @Schema(
            description = "A detailed outline of what was completed versus original agreements",
            example = "Built landing page, 5 pages total, mobile responsive layout optimized for all viewports.",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String projectDetails;

    @Schema(
            description = "The financial milestone valuation agreed upon in the contract (in INR)",
            example = "15000",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private int agreedAmount;

    @Schema(
            description = "The exact complaint, email text, or justification provided by the client withholding payment",
            example = "The website doesn't work on mobile and colors are wrong. I won't pay.",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String clientDispute;

    @Schema(
            description = "List of formalized explicit scope items from the contract agreement",
            example = "[\"5 pages\", \"responsive design\", \"working contact form\"]",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private List<String> deliverables;
    public DisputeRequestDto(String projectDetails,
                             int agreedAmount,
                             String clientDispute,
                             List<String> deliverables) {
        this.projectDetails = projectDetails;
        this.agreedAmount = agreedAmount;
        this.clientDispute = clientDispute;
        this.deliverables = deliverables;
    }

    public String getProjectDetails() {
        return projectDetails;
    }

    public void setProjectDetails(String projectDetails) {
        this.projectDetails = projectDetails;
    }

    public int getAgreedAmount() {
        return agreedAmount;
    }

    public void setAgreedAmount(int agreedAmount) {
        this.agreedAmount = agreedAmount;
    }

    public String getClientDispute() {
        return clientDispute;
    }

    public void setClientDispute(String clientDispute) {
        this.clientDispute = clientDispute;
    }

    public List<String> getDeliverables() {
        return deliverables;
    }

    public void setDeliverables(List<String> deliverables) {
        this.deliverables = deliverables;
    }


}
