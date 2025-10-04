package online_learning_platform__rest_api.Service.Student;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import online_learning_platform__rest_api.Entity.Student;
import online_learning_platform__rest_api.Exception.Student.StudentNotFoundException;
import online_learning_platform__rest_api.Repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).
                orElseThrow(() -> new StudentNotFoundException(id));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public Student updateStudent(Long id, Student student) {
        Student existStudent = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
        existStudent.setName(student.getName());
        existStudent.setEmail(student.getEmail());

        return existStudent;
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        if(!studentRepository.existsById(id))
            throw new StudentNotFoundException(id);

        studentRepository.deleteById(id);
    }
}
