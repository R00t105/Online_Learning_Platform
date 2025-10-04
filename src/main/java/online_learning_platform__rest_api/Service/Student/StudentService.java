package online_learning_platform__rest_api.Service.Student;

import online_learning_platform__rest_api.Entity.Student;
import java.util.List;

public interface StudentService {

    Student createStudent(Student student);
    Student getStudentById(Long id);
    List<Student> getAllStudents();
    Student updateStudent(Long id, Student student);
    void deleteStudent(Long id);

}
