package online_learning_platform__rest_api.Service.Instructor;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import online_learning_platform__rest_api.Entity.Instructor;
import online_learning_platform__rest_api.Exception.Instructor.InstructorNotFoundException;
import online_learning_platform__rest_api.Repository.InstructorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService{

    private final InstructorRepository instructorRepository;

    @Override
    public Instructor createInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorRepository.findById(id).
                orElseThrow(() -> new InstructorNotFoundException(id));
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor updateInstructor(Long id, Instructor instructor) {
        Instructor existInstructor = instructorRepository.findById(id).orElseThrow(() -> new InstructorNotFoundException(id));
            existInstructor.setName(instructor.getName());
            existInstructor.setBio(instructor.getBio());
            existInstructor.setProfilePictureUrl(instructor.getProfilePictureUrl());

        return existInstructor;
    }

    @Override
    @Transactional
    public void deleteInstructor(Long id) {
        if(!instructorRepository.existsById(id))
            throw new InstructorNotFoundException(id);

        instructorRepository.deleteById(id);
    }
}
