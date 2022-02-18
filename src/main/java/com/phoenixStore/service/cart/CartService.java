package com.phoenixStore.service.cart;

import com.github.fge.jsonpatch.JsonPatch;
import com.phoenixStore.data.dto.CartItemDto;
import com.phoenixStore.data.dto.CartResponseDto;
import com.phoenixStore.data.dto.CartUpdateDto;
import com.phoenixStore.data.models.Cart;

public interface CartService {

    CartResponseDto addItemToCart(CartItemDto cartItemDto);

    CartResponseDto viewCart(Long userId);

    CartResponseDto updateCart(CartUpdateDto cartUpdateDto);

}
