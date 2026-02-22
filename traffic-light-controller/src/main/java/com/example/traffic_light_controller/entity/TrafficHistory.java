package com.example.traffic_light_controller.entity;

import com.example.traffic_light_controller.enums.Direction;
import com.example.traffic_light_controller.enums.TrafficLightState;

import java.time.LocalDateTime;

public class TrafficHistory {

    private final Direction direction;
    private final TrafficLightState from;
    private final TrafficLightState to;
    private final LocalDateTime timestamp;

    public TrafficHistory(Direction direction,
                          TrafficLightState from,
                          TrafficLightState to) {
        this.direction = direction;
        this.from = from;
        this.to = to;
        this.timestamp = LocalDateTime.now();
    }

    public Direction getDirection() {
        return direction;
    }

    public TrafficLightState getFrom() {
        return from;
    }

    public TrafficLightState getTo() {
        return to;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}

