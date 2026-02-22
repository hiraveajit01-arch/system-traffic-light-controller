package com.example.traffic_light_controller.service;

import com.example.traffic_light_controller.entity.Direction;
import com.example.traffic_light_controller.entity.TrafficHistory;
import com.example.traffic_light_controller.entity.TrafficLightState;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HistoryServiceTest {

    @Test
    void shouldRecordStateTransition() {

        HistoryService historyService = new HistoryService();

        historyService.record(Direction.NORTH,
                TrafficLightState.RED,
                TrafficLightState.GREEN);

        List<TrafficHistory> history = historyService.getHistory();

        assertEquals(1, history.size());
        assertEquals(Direction.NORTH, history.get(0).getDirection());
        assertEquals(TrafficLightState.RED, history.get(0).getFrom());
        assertEquals(TrafficLightState.GREEN, history.get(0).getTo());
    }
}

