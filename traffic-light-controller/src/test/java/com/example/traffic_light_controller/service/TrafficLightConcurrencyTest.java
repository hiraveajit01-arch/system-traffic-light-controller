package com.example.traffic_light_controller.service;

import com.example.traffic_light_controller.entity.Direction;
import com.example.traffic_light_controller.entity.TrafficLightState;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrafficLightConcurrencyTest {

    @Test
    void onlyOneDirectionShouldBecomeGreenInParallel() throws Exception {

        TrafficLightService service = new TrafficLightService();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<Boolean> task1 = () -> {
            try {
                service.changeState(Direction.NORTH, TrafficLightState.GREEN);
                return true;
            } catch (Exception e) {
                return false;
            }
        };

        Callable<Boolean> task2 = () -> {
            try {
                service.changeState(Direction.SOUTH, TrafficLightState.GREEN);
                return true;
            } catch (Exception e) {
                return false;
            }
        };

        Future<Boolean> f1 = executor.submit(task1);
        Future<Boolean> f2 = executor.submit(task2);

        int successCount = 0;
        if (f1.get()) successCount++;
        if (f2.get()) successCount++;

        assertEquals(1, successCount);

        executor.shutdown();
    }
}

