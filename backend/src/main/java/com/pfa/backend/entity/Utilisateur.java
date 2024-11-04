package com.pfa.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    private String antecedentsMedicaux;
}

