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
public class Stade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStade;
    private String nomStade;
    private String ville;

    @JsonIgnore
    @OneToMany(
            mappedBy = "stade",
            cascade = CascadeType.ALL
           // orphanRemoval = true
    )
    private List<Matche> matches ;

    public void addMatch(Matche matche){
        matches.add(matche);
        matche.setStade(this);
    }

    public void removeMatch(Matche matche){
        matches.remove(matche);
        matche.setStade(null);
    }
}
