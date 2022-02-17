package com.phoenixStore.data.dto;

import com.phoenixStore.data.models.Item;
import lombok.Data;

import java.util.List;

@Data
public class CartResponseDto {

    private List<Item> totalItemsInCart;

    private double totalPrice;


}
