package com.master.football_game.controllers;

import com.master.football_game.entities.Arbitre;
import com.master.football_game.entities.Equipe;
import com.master.football_game.entities.Matche;
import com.master.football_game.entities.Stade;
import com.master.football_game.repositories.MatcheRepository;
import com.master.football_game.services.MatcheService;
import com.master.football_game.services.StadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/matches")
public class MatcheController {
    @Autowired
    private MatcheService matcheService;
    @Autowired
    private MatcheRepository matcheRepository;

    // 5- Récupérer les matchs qui sont programmés le ‘28/02/2021’
    @GetMapping("/date")
    public List<Matche> getAllMatches(@RequestParam("date") String dateMatch){

        //  format de la chaîne de date et conversion en LocalDate
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Convertissez la chaîne en LocalDate et LocalTime
        LocalDate datematch = LocalDate.parse(dateMatch, formatDate);

        return  matcheService.getAllByDate(datematch);
    }

    @GetMapping("/test/v1/played")
    public List<Matche> getTest1(){

        // cette methode on utilise la date actuel de la machine
        return matcheService.findByStartDateMatchBefore();
    }

   /* @GetMapping("/test/v2/played")
    public List<Matche> getTest2(){

        // cette methode on utilise la date actuel de la machine
       return  matcheService.findByStartDateMatchBeforeAndStartHeureMatchBefore();
    }*/

    /* 10- Supprimer tous les matchs déjà passés */
    //version 1
    @DeleteMapping("/v1/played")
    public void deleteAllMatchPlayed(){

        // cette methode on utilise la date actuel de la machine
        List<Matche> matches = matcheService.findByStartDateMatchBefore();
        matcheService.deleteMatches(matches);
    }

    //version 2

   /* @DeleteMapping("/v2/played")
    public void deleteAllMatchPlayedV2(){

        // cette methodes utilise la date et l'heure courant
        List<Matche> matches = matcheService.findByStartDateMatchBeforeAndStartHeureMatchBefore() ;
        matcheService.deleteMatches(matches);
    }*/

    @GetMapping
    public List<Matche> getAllMatches(){

        return matcheService.getAllMatches();
    }

    @GetMapping("/{id}")
    public Matche getMatchById(@PathVariable Long id) {
        return matcheService.getMatchById(id);
    }

    /* matche doit contenir les Attributs des classes en relation (seulement leur id suiffisent). on a uitlisé @DynamicUpdate dans @Entity
    * */
    @PostMapping
    public Matche saveMatch(
            @RequestParam("date") String dateMatch,
            @RequestParam("heure") String heureMatch,
            @RequestParam Long arbitreId,
            @RequestParam Long stadeId,
            @RequestParam Long equipeExtId,
            @RequestParam Long equipeDomId
            )  {

         //  format de la chaîne de date et conversion en LocalDate
        //ATTENTION : format qu'on s'attends a reçevoir dans le requestParam dd-MM-yyyy
        // mais tjrs dans BDD MysQl aura le format par défaut yyyy-MM-dd
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        //par défaut heure  est comme ça : donc on peut ignorer formatHeure L107
        DateTimeFormatter formatHeure = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Convertissez la chaîne en LocalDate et LocalTime
        LocalDate datematch = LocalDate.parse(dateMatch, formatDate);
        LocalTime heurematch = LocalTime.parse(heureMatch);


        return matcheService.saveMatch(datematch,heurematch,arbitreId,stadeId,equipeDomId,equipeExtId);
    }
    @PutMapping
    public Matche updateMatch(
            @RequestParam("id") Long idMatch,
            @RequestParam("date") String dateMatch,
            @RequestParam("heure") String heureMatch,
            @RequestParam Long arbitreId,
            @RequestParam Long stadeId,
            @RequestParam Long equipeExtId,
            @RequestParam Long equipeDomId
    )  {

        //  je fais exprès de prendre les format Date par défaut (yyyy-MM-dd):

        DateTimeFormatter formatHeure = DateTimeFormatter.ofPattern("HH:mm:ss");

        LocalTime heurematch = LocalTime.parse(heureMatch, formatHeure);

        //sera appliqué le format par défaut (yyyy-MM-dd)
        LocalDate datematch = LocalDate.parse(dateMatch);

        return matcheService.updateMatch(idMatch,datematch,heurematch,arbitreId,stadeId,equipeDomId,equipeExtId);
    }
    @DeleteMapping("/{id}")
    public void deleteByIdMatch(@PathVariable Long id) {
        matcheService.deleteByIdMatch(id);
    }

    @DeleteMapping("/v1")
    public void deleteByIdMatchv1(@PathVariable Long id) {

        matcheRepository.deleteByDateMatch(LocalDate.now());
    }
}
