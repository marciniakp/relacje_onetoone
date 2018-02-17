package com.wersun.relacje.model;

import javax.persistence.*;

@Entity
@Table (name="user_details")
public class UserDetails {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name="id_user_details")
    private Long id;
    @Column (name = "firstname")
    private String firstName;
    @Column (name = "lastname")
    private String lastName;
    @Column (name = "address")
    private String address;
    @OneToOne (mappedBy = "userDetails")
    private User user;

    public UserDetails(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public UserDetails() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
