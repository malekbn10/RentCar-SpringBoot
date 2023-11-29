package com.projet.LocationVoiture.business.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.projet.LocationVoiture.business.services.IOperationService;
import com.projet.LocationVoiture.dao.entities.Client;
import com.projet.LocationVoiture.dao.entities.Operation;
import com.projet.LocationVoiture.dao.repositories.OperationRepository;

public class OperationServiceImpl implements IOperationService {
    
    @Autowired
    OperationRepository operationRepository;
    @Override
    public Optional<Operation> getOperation(Client nomClient) {
        return operationRepository.findByNomClient(nomClient);
    }

    @Override
    public void addOperation(Operation o) {
        operationRepository.save(o);
    }

    @Override
    public void updateOperation(Operation o) {
        operationRepository.save(o);
    }

    @Override
    public void deleteOperation(Long id) {
        operationRepository.deleteById(id);
    }

    @Override
    public List<Operation> getAllOperation() {
        return operationRepository.findAll();
     }

    @Override
    public Optional<Operation> getOperationById(Long id) {
        return operationRepository.findById(id);
    }
    
}