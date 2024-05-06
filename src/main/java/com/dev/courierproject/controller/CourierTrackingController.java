package com.dev.courierproject.controller;


import com.dev.courierproject.dto.request.CourierTrackingRequest;
import com.dev.courierproject.dto.response.CourierTrackingResponse;
import com.dev.courierproject.implement.CourierTrackingImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
@Tag(name ="Courier Tracking", description = "Courier Tracking API")
@RestController
@RequestMapping("/api/v1")
public class CourierTrackingController {

    public final CourierTrackingImpl courierTrackingImpl;

    public CourierTrackingController(CourierTrackingImpl courierTrackingImpl) {
        this.courierTrackingImpl = courierTrackingImpl;
    }

    @Operation(summary = "Courier Tracking Create",
            description = "Courier Tracking Create")
    @PostMapping("/save")
    public CourierTrackingResponse saveCourierTracking(@RequestBody CourierTrackingRequest courierTrackingRequest) throws IOException {
        return courierTrackingImpl.saveCourierTracking(courierTrackingRequest);
    }



    @Operation(summary = "Courier Total Travel Distance",
            description = "Courier Total Travel Distance")
    @GetMapping("/distance/{courierId}")
    public String getTotalTravelDistance(@PathVariable Long courierId){
        return courierTrackingImpl.getTotalTravelDistance(courierId);
    }
}
