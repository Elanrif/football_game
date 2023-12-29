package com.master.football_game.services;

import com.master.football_game.entities.Arbitre;
import com.master.football_game.entities.Equipe;
import com.master.football_game.entities.Matche;
import com.master.football_game.entities.Stade;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public interface MatcheService {
    List<Matche> getAllMatches() ;
    Matche getMatchById(Long id);
    Matche saveMatch(LocalDate dateMatch, LocalTime heureMatch, Long arbitreId, Long stadeId, Long equipeDomId, Long equipeExtId);
    Matche updateMatch(Long idMatch,LocalDate dateMatch,LocalTime heureMatch, Long arbitreId,Long stadeId,Long equipeDomId,Long equipeExtId);
    void deleteByIdMatch(Long id);

    List<Matche> getAllByDate(LocalDate date) ;

    //10- suprimer tout les matches déjà passé
    List<Matche> findByStartDateMatchBefore() ;

    List<Matche> findByStartDateMatchBeforeAndStartHeureMatchBefore();

    void deleteMatches(List<Matche> matches);
}
