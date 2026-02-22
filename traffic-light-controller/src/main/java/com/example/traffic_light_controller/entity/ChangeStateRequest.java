package com.example.traffic_light_controller.entity;

import com.example.traffic_light_controller.enums.Direction;
import com.example.traffic_light_controller.enums.TrafficLightState;

public class ChangeStateRequest {

    private Direction direction;
    private TrafficLightState newState;

    public Direction getDirection() {
        return direction;
    }

    public TrafficLightState getNewState() {
        return newState;
    }
}

