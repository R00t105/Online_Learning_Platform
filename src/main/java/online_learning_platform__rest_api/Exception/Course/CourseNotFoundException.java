package online_learning_platform__rest_api.Exception.Course;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CourseNotFoundException extends RuntimeException{

    public CourseNotFoundException(Long id) {
        super("COURSE NOT FOUND WITH ID : " + id);
    }
}
