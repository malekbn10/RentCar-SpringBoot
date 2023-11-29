package com.projet.LocationVoiture.dao.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.LocationVoiture.dao.entities.Client;


public interface ClientRepository extends JpaRepository<Client,Long> {
    Optional<Client>  findByCin(Long cin);
}