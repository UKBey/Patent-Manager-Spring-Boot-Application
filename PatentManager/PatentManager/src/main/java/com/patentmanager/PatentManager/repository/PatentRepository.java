package com.patentmanager.PatentManager.repository;

import com.patentmanager.PatentManager.model.Patent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatentRepository extends JpaRepository<Patent, Long> {
}
