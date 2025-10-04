package online_learning_platform__rest_api.Exception.Instructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InstructorNotFoundException extends RuntimeException{

    public InstructorNotFoundException(Long id) {

        super("INSTRUCTOR NOT FOUND WITH ID : " + id);

    }
}
