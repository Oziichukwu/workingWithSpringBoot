package com.phoenixStore.service.product;

import com.phoenixStore.data.dto.ProductDto;
import com.phoenixStore.data.models.Product;
import com.phoenixStore.data.repository.ProductRepository;
import com.phoenixStore.web.exception.BusinessLogicException;
import com.phoenixStore.web.exception.ProductDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product findProductById(Long productId) throws ProductDoesNotExistException{

        if (productId == null){
            throw new IllegalArgumentException("Id cannot be null");
        }
        Optional<Product> queryResult = productRepository.findById(productId);

        return queryResult.orElseThrow(()->
                new ProductDoesNotExistException("Product with Id:" + productId+ "Does not exist"));

    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(ProductDto productDto) {

        if (productDto == null){
            throw new IllegalArgumentException("Argument cannot be null");
        }

        Optional<Product> query = productRepository.findByName(productDto.getName());
        if (query.isPresent()){
            throw new BusinessLogicException("Product with name " + productDto.getName()+ "already exist");
        }
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());

        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long productId, ProductDto productDetails) {

        Product updatedProduct = productRepository.findById(productId).orElseThrow(()->
                 new ProductDoesNotExistException("product with " + productId + "does not exist" ));

        updatedProduct.setName(productDetails.getName());
        updatedProduct.setQuantity(productDetails.getQuantity());
        updatedProduct.setDescription(productDetails.getDescription());
        updatedProduct.setPrice(productDetails.getPrice());

        return productRepository.save(updatedProduct);
    }
}
