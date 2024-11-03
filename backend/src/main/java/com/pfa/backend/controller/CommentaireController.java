package com.pfa.backend.controller;

import com.pfa.backend.entiey.Commentaire;
import com.pfa.backend.entiey.Plante;
import com.pfa.backend.repository.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/commentaires")
public class CommentaireController {
    @Autowired
    private CommentaireRepository commentaireRepository;

    @GetMapping("{planteId}")
    public List<Commentaire> getCommentairesByPlanteId(@PathVariable Long planteId) {
        return commentaireRepository.findByPlanteId(planteId);
    }

    @PostMapping("/plante/{planteId}")
    public Commentaire addCommentaire(@PathVariable Long planteId, @RequestBody Commentaire commentaire) {

            return null;

    }
}

