package com.phoenixStore.service.cart;


import com.phoenixStore.data.dto.CartItemDto;
import com.phoenixStore.data.models.AppUser;
import com.phoenixStore.data.models.Cart;
import com.phoenixStore.data.models.Item;
import com.phoenixStore.data.models.Product;
import com.phoenixStore.data.repository.AppUserRepository;
import com.phoenixStore.data.repository.CartRepository;
import com.phoenixStore.data.repository.ProductRepository;
import com.phoenixStore.web.exception.BusinessLogicException;
import com.phoenixStore.web.exception.ProductDoesNotExistException;
import com.phoenixStore.web.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private ProductRepository productRepository;


    @Override
    public void addItemToCart(CartItemDto cartItemDto) {

        Optional<AppUser> query = appUserRepository.findById(cartItemDto.getUserId());

        if (query.isEmpty()){
            throw new UserNotFoundException("User with id" + cartItemDto.getUserId()+ "not found");
        }

        AppUser existingUser = query.get();

        Cart myCart = existingUser.getMyCart();

        Product product =  productRepository.findById(cartItemDto.getProductId()).orElse(null);
        if(product == null){
            throw new ProductDoesNotExistException("Product with id" + cartItemDto.getProductId()+ "does not exist");
        }

        if (!quantityIsValid(product, cartItemDto.getQuantity())){
            throw new BusinessLogicException("Quantity is too large");
        }

        Item cartItem = new Item(product, cartItemDto.getQuantity());

        myCart.addItem(cartItem);

        cartRepository.save(myCart);

    }

    private boolean quantityIsValid (Product product, int quantity){
        return product.getQuantity() >= quantity;
    }
}
