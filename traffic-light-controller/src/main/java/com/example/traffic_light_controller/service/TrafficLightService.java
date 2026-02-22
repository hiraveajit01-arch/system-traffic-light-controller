package com.example.traffic_light_controller.service;
import com.example.traffic_light_controller.entity.TrafficHistory;
import com.example.traffic_light_controller.enums.ControllerStatus;
import com.example.traffic_light_controller.enums.Direction;
import com.example.traffic_light_controller.enums.TrafficLightState;
import com.example.traffic_light_controller.exception.ControllerPausedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class TrafficLightService {

    private final Map<Direction, TrafficLightState> states =
            new EnumMap<>(Direction.class);


    private final ConflictValidator validator;
    private final ControllerStateService controllerStateService;
    private final HistoryService historyService;


    public TrafficLightService() {
        this.validator = new ConflictValidator();
        this.controllerStateService = new ControllerStateService();
        this.historyService = new HistoryService();

        for (Direction direction : Direction.values()) {
            states.put(direction, TrafficLightState.RED);
        }
    }


    public TrafficLightService(ConflictValidator validator,
                               ControllerStateService controllerStateService,
                               HistoryService historyService) {
        this.validator = validator;
        this.controllerStateService = controllerStateService;
        this.historyService = historyService;

        for (Direction direction : Direction.values()) {
            states.put(direction, TrafficLightState.RED);
        }
    }

    public synchronized void changeState(Direction direction,
                                         TrafficLightState newState) {

        if (controllerStateService.getStatus() == ControllerStatus.PAUSED) {
            throw new ControllerPausedException();
        }

        TrafficLightState previousState = states.get(direction);

        validator.validate(direction, newState, states);

        states.put(direction, newState);

        historyService.record(direction, previousState, newState);
    }

    public Map<Direction, TrafficLightState> getCurrentStates() {
        return Collections.unmodifiableMap(states);
    }

    public List<TrafficHistory> getHistory() {
        return historyService.getHistory();
    }

    public void pauseController() {
        controllerStateService.pause();
    }

    public void resumeController() {
        controllerStateService.resume();
    }
}
