package tn.esprit.anasbettouzia4twin5.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.anasbettouzia4twin5.entities.Instructor;
import tn.esprit.anasbettouzia4twin5.services.InstructorServicesImpl;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/instructor")
public class InstructorRestController {
    private final InstructorServicesImpl instructorServices;

    @PostMapping("/add")
    public Instructor saveInstructor(@RequestBody Instructor instructor) {
        return instructorServices.addInstructor(instructor);
    }

    @GetMapping("/get/{numinstructor}")
    public Instructor getInstructor(@PathVariable Long numinstructor){
        return instructorServices.retirerInstructor(numinstructor);
    }

    @PutMapping("/update")
    public Instructor updateInstructor(@RequestBody Instructor instructor) {
        return instructorServices.updateInstructor(instructor);
    }

    @GetMapping("/all")
    public List<Instructor> getAllInstructors() {
        return instructorServices.getAllinstructor();
    }

    @DeleteMapping("/remove/{numinstructor}")
    public void removeInstructor(@PathVariable Long numinstructor) {
        instructorServices.removeInstructor(numinstructor);
    }
}
