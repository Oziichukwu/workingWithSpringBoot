package com.phoenixStore.service.product;

import com.github.fge.jsonpatch.JsonPatch;
import com.phoenixStore.data.dto.ProductDto;
import com.phoenixStore.data.models.Product;
import com.phoenixStore.web.exception.ProductDoesNotExistException;

import java.util.List;

public interface ProductService {

    Product findProductById(Long productId)throws ProductDoesNotExistException;

    List<Product> getAllProducts();

    Product createProduct(ProductDto productDto);

    Product updateProduct(Long productId, ProductDto productDetails);

    Product updateProductDetails(Long productId, JsonPatch patch);
}
