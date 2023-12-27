package dev.domain.User;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /*@Length(min = 5, message = "You have a problem in your fullname") */
    @NotNull
    @Column(name = "full_name")
    private String fullname;

    @NotNull
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", message = "Incorrect email format")
    @Column(name = "email")
    private String email;

    @NotNull
    @Size(min = 8)
    @Column(name = "password")
    private String password;

    @NotNull
    @Past
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name="enabled")
    private int enabled;

    @NotNull
    @Column(name="contactInfo")
    private String contactInfo;

    @Column(name="address")
    private String Address;
    @NotNull
    @Column(name="type")
    private String type;

    public User() {
    }

    public User(int id, String fullname, Gender gender, String email, String password, LocalDate dateOfBirth, int enabled, String contactInfo, String address, String type) {
        this.id = id;
        this.fullname = fullname;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.enabled = enabled;
        this.contactInfo = contactInfo;
        Address = address;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



}
