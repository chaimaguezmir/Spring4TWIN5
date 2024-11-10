package tn.esprit.anasbettouzia4twin5.services;

import tn.esprit.anasbettouzia4twin5.entities.Registration;

import java.util.List;

public interface IRegistrationServices {
    Registration addRegistration(Registration registration);
    Registration updateRegistration(Registration registration);
    Registration retirerRegistration(Long numRegistration);
    List<Registration> getAllRegistration();
    void removeRegistration(Long numRegistration);
    Registration addRegistrationAndAssignToSkier(Registration registration, Long numSkier);
    Registration addRegistrationAndAssignToCourse(Registration registration, Long numCourse);
}
