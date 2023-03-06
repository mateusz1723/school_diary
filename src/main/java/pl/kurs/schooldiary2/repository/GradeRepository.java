package pl.kurs.schooldiary2.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.kurs.schooldiary2.model.Grade;

public interface GradeRepository extends JpaRepository<Grade, Long> {

}
