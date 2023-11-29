package com.projet.LocationVoiture.dao.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Agent")
@AllArgsConstructor
@Getter
@Setter
public class Agent{
    @Id
    @Column(name = "cin")
    private Long cin;


    @Column(name = "name", length = 30, nullable = false,unique =false)
    private String name;

    @Column(name = "password", length = 30, nullable = false,unique =false)
    private String password;
    
    @Column(name = "date_naissance")
    @Temporal(TemporalType.DATE)
    private Date date_naissance;


    @Column(name = "genre", length = 5, nullable = false,unique =false)
    private String genre; 
    
    
}