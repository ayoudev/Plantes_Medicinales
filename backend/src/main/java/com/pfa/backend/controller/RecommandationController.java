package com.pfa.backend.controller;

import com.pfa.backend.entity.Plante;
import com.pfa.backend.service.RecommandationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recommandations")
public class RecommandationController {

    private final RecommandationService recommandationService;

    @Autowired
    public RecommandationController(RecommandationService recommandationService) {
        this.recommandationService = recommandationService;
    }

    @GetMapping("/{userId}")
    public List<Plante> getRecommandations(@PathVariable Long userId) {
        return recommandationService.getRecommandations(userId);
    }
}
