package com.master.football_game.repositories;

import com.master.football_game.entities.Stade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StadeRepository extends JpaRepository<Stade,Long> {

    // question 6 , stade ou se deroule match 3  ?
    Stade findByMatchesIdMatch(Long matchId) ;
}
