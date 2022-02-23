package com.phoenixStore.data.models;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;


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

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private boolean enabled;


    @ElementCollection
    private List<Authority> authorities;

    @Column(length = 500)
    private String address;

    @OneToOne(cascade =  CascadeType.ALL)
    private final Cart myCart;

    public AppUser(){
        this.myCart = new Cart();
        this.myCart.setTotalPrice(0.0);
    }
}
