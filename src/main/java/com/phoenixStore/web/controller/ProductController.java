package com.phoenixStore.web.controller;


import com.phoenixStore.data.dto.ApiResponse;
import com.phoenixStore.data.dto.ProductDto;
import com.phoenixStore.data.models.Product;
import com.phoenixStore.service.product.ProductService;
import com.phoenixStore.web.exception.ProductDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping()
    public ResponseEntity<?> findAllProducts(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
        //return ResponseEntity.ok().body(products);
    }

    @PostMapping()
    public ResponseEntity<?> createProduct(@RequestBody ProductDto productDto){
        try {
            Product product = productService.createProduct(productDto);
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        }catch (ProductDoesNotExistException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?>findProduct(@PathVariable Long productId){
        try {
            productService.findProductById(productId);
            return new ResponseEntity<>(new ApiResponse(true, "Product Found"), HttpStatus.OK);
        }catch (ProductDoesNotExistException e){
            return new ResponseEntity<>(new ApiResponse(false, "Product does not exist"), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{productId}")
    public ResponseEntity<?>updateProduct(@PathVariable Long productId, @RequestBody ProductDto productDetails){

        try{
            return new ResponseEntity<>(productService.updateProduct(productId, productDetails),HttpStatus.OK );
        }catch (ProductDoesNotExistException e){
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}