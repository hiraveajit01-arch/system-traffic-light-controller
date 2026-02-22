package com.example.traffic_light_controller.service;

import com.example.traffic_light_controller.entity.Direction;
import com.example.traffic_light_controller.entity.TrafficLightState;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class ConflictValidator {

    public void validate(Direction direction,
                         TrafficLightState newState,
                         Map<Direction, TrafficLightState> currentStates) {

        if (newState == TrafficLightState.GREEN) {
            for (Map.Entry<Direction, TrafficLightState> entry : currentStates.entrySet()) {
                if (!entry.getKey().equals(direction)
                        && entry.getValue() == TrafficLightState.GREEN) {
                    throw new RuntimeException("Green Signal is conflicting");
                }
            }
        }
    }
}

