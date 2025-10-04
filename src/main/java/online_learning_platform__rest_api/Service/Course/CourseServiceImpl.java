package online_learning_platform__rest_api.Service.Course;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import online_learning_platform__rest_api.Entity.Course;
import online_learning_platform__rest_api.Exception.Course.CourseNotFoundException;
import online_learning_platform__rest_api.Repository.CourseRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;


    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        Course existingCourse = courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
        existingCourse.setTitle(course.getTitle());
        existingCourse.setDescription(course.getDescription());
        existingCourse.setPrice(course.getPrice());
        courseRepository.save(existingCourse);

        return existingCourse;
    }

    @Override
    @Transactional
    public void deleteCourse(Long id) {
        Course existCourse = courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
        courseRepository.delete(existCourse);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
    }
}
