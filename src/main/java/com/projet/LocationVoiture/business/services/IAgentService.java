package com.projet.LocationVoiture.business.services;

import java.util.List;
import java.util.Optional;

import com.projet.LocationVoiture.dao.entities.Agent;

public interface IAgentService {
    public Optional<Agent> getAgent(String name);
    public void addAgent (Agent a);
    public void updateAgent (Agent a);
    public void deleteAgent (Long cin);
    public List<Agent> getAllAgent();
}