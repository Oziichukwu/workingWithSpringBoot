package com.phoenixStore.data.models;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<Product> products;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Item>itemList;

    @Transient
    private Double totalPrice;


    public void addItem(Item item){
        if (itemList == null){
            itemList = new ArrayList<>();
        }
        itemList.add(item);
    }


}
