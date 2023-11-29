package com.projet.LocationVoiture.web.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.projet.LocationVoiture.business.services.IOperationService;
import com.projet.LocationVoiture.dao.entities.Client;
import com.projet.LocationVoiture.dao.entities.Operation;
import com.projet.LocationVoiture.web.models.requests.OperationForm;

public class OperationController {
    @Autowired
    IOperationService operationService;

    //Retrieving All Operations
    @GetMapping
    public ResponseEntity<Object> getAllOperation(){
        return new ResponseEntity<>(this.operationService.getAllOperation(),HttpStatus.OK);
    }
     // Retriving Client By ClientName
    @GetMapping("{name}")
    public ResponseEntity<Object> getOperation(@PathVariable("name") Client nomClient) {
        Optional<Operation> operation = operationService.getOperation(nomClient);
        if (operation.isPresent()) {
            return new ResponseEntity<>(operation.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed: Operation not found", HttpStatus.NOT_FOUND);
        }

    }

    // Adding an Operation
    @PostMapping()
    public ResponseEntity<Object> addOperation(@RequestBody() OperationForm operationForm) {
        operationService.addOperation(new Operation(null, operationForm.getDateDebut(), operationForm.getDateFin(), operationForm.getGarantie(), operationForm.getMontantGarantie(), operationForm.getNomClient(), operationForm.getCinClient()) );
        return new ResponseEntity<>("Operation is successfully Created!", HttpStatus.CREATED);
    }

    // Updating an Operation
    @PutMapping("{name}")
    public ResponseEntity<Object> updateOperation(@RequestBody OperationForm operationForm,
            @PathVariable("name") Client nomClient) {
        Optional<Operation> operation = operationService.getOperation(nomClient);
        if (operation.isPresent()) {
            operation.get().setDateDebut(operationForm.getDateDebut());            
            operation.get().setDateFin(operationForm.getDateFin());
            operation.get().setGarantie(operationForm.getGarantie());
            operation.get().setMontantGarantie(operationForm.getMontantGarantie());
            operation.get().setNomClient(operationForm.getNomClient());
            operation.get().setCinClient(operationForm.getCinClient());
            return new ResponseEntity<>("Operation is updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed: Operation not found", HttpStatus.NOT_FOUND);
        }
    }

    // Deleting an Operation
    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteVoiture(@PathVariable("id") Long id) {
        Optional<Operation> operation = operationService.getOperationById(id);

        if (operation.isPresent()) {
            operationService.deleteOperation(operation.get().getId());
            return new ResponseEntity<>("Operation is deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Failed: Operation not found", HttpStatus.NOT_FOUND);
    }
}