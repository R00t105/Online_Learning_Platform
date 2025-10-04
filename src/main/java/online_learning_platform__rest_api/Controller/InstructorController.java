package online_learning_platform__rest_api.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import online_learning_platform__rest_api.Entity.Instructor;
import online_learning_platform__rest_api.Service.Instructor.InstructorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/instructors")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;


    @GetMapping()
    public ResponseEntity<List<Instructor>> getAllInstructors(){
        return ResponseEntity.ok(instructorService.getAllInstructors());
    }

    @PostMapping()
    public ResponseEntity<Instructor> createInstructor(@RequestBody @Valid Instructor instructor){
        return ResponseEntity.ok(instructorService.createInstructor(instructor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable Long id, @RequestBody Instructor instructor){
        return ResponseEntity.ok(instructorService.updateInstructor(id, instructor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Instructor> deleteInstructor(@PathVariable Long id){
        instructorService.deleteInstructor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getInstructor(@PathVariable Long id){
        return ResponseEntity.ok(instructorService.getInstructorById(id));
    }

}
