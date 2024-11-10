package tn.esprit.anasbettouzia4twin5.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.anasbettouzia4twin5.entities.Course;
import tn.esprit.anasbettouzia4twin5.repository.ICourseRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServicesImpl implements ICourseServices{

    private final ICourseRepository courseRepository;
    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course retirerCourse(Long numCourse) {
        return courseRepository.findById(numCourse).orElse(null);
    }

    @Override
    public List<Course> getAllCourse() {
        return (List<Course>)courseRepository.findAll();
    }

    @Override
    public void removeCourse(Long numCourse) {
        courseRepository.deleteById(numCourse);

    }
}
