package uz.online.olympiad.project1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.online.olympiad.project1.Entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    boolean existsByEmail(String email);
    boolean existsByEmailAndPassword(String email, String password);
}
