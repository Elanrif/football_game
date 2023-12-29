package com.master.football_game.services;

import com.master.football_game.entities.Arbitre;
import com.master.football_game.entities.Equipe;
import com.master.football_game.entities.Matche;
import com.master.football_game.entities.Stade;
import com.master.football_game.repositories.ArbitreRepository;
import com.master.football_game.repositories.EquipeRepository;
import com.master.football_game.repositories.MatcheRepository;
import com.master.football_game.repositories.StadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
public class MatchServiceImpl implements MatcheService{

    @Autowired
    private MatcheRepository matcheRepository;
    @Autowired
    private ArbitreRepository arbitreRepository;
    @Autowired
    private StadeRepository stadeRepository;
    @Autowired
    private EquipeRepository equipeRepository ;

    @Override
    public List<Matche> getAllMatches() {
        return matcheRepository.findAll();
    }

    @Override
    public Matche getMatchById(Long id) {
        return matcheRepository.findById(id).get();
    }

    @Override
    public Matche saveMatch(LocalDate dateMatch,
                            LocalTime heureMatch,
                            Long arbitreId,
                            Long stadeId,
                            Long equipeDomId,
                            Long equipeExtId) {

       Matche matche = new Matche(null,dateMatch,heureMatch,null,null,null,null) ;

       Arbitre arbitre = arbitreRepository.findById(arbitreId).orElse(null);
       Stade stade = stadeRepository.findById(stadeId).get() ;
       Equipe equipeD = equipeRepository.findById(equipeDomId).orElse(null) ;
       Equipe equipeE = equipeRepository.findById(equipeExtId).orElse(null) ;

       if(arbitre !=null && stade != null && equipeD != null && equipeE !=null){

           //utilisation des helpers methodes pour aider la synchronisation
           arbitre.addMatch(matche);
           stade.addMatch(matche);
           equipeD.addMatcheDomicile(matche);
           equipeE.addMatcheExterieur(matche);
       }
        /* Grâce aux Cascade les autres objets seront mise auto à jour*/
        return matcheRepository.save(matche);
    }

    @Override
    public Matche updateMatch(
                            Long idMatch,
                            LocalDate dateMatch,
                            LocalTime heureMatch,
                            Long arbitreId,
                            Long stadeId,
                            Long equipeDomId,
                            Long equipeExtId) {

        //chercher le match dans la BDD
        Matche match = matcheRepository.findById(idMatch).get() ;

        Arbitre arbitre = arbitreRepository.findById(arbitreId).orElse(null);
        Stade stade = stadeRepository.findById(stadeId).get() ;
        Equipe equipeD = equipeRepository.findById(equipeDomId).orElse(null) ;
        Equipe equipeE = equipeRepository.findById(equipeExtId).orElse(null) ;

        //modification
        if(match != null && arbitre !=null && stade != null && equipeD != null && equipeE !=null){

            match.setDateMatch(dateMatch);
            match.setHeureMatch(heureMatch);

            //utilisation des helpers methodes pour aider la synchronisation
            arbitre.addMatch(match);
            stade.addMatch(match);
            equipeD.addMatcheDomicile(match);
            equipeE.addMatcheExterieur(match);
        }
        /* Grâce aux Cascade les autres objets seront mise automatiquement à jour*/
        return matcheRepository.save(match);
    }

    @Override
    public void deleteByIdMatch(Long id) {
        matcheRepository.deleteById(id);
    }

    @Override
    public List<Matche> getAllByDate(LocalDate date) {
        return matcheRepository.findByDateMatch(date);
    }

    //version 1
    @Override
    public List<Matche> findByStartDateMatchBefore() {

        // Obtenez la date actuelle
        LocalDate currentDate = LocalDate.now();

        // Définissez le format de la date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // formatter la  date selon le format spécifié en String
        String dateString = currentDate.format(formatter);

        // Convertissez la chaîne dateString en LocalDate
        LocalDate currentDatenew = LocalDate.parse(dateString, formatter);

       return  matcheRepository.findByDateMatchBefore(currentDatenew);

    }

    //version 2
    @Override
    public List<Matche> findByStartDateMatchBeforeAndStartHeureMatchBefore() {

        // Obtenez la date et l'heure actuelle
        LocalDate currentDate = LocalDate.now();

        LocalTime currentTime = LocalTime.now() ;

        // Définissez le format de la date et l'heure
        DateTimeFormatter formatterD = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        DateTimeFormatter formatterH = DateTimeFormatter.ofPattern("HH:mm:ss");

        // formatter la  date et l'heure selon le format spécifié en String
        String dateString = currentDate.format(formatterD);
        String heureString = currentTime.format(formatterH);

        // Convertissez les chaines
        LocalDate currentDatenew = LocalDate.parse(dateString, formatterD);
        LocalTime currentHeurenew = LocalTime.parse(heureString, formatterH);

        return  matcheRepository.findByDateMatchBeforeAndHeureMatchBefore(currentDatenew,currentHeurenew);

    }

    // etape 2 question 10 :
    @Override
    public void deleteMatches(List<Matche> matches) {

        matcheRepository.deleteAll(matches);
    }
}
