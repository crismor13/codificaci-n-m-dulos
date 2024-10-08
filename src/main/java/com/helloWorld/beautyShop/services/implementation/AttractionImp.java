//package com.helloWorld.beautyShop.services.implementation;
//
//import com.helloWorld.beautyShop.repositories.AttractionRepository;
//import com.helloWorld.beautyShop.services.AttractionService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class AttractionImp implements AttractionService {
//
//    @Autowired
//    private AttractionRepository attractionRepository;
//
//
//    @Override
//    public AttractionModel saveAttraction(AttractionModel newAttraction) {
//        return attractionRepository.save(newAttraction);
//    }
//
//    @Override
//    public Optional<AttractionModel> getAttractionById(Long attractionId) {
//        return attractionRepository.findById(attractionId);
//    }
//
//    @Override
//    public List<AttractionModel> getAllAttractions() {
//        return (List<AttractionModel>) attractionRepository.findAll();
//    }
//}
