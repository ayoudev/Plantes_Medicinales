package com.pfa.backend.controller;

import com.pfa.backend.entiey.Plante;
import com.pfa.backend.repository.PlanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recommandations")
public class RecommandationController {
    @Autowired
    private PlanteRepository planteRepository;

    @GetMapping("/{userId}")
    public List<Plante> getRecommandations(@PathVariable Long userId) {
        return null;
    }
}