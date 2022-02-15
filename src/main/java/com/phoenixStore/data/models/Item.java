package com.phoenixStore.data.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    private Product product;

    private Integer quantityAddedToCart;

    public Item(Product product, Integer quantityAddedToCart){
        if (quantityAddedToCart <= product.getQuantity()){
            this.quantityAddedToCart = quantityAddedToCart;
        }
        this.product = product;
    }

    public void setQuantityAddedToCart(Integer quantityAddedToCart){
        if (quantityAddedToCart <= product.getQuantity())
            this.quantityAddedToCart = quantityAddedToCart;

    }
}
