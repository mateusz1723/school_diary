package pl.kurs.schooldiary2.commands;

import java.time.LocalDate;

public class UpdateTeacherCommand {

    private Long id;
    private String firstName;
    private String lastName;
    private String pesel;
    private LocalDate birthDate;


    public long getId() {
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

}
