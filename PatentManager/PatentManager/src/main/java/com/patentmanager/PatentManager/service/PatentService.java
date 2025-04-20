package com.patentmanager.PatentManager.service;

import com.patentmanager.PatentManager.exception.PatentNotFoundException;
import com.patentmanager.PatentManager.exception.PatentDeletionNotAllowedException;
import com.patentmanager.PatentManager.model.Patent;
import com.patentmanager.PatentManager.repository.PatentRepository;
import com.patentmanager.PatentManager.repository.CertificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatentService {

    private final PatentRepository patentRepository;
    private final CertificationRepository certificationRepository;

    // Constructor injection ile CertificationRepository ekleniyor
    public PatentService(PatentRepository patentRepository, CertificationRepository certificationRepository) {
        this.patentRepository = patentRepository;
        this.certificationRepository = certificationRepository;
    }

    public List<Patent> getAllPatents() {
        return patentRepository.findAll();
    }

    public Patent getPatentById(Long id) {
        return patentRepository.findById(id)
                .orElseThrow(PatentNotFoundException::new);
    }

    public Patent createPatent(Patent patent) {
        return patentRepository.save(patent);
    }

    public Patent updatePatent(Long id, Patent patentDetails) {
        return patentRepository.findById(id).map(patent -> {
            patent.setTitle(patentDetails.getTitle());
            patent.setDescription(patentDetails.getDescription());
            return patentRepository.save(patent);
        }).orElseThrow(PatentNotFoundException::new);
    }

    public void deletePatent(Long id) {
        if (!patentRepository.existsById(id)) {
            throw new PatentNotFoundException();
        }

        // Artık certificationRepository üzerinden doğru çağrı yapılabilir
        if (certificationRepository.existsByPatentId(id)) {
            throw new PatentDeletionNotAllowedException();
        }

        patentRepository.deleteById(id);
    }
}
