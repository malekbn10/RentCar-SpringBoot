package com.projet.LocationVoiture.business.services;

import java.util.List;
import java.util.Optional;

import com.projet.LocationVoiture.dao.entities.Client;

public interface IClientService {
    
    public Optional<Client> getClient(Long cin);
    public void addClient (Client c);
    public void updateClient (Client c);
    public void deleteClient (Long cin);
    public List<Client> getAllClient();
}