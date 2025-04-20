package com.patentmanager.PatentManager.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @Schema(example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID'nin otomatik artmasını sağlar
    private Long id;

    @Schema(example = "isim")
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Schema(example = "adres")
    @Column(name = "address", length = 100, nullable = false)
    private String address;

    // Parametresiz constructor (Zorunlu)
    public Author() {}

    // Parametreli constructor (Opsiyonel)
    public Author(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Getter ve Setter Metotları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
