package com.phoenixStore.service.cart;

import com.phoenixStore.data.dto.CartItemDto;
import com.phoenixStore.data.dto.CartResponseDto;
import com.phoenixStore.data.models.Cart;

public interface CartService {

    CartResponseDto addItemToCart(CartItemDto cartItemDto);

    Cart viewCart();

}
