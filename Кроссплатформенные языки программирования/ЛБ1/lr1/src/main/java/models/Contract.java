package models;
import java.util.List;
import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "contracts")
public class Contract extends BaseEntity{

    @Column (name = "number_contract")
    private String numberContract;

    //можно не указывать Column name, если оно совпадает с названием столбца в таблице
    @Column (name = "total_cost")
    private int totalCost;

    @Column (name = "create_date")
    private Date createDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToMany(mappedBy = "contract")
    private List<PatientCard> patientCards;

    public Contract(int id, String numberContract, int totalCost, Date createDate, Patient patient, List<PatientCard> patientCards) {
        this.id = id;
        this.numberContract = numberContract;
        this.totalCost = totalCost;
        this.createDate = createDate;
        this.patient = patient;
    }
    public Contract(String numberContract, int totalCost, Date createDate, Patient patient, List<PatientCard> patientCards) {
        this.numberContract = numberContract;
        this.totalCost = totalCost;
        this.createDate = createDate;
        this.patient = patient;
    }

    public Contract() {
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getNumberContract() {
        return numberContract;
    }

    public void setNumberContract(String numberContract) {
        this.numberContract = numberContract;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<PatientCard> getPatientCards() {
        return patientCards;
    }

    public void setPatientCard(List<PatientCard> patientCards) {
        this.patientCards = patientCards;
    }
    @Override
    public String toString() {
        return numberContract + " " + totalCost;
    }


}
