package pl.kurs.schooldiary2.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.kurs.schooldiary2.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {


}
