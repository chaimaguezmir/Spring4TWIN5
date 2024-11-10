package tn.esprit.anasbettouzia4twin5.services;

import tn.esprit.anasbettouzia4twin5.entities.Piste;

import java.util.List;

public interface IPisteServices {
    Piste addPiste(Piste piste);
    Piste updatePiste(Piste piste);
    Piste retirerPiste(Long numPiste);
    List<Piste> getAllPiste();
    void removePiste(Long numPiste);
}
