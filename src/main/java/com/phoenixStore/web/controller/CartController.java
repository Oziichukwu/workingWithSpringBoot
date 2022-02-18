package com.phoenixStore.web.controller;


import com.phoenixStore.data.dto.CartItemDto;
import com.phoenixStore.data.dto.CartResponseDto;
import com.phoenixStore.service.cart.CartService;
import com.phoenixStore.web.exception.BusinessLogicException;
import com.phoenixStore.web.exception.ProductDoesNotExistException;
import com.phoenixStore.web.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;


    @PostMapping()
    public ResponseEntity<?>addItemToCart(CartItemDto cartItemDto){
        CartResponseDto cartResponseDto = null;
        try{
            cartResponseDto = cartService.addItemToCart(cartItemDto);
        }catch (ProductDoesNotExistException | UserNotFoundException | BusinessLogicException e){
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok().body(cartResponseDto);
    }
}
