package com.pfa.backend.service;

import com.pfa.backend.entity.Commentaire;
import com.pfa.backend.entity.Plante;
import com.pfa.backend.repository.CommentaireRepository;
import com.pfa.backend.repository.PlanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentaireService {

    private final CommentaireRepository commentaireRepository;
    private final PlanteRepository planteRepository;

    @Autowired
    public CommentaireService(CommentaireRepository commentaireRepository, PlanteRepository planteRepository) {
        this.commentaireRepository = commentaireRepository;
        this.planteRepository = planteRepository;
    }

    public List<Commentaire> getCommentairesByPlanteId(Long planteId) {
        return commentaireRepository.findByPlanteId(planteId);
    }

    public Optional<Commentaire> addCommentaireToPlante(Long planteId, Commentaire commentaire) {
        Optional<Plante> plante = planteRepository.findById(planteId);
        if (plante.isPresent()) {
            commentaire.setPlante(plante.get());
            return Optional.of(commentaireRepository.save(commentaire));
        }
        return Optional.empty();
    }
}
