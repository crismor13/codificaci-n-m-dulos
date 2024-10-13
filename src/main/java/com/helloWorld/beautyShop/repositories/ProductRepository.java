package com.helloWorld.beautyShop.repositories;

import com.helloWorld.beautyShop.models.Product;
import com.helloWorld.beautyShop.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByQuantityLessThanEqual(int quantity);
}
