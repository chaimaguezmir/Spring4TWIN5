package tn.esprit.anasbettouzia4twin5.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.anasbettouzia4twin5.entities.Color;
import tn.esprit.anasbettouzia4twin5.entities.Piste;
import tn.esprit.anasbettouzia4twin5.entities.Skier;

import java.util.List;

public interface IPisteRepository extends CrudRepository<Piste,Long> {
    List<Piste> findByColor(Color color);
}
