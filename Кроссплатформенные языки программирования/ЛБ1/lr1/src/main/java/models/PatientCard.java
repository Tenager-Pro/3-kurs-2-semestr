package models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "patient_cards")
public class PatientCard extends BaseEntity{

    @Column(name = "number_card")
    private String numberCard;

    @Column (name = "create_date")
    private Date createDate;

    @Column (name = "name_proc")
    private String nameProc;

    @Column (name = "price")
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @Column(name = "total_price")
    private int totalPrice;

    public PatientCard() {}

    public PatientCard(int id, String numberCard,String nameProc,Date createDate,int price,Doctor doctor, Contract contract) {
        this.id = id;
        this.numberCard = numberCard;
        this.nameProc = nameProc;
        this.createDate = createDate;
        this.price = price;
        this.doctor = doctor;
        this.contract=contract;
        this.totalPrice = price * doctor.getRatio();


    }
    public PatientCard(String numberCard,String nameProc,Date createDate,int price,Doctor doctor, Contract contract) {
        this.numberCard = numberCard;
        this.nameProc = nameProc;
        this.createDate = createDate;
        this.price = price;
        this.doctor = doctor;
        this.contract=contract;
        this.totalPrice = price * doctor.getRatio();


    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice() {this.totalPrice = this.price * this.doctor.getRatio();}

    public String getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

    public String getNameProc() {
        return nameProc;
    }

    public void setNameProc(String nameProc) {
        this.nameProc = nameProc;
    }
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }


}
