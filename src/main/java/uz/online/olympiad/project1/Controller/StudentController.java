package uz.online.olympiad.project1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.online.olympiad.project1.Entity.Student;
import uz.online.olympiad.project1.Repository.StudentRepository;
import uz.online.olympiad.project1.payload.ApiResponse;



@RestController
@RequestMapping(value = "/reg")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;


    @PostMapping
    public ResponseEntity addStudent(@RequestBody Student student) {

        if (studentRepository.existsByEmail(student.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ApiResponse("Bu email ro`yxatdan o`tgan.Iltimos boshqa email kiriting!", false));
        }

        if (student.getPassword().length() < 8) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse("Parol kamida 8 belgidan iborat bo`lishi kerak", false));
        }


        studentRepository.save(student);
        return ResponseEntity.ok(new ApiResponse("Siz muvaffaqiyatli ro`yxatdan o`tdingiz.", true));

    }
}
