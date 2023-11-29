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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.LocationVoiture.business.services.IClientService;
import com.projet.LocationVoiture.dao.entities.Client;
import com.projet.LocationVoiture.web.models.requests.ClientForm;
@RestController
@RequestMapping("/clients")
public class ClientController {
     // Retrieving All Clients
    @Autowired
    IClientService clientService;

    @GetMapping()
    public ResponseEntity<Object> getAllVoiture() {
        return new ResponseEntity<>(this.clientService.getAllClient(), HttpStatus.OK);
    }

    // Retriving Client By Name
    @GetMapping("{marque}")
    public ResponseEntity<Object> getClient(@PathVariable("name") Long cin) {
        Optional<Client> client = clientService.getClient(cin);
        if (client.isPresent()) {
            return new ResponseEntity<>(client.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed: Client not found", HttpStatus.NOT_FOUND);
        }

    }

    // Adding a Client
    @PostMapping()
    public ResponseEntity<Object> addVoiture(@RequestBody() ClientForm clientForm) {
        clientService.addClient(new Client(clientForm.getCin(), clientForm.getName(), clientForm.getDate_naissance(), clientForm.getGenre()) );
        return new ResponseEntity<>("Client is successfully Created!", HttpStatus.CREATED);
    }

    // Updating a Client
    @PutMapping("{cin}")
    public ResponseEntity<Object> updateVoiture(@RequestBody ClientForm clientForm,
            @PathVariable("cin") Long cin) {
        Optional<Client> client = clientService.getClient(cin);
        if (client.isPresent()) {
            client.get().setCin(clientForm.getCin());
            client.get().setName(clientForm.getName());
            client.get().setDate_naissance(clientForm.getDate_naissance());
            client.get().setGenre(clientForm.getGenre());
        
            return new ResponseEntity<>("Client is updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed: Client not found", HttpStatus.NOT_FOUND);
        }
    }

    // Deleting a Car
    @DeleteMapping("{cin}")
    public ResponseEntity<Object> deleteVoiture(@PathVariable("cin") Long cin) {
        Optional<Client> client = clientService.getClient(cin);

        if (client.isPresent()) {
            clientService.deleteClient(client.get().getCin());
            return new ResponseEntity<>("Client is deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Failed: Client not found", HttpStatus.NOT_FOUND);
    }
}