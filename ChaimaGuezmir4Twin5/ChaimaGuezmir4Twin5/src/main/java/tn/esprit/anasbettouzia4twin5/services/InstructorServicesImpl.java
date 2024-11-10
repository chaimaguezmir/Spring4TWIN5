package tn.esprit.anasbettouzia4twin5.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.anasbettouzia4twin5.entities.Instructor;
import tn.esprit.anasbettouzia4twin5.repository.IInstructorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorServicesImpl implements IInstructorServices{

    private final IInstructorRepository instructorRepository;
    @Override
    public Instructor addInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor updateInstructor(Instructor updatedInstructor) {

        Instructor existingInstructor = instructorRepository.findById(updatedInstructor.getNumInstructor())
                .orElseThrow(() -> new RuntimeException("Instructor not found with ID: " + updatedInstructor.getNumInstructor()));

        existingInstructor.setFirstName(updatedInstructor.getFirstName());
        existingInstructor.setLastName(updatedInstructor.getLastName());
        existingInstructor.setDateOfHire(updatedInstructor.getDateOfHire());
        existingInstructor.setCourses(updatedInstructor.getCourses());

        return instructorRepository.save(existingInstructor);
    }


    @Override
    public Instructor retirerInstructor(Long numinstructor) {
        return instructorRepository.findById(numinstructor).orElse(null);
    }

    @Override
    public List<Instructor> getAllinstructor() {
        return (List<Instructor>)instructorRepository.findAll();
    }

    @Override
    public void removeInstructor(Long numinstructor) {
        instructorRepository.deleteById(numinstructor);

    }
}
