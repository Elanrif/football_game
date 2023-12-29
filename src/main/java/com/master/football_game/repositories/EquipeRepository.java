package com.master.football_game.repositories;

import com.master.football_game.entities.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe,Long> {

    //4- tout les equipes du Maroc
    List<Equipe> findByPays(String name) ;

}
