package uz.muhandis.library.models;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Person {
    private int id;
    @NotEmpty(message = "Full name not should be empty")
    private String fullName;
    @NotNull(message = "Year of birth not should be empty")
    @Min(value = 1900, message = "Year of birth should be greater than 1900")
    private int birthYear;

    public Person() {
    }

    public Person(int id, String fullName, int birthYear) {
        this.id=id;
        this.fullName = fullName;
        this.birthYear = birthYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", yearOfBirth=" + birthYear +
                '}';
    }
}

