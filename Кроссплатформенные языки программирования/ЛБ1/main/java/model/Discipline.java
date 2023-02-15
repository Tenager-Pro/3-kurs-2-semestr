package model;

import jakarta.persistence.*;

import java.math.BigDecimal;


@Entity
@Table(name="disciplines")
public class Discipline extends BaseEntity {

    @Column(name="name", length=64, nullable=false)
    private String name;

    @Column(name="credit_points", nullable=false)
    private BigDecimal creditPoints;

    @Column(name="academic_hours")
    private BigDecimal academicHours;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    public Discipline() {}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAcademicHours() {
        return academicHours;
    }
    public void setAcademicHours(BigDecimal academicHours) {
        this.academicHours = academicHours;
    }

    public BigDecimal getCreditPoints() {
        return creditPoints;
    }
    public void setCreditPoints(BigDecimal creditPoints) {
        this.creditPoints = creditPoints;
    }

    public Teacher getTeacher() { return teacher; }
    public void setTeacher() { this.teacher = teacher; }
}