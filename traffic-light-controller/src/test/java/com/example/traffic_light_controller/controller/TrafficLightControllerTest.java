package com.example.traffic_light_controller.controller;

package com.example.traffic.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class TrafficLightControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnCurrentLightsState() throws Exception {
        mockMvc.perform(get("/lights"))
                .andExpect(status().isOk());
    }
}

