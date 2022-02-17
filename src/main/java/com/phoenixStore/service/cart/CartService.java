package com.phoenixStore.service.cart;

import com.phoenixStore.data.dto.CartItemDto;
import com.phoenixStore.data.models.Cart;

public interface CartService {

    void addItemToCart(CartItemDto cartItemDto);

}
