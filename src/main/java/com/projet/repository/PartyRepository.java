package com.projet.repository;

import com.projet.entity.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PartyRepository extends JpaRepository<Party, Long> {
    List<Party> findByName(String name);
}
