package com.pfa.backend.controller;

import com.pfa.backend.entiey.Plante;
import com.pfa.backend.repository.PlanteRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plantes")
public class PlanteController {
    @Autowired
    private PlanteRepository planteRepository;

    @GetMapping
    public List<Plante> getAllPlantes() {
        return planteRepository.findAll();
    }

    @GetMapping("/search")
    public List<Plante> searchPlantes(@RequestParam(required = false) String nom,
                                      @RequestParam(required = false) String propriete,
                                      @RequestParam(required = false) String utilisation,
                                      @RequestParam(required = false) String region) {
        return planteRepository.searchPlantes(nom, propriete, utilisation, region);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plante> getPlanteById(@PathVariable Long id) {
        return planteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
