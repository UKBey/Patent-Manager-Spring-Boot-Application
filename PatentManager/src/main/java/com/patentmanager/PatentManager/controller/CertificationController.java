package com.patentmanager.PatentManager.controller;

import com.patentmanager.PatentManager.dto.CertificationRequest;
import com.patentmanager.PatentManager.model.Author;
import com.patentmanager.PatentManager.model.Certification;
import com.patentmanager.PatentManager.model.Patent;
import com.patentmanager.PatentManager.service.AuthorService;
import com.patentmanager.PatentManager.service.CertificationService;
import com.patentmanager.PatentManager.service.PatentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/certifications")
@Tag(name = "Certifications API", description = "CRUD Operations for Certification")
public class CertificationController {

    private final CertificationService certificationService;
    private final AuthorService authorService;
    private final PatentService patentService;

    public CertificationController(CertificationService certificationService, AuthorService authorService, PatentService patentService) {
        this.certificationService = certificationService;
        this.authorService = authorService;
        this.patentService = patentService;
    }

    @GetMapping
    @Operation(summary = "Get All Certifications", description = "Returns all certifications from database.")
    public ResponseEntity<List<Certification>> getAllCertifications() {
        return ResponseEntity.ok(certificationService.getAllCertifications());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Certification by ID", description = "Returns certification with the given ID from database.")
    public ResponseEntity<Certification> getCertificationById(@PathVariable Long id) {
        return ResponseEntity.ok(certificationService.getCertificationById(id));
    }

    @PostMapping
    @Operation(summary = "Create New Certification", description = "Adds new certification to database.")
    public ResponseEntity<Certification> createCertification(@RequestBody CertificationRequest request) {
        Author author = authorService.getAuthorById(request.getAuthorId());
        Patent patent = patentService.getPatentById(request.getPatentId());

        Certification certification = new Certification();
        certification.setAuthor(author);
        certification.setPatent(patent);
        certification.setIssueDate(request.getIssueDate() != null ? request.getIssueDate() : java.time.LocalDate.now());
        certification.setDurationInYears(request.getDurationInYears());

        Certification savedCertification = certificationService.createCertification(certification);
        return ResponseEntity.ok(savedCertification);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Certification by ID", description = "Updates certification with the given ID in database.")
    public ResponseEntity<Certification> updateCertification(@PathVariable Long id, @RequestBody CertificationRequest request) {
        Author author = authorService.getAuthorById(request.getAuthorId());
        Patent patent = patentService.getPatentById(request.getPatentId());

        Certification updatedCertification = new Certification();
        updatedCertification.setAuthor(author);
        updatedCertification.setPatent(patent);
        updatedCertification.setIssueDate(request.getIssueDate() != null ? request.getIssueDate() : java.time.LocalDate.now());
        updatedCertification.setDurationInYears(request.getDurationInYears());

        Certification savedCertification = certificationService.updateCertification(id, updatedCertification);
        return ResponseEntity.ok(savedCertification);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Certification by ID", description = "Deletes certification with the given ID from database.")
    public ResponseEntity<Void> deleteCertification(@PathVariable Long id) {
        certificationService.deleteCertification(id);
        return ResponseEntity.noContent().build();
    }
}