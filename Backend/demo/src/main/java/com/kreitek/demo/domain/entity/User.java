package com.kreitek.demo.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequence")
    private Long id;

    @Column(length = 100, nullable = false)
    @Size(min = 3, max = 100)
    private String nickname;

    @Column(length = 100, nullable = false)
    @Size(min = 3, max = 100)
    private String lastName;

    @Column(length = 100, nullable = false)
    @Size(min = 3, max = 100)
    private String name;

    @Column(length = 9, nullable = false)
    @Pattern(regexp = "\\d{9}", message = "Phone number must be exactly 9 digits")
    private String phoneNumber;

    @Column(length = 100, nullable = false)
    @Email
    private String email;

    @NotEmpty
    @Column(length = 100, nullable = false)
    @Size(min = 3, max = 100)
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
}
