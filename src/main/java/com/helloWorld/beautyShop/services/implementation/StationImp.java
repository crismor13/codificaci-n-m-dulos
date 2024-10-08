//package com.helloWorld.beautyShop.services.implementation;
//
//import com.helloWorld.beautyShop.repositories.StationRepository;
//import com.helloWorld.beautyShop.services.StationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class StationImp implements StationService {
//
//    @Autowired
//    private StationRepository stationRepository;
//
//    @Override
//    public StationModel saveStation(StationModel newStation) {
//        return null;
//    }
//
//    @Override
//    public Optional<StationModel> getStationById(Long id) {
//        return stationRepository.findById(id);
//    }
//
//    @Override
//    public List<StationModel> getAllStations() {
//        return (List<StationModel>) stationRepository.findAll();
//    }
//}
