package com.example.traffic_light_controller.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ControllerStateServiceTest {

    @Test
    void shouldPauseController() {
        ControllerStateService service = new ControllerStateService();
        service.pause();
        assertEquals(ControllerStatus.PAUSED, service.getStatus());
    }
}

