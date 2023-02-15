package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "patient_cards")
public class PatientCard extends BaseEntity{

    @Column(name = "number_card")
    private String numberCard;

    @Column (name = "date")
    private Date dateOfVisit;


}
