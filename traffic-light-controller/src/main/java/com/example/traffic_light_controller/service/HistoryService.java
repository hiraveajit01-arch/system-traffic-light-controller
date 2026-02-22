package com.example.traffic_light_controller.service;

import com.example.traffic_light_controller.enums.Direction;
import com.example.traffic_light_controller.entity.TrafficHistory;
import com.example.traffic_light_controller.enums.TrafficLightState;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
public class HistoryService {


    private final List<TrafficHistory> history = new ArrayList<>();

    public void record(Direction direction,
                       TrafficLightState from,
                       TrafficLightState to) {
        history.add(new TrafficHistory(direction, from, to));
    }

    public List<TrafficHistory> getHistory() {
        return Collections.unmodifiableList(history);
    }
}


