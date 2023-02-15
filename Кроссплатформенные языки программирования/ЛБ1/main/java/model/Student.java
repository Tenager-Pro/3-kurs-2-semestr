package model;

import jakarta.persistence.*;

import java.sql.Date;


@Entity
@Table(name="students")
public class Student extends BaseEntity {
    @Column(name="name", length=128, nullable=false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    @Column(name="phone_number", length=16, nullable=true)
    private String phoneNumber;

    @Column(name="birth_date", nullable=false)
    private Date birthDate;

    public Student() {}
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Group getGroup() {
        return group;
    }
    public void setGroup(Group group) {
        this.group = group;
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