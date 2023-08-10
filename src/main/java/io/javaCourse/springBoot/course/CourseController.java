package io.javaCourse.springBoot.course;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
// to declare the dependency that already created by service annotation in business
	@Autowired
// create private Obj from TopicService class to call in this class
	private CourseService courseService;
	
	@RequestMapping("/courses")
	public List<Course> getAllTopics() {
		//
		return courseService.getAllCourses();
	}
	
// request on courses/ variable id call "id"
	
	@RequestMapping("/courses/{id}")	
	public Course getCourse(@PathVariable("id") String id) {
		return courseService.getCourse(id);
	}
//request mapping is a post put ur value on /courses	
	@RequestMapping(method=RequestMethod.POST , value="/courses")
//take the request json from request body & conver it into a Topic instance & pass for postTopic	
	public void postCourse(@RequestBody Course course) {
	courseService.addCourse(course);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/courses/{id}")
	public void updateCourse(@RequestBody Course course,@PathVariable String id) {
		courseService.updateCourse(id, course);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
	
}
