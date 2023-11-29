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

import com.projet.LocationVoiture.business.services.IVoitureService;
import com.projet.LocationVoiture.dao.entities.Voiture;
import com.projet.LocationVoiture.web.models.requests.VoitureForm;

@RestController
@RequestMapping("/voitures")
public class VoitureController {

    // Retrieving All Cars
    @Autowired
    IVoitureService voitureService;

    @GetMapping()
    public ResponseEntity<Object> getAllVoiture() {
        return new ResponseEntity<>(this.voitureService.getAllVoiture(), HttpStatus.OK);
    }

    // Retriving Cars By Marque
    @GetMapping("{marque}")
    public ResponseEntity<Object> findByMarque(@PathVariable("marque") String marque) {
        Optional<Voiture> voiture = voitureService.findByMarque(marque);
        if (voiture.isPresent()) {
            return new ResponseEntity<>(voiture.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed: Voiture not found", HttpStatus.NOT_FOUND);
        }

    }

    // Adding a Car
    @PostMapping()
    public ResponseEntity<Object> addVoiture(@RequestBody() VoitureForm voitureForm) {
        voitureService.addVoiture(new Voiture(voitureForm.getImmatricule(), voitureForm.getMarque(),
                voitureForm.getDate_mise_circulation(), voitureForm.getPrixLoc(), voitureForm.getImage()));
        return new ResponseEntity<>("Voiture is successfully Created!", HttpStatus.CREATED);
    }

    // Updating a Car
    @PutMapping("{immatricule}")
    public ResponseEntity<Object> updateVoiture(@RequestBody VoitureForm voitureForm,
            @PathVariable("immatricule") String Immatricule) {
        Optional<Voiture> voiture = voitureService.getVoiture(Immatricule);
        if (voiture.isPresent()) {
            voiture.get().setPrixLoc(voitureForm.getPrixLoc());
            voiture.get().setImage(voitureForm.getImage());
            return new ResponseEntity<>("Car is updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed: Car not found", HttpStatus.NOT_FOUND);
        }
    }

    // Deleting a Car
    @DeleteMapping("{immatricule}")
    public ResponseEntity<Object> deleteVoiture(@PathVariable("immatricule") String Immatricule) {
        Optional<Voiture> voiture = voitureService.getVoiture(Immatricule);

        if (voiture.isPresent()) {
            voitureService.deleteVoiture(voiture.get().getImmatricule());
            return new ResponseEntity<>("Car is deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Failed: Car not found", HttpStatus.NOT_FOUND);
    }

}