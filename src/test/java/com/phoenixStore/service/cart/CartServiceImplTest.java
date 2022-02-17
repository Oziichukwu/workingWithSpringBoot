package com.phoenixStore.service.cart;

import com.phoenixStore.data.dto.CartItemDto;
import com.phoenixStore.data.dto.CartResponseDto;
import com.phoenixStore.data.models.AppUser;
import com.phoenixStore.data.models.Cart;
import com.phoenixStore.data.models.Item;
import com.phoenixStore.data.models.Product;
import com.phoenixStore.data.repository.AppUserRepository;
import com.phoenixStore.data.repository.CartRepository;
import com.phoenixStore.data.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@Slf4j
@SpringBootTest
@Sql("/db/insert.sql")
class CartServiceImplTest {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartService cartService;

    @BeforeEach
    void setUp() {
    }




    @Test
    @DisplayName("add item to cart")
    void addItemToCartTest(){

        CartItemDto cartItemDto = new CartItemDto();

        cartItemDto.setQuantity(1);
        cartItemDto.setUserId(5005L);
        cartItemDto.setProductId(12L);

        AppUser userInDb = appUserRepository.findById(cartItemDto.getUserId()).orElse(null);
        assertThat(userInDb).isNotNull();

        Cart myCart = userInDb.getMyCart();
        assertThat(myCart).isNotNull();

        Product product = productRepository.findById(12L).orElse(null);
        assertThat(product).isNotNull();
        assertThat(product.getQuantity()).isGreaterThanOrEqualTo(cartItemDto.getQuantity());


        Item cartItem = new Item(product, cartItemDto.getQuantity());

        myCart.addItem(cartItem);

        cartRepository.save(myCart);
        assertThat(myCart.getItemList().size()).isEqualTo(4);

    }


    @Test
    @DisplayName("Add item to cart test")
    void addItemToCartTest2(){

        CartItemDto cartItemDto = new CartItemDto();

        cartItemDto.setQuantity(1);
        cartItemDto.setUserId(5005L);
        cartItemDto.setProductId(12L);

        CartResponseDto cartResponseDto = cartService.addItemToCart(cartItemDto);
        assertThat(cartResponseDto.getTotalItemsInCart()).isNotNull();
        assertThat(cartResponseDto.getTotalPrice()).isNotNull();
    }

}