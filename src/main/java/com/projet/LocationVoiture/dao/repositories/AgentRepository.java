package com.projet.LocationVoiture.dao.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.LocationVoiture.dao.entities.Agent;


public interface AgentRepository extends JpaRepository<Agent,Long> {
    Optional<Agent>  findByName(String name);
}