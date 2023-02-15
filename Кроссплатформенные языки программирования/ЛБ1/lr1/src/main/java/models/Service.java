package models;

import jakarta.persistence.*;

@Entity
@Table(name = "services")
public class Service extends BaseEntity{

    @Column (name = "name")
    private String name;

    //можно не указывать Column name, если оно совпадает с названием столбца в таблице
    @Column (name = "price")
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_card_id")
    private PatientCard patientCard;

    public Service() {
    }

    public Service(String name, double price) {
        this.name = name;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
    public PatientCard getPatientCard() {
        return patientCard;
    }

    public void setPatientCard(PatientCard patientCard) {
        this.patientCard = patientCard;
    }

    @Override
    public String toString() {
        return name + " " + price;
    }

}
