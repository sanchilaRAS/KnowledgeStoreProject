package com.spring.backend.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authorprofile")
public class AuthorProfile {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "home_town")
    private String home_town;

    @OneToMany(mappedBy = "authorProfile" ,cascade = CascadeType.ALL)
//    @JoinColumn(name = "uc_fid",referencedColumnName = "id")
    List<Notes> notes = new ArrayList<>();

    public AuthorProfile() {

    }

    public AuthorProfile(String first_name, String last_name, String phone_number, String home_town) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.home_town = home_town;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getHome_town() {
        return home_town;
    }

    public void setHome_town(String home_town) {
        this.home_town = home_town;
    }

    public List<Notes> getNotes() {
        return notes;
    }

    public void setNotes(List<Notes> notes) {
        this.notes = notes;
    }
}
