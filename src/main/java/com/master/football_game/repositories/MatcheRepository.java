package com.master.football_game.repositories;

import com.master.football_game.entities.Matche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Repository
public interface MatcheRepository extends JpaRepository<Matche,Long> {

    //5- match programée le ?
    List<Matche> findByDateMatch(LocalDate date) ;

    /* 10- supprimer tout les match déjà passé */
    //version 1
    List<Matche> findByDateMatchBefore(LocalDate date);
    //version 2
    List<Matche> findByDateMatchBeforeAndHeureMatchBefore(LocalDate date, LocalTime time);

    /* autre forme */
    void deleteByDateMatch(LocalDate date);

}
