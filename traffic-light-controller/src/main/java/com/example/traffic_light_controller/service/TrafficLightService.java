package com.example.traffic_light_controller.service;

import com.example.traffic_light_controller.entity.Direction;
import com.example.traffic_light_controller.entity.TrafficLightState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
@Service
public class TrafficLightService {

        private final Map<Direction, TrafficLightState> states =
            new EnumMap<>(Direction.class);

    public TrafficLightService() {
        for (Direction direction : Direction.values()) {
            states.put(direction, TrafficLightState.RED);
        }
    }
    public Map<Direction, TrafficLightState> getCurrentStates() {
        return Collections.unmodifiableMap(states);
    }

    public void changeState(Direction direction, TrafficLightState newState) {
        states.put(direction, newState);
    }

}
