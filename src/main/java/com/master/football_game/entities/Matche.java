package com.master.football_game.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@DynamicUpdate
@Entity
public class Matche {
    /*le nom Match est un nom reservé a certains base de donnée et génère une erreur.*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMatch  ;
    private LocalDate dateMatch ;
    private LocalTime heureMatch;

    @ManyToOne(cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST
    })
    @JoinColumn(name="arbitre_id")
    private Arbitre arbitre ;

    @ManyToOne(cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST
    })
    @JoinColumn(name="state_id")
    private Stade stade ;

    @ManyToOne(cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST
    })
    @JoinColumn(name="equipe_domicile")
    private Equipe equipeDomicile ;

    @ManyToOne(cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST
    })
    @JoinColumn(name="equipe_exterieur")
    private Equipe equipeExterieur ;
}
