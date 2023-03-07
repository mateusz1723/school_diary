package pl.kurs.schooldiary2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kurs.schooldiary2.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {


}
