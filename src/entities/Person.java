package entities;

import java.time.LocalDate;
import java.util.Date;

public class Person {
    private int Id;
    private String Name;
    private int Age;
    private Boolean Gender;
    private LocalDate DateOfBirth;
    private LoginDetails loginDetails;

    public Person(int id, String name, int age, Boolean gender, LocalDate dateOfBirth, LoginDetails loginDetails) {
        Id = id;
        Name = name;
        Age = age;
        Gender = gender;
        DateOfBirth = dateOfBirth;
        this.loginDetails = loginDetails;
    }
    public Person(String name, int age, Boolean gender, LocalDate  dateOfBirth, LoginDetails loginDetails) {
        Name = name;
        Age = age;
        Gender = gender;
        DateOfBirth = dateOfBirth;
        this.loginDetails = loginDetails;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public Boolean getGender() {
        return Gender;
    }

    public void setGender(Boolean gender) {
        Gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public LoginDetails getLoginDetails() {
        return loginDetails;
    }

    public void setLoginDetails(LoginDetails loginDetails) {
        this.loginDetails = loginDetails;
    }
}
