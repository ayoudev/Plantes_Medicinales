package com.pfa.backend.controller;

import com.pfa.backend.entity.Plante;
import com.pfa.backend.service.PlanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plantes")
public class PlanteController {

    private final PlanteService planteService;

    @Autowired
    public PlanteController(PlanteService planteService) {
        this.planteService = planteService;
    }

    @PostMapping("/add")
    public Plante createPlante(@RequestBody Plante plante) {
        return planteService.createPlante(plante);
    }
    @GetMapping
    public List<Plante> getAllPlantes() {
        return planteService.getAllPlantes();
    }

    @GetMapping("/search")
    public List<Plante> searchPlantes(@RequestParam(required = false) String nom,
                                      @RequestParam(required = false) String propriete,
                                      @RequestParam(required = false) String utilisation,
                                      @RequestParam(required = false) String region) {
        return planteService.searchPlantes(nom, propriete, utilisation, region);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plante> getPlanteById(@PathVariable Long id) {
        return planteService.getPlanteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePlante(@PathVariable Long id) {
        planteService.deletePlante(id);
        return ResponseEntity.noContent().build();
    }
}
