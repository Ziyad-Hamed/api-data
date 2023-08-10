package io.javaCourse.springBoot.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//marks class as a spring business service to make instance of it in memory at runtime
@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	// method return all courses
	public List<Course> getAllCourses(){
		
		List<Course> Courses = new ArrayList<>();
		courseRepository.findAll()
		.forEach(Courses::add);
		return Courses;
	}
	
//create method to get course by id	
	public Course getCourse(String id) {
	    return courseRepository.findById(id).orElse(null);
	}

	public void addCourse(Course course) {

		courseRepository.save(course);
	}

	public void updateCourse(String id, Course course) {
		
		courseRepository.save(course);
		
	}

	public void deleteCourse(String id) {
		
		courseRepository.deleteById(id);
	}
	
}
