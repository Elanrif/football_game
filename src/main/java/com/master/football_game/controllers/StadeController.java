package com.master.football_game.controllers;

import com.master.football_game.entities.Arbitre;
import com.master.football_game.entities.Stade;
import com.master.football_game.services.StadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/stades")
public class StadeController {

    @Autowired
    private StadeService stadeService;

   // 6- Récupérer le stade où se déroule le match de l’id=3
    @GetMapping("/match/{idMatch}")
    public Stade getStadeFromMatchId(@PathVariable Long idMatch){

        return stadeService.findByMatchesIdMatch(idMatch);
    }

    @GetMapping
    public List<Stade> getAllArbitres(){

        return stadeService.getAllStades();
    }

    @GetMapping("/{id}")
    public Stade getStadeById(@PathVariable Long id) {
        return stadeService.getStadeById(id);
    }

    @PostMapping
    public Stade saveStade(@RequestBody Stade stade) {
        return stadeService.saveStade(stade);
    }

    @PutMapping
    public Stade updateStade(@RequestBody Stade stade) {
        return stadeService.saveStade(stade);
    }

    @DeleteMapping("/{id}")
    public void deleteByIdStade(@PathVariable Long id) {

        stadeService.deleteByIdStade(id);
    }
}
