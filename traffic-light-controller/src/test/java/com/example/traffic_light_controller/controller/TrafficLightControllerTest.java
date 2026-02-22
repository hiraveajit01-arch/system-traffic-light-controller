package com.example.traffic_light_controller.controller;

import com.example.traffic_light_controller.service.TrafficLightService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TrafficLightController.class)
class TrafficLightControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private TrafficLightService service;

    @Test
    void shouldReturnLights() throws Exception {
        mockMvc.perform(get("/api/lights"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldPauseController() throws Exception {
        mockMvc.perform(post("/api/pause"))
                .andExpect(status().isOk());
    }
}


