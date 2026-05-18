package com.freelancerSmartProposal.SmartProposal;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
import java.util.Map;

@Schema(description = "The complete structured proposal schema populated by Gemini AI")
public class ProposalResponseDto {
    @Schema(description = "A catchy, professional title for the freelance proposal", example = "Production-Ready E-Commerce Architecture Development Proposal")
    private String proposalTitle;

    @Schema(description = "High-level overview summary selling the freelancer's technical approach", example = "This proposal outlines a phased implementation plan for a scalable online store application...")
    private String executiveSummary;

    @Schema(description = "Itemized breakdown of what functional engineering works will be performed")
    private List<String> scopeOfWork;

    @Schema(description = "Map of developmental phases linked to milestones", example = "{\"Phase 1\": \"Database modeling & infrastructure initialization (Week 1)\"}")
    private Map<String, String> timeline;

    @Schema(description = "Estimated financial pricing bracket structured for local context", example = "₹35,000 - ₹50,000")
    private String estimatedCost;

    @Schema(description = "Explicit, tangible items delivered to the client at handover stages")
    private List<String> deliverables;

    @Schema(description = "Payment milestones, liability waivers, and revision limit frameworks")
    private String termsAndConditions;
    public ProposalResponseDto(){}

    public ProposalResponseDto(String proposalTitle, String executiveSummary, List<String> scopeOfWork, Map<String, String> timeline, String estimatedCost, List<String> deliverables, String termsAndConditions) {
        this.proposalTitle = proposalTitle;
        this.executiveSummary = executiveSummary;
        this.scopeOfWork = scopeOfWork;
        this.timeline = timeline;
        this.estimatedCost = estimatedCost;
        this.deliverables = deliverables;
        this.termsAndConditions = termsAndConditions;
    }

    public String getProposalTitle() {
        return proposalTitle;
    }

    public void setProposalTitle(String proposalTitle) {
        this.proposalTitle = proposalTitle;
    }

    public String getExecutiveSummary() {
        return executiveSummary;
    }

    public void setExecutiveSummary(String executiveSummary) {
        this.executiveSummary = executiveSummary;
    }

    public List<String> getScopeOfWork() {
        return scopeOfWork;
    }

    public void setScopeOfWork(List<String> scopeOfWork) {
        this.scopeOfWork = scopeOfWork;
    }

    public Map<String, String> getTimeline() {
        return timeline;
    }

    public void setTimeline(Map<String, String> timeline) {
        this.timeline = timeline;
    }

    public String getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(String estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public List<String> getDeliverables() {
        return deliverables;
    }

    public void setDeliverables(List<String> deliverables) {
        this.deliverables = deliverables;
    }

    public String getTermsAndConditions() {
        return termsAndConditions;
    }

    public void setTermsAndConditions(String termsAndConditions) {
        this.termsAndConditions = termsAndConditions;
    }

}
