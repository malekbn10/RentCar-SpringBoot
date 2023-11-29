package com.projet.LocationVoiture.business.services;

import java.util.List;
import java.util.Optional;

import com.projet.LocationVoiture.dao.entities.Client;
import com.projet.LocationVoiture.dao.entities.Operation;

public interface IOperationService {
    
    public Optional<Operation> getOperation(Client nomClient);
    public Optional<Operation> getOperationById(Long id);

    public void addOperation (Operation o);
    public void updateOperation (Operation o);
    public void deleteOperation (Long id);
    public List<Operation> getAllOperation();

}