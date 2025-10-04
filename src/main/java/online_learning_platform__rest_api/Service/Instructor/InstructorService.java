package online_learning_platform__rest_api.Service.Instructor;

import online_learning_platform__rest_api.Entity.Instructor;
import java.util.List;

public interface InstructorService {

    Instructor createInstructor(Instructor instructor);
    Instructor getInstructorById(Long id);
    List<Instructor> getAllInstructors();
    Instructor updateInstructor(Long id, Instructor instructor);
    void deleteInstructor(Long id);

}
