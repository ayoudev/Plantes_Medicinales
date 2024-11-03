package com.pfa.backend.repository;

import com.pfa.backend.entiey.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
    List<Commentaire> findByPlanteId(Long planteId);
}
