package com.projet.LocationVoiture.dao.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.LocationVoiture.dao.entities.Voiture;

public interface VoitureRepository extends JpaRepository<Voiture,String> {
    Optional<Voiture> findByMarque(String marque);
}