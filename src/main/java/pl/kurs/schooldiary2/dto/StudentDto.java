package pl.kurs.schooldiary2.dto;

import java.time.LocalDate;

public class StudentDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String pesel;
    private LocalDate birthDate;
    private TeacherSimpleDto teacher;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public TeacherSimpleDto getTeacher() {
        return teacher;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setTeacher(TeacherSimpleDto teacher) {
        this.teacher = teacher;
    }
}
