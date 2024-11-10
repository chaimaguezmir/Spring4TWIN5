package tn.esprit.anasbettouzia4twin5.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.anasbettouzia4twin5.entities.Registration;
import tn.esprit.anasbettouzia4twin5.services.RegistrationServicesImp;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/registration")
public class RegistrationRestController {
    private final RegistrationServicesImp registrationServices;

    @PostMapping("/add")
    public Registration getRegistration(@RequestBody Registration registration){
        return registrationServices.addRegistration(registration);
    }

    @GetMapping("/get/{numRegistration}")
    public Registration getRegistration(@PathVariable Long numRegistration){
        return  registrationServices.retirerRegistration(numRegistration);
    }

    @PutMapping("/update")
    public Registration updateRegistration(@RequestBody Registration registration){
        return registrationServices.updateRegistration(registration);
    }

    @GetMapping("/all")
    public List<Registration> getAllRegistrations(){
        return registrationServices.getAllRegistration();
    }

    @DeleteMapping("/remove/{numRegistration}")
    public void removeRegistration(@PathVariable Long numRegistration){
        registrationServices.removeRegistration(numRegistration);
    }

    @PostMapping("/add-and-assign/{numSkier}")
    public Registration addRegistrationAndAssignToSkier(@RequestBody Registration registration, @PathVariable Long numSkier) {
        return registrationServices.addRegistrationAndAssignToSkier(registration, numSkier);
    }

    @PostMapping("/add-and-assignCourse/{numCourse}")
    public Registration addRegistrationAndAssignToCourse(@RequestBody Registration registration, @PathVariable Long numCourse) {
        return registrationServices.addRegistrationAndAssignToCourse(registration, numCourse);
    }

}
