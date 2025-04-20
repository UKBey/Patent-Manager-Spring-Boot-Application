package com.patentmanager.PatentManager.controller;

import com.patentmanager.PatentManager.model.Patent;
import com.patentmanager.PatentManager.service.PatentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patents")
@Tag(name = "Patents API", description = "CRUD Operations for Patents")
public class PatentController {

    private final PatentService patentService;

    public PatentController(PatentService patentService) {
        this.patentService = patentService;
    }

    @GetMapping
    @Operation(summary = "Get All Patents", description = "Returns all patents from database.")
    public ResponseEntity<List<Patent>> getAllPatents() {
        return ResponseEntity.ok(patentService.getAllPatents());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Patent by ID", description = "Returns patent with the given ID from database.")
    public ResponseEntity<Patent> getPatentById(@PathVariable Long id) {
        return ResponseEntity.ok(patentService.getPatentById(id));
    }

    @PostMapping
    @Operation(summary = "Create New Patent", description = "Adds new patent to database.")
    public ResponseEntity<Patent> createPatent(@RequestBody Patent patent) {
        return ResponseEntity.ok(patentService.createPatent(patent));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Patent by ID", description = "Updates patent with the given ID in database.")
    public ResponseEntity<Patent> updatePatent(@PathVariable Long id, @RequestBody Patent patentDetails) {
        return ResponseEntity.ok(patentService.updatePatent(id, patentDetails));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Patent by ID", description = "Deletes patent with the given ID from database.")
    public ResponseEntity<Void> deletePatent(@PathVariable Long id) {
        patentService.deletePatent(id);
        return ResponseEntity.noContent().build();
    }
}