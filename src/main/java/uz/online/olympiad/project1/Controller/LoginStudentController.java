package uz.online.olympiad.project1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.online.olympiad.project1.Repository.StudentRepository;
import uz.online.olympiad.project1.payload.LoginStudentDto;

@RestController
@RequestMapping(value = "/come")
public class LoginStudentController {
    @Autowired
    StudentRepository studentRepository;

    @PostMapping
    public void loginStudent(@RequestBody LoginStudentDto loginStudentDto) {
        if (studentRepository.existsByEmailAndPassword(loginStudentDto.getEmail(), loginStudentDto.getPassword())){
            ///test bo`limiga o`tish
        }
    }

}
