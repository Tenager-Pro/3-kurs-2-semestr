package models;

import jakarta.persistence.*;
@Entity
@Table (name = "doctors")
public class Doctor extends BaseEntity{


    @Column(name="name")
    private String name;

    @Column(name="post")
    private String post;

    @Column(name="ratio")
    private int ratio;
    @Column(name="phone_number", length=16, nullable=true)
    private String phoneNumber;

    public Doctor(int id, String name,String post, int ratio, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.post=post;
        this.ratio = ratio;
        this.phoneNumber = phoneNumber;

    }
    public Doctor(String name,String post, int ratio, String phoneNumber) {
        this.name = name;
        this.post=post;
        this.ratio = ratio;
        this.phoneNumber = phoneNumber;

    }
    public Doctor() {}

    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getRatio() {
        return ratio;
    }

    public void setRatio(int ratio) {
        this.ratio = ratio;
    }

}
