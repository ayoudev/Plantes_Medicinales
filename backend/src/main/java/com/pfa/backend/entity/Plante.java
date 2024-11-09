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
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;
    @ManyToMany
    @JoinTable(
            name = "plante_maladie",
            joinColumns = @JoinColumn(name = "plante_id"),
            inverseJoinColumns = @JoinColumn(name = "maladie_id"))
    private List<Maladie> maladies;

    @OneToMany(mappedBy = "plante", cascade = CascadeType.ALL)
    private List<Article> articles;

    @OneToMany(mappedBy = "plante", cascade = CascadeType.ALL)
    private List<Image> images;

    @OneToMany(mappedBy = "plante", cascade = CascadeType.ALL)
    private List<Commentaire> commentaires;

}
