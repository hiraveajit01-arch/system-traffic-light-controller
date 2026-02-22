package com.example.traffic_light_controller.service;

import com.example.traffic_light_controller.entity.Direction;
import com.example.traffic_light_controller.entity.TrafficLightState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrafficLightServiceTest {

    private TrafficLightService service;


    @BeforeEach
    void setup() {
        service = new TrafficLightService();
    }
    //Test case to initialize all lights to RED initially
    @Test
    void shouldInitializeAllDirectionsToRed() {
        Map<Direction, TrafficLightState> states = service.getCurrentStates();

        assertEquals(TrafficLightState.RED, states.get(Direction.NORTH));
        assertEquals(TrafficLightState.RED, states.get(Direction.SOUTH));
        assertEquals(TrafficLightState.RED, states.get(Direction.EAST));
        assertEquals(TrafficLightState.RED, states.get(Direction.WEST));
    }
    //Test case to change the state of any direction
    @Test
    void shouldChangeStateSuccessfully() {
        service.changeState(Direction.NORTH, TrafficLightState.GREEN);

        assertEquals(TrafficLightState.GREEN,
                service.getCurrentStates().get(Direction.NORTH));
    }
    //Test case to not allow conflicting state change
    @Test
    void shouldNotAllowConflictingGreenSignals() {

        service.changeState(Direction.NORTH, TrafficLightState.GREEN);

        org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class,
                () -> service.changeState(Direction.SOUTH, TrafficLightState.GREEN));
    }
    //Test case to add history in traffic light change

    @Test
    void shouldRecordHistoryWhenStateChanges() {

        service.changeState(Direction.NORTH, TrafficLightState.GREEN);

        assertEquals(1, service.getHistory().size());
    }


}
