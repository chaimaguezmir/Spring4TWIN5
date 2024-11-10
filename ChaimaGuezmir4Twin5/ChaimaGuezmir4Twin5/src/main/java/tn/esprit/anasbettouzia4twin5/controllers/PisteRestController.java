package tn.esprit.anasbettouzia4twin5.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.anasbettouzia4twin5.entities.Color;
import tn.esprit.anasbettouzia4twin5.entities.Piste;
import tn.esprit.anasbettouzia4twin5.entities.Skier;
import tn.esprit.anasbettouzia4twin5.services.PisteServicesImpl;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/piste")
public class PisteRestController {
    private final PisteServicesImpl pisteServices;

    @PostMapping("/add")
    public Piste savePiste(@RequestBody Piste piste) {
        return pisteServices.addPiste(piste);
    }

    @GetMapping("/get/{numPiste}")
    public Piste getPiste(@PathVariable Long numPiste){
        return pisteServices.retirerPiste(numPiste);
    }

    @PutMapping("/update")
    public Piste updatePiste(@RequestBody Piste piste) {
        return pisteServices.updatePiste(piste);
    }

    @GetMapping("/all")
    public List<Piste> getAllPistes() {
        return pisteServices.getAllPiste();
    }

    @DeleteMapping("/remove/{numPiste}")
    public void removePiste(@PathVariable Long numPiste) {
        pisteServices.removePiste(numPiste);
    }
    @GetMapping("/find-by-color/{color}")
    public List<Piste> findByColor(@PathVariable Color color){
        return  pisteServices.findByColor(color);
    }

}
