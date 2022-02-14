package com.phoenixStore.data.repository;

import com.phoenixStore.data.models.Cart;
import com.phoenixStore.data.models.Item;
import com.phoenixStore.data.models.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
@Sql(scripts = {"/db/insert.sql"})
public class CartRepositoryTest {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("Add an item to cart")
    void addProductToCart() {
        Product product = productRepository.findByName("television").orElse(null);
        assertThat(product).isNotNull();

        Item item = new Item(product, 4);
        Cart cart = new Cart();
        cart.addItem(item);

        cartRepository.save(cart);
        assertThat(cart.getId()).isNotNull();
        assertThat(cart.getItemList().isEmpty()).isFalse();
        assertThat(cart.getItemList().get(0).getProduct()).isNotNull();
        log.info("Cart object ::{} ", cart);

    }
}
