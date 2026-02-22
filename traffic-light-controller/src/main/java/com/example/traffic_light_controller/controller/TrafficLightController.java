package com.example.traffic_light_controller.controller;

import com.example.traffic_light_controller.service.TrafficLightService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrafficLightController {

    private final TrafficLightService service = new TrafficLightService();

    @GetMapping("/lights")
    public Object getLights() {
        return service.getCurrentStates();
    }
}
