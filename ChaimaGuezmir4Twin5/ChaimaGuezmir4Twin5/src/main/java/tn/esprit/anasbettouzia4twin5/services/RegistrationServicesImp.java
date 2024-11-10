package tn.esprit.anasbettouzia4twin5.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.anasbettouzia4twin5.entities.Course;
import tn.esprit.anasbettouzia4twin5.entities.Registration;
import tn.esprit.anasbettouzia4twin5.entities.Skier;
import tn.esprit.anasbettouzia4twin5.repository.ICourseRepository;
import tn.esprit.anasbettouzia4twin5.repository.IRegistrationRepository;
import tn.esprit.anasbettouzia4twin5.repository.ISkierRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegistrationServicesImp implements IRegistrationServices{

    private final IRegistrationRepository iRegistrationRepository;
    private final ISkierRepository iSkierRepository;
    private final ICourseRepository iCourseRepository;

    @Override
    public Registration addRegistration(Registration registration) {
        return iRegistrationRepository.save(registration);
    }

    @Override
    public Registration updateRegistration(Registration updatedRegistration) {
        Registration existingRegistration = iRegistrationRepository.findById(updatedRegistration.getNumRegistration())
                .orElseThrow(() -> new RuntimeException("Registration not found with ID: " + updatedRegistration.getNumRegistration()));

        existingRegistration.setNumWeek(updatedRegistration.getNumWeek());
        existingRegistration.setSkier(updatedRegistration.getSkier());
        existingRegistration.setCourse(updatedRegistration.getCourse());

        return iRegistrationRepository.save(existingRegistration);
    }


    @Override
    public Registration retirerRegistration(Long numRegistration) {
        return iRegistrationRepository.findById(numRegistration).orElse(null);
    }

    @Override
    public List<Registration> getAllRegistration() {
        return (List<Registration>) iRegistrationRepository.findAll();
    }

    @Override
    public void removeRegistration(Long numRegistration) {
         iRegistrationRepository.deleteById(numRegistration);
    }

    @Override
    public Registration addRegistrationAndAssignToSkier(Registration registration, Long numSkier) {
        Optional<Skier> skierOptional = iSkierRepository.findById(numSkier);
        if (skierOptional.isPresent()) {
            Skier skier = skierOptional.get();
            registration.setSkier(skier);
            return iRegistrationRepository.save(registration);
        } else {
            throw new RuntimeException("Skier not found with ID: " + numSkier);
        }
    }

    @Override
    public Registration addRegistrationAndAssignToCourse(Registration registration, Long numCourse) {
        Optional<Course> courseOptional = iCourseRepository.findById(numCourse);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            registration.setCourse(course);
            return iRegistrationRepository.save(registration);
        } else {
            throw new RuntimeException("Skier not found with ID: " + numCourse);
        }
    }
}

