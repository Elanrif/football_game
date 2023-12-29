package com.master.football_game.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@DynamicUpdate
@Entity
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipe ;
    private String nomEquipe ;
    private String pays;
    @OneToMany(
            mappedBy = "equipe",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Joueur> joueurs;

    @JsonIgnore
    @OneToMany(
            mappedBy = "equipeDomicile",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Matche> matcheDomiciles ;

    @JsonIgnore
    @OneToMany(
            mappedBy = "equipeExterieur",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Matche> matcheExterieurs ;

    public void addMatcheDomicile(Matche matche){
        matcheDomiciles.add(matche);
        matche.setEquipeDomicile(this);
    }

    public void removeMatcheDomicile(Matche matche){
        matcheExterieurs.remove(matche);
        matche.setEquipeExterieur(null);
    }

    public void addMatcheExterieur(Matche matche){
        matcheExterieurs.add(matche);
        matche.setEquipeExterieur(this);
    }

    public void removeMatcheExterieur(Matche matche){
        matcheExterieurs.remove(matche);
        matche.setEquipeExterieur(null);
    }

    public void addJoueur(Joueur joueur){
        joueurs.add(joueur);
        joueur.setEquipe(this);
    }

    public void removeJoueur(Joueur joueur){
        joueurs.remove(joueur);
        joueur.setEquipe(null);
    }
}
