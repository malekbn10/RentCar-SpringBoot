package com.projet.LocationVoiture.web.models.requests;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AgentForm {
    
    private Long cin;
    private String name;
    private String password;
    private Date date_naissance;
    private String genre; 

}