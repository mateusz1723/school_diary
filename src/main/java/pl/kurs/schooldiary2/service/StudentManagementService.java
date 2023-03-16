package pl.kurs.schooldiary2.service;

import org.springframework.stereotype.Service;
import pl.kurs.schooldiary2.model.Student;
import pl.kurs.schooldiary2.repository.StudentRepository;

@Service
public class StudentManagementService extends GenericManagementService<Student, StudentRepository>{

    public StudentManagementService(StudentRepository repository) {
        super(repository);
    }
}
