package tn.esprit.anasbettouzia4twin5.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.anasbettouzia4twin5.entities.Color;
import tn.esprit.anasbettouzia4twin5.entities.Skier;
import tn.esprit.anasbettouzia4twin5.services.SkierServicesImpl;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/skier")
public class SkierRestController {
    private final SkierServicesImpl skierServices;

    @PostMapping("/add")
    public Skier saveSkier(@RequestBody Skier skier) {
        return skierServices.addSkier(skier);
    }

    @GetMapping("/get/{numSkier}")
    public Skier getSkier(@PathVariable Long numSkier){
        return skierServices.retirerSkier(numSkier);
    }

    @PutMapping("/update")
    public Skier updateSkier(@RequestBody Skier skier) {
        return skierServices.updateSkier(skier);
    }

    @GetMapping("/all")
    public List<Skier> getAllSkiers() {
        return skierServices.getAllSkier();
    }

    @DeleteMapping("/remove/{numSkier}")
    public void removeSkier(@PathVariable Long numSkier) {
        skierServices.removeSkier(numSkier);
    }
    @GetMapping("/getBy/{fname}/{lname}")
    public Skier getByFirstName(@PathVariable String fname,String lname){
        return skierServices.findByFirstName(fname,lname);
    }
    @GetMapping("/getBy/{date}")
    public Skier getByDate(@PathVariable LocalDate date){
        return skierServices.findByDateNaissance(date);
    }
    @PostMapping("/assign-to-piste/{firstName}/{lastName}/{color}")
    public Skier assignSkierToPiste(@PathVariable String firstName,
                                    @PathVariable String lastName,
                                    @PathVariable String color) {
        return skierServices.assignSkierToPiste(firstName, lastName, color);
    }

}
