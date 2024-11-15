package com.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projet.entity.Provisions;


public interface ProvisionRepository extends JpaRepository<Provisions, Long> {
}
