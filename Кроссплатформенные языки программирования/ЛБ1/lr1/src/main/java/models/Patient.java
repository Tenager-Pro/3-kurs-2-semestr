package models;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table (name = "patients")
public class Patient extends BaseEntity{

    @Column(name = "first_name")
    private String firstName;
    @Column(name="phone_number", length=16, nullable=true)
    private String phoneNumber;
    @Column(name = "birth_date", nullable=false)
    private Date birthDate;

    @Column(name = "patient_card")
    private Integer patientCard;
    public Patient() {}

    public void addContract(Contract contract) {
        contract.setPatient(this);
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public Integer getPatientCard() {
        return patientCard;
    }

    public void setPatientCard(Integer patientCard){
        this.patientCard = patientCard;
    }
    @Override
    public String toString() {
        return "models.User{" +
                "id=" + id +
                ", name='" + firstName + '\''+ '}';
    }
}
