package pl.kurs.schooldiary2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kurs.schooldiary2.commands.CreateTeacherCommand;
import pl.kurs.schooldiary2.commands.UpdateTeacherCommand;
import pl.kurs.schooldiary2.dto.StatusDto;
import pl.kurs.schooldiary2.dto.TeacherDto;
import pl.kurs.schooldiary2.model.Teacher;
import pl.kurs.schooldiary2.service.TeacherManagementService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherManagementService teacherManagementService;
    private final ModelMapper modelMapper;

    public TeacherController(TeacherManagementService teacherManagementService, ModelMapper modelMapper) {
        this.teacherManagementService = teacherManagementService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable("id") long id){
        Teacher teacher = teacherManagementService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(teacher, TeacherDto.class));
    }

    @GetMapping
    public ResponseEntity<List<TeacherDto>> getAllTeachers(){
         return ResponseEntity.ok(teacherManagementService.getAll().stream()
                .map(x -> modelMapper.map(x, TeacherDto.class))
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<TeacherDto> createTeacher(@RequestBody CreateTeacherCommand createTeacherCommand){

        Teacher teacher = teacherManagementService.add(modelMapper.map(createTeacherCommand, Teacher.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(teacher, TeacherDto.class));
    }


    @PutMapping
    public ResponseEntity<TeacherDto> updateTeacher(@RequestBody UpdateTeacherCommand updateTeacherCommand){
        Teacher teacher = teacherManagementService.edit(modelMapper.map(updateTeacherCommand, Teacher.class));
        return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(teacher, TeacherDto.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StatusDto> deleteTeacherById(@PathVariable("id") long id){
        teacherManagementService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new StatusDto("Usunieto nauczyciela o id: " + id));
    }



}
