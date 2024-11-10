package tn.esprit.anasbettouzia4twin5.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Registration implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numRegistration ;


    private int numWeek ;

    @JsonIgnore
    @ManyToOne
    private Skier skier;

    @JsonIgnore
    @ManyToOne
    private Course course ;

}

