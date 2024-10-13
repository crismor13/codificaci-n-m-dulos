package com.helloWorld.beautyShop.repositories;

import com.helloWorld.beautyShop.models.Sale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends CrudRepository<Sale, Long> {

    // Custom query to get the 8 most recent sales
    @Query("SELECT s FROM Sale s ORDER BY s.saleDate DESC")
    List<Sale> findTop8ByOrderBySaleDateDesc();
}
