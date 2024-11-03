package com.pfa.backend.entiey;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String contenu;

    @ManyToOne
    @JoinColumn(name = "plante_id")
    private Plante plante;

}