package com.freelancerSmartProposal.SmartProposal;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
import java.util.Map;


@Schema(description = "Input requirements sent to Gemini to generate custom freelance project documents")
public class ProposalRequestDto {
    @Schema(description = "The target category or niche of the application", example = "E-Commerce System", requiredMode = Schema.RequiredMode.REQUIRED)
    private String projectType;

    @Schema(description = "Key features, pages, or logic components requested by the client", example = "Product catalog, Stripe payment gateway, and a mobile-responsive UI.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String clientRequirements;

    @Schema(description = "Frameworks, languages, and databases requested for implementation", example = "Django, Python, PostgreSQL, TailwindCSS", requiredMode = Schema.RequiredMode.REQUIRED)
    private String techStack;

    @Schema(description = "The professional background and seniority of the developer creating the doc", example = "2 years of backend software development experience", requiredMode = Schema.RequiredMode.REQUIRED)
    private String freelancerExperience;
    public ProposalRequestDto(){}

    public ProposalRequestDto(String projectType, String clientRequirements, String techStack, String freelancerExperience) {
        this.projectType = projectType;
        this.clientRequirements = clientRequirements;
        this.techStack = techStack;
        this.freelancerExperience = freelancerExperience;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getClientRequirements() {
        return clientRequirements;
    }

    public void setClientRequirements(String clientRequirements) {
        this.clientRequirements = clientRequirements;
    }

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    public String getFreelancerExperience() {
        return freelancerExperience;
    }

    public void setFreelancerExperience(String freelancerExperience) {
        this.freelancerExperience = freelancerExperience;
    }



}
