package tn.esprit.anasbettouzia4twin5.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.anasbettouzia4twin5.entities.Course;
import tn.esprit.anasbettouzia4twin5.services.CourseServicesImpl;


import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/course")
public class CourseRestController {
    private final CourseServicesImpl courseServices;

    @PostMapping("/add")
    public Course saveCourse(@RequestBody Course course) {
        return courseServices.addCourse(course);
    }

    @GetMapping("/get/{numCourse}")
    public Course getCourse(@PathVariable Long numCourse){
        return courseServices.retirerCourse(numCourse);
    }

    @PutMapping("/update")
    public Course updateCourse(@RequestBody Course course) {
        return courseServices.updateCourse(course);
    }

    @GetMapping("/all")
    public List<Course> getAllCourses() {
        return courseServices.getAllCourse();
    }

    @DeleteMapping("/remove/{numCourse}")
    public void removeCourse(@PathVariable Long numCourse) {
        courseServices.removeCourse(numCourse);
    }
}
