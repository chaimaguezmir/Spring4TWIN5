package tn.esprit.anasbettouzia4twin5.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.anasbettouzia4twin5.entities.Color;
import tn.esprit.anasbettouzia4twin5.entities.Piste;
import tn.esprit.anasbettouzia4twin5.entities.Skier;
import tn.esprit.anasbettouzia4twin5.repository.IPisteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PisteServicesImpl implements IPisteServices{

    private final IPisteRepository iPisteRepository;
    @Override
    public Piste addPiste(Piste piste) {
        return iPisteRepository.save(piste);
    }

    @Override
    public Piste updatePiste(Piste updatedPiste) {
        Piste existingPiste = iPisteRepository.findById(updatedPiste.getNumPiste())
                .orElseThrow(() -> new RuntimeException("Piste not found with ID: " + updatedPiste.getNumPiste()));

        existingPiste.setNamePiste(updatedPiste.getNamePiste());
        existingPiste.setColor(updatedPiste.getColor());
        existingPiste.setLength(updatedPiste.getLength());
        existingPiste.setSlope(updatedPiste.getSlope());
        existingPiste.setSkier(updatedPiste.getSkier());

        return iPisteRepository.save(existingPiste);
    }


    @Override
    public Piste retirerPiste(Long numPiste) {
        return iPisteRepository.findById(numPiste).orElse(null);
    }

    @Override
    public List<Piste> getAllPiste() {
        return (List<Piste>)iPisteRepository.findAll();
    }

    @Override
    public void removePiste(Long numPiste) {
        iPisteRepository.deleteById(numPiste);
    }
    public List<Piste> findByColor(Color color){
        return iPisteRepository.findByColor(color);
    }
}
