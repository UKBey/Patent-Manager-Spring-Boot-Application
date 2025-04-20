package com.patentmanager.PatentManager.repository;

import com.patentmanager.PatentManager.model.Certification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificationRepository extends JpaRepository<Certification, Long> {
    boolean existsByPatentId(Long patentId);
    boolean existsByAuthorId(Long authorId);

}
