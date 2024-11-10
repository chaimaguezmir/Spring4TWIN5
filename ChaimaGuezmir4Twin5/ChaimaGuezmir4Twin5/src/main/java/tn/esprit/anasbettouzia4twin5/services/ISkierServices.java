package tn.esprit.anasbettouzia4twin5.services;

import tn.esprit.anasbettouzia4twin5.entities.Color;
import tn.esprit.anasbettouzia4twin5.entities.Skier;

import java.time.LocalDate;
import java.util.List;

public interface ISkierServices {
    Skier addSkier(Skier skier);
    Skier updateSkier(Skier skier);
    Skier retirerSkier(Long numSkier);
    List<Skier> getAllSkier();
    void removeSkier(Long numSkier);
    Skier findByFirstName(String fname, String lname);
    Skier findByDateNaissance(LocalDate date);
    List<Skier> assignSkierToPiste(String fname, String lname, Color color);
}
