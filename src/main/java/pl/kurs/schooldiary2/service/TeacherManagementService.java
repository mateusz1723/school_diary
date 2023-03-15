package pl.kurs.schooldiary2.service;

import org.springframework.stereotype.Service;
import pl.kurs.schooldiary2.model.Teacher;
import pl.kurs.schooldiary2.repository.TeacherRepository;

@Service
public class TeacherManagementService extends GenericManagementService<Teacher, TeacherRepository>{

    public TeacherManagementService(TeacherRepository repository) {
        super(repository);
    }


}
