package com.phoenixStore.service.cart;


import com.phoenixStore.data.models.Cart;
import com.phoenixStore.data.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;


    @Override
    public void saveCart(Cart cart) {

    }
}
