package com.master.football_game.services;

import com.master.football_game.entities.Arbitre;
import com.master.football_game.repositories.ArbitreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArbitreServiceImpl implements ArbitreService{
    @Autowired
    private ArbitreRepository arbitreRepository ;

    @Override
    public List<Arbitre> getAllArbitres() {
        return arbitreRepository.findAll();
    }

    @Override
    public Arbitre getArbitreById(Long id) {
        return arbitreRepository.findById(id).orElse(null);
    }

    @Override
    public Arbitre saveArbitre(Arbitre arbitre) {
        return arbitreRepository.save(arbitre);
    }

    @Override
    public Arbitre updateArbitre(Arbitre arbitre) {

        Arbitre arbit = arbitreRepository.findById(arbitre.getIdArbitre()).orElse(null)  ;
        arbit.setNom(arbitre.getNom());
        arbit.setNationalite(arbit.getNationalite());
        return arbitreRepository.save(arbit);
    }

    @Override
    public void deleteByIdArbitre(Long id) {
        arbitreRepository.deleteById(id);
    }
}
