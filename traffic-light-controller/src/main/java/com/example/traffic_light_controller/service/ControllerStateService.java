package com.example.traffic_light_controller.service;

import com.example.traffic_light_controller.enums.ControllerStatus;
import org.springframework.stereotype.Service;

@Service
public class ControllerStateService {

    private ControllerStatus status = ControllerStatus.RUNNING;

    public void pause() {
        status = ControllerStatus.PAUSED;
    }

    public void resume() {
        status = ControllerStatus.RUNNING;
    }

    public ControllerStatus getStatus() {
        return status;
    }
}


