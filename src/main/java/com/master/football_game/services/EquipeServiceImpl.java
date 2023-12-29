package com.master.football_game.services;

import com.master.football_game.entities.Equipe;
import com.master.football_game.entities.Matche;
import com.master.football_game.repositories.EquipeRepository;
import com.master.football_game.repositories.MatcheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EquipeServiceImpl implements EquipeService{
    @Autowired
    private EquipeRepository equipeRepository;
    @Autowired
    private MatcheRepository matcheRepository ;

    @Override
    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe getEquipeById(Long id) {
        return equipeRepository.findById(id).get();
    }

    @Override
    public Equipe saveEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @Override
    public Equipe updateEquipe(Equipe equipe) {
        Equipe equip = equipeRepository.findById(equipe.getIdEquipe()).orElse(null);
        equip.setNomEquipe(equipe.getNomEquipe());
        equip.setPays(equipe.getPays());
        return equipeRepository.save(equip);
    }

    @Override
    public void deleteByIdEquipe(Long id) {
        equipeRepository.deleteById(id);
    }

    @Override
    public List<Equipe> findByEquipesName(String nomEquipe) {
        return equipeRepository.findByPays(nomEquipe);
    }

    //question 8 , les 2 equipes du match id = 3
    @Override
    public List<Equipe> findByMatchId(Long idMatch) {

        Matche match  = matcheRepository.findById(idMatch).orElse(null) ;
        List<Equipe> equipes = new ArrayList<>() ;

        equipes.add(match.getEquipeDomicile()) ;
        equipes.add(match.getEquipeExterieur()) ;

        return equipes ;
    }
}
