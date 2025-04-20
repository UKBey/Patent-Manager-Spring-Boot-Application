package com.patentmanager.PatentManager.service;

import com.patentmanager.PatentManager.model.Certification;
import com.patentmanager.PatentManager.repository.CertificationRepository;
import com.patentmanager.PatentManager.exception.CertificationNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificationService {

    private final CertificationRepository certificationRepository;

    public CertificationService(CertificationRepository certificationRepository) {
        this.certificationRepository = certificationRepository;
    }

    public List<Certification> getAllCertifications() {
        return certificationRepository.findAll();
    }

    public Certification getCertificationById(Long id) {
        return certificationRepository.findById(id)
                .orElseThrow(CertificationNotFoundException::new);
    }

    public Certification createCertification(Certification certification) {
        return certificationRepository.save(certification);
    }
    public Certification updateCertification(Long id, Certification updatedCertification) {
        return certificationRepository.findById(id).map(certification -> {
            certification.setAuthor(updatedCertification.getAuthor());
            certification.setPatent(updatedCertification.getPatent());
            certification.setIssueDate(updatedCertification.getIssueDate());
            certification.setDurationInYears(updatedCertification.getDurationInYears());
            return certificationRepository.save(certification);
        }).orElseThrow(() -> new RuntimeException("Certification not found with id " + id));
    }

    public void deleteCertification(Long id) {
        certificationRepository.deleteById(id);
    }
}
