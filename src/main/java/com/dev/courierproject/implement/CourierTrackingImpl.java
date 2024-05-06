package com.dev.courierproject.implement;

import com.dev.courierproject.dto.request.CourierTrackingRequest;
import com.dev.courierproject.dto.response.CourierTrackingResponse;

import java.io.IOException;


public interface CourierTrackingImpl {

    CourierTrackingResponse saveCourierTracking(CourierTrackingRequest courierTrackingRequest) throws IOException;
    String getTotalTravelDistance(Long courierId);
}
