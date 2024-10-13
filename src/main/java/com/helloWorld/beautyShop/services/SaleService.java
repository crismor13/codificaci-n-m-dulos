package com.helloWorld.beautyShop.services;

import com.helloWorld.beautyShop.models.Sale;

import java.util.List;
import java.util.Optional;

public interface SaleService {

    List<Sale> getAllSales();
    List<Sale> getMostRecentSales();
    Optional<Sale> getSaleById(Long id);
}
