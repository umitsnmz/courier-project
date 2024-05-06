package com.dev.courierproject.mapper;

import com.dev.courierproject.dto.request.CourierTrackingRequest;
import com.dev.courierproject.dto.response.CourierTrackingResponse;
import com.dev.courierproject.entity.CourierTracking;
import org.springframework.stereotype.Component;

@Component
public class CourierTrackingMapper {

    public CourierTracking courierTrackingRequestToCourierTracking(CourierTrackingRequest courierTrackingRequest) {
        CourierTracking courierTracking = new CourierTracking();
        courierTracking.setCourierId(courierTrackingRequest.getCourierId());
        courierTracking.setLng(courierTrackingRequest.getLng());
        courierTracking.setLat(courierTrackingRequest.getLat());
        return courierTracking;
    }

    public CourierTrackingResponse courierTrackingToCourierTrackingResponse(CourierTracking courierTracking) {
        CourierTrackingResponse courierTrackingResponse = new CourierTrackingResponse();
        courierTrackingResponse.setCourierId(courierTracking.getCourierId());
        courierTrackingResponse.setLng(courierTracking.getLng());
        courierTrackingResponse.setLat(courierTracking.getLat());
        return courierTrackingResponse;
    }
}
