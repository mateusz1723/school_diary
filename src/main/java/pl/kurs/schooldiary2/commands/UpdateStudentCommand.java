package pl.kurs.schooldiary2.commands;

import java.time.LocalDate;

public class UpdateStudentCommand {

    private Long id;
    private String firstName;
    private String lastName;
    private String pesel;
    private LocalDate birthDate;
    private Long teacherNumber;

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

    public Long getTeacherNumber() {
        return teacherNumber;
    }
}
