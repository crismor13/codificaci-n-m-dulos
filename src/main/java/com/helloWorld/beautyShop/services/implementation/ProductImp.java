package com.helloWorld.beautyShop.services.implementation;

import com.helloWorld.beautyShop.models.Product;
import com.helloWorld.beautyShop.models.User;
import com.helloWorld.beautyShop.repositories.ProductRepository;
import com.helloWorld.beautyShop.services.AuthService;
import com.helloWorld.beautyShop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public List<Product> getLowStockProducts(int threshold) {
        return productRepository.findByQuantityLessThanEqual(threshold);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product saveProduct(Product newProduct) {
        return productRepository.save(newProduct);
    }

    @Override
    public Product updateProduct(Product updatedProduct, Long productId) {
        Optional<Product> oldProductOptional = getProductById(productId);

        // Check if the product with the given ID exists
        if (oldProductOptional.isPresent()) {
            Product oldProduct = oldProductOptional.get();

            // Update the fields of the old product with the new data
            oldProduct.setName(updatedProduct.getName());
            oldProduct.setDescription(updatedProduct.getDescription());
            oldProduct.setPrice(updatedProduct.getPrice());
            oldProduct.setQuantity(updatedProduct.getQuantity());

            // Save the updated product
            return productRepository.save(oldProduct);
        }
        return null;
    }


    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
