package com.phoenixStore.data.models;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;


@Entity
@Data
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true)
    private String email;

    @Column(length = 500)
    private String address;

    @OneToOne(cascade =  CascadeType.PERSIST)
    private final Cart myCart;

    public AppUser(){
        this.myCart = new Cart();
    }
}
