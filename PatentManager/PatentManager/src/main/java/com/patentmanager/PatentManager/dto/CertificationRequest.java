package com.patentmanager.PatentManager.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public class CertificationRequest {
    @Schema(example = "1")
    private Long authorId;
    @Schema(example = "1")
    private Long patentId;
    @Schema(example = "YYYY-MM-DD")
    private LocalDate issueDate;
    @Schema(example = "40")
    private int durationInYears;

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getPatentId() {
        return patentId;
    }

    public void setPatentId(Long patentId) {
        this.patentId = patentId;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public int getDurationInYears() {
        return durationInYears;
    }

    public void setDurationInYears(int durationInYears) {
        this.durationInYears = durationInYears;
    }
}
