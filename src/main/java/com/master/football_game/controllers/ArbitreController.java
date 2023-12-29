package com.master.football_game.controllers;

import com.master.football_game.entities.Arbitre;
import com.master.football_game.services.ArbitreService;
import com.master.football_game.services.StadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/arbitres")
public class ArbitreController {
    @Autowired
    private ArbitreService arbitreService;

    @GetMapping
    public List<Arbitre> getAllArbitres(){

        return arbitreService.getAllArbitres();
    }

    @GetMapping("/{id}")
    public Arbitre getArbitre(@PathVariable Long id){

        return arbitreService.getArbitreById(id);
    }


    @PostMapping
    public Arbitre saveArbitre(@RequestBody Arbitre arbitre){

        return arbitreService.saveArbitre(arbitre) ;
    }

    @PutMapping
    public Arbitre updateArbitre(@RequestBody Arbitre arbitre){

        return arbitreService.updateArbitre(arbitre) ;
    }

    @DeleteMapping("/{id}")
    public void deleteByIdArbitre(@PathVariable Long id){

        arbitreService.deleteByIdArbitre(id);
    }
}
