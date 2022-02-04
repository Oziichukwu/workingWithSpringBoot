package com.phoenixStore.service.product;

import com.phoenixStore.data.dto.ProductDto;
import com.phoenixStore.data.models.Product;
import com.phoenixStore.web.exception.ProductDoesNotExistException;

import java.util.List;

public interface ProductService {

    Product findProductById(Long productId)throws ProductDoesNotExistException;

    List<Product> getAllProducts();

    Product createProduct(ProductDto productDto);

    Product updateProduct(Long productId, ProductDto productDetails);
}
