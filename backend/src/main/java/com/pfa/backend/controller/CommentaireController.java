package com.pfa.backend.controller;

import com.pfa.backend.entity.Commentaire;
import com.pfa.backend.service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/commentaires")
public class CommentaireController {

    private final CommentaireService commentaireService;

    @Autowired
    public CommentaireController(CommentaireService commentaireService) {
        this.commentaireService = commentaireService;
    }

    @GetMapping("/plante/{planteId}")
    public List<Commentaire> getCommentairesByPlanteId(@PathVariable Long planteId) {
        return commentaireService.getCommentairesByPlanteId(planteId);
    }

    @PostMapping("/plante/{planteId}")
    public Commentaire addCommentaire(@PathVariable Long planteId, @RequestBody Commentaire commentaire) {
        Optional<Commentaire> savedCommentaire = commentaireService.addCommentaireToPlante(planteId, commentaire);
        return savedCommentaire.orElseThrow(() -> new RuntimeException("La plante avec l'ID " + planteId + " n'a pas été trouvée."));
    }
}