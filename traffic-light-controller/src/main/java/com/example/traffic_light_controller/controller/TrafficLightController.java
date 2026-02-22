package com.example.traffic_light_controller.controller;

import com.example.traffic_light_controller.entity.ChangeStateRequest;
import com.example.traffic_light_controller.service.TrafficLightService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrafficLightController {

    private final TrafficLightService service = new TrafficLightService();

    @PostMapping("/lights")
    public void changeState(@RequestBody ChangeStateRequest request) {
        service.changeState(request.getDirection(),
                request.getNewState());
    }

}
