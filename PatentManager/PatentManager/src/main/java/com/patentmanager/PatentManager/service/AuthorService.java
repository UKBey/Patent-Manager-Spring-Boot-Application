package com.patentmanager.PatentManager.service;

import com.patentmanager.PatentManager.exception.AuthorNotFoundException;
import com.patentmanager.PatentManager.exception.AuthorDeletionNotAllowedException;
import com.patentmanager.PatentManager.model.Author;
import com.patentmanager.PatentManager.repository.AuthorRepository;
import com.patentmanager.PatentManager.repository.CertificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final CertificationRepository certificationRepository;

    public AuthorService(AuthorRepository authorRepository, CertificationRepository certificationRepository) {
        this.authorRepository = authorRepository;
        this.certificationRepository = certificationRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(AuthorNotFoundException::new);
    }

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author updateAuthor(Long id, Author authorDetails) {
        return authorRepository.findById(id).map(author -> {
            author.setName(authorDetails.getName());
            author.setAddress(authorDetails.getAddress());
            return authorRepository.save(author);
        }).orElseThrow(AuthorNotFoundException::new);
    }

    public void deleteAuthor(Long id) {
        if (!authorRepository.existsById(id)) {
            throw new AuthorNotFoundException();
        }

        if (certificationRepository.existsByAuthorId(id)) {
            throw new AuthorDeletionNotAllowedException();
        }

        authorRepository.deleteById(id);
    }
}
