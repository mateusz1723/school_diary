package pl.kurs.schooldiary2.commands;

import java.time.LocalDate;

public class CreateStudentCommand {

    private String firstName;
    private String lastName;
    private String pesel;
    private LocalDate birthDate;
    private Long teacherNumber;

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

    public Long getTeacherNumber() {
        return teacherNumber;
    }
}
