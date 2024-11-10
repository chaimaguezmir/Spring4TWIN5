package tn.esprit.anasbettouzia4twin5.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.anasbettouzia4twin5.entities.Color;
import tn.esprit.anasbettouzia4twin5.entities.Piste;
import tn.esprit.anasbettouzia4twin5.entities.Skier;
import tn.esprit.anasbettouzia4twin5.repository.IPisteRepository;
import tn.esprit.anasbettouzia4twin5.repository.ISkierRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SkierServicesImpl implements ISkierServices {

    private final ISkierRepository skierRepository;
    private final IPisteRepository pisteRepository;

    @Override
    public Skier addSkier(Skier skier) {
        return skierRepository.save(skier);
    }

    @Override
    public Skier updateSkier(Skier updatedSkier) {

        Skier existingSkier = skierRepository.findById((long) updatedSkier.getIdSkier())
                .orElseThrow(() -> new RuntimeException("Skier not found with ID: " + updatedSkier.getIdSkier()));

        existingSkier.setLastName(updatedSkier.getLastName());
        existingSkier.setFirstName(updatedSkier.getFirstName());
        existingSkier.setBirthDate(updatedSkier.getBirthDate());
        existingSkier.setSubscription(updatedSkier.getSubscription());
        existingSkier.setRegistration(updatedSkier.getRegistration());
        existingSkier.setPiste(updatedSkier.getPiste());

        return skierRepository.save(existingSkier);
    }


    @Override
    public Skier retirerSkier(Long numSkier) {
        return skierRepository.findById(numSkier).orElse(null);
    }

    @Override
    public List<Skier> getAllSkier() {
        return (List<Skier>) skierRepository.findAll();
    }

    @Override
    public void removeSkier(Long numSkier) {
        skierRepository.deleteById(numSkier);

    }

    @Override
    public Skier findByFirstName(String fname, String lname) {
        return null;
    }


    @Override
    public Skier findByDateNaissance(LocalDate date) {
        return skierRepository.findByBirthDate(date);
    }

    @Override
    public List<Skier> assignSkierToPiste(String fname, String lname, Color color) {
        return null;
    }

    public Skier assignSkierToPiste(String firstName, String lastName, String color) {

        Skier skier = skierRepository.findByFirstNameAndLastName(firstName, lastName)
                .orElseThrow(() -> new RuntimeException("Skier not found"));

        Color skierColor;
        try {
            skierColor = Color.valueOf(color.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid color provided");
        }

        List<Piste> pistes = pisteRepository.findByColor(skierColor);
        if (pistes.isEmpty()) {
            throw new RuntimeException("No pistes found with the specified color");
        }

        for (Piste piste : pistes) {
            skier.getPiste().add(piste);  // Add the piste to the skier's pistes
        }

        // Step 5: Save the updated skier
        return skierRepository.save(skier);
    }


}
