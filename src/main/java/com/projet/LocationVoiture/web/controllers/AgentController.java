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

import com.projet.LocationVoiture.business.services.IAgentService;
import com.projet.LocationVoiture.dao.entities.Agent;
import com.projet.LocationVoiture.web.models.requests.AgentForm;

public class AgentController {
     @Autowired
    IAgentService agentService;

    //Retrieving All Agents
    @GetMapping
    public ResponseEntity<Object> getAllAgent(){
        return new ResponseEntity<>(this.agentService.getAllAgent(),HttpStatus.OK);
    }
     // Retriving Agent By Name
    @GetMapping("{name}")
    public ResponseEntity<Object> getAgent(@PathVariable("name") String name) {
        Optional<Agent> agent = agentService.getAgent(name);
        if (agent.isPresent()) {
            return new ResponseEntity<>(agent.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed: Agent not found", HttpStatus.NOT_FOUND);
        }

    }

    // Adding an Agent
    @PostMapping()
    public ResponseEntity<Object> addAgent(@RequestBody() AgentForm agentForm) {
        agentService.addAgent(new Agent(agentForm.getCin(), agentForm.getName(), agentForm.getPassword(), agentForm.getDate_naissance(), agentForm.getGenre()));
        return new ResponseEntity<>("Agent is successfully Created!", HttpStatus.CREATED);
    }

    // Updating an Operation
    @PutMapping("{name}")
    public ResponseEntity<Object> updateAgent(@RequestBody AgentForm agentForm,
            @PathVariable("name") String name ) {
        Optional<Agent> agent = agentService.getAgent(name);
        if (agent.isPresent()) {
            agent.get().setCin(agentForm.getCin());
            agent.get().setName(agentForm.getName());
            agent.get().setPassword(agentForm.getPassword());
            agent.get().setDate_naissance(agentForm.getDate_naissance());
            agent.get().setGenre(agentForm.getGenre());

            return new ResponseEntity<>("Agent is updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed: Agent not found", HttpStatus.NOT_FOUND);
        }
    }

    // Deleting an Operation
    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteVoiture(@PathVariable("id") String name) {
        Optional<Agent> agent = agentService.getAgent(name);

        if (agent.isPresent()) {
            agentService.deleteAgent(agent.get().getCin());
            return new ResponseEntity<>("Agent is deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Failed: Agent not found", HttpStatus.NOT_FOUND);
    }

}