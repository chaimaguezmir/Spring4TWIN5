package tn.esprit.anasbettouzia4twin5.entities;



import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.time.LocalDate;
import java.util.Set;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity

public class Skier implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSkier ;

    private String lastName;
    private String firstName;
    private LocalDate birthDate ;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Subscription subscription ;

    @OneToMany(mappedBy = "skier",fetch =FetchType.EAGER)
    private Set<Registration> registration;

    @ManyToMany(mappedBy = "skier")
    private Set<Piste> piste;
    @Enumerated(EnumType.STRING)
    private Color color;

}

