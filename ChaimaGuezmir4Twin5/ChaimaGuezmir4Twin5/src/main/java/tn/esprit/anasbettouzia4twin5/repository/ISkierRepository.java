package tn.esprit.anasbettouzia4twin5.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.anasbettouzia4twin5.entities.Color;
import tn.esprit.anasbettouzia4twin5.entities.Skier;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ISkierRepository extends CrudRepository<Skier,Long> {
    Optional<Skier> findByFirstNameAndLastName(String fname,String lname);
    Skier findByBirthDate(LocalDate birthDate);



}
