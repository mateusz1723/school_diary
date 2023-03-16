package pl.kurs.schooldiary2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kurs.schooldiary2.commands.CreateStudentCommand;
import pl.kurs.schooldiary2.commands.UpdateStudentCommand;
import pl.kurs.schooldiary2.dto.StatusDto;
import pl.kurs.schooldiary2.dto.StudentDto;
import pl.kurs.schooldiary2.dto.TeacherSimpleDto;
import pl.kurs.schooldiary2.model.Student;
import pl.kurs.schooldiary2.model.Teacher;
import pl.kurs.schooldiary2.service.StudentManagementService;
import pl.kurs.schooldiary2.service.TeacherManagementService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentManagementService studentManagementService;
    private final TeacherManagementService teacherManagementService;
    private final ModelMapper modelMapper;

    public StudentController(StudentManagementService studentManagementService, TeacherManagementService teacherManagementService, ModelMapper modelMapper) {
        this.studentManagementService = studentManagementService;
        this.teacherManagementService = teacherManagementService;
        this.modelMapper = modelMapper;
    }


    @PostMapping
    @Transactional
    public ResponseEntity<StudentDto> createStudent(@RequestBody CreateStudentCommand createStudentCommand) {
        Teacher teacher = teacherManagementService.get(createStudentCommand.getTeacherNumber());
        Student student = modelMapper.map(createStudentCommand, Student.class);
        student.setTeacher(teacher);
        student = studentManagementService.add(student);
        StudentDto studentDto = modelMapper.map(student, StudentDto.class);
        studentDto.setTeacher(modelMapper.map(student.getTeacher(), TeacherSimpleDto.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(studentDto);
    }


    @PutMapping
    public ResponseEntity<StudentDto> updateStudent(@RequestBody UpdateStudentCommand updateStudentCommand) {
        Teacher teacher = teacherManagementService.get(updateStudentCommand.getTeacherNumber());
        Student student = modelMapper.map(updateStudentCommand, Student.class);
        student.setTeacher(teacher);
        student = studentManagementService.edit(student);
        StudentDto studentDto = modelMapper.map(student, StudentDto.class);
        studentDto.setTeacher(modelMapper.map(student.getTeacher(), TeacherSimpleDto.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(studentDto);
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        return ResponseEntity.ok(studentManagementService.getAll().stream()
                .map(x -> modelMapper.map(x, StudentDto.class))
                .collect(Collectors.toList()));

    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable("id") long id){
        StudentDto student = modelMapper.map(studentManagementService.get(id), StudentDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<StatusDto> deleteStudent(@PathVariable("id") long id){
        studentManagementService.delete(id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new StatusDto("Student o id: " + id + " został usuniety"));
    }

//todo obsluga wyjatkow
}
