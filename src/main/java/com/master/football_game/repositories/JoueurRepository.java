package com.master.football_game.repositories;

import com.master.football_game.entities.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur,Long> {

    //7 recupere tout les joeurs de l'equipe 'ATL MADRID'
    List<Joueur> findByEquipeNomEquipe(String nom);

    //Q-9 , recuperer tout les joueurs poste = attaquant de l'équipe PSG
    List<Joueur> findByPosteAndEquipeNomEquipe(String poste,String nomEquipe);
}
