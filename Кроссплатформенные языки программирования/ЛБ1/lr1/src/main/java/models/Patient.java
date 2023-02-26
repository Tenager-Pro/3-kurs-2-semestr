package models;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table (name = "patients")
public class Patient extends BaseEntity{

    @Column(name = "name")
    private String name;
    @Column(name="phone_number", length=16, nullable=true)
    private String phoneNumber;
    @Column(name = "birth_date", nullable=false)
    private Date birthDate;

    public Patient() {}

    public Patient(int id,String name,String phoneNumber,Date birthDate) {
        this.id =id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }
    public Patient(String name,String phoneNumber,Date birthDate) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }

    public void addContract(Contract contract) {
        contract.setPatient(this);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setBirthDate(Date birthDate){
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "models.User{" +
                "id=" + id +
                ", name='" + name + '\''+ '}';
    }
}
