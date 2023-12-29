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
public class Arbitre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArbitre ;
    private String nom ;
    private String nationalite;


    @OneToMany(
            mappedBy = "arbitre",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<Matche> matches ;

    public void addMatch(Matche matche){
        matches.add(matche);
        matche.setArbitre(this);
    }

    public void removeMatch(Matche matche){
        matches.remove(matche);
        matche.setArbitre(null);
    }
}
