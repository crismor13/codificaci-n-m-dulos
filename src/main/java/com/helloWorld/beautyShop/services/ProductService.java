package com.helloWorld.beautyShop.services;

import com.helloWorld.beautyShop.models.Product;
import com.helloWorld.beautyShop.models.User;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();
    List<Product> getLowStockProducts(int threshold);
    Optional<Product> getProductById(Long id);
    Product saveProduct(Product newProduct);
    Product updateProduct(Product updatedProduct, Long productId);
    void deleteProduct(Long id);
}
