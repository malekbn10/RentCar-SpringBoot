package com.projet.LocationVoiture.dao.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.LocationVoiture.dao.entities.Client;
import com.projet.LocationVoiture.dao.entities.Operation;


@Repository
public interface OperationRepository extends JpaRepository<Operation,Long> {
    Optional<Operation> findByNomClient(Client nomClient);
}