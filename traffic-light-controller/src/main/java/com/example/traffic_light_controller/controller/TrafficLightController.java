package com.example.traffic_light_controller.controller;

import com.example.traffic_light_controller.entity.ChangeStateRequest;
import com.example.traffic_light_controller.service.TrafficLightService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TrafficLightController {

    private final TrafficLightService service;

    public TrafficLightController(TrafficLightService service) {
        this.service = service;
    }

    @GetMapping("/lights")
    public Object getLights() {
        return service.getCurrentStates();
    }

    @PostMapping("/lights")
    public void changeState(@RequestBody ChangeStateRequest request) {
        service.changeState(request.getDirection(),
                request.getNewState());
    }
    @GetMapping("/history")
    public Object getHistory() {
        return service.getHistory();
    }

}

