package com.master.football_game.services;

import com.master.football_game.entities.Equipe;
import com.master.football_game.entities.Joueur;
import com.master.football_game.repositories.EquipeRepository;
import com.master.football_game.repositories.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JoueurServiceImpl implements JoueurService{

    @Autowired
    private JoueurRepository joueurRepository;

    @Autowired
    private EquipeRepository equipeRepository ;

    @Override
    public List<Joueur> getAllJoueurs() {
        return joueurRepository.findAll();
    }

    @Override
    public Joueur getJoueurById(Long id) {
        return joueurRepository.findById(id).orElse(null);
    }

    @Override
    public Joueur saveJoueur(String nomJoueur,String poste ,Long idEquipe) {
        Joueur player = new Joueur(null,nomJoueur,poste,null);
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);

       //helpers methodes : pour aider à la synchronisation.
        if(equipe != null)
             equipe.addJoueur(player);

        return joueurRepository.save(player);
    }

    @Override
    public Joueur updateJoueur(Long idJoueur,String nomJoueur,String poste,Long idEquipe) {

        Joueur joueur = joueurRepository.findById(idJoueur).orElse(null);
        Equipe equipe  = equipeRepository.findById(idEquipe).orElse(null);

        if(joueur !=null && equipe != null){

            joueur.setNomJoueur(nomJoueur);
            joueur.setPoste(poste);
            equipe.addJoueur(joueur);

        }

        return joueurRepository.save(joueur);
    }

    @Override
    public void deleteByIdJoueur(Long id) {
        joueurRepository.deleteById(id);
    }

    @Override
    public List<Joueur> findByEquipeNomEquipe(String nomEquipe) {
        return joueurRepository.findByEquipeNomEquipe(nomEquipe);
    }

    @Override
    public List<Joueur> findByPosteAndEquipeNomEquipe(String poste, String equipeName) {
        return joueurRepository.findByPosteAndEquipeNomEquipe(poste,equipeName);
    }
}
