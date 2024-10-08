package com.helloWorld.beautyShop.services;

import com.helloWorld.beautyShop.repositories.AttractionRepository;
import com.helloWorld.beautyShop.services.implementation.AttractionImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class AttractionImpTest {

    @InjectMocks
    private AttractionImp attractionService;

    @Mock
    private AttractionRepository attractionRepository;

    @Test
    public void shouldSaveAttraction() {
        AttractionModel newAttraction = new AttractionModel();

        when(attractionRepository.save(newAttraction)).thenReturn(newAttraction);

        AttractionModel savedAttraction = attractionService.saveAttraction(newAttraction);

        assertEquals(newAttraction.getAttractionId(), savedAttraction.getAttractionId());
    }

    @Test
    public void shouldGetAttractionById() {
        AttractionModel attraction = new AttractionModel();

        when(attractionRepository.findById(1L)).thenReturn(Optional.of(attraction));

        Optional<AttractionModel> foundAttraction = attractionService.getAttractionById(1L);

        assertEquals(attraction.getAttractionId(), foundAttraction.get().getAttractionId());
    }

    @Test
    public void shouldGetAllAttractions() {
        AttractionModel attraction1 = new AttractionModel();
        AttractionModel attraction2 = new AttractionModel();
        when(attractionRepository.findAll()).thenReturn(Arrays.asList(attraction1, attraction2));

        List<AttractionModel> attractions = attractionService.getAllAttractions();

        assertEquals(2, attractions.size());
    }
}