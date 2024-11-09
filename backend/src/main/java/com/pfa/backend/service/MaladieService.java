package com.pfa.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pfa.backend.entity.Maladie;
import com.pfa.backend.repository.MaladieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MaladieService {
    @Autowired
    private MaladieRepository maladieRepository;

    public List<Maladie> getAllMaladies() {
        return maladieRepository.findAll();
    }

    public Optional<Maladie> getMaladieById(Long id) {
        return maladieRepository.findById(id);
    }

    public Maladie createMaladie(Maladie maladie) {
        return maladieRepository.save(maladie);
    }

    public void deleteMaladie(Long id) {
        maladieRepository.deleteById(id);
    }
}
