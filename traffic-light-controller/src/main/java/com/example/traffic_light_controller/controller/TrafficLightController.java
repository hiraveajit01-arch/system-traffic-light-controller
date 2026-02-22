package com.example.traffic_light_controller.controller;


import com.example.traffic_light_controller.entity.ChangeStateRequest;
import com.example.traffic_light_controller.service.TrafficLightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "Traffic Controller", description = "Manage traffic lights")
public class TrafficLightController {

    private final TrafficLightService service;



    @GetMapping("/lights")
    @Operation(summary = "Get current traffic light states")
    public Object getLights() {
        return service.getCurrentStates();
    }
//    git commit -am "Expose GET /history endpoint" 25

    @GetMapping("/history")
    @Operation(summary = "Get current traffic light history")
    public Object getHistory() {
        return service.getHistory();
    }

    //    "Add REST endpoints for pause and resume"  26
    @PostMapping("/pause")
    @Operation(summary = "Pause controller")
    public void pause() {
        service.pauseController();
    }

    @PostMapping("/resume")
    @Operation(summary = "Resume controller")
    public void resume() {
        service.resumeController();
    }

    @PostMapping("/lights")
    @Operation(summary = "Change traffic light state")
    public void changeState(@RequestBody ChangeStateRequest request) {
        service.changeState(request.getDirection(),
                request.getNewState());
    }



}


