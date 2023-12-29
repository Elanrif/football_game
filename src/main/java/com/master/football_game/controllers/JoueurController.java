package com.master.football_game.controllers;

import com.master.football_game.entities.Arbitre;
import com.master.football_game.entities.Equipe;
import com.master.football_game.entities.Joueur;
import com.master.football_game.services.JoueurService;
import com.master.football_game.services.StadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/joueurs")
public class JoueurController {
    @Autowired
    private JoueurService joueurService;

    /*1- recupérer tout les joueurs*/
    @GetMapping
    public List<Joueur> getAllArbitres(){

        return joueurService.getAllJoueurs();
    }

    @GetMapping("/{id}")
    public Joueur getJoueur(@PathVariable Long id){

        return joueurService.getJoueurById(id);
    }

    @PostMapping
    public Joueur saveJoueur(
            @RequestParam("nom") String nomJoeur,
            @RequestParam("poste") String poste ,
            @RequestParam Long idEquipe){

        return joueurService.saveJoueur(nomJoeur,poste,idEquipe) ;
    }

    @PutMapping
    public Joueur updateJoueur(
            @RequestParam Long idJoueur,
            @RequestParam("nom") String nomJoeur,
            @RequestParam("poste") String poste ,
            @RequestParam Long idEquipe){

        return joueurService.updateJoueur(idJoueur,nomJoeur,poste,idEquipe) ;
    }

    @DeleteMapping("/{id}")
    public void deleteByIdJoueur(@PathVariable Long id){

        joueurService.deleteByIdJoueur(id);
    }
}
