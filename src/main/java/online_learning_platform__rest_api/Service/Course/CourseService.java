package online_learning_platform__rest_api.Service.Course;

import online_learning_platform__rest_api.Entity.Course;
import java.util.List;

public interface CourseService {

    Course createCourse(Course course);
    List<Course> getAllCourses();
    Course updateCourse(Long id, Course course);
    void deleteCourse(Long id);
    Course getCourseById(Long id);

}
