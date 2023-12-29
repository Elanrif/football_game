package com.master.football_game.services;

import com.master.football_game.entities.Equipe;
import com.master.football_game.entities.Joueur;

import java.util.List;

public interface JoueurService {

    List<Joueur> getAllJoueurs() ;
    Joueur getJoueurById(Long id);
    Joueur saveJoueur(String nomJoeur,String poste, Long idEquipe);
    Joueur updateJoueur(Long idJoueur, String nomJoeur,String poste,Long idEquipe);
    void deleteByIdJoueur(Long id);

    // 7- Récupérer tous les joueurs de l’équipe ‘ATL MADRID'
    List<Joueur> findByEquipeNomEquipe(String nomEquipe);

    // 9- Récupérer tous les joueurs de poste=’attaquant’ de l’équipe ‘PSG’
    List<Joueur> findByPosteAndEquipeNomEquipe(String poste,String equipeName);
}
