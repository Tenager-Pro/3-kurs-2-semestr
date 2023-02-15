package model;

import jakarta.persistence.*;

import java.sql.Date;


@Entity
@Table(name="teachers")
public class Teacher extends BaseEntity {

    @Column(name="name", length=128, nullable=false)
    private String name;

    @Column(name="phone_number", length=16, nullable=true)
    private String phoneNumber;

    @Column(name="birth_date", nullable=false)
    private Date birthDate;

    @Column(name="position", length=32, nullable=true)
    private String position;

    public Teacher() {}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}