package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="groups")
public class Group extends BaseEntity {

    @Column(name="name", length=16, nullable=false)
    private String name;

    public Group() {}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}