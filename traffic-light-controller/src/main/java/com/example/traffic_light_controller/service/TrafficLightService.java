package com.example.traffic_light_controller.service;

import com.example.traffic_light_controller.entity.Direction;
import com.example.traffic_light_controller.entity.TrafficHistory;
import com.example.traffic_light_controller.entity.TrafficLightState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
@Service
public class TrafficLightService {
    private final ConflictValidator validator = new ConflictValidator();
    private final HistoryService historyService = new HistoryService();

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



    public synchronized void changeState(Direction direction, TrafficLightState newState) {

        TrafficLightState previousState = states.get(direction);

        validator.validate(direction, newState, states);

        states.put(direction, newState);

        historyService.record(direction, previousState, newState);
    }

    public List<TrafficHistory> getHistory() {
        return historyService.getHistory();
    }




}
