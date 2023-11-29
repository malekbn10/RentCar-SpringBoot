package com.projet.LocationVoiture.business.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.projet.LocationVoiture.business.services.IAgentService;
import com.projet.LocationVoiture.dao.entities.Agent;
import com.projet.LocationVoiture.dao.repositories.AgentRepository;

public class AgentServiceImpl implements IAgentService {
    @Autowired
    AgentRepository agentRepository;
   
    @Override
    public Optional<Agent> getAgent(String name) {
        return agentRepository.findByName(name);
    }
    @Override
    public void addAgent(Agent a) {
        agentRepository.save(a);
    }
    @Override
    public void updateAgent(Agent a) {
        agentRepository.save(a);
    }
    @Override
    public void deleteAgent(Long cin) {
        agentRepository.deleteById(cin);

    }
    @Override
    public List<Agent> getAllAgent() {
        return agentRepository.findAll();
    }

    
}