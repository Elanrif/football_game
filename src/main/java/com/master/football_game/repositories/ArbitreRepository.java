package com.master.football_game.repositories;

import com.master.football_game.entities.Arbitre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArbitreRepository extends JpaRepository<Arbitre,Long> {
}
