package com.master.football_game.controllers;

import com.master.football_game.entities.Equipe;
import com.master.football_game.entities.Equipe;
import com.master.football_game.entities.Joueur;
import com.master.football_game.services.EquipeService;
import com.master.football_game.services.JoueurService;
import com.master.football_game.services.StadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/equipes")
public class EquipeController {
    @Autowired
    private EquipeService equipeService;
    @Autowired
    private JoueurService joueurService ;

    /*4- recupérer tout les equipes du Maroc*/
    @GetMapping("/name")
    public List<Equipe> findByEquipesName(@RequestParam String nameEquipe){

        return equipeService.findByEquipesName(nameEquipe);
    }

    // 7- Récupérer tous les joueurs de l’équipe ‘ATL MADRID’
    @GetMapping("/joeurs")
    public List<Joueur> findByEquipeNomEquipe(@RequestParam String nomEquipe){

        return joueurService.findByEquipeNomEquipe(nomEquipe);
    }

    // 8- Récupérer les deux équipes du match de l’id=3
    @GetMapping("/match/{idMatch}")
    public List<Equipe> findByMatchId(@PathVariable Long idMatch){

        return equipeService.findByMatchId(idMatch);
    }

    // 9- Récupérer tous les joueurs de poste=’attaquant’ de l’équipe ‘PSG’
    @GetMapping("/joeurs/poste-nomEquipe")
    public List<Joueur> findByPosteAndEquipeNomEquipe(@RequestParam String poste , @RequestParam String nomEquipe){

        return joueurService.findByPosteAndEquipeNomEquipe(poste,nomEquipe);
    }

    @GetMapping
    public List<Equipe> getAllEquipes(){

        return equipeService.getAllEquipes();
    }

    @GetMapping("/{id}")
    public Equipe getEquipe(@PathVariable Long id){

        return equipeService.getEquipeById(id);
    }
    @PostMapping
    public Equipe saveEquipe(@RequestBody Equipe equipe){

        return equipeService.saveEquipe(equipe) ;
    }

    @PutMapping
    public Equipe updateEquipe(@RequestBody Equipe equipe){

        return equipeService.updateEquipe(equipe) ;
    }

    @GetMapping("/maroc")
    public List<Equipe> getEquipeMaroc(){

        return null ;
    }

    @DeleteMapping("/{id}")
    public void deleteByIdEquipe(@PathVariable Long id){

        equipeService.deleteByIdEquipe(id);
    }
}
