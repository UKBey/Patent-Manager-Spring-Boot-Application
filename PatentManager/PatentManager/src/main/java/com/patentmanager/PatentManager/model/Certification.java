package com.patentmanager.PatentManager.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "certifications")
public class Certification {

    @Schema(example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @Schema(example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    @ManyToOne
    @JoinColumn(name = "patent_id", nullable = false)
    private Patent patent;

    @Schema(example = "YYYY-MM-DD")
    @Column(name = "issue_date", nullable = false)
    private LocalDate issueDate;

    @Schema(example = "40")
    @Column(name = "duration", nullable = false)
    private int durationInYears;

    // ✅ Getter ve Setter Metotlarını Manuel Ekleyelim
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Patent getPatent() {
        return patent;
    }

    public void setPatent(Patent patent) {
        this.patent = patent;
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
