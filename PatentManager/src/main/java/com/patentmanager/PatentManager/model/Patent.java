package com.patentmanager.PatentManager.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "patents")
public class Patent {
    @Schema(example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(example = "isim")
    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @Schema(example = "açıklama")
    @Column(name = "description", length = 200, nullable = false)
    private String description;

    // Parametresiz constructor (Zorunlu)
    public Patent() {}

    // Parametreli constructor (Opsiyonel)
    public Patent(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // Getter ve Setter Metotları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}