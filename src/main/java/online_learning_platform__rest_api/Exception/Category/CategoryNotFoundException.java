package online_learning_platform__rest_api.Exception.Category;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends RuntimeException{

    public CategoryNotFoundException(int id) {
        super("CATEGORY NOT FOUND WITH ID : " + id);
    }
}
