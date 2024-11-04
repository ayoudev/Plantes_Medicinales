package com.pfa.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Plante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private String propriete;
    private String utilisation;
    private String precaution;
    private String regionGeographique;

    @OneToMany(mappedBy = "plante")
    private List<Image> images;

    @OneToMany(mappedBy = "plante")
    private List<Article> articles;

    @OneToMany(mappedBy = "plante")
    private List<Commentaire> commentaires;

}
