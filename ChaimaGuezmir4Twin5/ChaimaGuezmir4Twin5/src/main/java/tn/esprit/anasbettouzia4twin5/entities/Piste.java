package tn.esprit.anasbettouzia4twin5.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Piste implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numPiste ;

    private String namePiste ;

    @Enumerated(EnumType.STRING)
    private Color color ;

    private  int length ;
    private int slope ;

    @ManyToMany
    private Set<Skier> skier;


}
