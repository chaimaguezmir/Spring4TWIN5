package tn.esprit.anasbettouzia4twin5.services;

import tn.esprit.anasbettouzia4twin5.entities.Course;


import java.util.List;

public interface ICourseServices {
    Course addCourse(Course course);
    Course updateCourse(Course course);
    Course retirerCourse(Long numCourse);
    List<Course> getAllCourse();
    void removeCourse(Long numCourse);
}
