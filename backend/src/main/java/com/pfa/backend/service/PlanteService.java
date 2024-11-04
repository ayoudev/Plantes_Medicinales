package com.pfa.backend.service;

import com.pfa.backend.entity.Plante;
import com.pfa.backend.repository.PlanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanteService {

    private final PlanteRepository planteRepository;

    @Autowired
    public PlanteService(PlanteRepository planteRepository) {
        this.planteRepository = planteRepository;
    }

    public List<Plante> getAllPlantes() {
        return planteRepository.findAll();
    }

    public List<Plante> searchPlantes(String nom, String propriete, String utilisation, String region) {
        return planteRepository.searchPlantes(nom, propriete, utilisation, region);
    }

    public Optional<Plante> getPlanteById(Long id) {
        return planteRepository.findById(id);
    }
}
