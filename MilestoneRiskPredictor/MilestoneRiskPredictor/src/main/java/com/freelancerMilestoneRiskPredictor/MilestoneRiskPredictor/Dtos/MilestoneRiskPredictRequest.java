package com.freelancerMilestoneRiskPredictor.MilestoneRiskPredictor.Dtos;

import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "Payload containing project metrics and client history for AI milestone risk calculation")
public class MilestoneRiskPredictRequest {
    @Schema(description = "Unique Identifier of the active project track", example = "4a2b8c9d-1234-5678-90ab-cdef12345678", requiredMode = Schema.RequiredMode.REQUIRED)
    private String projectId;

    @Schema(description = "Historical invoicing and timeline compliance context of the client", example = "2 late payments in 3 projects", requiredMode = Schema.RequiredMode.REQUIRED)
    private String clientPaymentHistory;

    @Schema(description = "The target calendar delivery date for the active phase (YYYY-MM-DD)", example = "2026-06-01", requiredMode = Schema.RequiredMode.REQUIRED)
    private String currentMilestoneDeadline;

    @Schema(description = "Actual code/asset development completion metrics (Percentage)", example = "45", requiredMode = Schema.RequiredMode.REQUIRED)
    private int completionPercentage;

    @Schema(description = "Total number of calendar days spent since milestone initiation", example = "18", requiredMode = Schema.RequiredMode.REQUIRED)
    private int daysElapsed;

    @Schema(description = "Total timeline buffer allocated for this complete milestone run", example = "30", requiredMode = Schema.RequiredMode.REQUIRED)
    private int totalDays;

    @Schema(description = "Count of deadlines missed by either party in previous iterations", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private int previousMilestoneDelays;

    // Default No-Args Constructor
    public MilestoneRiskPredictRequest() {}

    // Parameterized Constructor
    public MilestoneRiskPredictRequest(String projectId, String clientPaymentHistory, String currentMilestoneDeadline,
                                  int completionPercentage, int daysElapsed, int totalDays, int previousMilestoneDelays) {
        this.projectId = projectId;
        this.clientPaymentHistory = clientPaymentHistory;
        this.currentMilestoneDeadline = currentMilestoneDeadline;
        this.completionPercentage = completionPercentage;
        this.daysElapsed = daysElapsed;
        this.totalDays = totalDays;
        this.previousMilestoneDelays = previousMilestoneDelays;
    }

    // Getters and Setters
    public String getProjectId() { return projectId; }
    public void setProjectId(String projectId) { this.projectId = projectId; }

    public String getClientPaymentHistory() { return clientPaymentHistory; }
    public void setClientPaymentHistory(String clientPaymentHistory) { this.clientPaymentHistory = clientPaymentHistory; }

    public String getCurrentMilestoneDeadline() { return currentMilestoneDeadline; }
    public void setCurrentMilestoneDeadline(String currentMilestoneDeadline) { this.currentMilestoneDeadline = currentMilestoneDeadline; }

    public int getCompletionPercentage() { return completionPercentage; }
    public void setCompletionPercentage(int completionPercentage) { this.completionPercentage = completionPercentage; }

    public int getDaysElapsed() { return daysElapsed; }
    public void setDaysElapsed(int daysElapsed) { this.daysElapsed = daysElapsed; }

    public int getTotalDays() { return totalDays; }
    public void setTotalDays(int totalDays) { this.totalDays = totalDays; }

    public int getPreviousMilestoneDelays() { return previousMilestoneDelays; }
    public void setPreviousMilestoneDelays(int previousMilestoneDelays) { this.previousMilestoneDelays = previousMilestoneDelays; }
}
