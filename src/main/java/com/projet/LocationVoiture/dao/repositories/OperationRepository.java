package com.projet.LocationVoiture.dao.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.LocationVoiture.dao.entities.Client;
import com.projet.LocationVoiture.dao.entities.Operation;



public interface OperationRepository extends JpaRepository<Operation,Long> {
    Optional<Operation> findByNomClient(Client nomClient);
}