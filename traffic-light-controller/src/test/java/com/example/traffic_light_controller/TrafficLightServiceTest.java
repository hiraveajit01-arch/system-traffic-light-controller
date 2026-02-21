package com.example.traffic_light_controller;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrafficLightServiceTest {

    //Test case to initialize all lights to RED initially
    @Test
    void shouldInitializeAllDirectionsToRed() {
        Map<Direction, TrafficLightState> states = service.getCurrentStates();

        assertEquals(TrafficLightState.RED, states.get(Direction.NORTH));
        assertEquals(TrafficLightState.RED, states.get(Direction.SOUTH));
        assertEquals(TrafficLightState.RED, states.get(Direction.EAST));
        assertEquals(TrafficLightState.RED, states.get(Direction.WEST));
    }
}
