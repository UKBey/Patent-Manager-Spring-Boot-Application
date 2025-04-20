package com.patentmanager.PatentManager.controller;

import com.patentmanager.PatentManager.model.Author;
import com.patentmanager.PatentManager.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@Tag(name = "Authors API", description = "CRUD Operations for Authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    @Operation(summary = "Get All Authors", description = "Returns all authors from database.")
    public ResponseEntity<List<Author>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Author by ID", description = "Returns author with the given ID from database.")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }

    @PostMapping
    @Operation(summary = "Create New Author", description = "Adds new author to database.")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        return ResponseEntity.ok(authorService.createAuthor(author));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Author by ID", description = "Updates author with the given ID in database.")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author authorDetails) {
        return ResponseEntity.ok(authorService.updateAuthor(id, authorDetails));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Author by ID", description = "Deletes author with the given ID from database.")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}