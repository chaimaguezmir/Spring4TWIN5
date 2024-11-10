package tn.esprit.anasbettouzia4twin5.services;

import tn.esprit.anasbettouzia4twin5.entities.Instructor;

import java.util.List;

public interface IInstructorServices {
    Instructor addInstructor(Instructor instructor);
    Instructor updateInstructor(Instructor instructor);
    Instructor retirerInstructor(Long numinstructor);
    List<Instructor> getAllinstructor();
    void removeInstructor(Long numinstructor);
}
