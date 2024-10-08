package com.helloWorld.beautyShop.controllers;


import com.helloWorld.beautyShop.services.implementation.AttractionImp;
import com.helloWorld.beautyShop.services.implementation.VisitorImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AttractionController.class)
public class AttractionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VisitorImp visitorService;

    @MockBean
    private AttractionImp attractionService;

    @Test
    public void loggedUserShouldReturnAttractions() throws Exception {

        MockHttpSession session = new MockHttpSession();
        session.setAttribute("visitor", new VisitorModel(
                "Cristian",
                25,
                000,
                "hola@email.com",
                "123"
        ));



        List<AttractionModel> attractions = new ArrayList<>();

        when(visitorService.isAuthenticated(any())).thenReturn(true);
        when(attractionService.getAllAttractions()).thenReturn(attractions);


        mockMvc.perform(MockMvcRequestBuilders.get("/attractions").session(session))
                .andExpect(status().isOk())
                .andExpect(view().name("attractions"))
                .andExpect(model().attribute("attractions", attractions));
    }

    @Test
    public void notLoggedUserShouldReturn404() throws Exception {


        when(visitorService.isAuthenticated(any())).thenReturn(false);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/attractions"))
                .andExpect(status().isOk())
                .andExpect(view().name("404"));
    }
}