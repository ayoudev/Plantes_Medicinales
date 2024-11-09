package com.pfa.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pfa.backend.entity.Maladie;
import com.pfa.backend.service.MaladieService;

import java.util.List;

@RestController
@RequestMapping("/api/maladies")
public class MaladieController {
    @Autowired
    private MaladieService maladieService;

    @GetMapping
    public List<Maladie> getAllMaladies() {
        return maladieService.getAllMaladies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maladie> getMaladieById(@PathVariable Long id) {
        return maladieService.getMaladieById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Maladie createMaladie(@RequestBody Maladie maladie) {
        return maladieService.createMaladie(maladie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaladie(@PathVariable Long id) {
        maladieService.deleteMaladie(id);
        return ResponseEntity.noContent().build();
    }
}
