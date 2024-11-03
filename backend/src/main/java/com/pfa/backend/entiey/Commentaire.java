package com.pfa.backend.entiey;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String auteur;
    private String contenu;
    private LocalDate datePublication;

    @ManyToOne
    @JoinColumn(name = "plante_id")
    private Plante plante;

    // Getters and Setters
}

