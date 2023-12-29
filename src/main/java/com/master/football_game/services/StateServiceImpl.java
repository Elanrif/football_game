package com.master.football_game.services;

import com.master.football_game.entities.Stade;
import com.master.football_game.repositories.StadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StateServiceImpl implements StadeService{

    @Autowired
    private StadeRepository stadeRepository;


    @Override
    public List<Stade> getAllStades() {
        return stadeRepository.findAll();
    }

    @Override
    public Stade getStadeById(Long id) {
        return stadeRepository.findById(id).orElse(null);
    }

    @Override
    public Stade saveStade(Stade stade) {
        return stadeRepository.save(stade);
    }

    @Override
    public Stade updateStade(Stade stade) {

        Stade stad = stadeRepository.findById(stade.getIdStade()).orElse(null);
        stad.setNomStade(stade.getNomStade());
        stad.setVille(stade.getVille());
        return stadeRepository.save(stad);
    }

    @Override
    public void deleteByIdStade(Long id) {
        stadeRepository.deleteById(id);
    }

    @Override
    public Stade findByMatchesIdMatch(Long idMatch) {
        return stadeRepository.findByMatchesIdMatch(idMatch);
    }
}
