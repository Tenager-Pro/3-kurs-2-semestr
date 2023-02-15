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
    private double totalCost;

    @Column (name = "create_date")
    private Date createDate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "contract", cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "service_ids")
    private List<Service> services;

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

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
    @Override
    public String toString() {
        return numberContract + " " + totalCost;
    }


}
