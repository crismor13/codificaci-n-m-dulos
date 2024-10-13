package com.helloWorld.beautyShop.services.implementation;

import com.helloWorld.beautyShop.models.Product;
import com.helloWorld.beautyShop.models.Sale;
import com.helloWorld.beautyShop.repositories.ProductRepository;
import com.helloWorld.beautyShop.repositories.SaleRepository;
import com.helloWorld.beautyShop.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleImp implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public List<Sale> getAllSales() {
        return (List<Sale>) saleRepository.findAll();
    }

    @Override
    public List<Sale> getMostRecentSales() {
        return (List<Sale>) saleRepository.findTop8ByOrderBySaleDateDesc();
    }

    @Override
    public Optional<Sale> getSaleById(Long id) {
        return Optional.empty();
    }
}
