package com.dev.courierproject.service;

import com.dev.courierproject.dto.request.CourierTrackingRequest;
import com.dev.courierproject.dto.response.CourierTrackingResponse;
import com.dev.courierproject.entity.CourierTracking;
import com.dev.courierproject.implement.CourierTrackingImpl;
import com.dev.courierproject.mapper.CourierTrackingMapper;
import com.dev.courierproject.mapper.StoreService;
import com.dev.courierproject.repository.CourierTrackingRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class CourierTrackingService implements CourierTrackingImpl {
    private static final double RADIUS_WORD= 6371;
    private final CourierTrackingRepository courierTrackingRepository;
    private final CourierTrackingMapper courierTrackingMapper;
    private final StoreService storeService;

    public CourierTrackingService(CourierTrackingRepository courierTrackingRepository, CourierTrackingMapper courierTrackingMapper, StoreService storeService) {
        this.courierTrackingRepository=courierTrackingRepository;
        this.courierTrackingMapper = courierTrackingMapper;
        this.storeService = storeService;
    }

    @Override
    public CourierTrackingResponse saveCourierTracking(CourierTrackingRequest courierTrackingRequest) throws IOException {
        CourierTracking courierTracking = courierTrackingMapper.courierTrackingRequestToCourierTracking(courierTrackingRequest);
        List<Map<String, Object>> stores = storeService.getStores();
        for (int i = 0; i <stores.size()- 1; i++){
            Object lat = stores.get(i).get("lat");
            Object lng = stores.get(i).get("lng");
            Object name = stores.get(i).get("name");
            double distance = calculateDistance((Double) lat,(Double) lng, courierTrackingRequest.getLat(), courierTrackingRequest.getLng());
            if (distance * 100 <=100) {
                List<CourierTracking> allByCourierIdAndStoreOrderByTimeDesc = courierTrackingRepository.findAllByCourierIdAndStoreOrderByTimeDesc(courierTracking.getCourierId(), (String) name);
                if (!allByCourierIdAndStoreOrderByTimeDesc.isEmpty()) {
                    LocalDateTime time = allByCourierIdAndStoreOrderByTimeDesc.get(0).getTime();
                    LocalDateTime now = LocalDateTime.now();
                    Duration fark = Duration.between(now, time);
                    if (fark.getSeconds() > 60) {
                        courierTracking.setEntrance(true);
                        courierTracking.setStore((String) name);
                        courierTracking = courierTrackingRepository.save(courierTracking);
                        return courierTrackingMapper.courierTrackingToCourierTrackingResponse(courierTracking);
                    }
                } else {
                    courierTracking.setEntrance(true);
                    courierTracking.setStore((String) name);
                    courierTracking = courierTrackingRepository.save(courierTracking);
                    return courierTrackingMapper.courierTrackingToCourierTrackingResponse(courierTracking);
                }
            }
        }
        courierTracking = courierTrackingRepository.save(courierTracking);
        return courierTrackingMapper.courierTrackingToCourierTrackingResponse(courierTracking);
    }

    @Override
    public String getTotalTravelDistance(Long courierId) {
        List<CourierTracking> allByCourierId = courierTrackingRepository.findAllByCourierIdOrderByTimeAsc(courierId);
        double totalDistance = 0;
        DecimalFormat df = new DecimalFormat("#.##");
        if (allByCourierId == null || allByCourierId.isEmpty()) {
            return "Kurye id : " + courierId + " olan kuryeye ait konum verisi bulunmamaktadır!";
        } else if (!(allByCourierId.size() > 1)) {
            return "Kurye id : " + courierId + " olan kurye hiç yol almamıştır!";
        } else {
            for (int i = 0; i < allByCourierId.size() - 1; i++) {
                CourierTracking konum1 = allByCourierId.get(i);
                CourierTracking konum2 = allByCourierId.get(i + 1);
                double distance = calculateDistance(konum1.getLat(), konum1.getLng(), konum2.getLat(), konum2.getLng());
                totalDistance += distance;
            }
            //allByCourierId.stream().map(courierTracking -> courierTracking.getLat()+ " " +courierTracking.getLng()).collect(Collectors.toList());
            return "Kurye id                 : " + courierId +
                    "\nKurye İlk Hareket Zamanı : " + allByCourierId.get(0).getTime() +
                    "\nKurye Son Hareket Zamanı : " + allByCourierId.get(allByCourierId.size() - 1).getTime() +
                    "\nTotal Mesafe             : " + Double.parseDouble(df.format(totalDistance))+" km";
        }
    }

    public double calculateDistance(double lat1, double lng1, double lat2, double lng2) {
        double lat1Rad = Math.toRadians(lat1);
        double lng1Rad = Math.toRadians(lng1);
        double lat2Rad = Math.toRadians(lat2);
        double lng2Rad = Math.toRadians(lng2);
        double dLat = lat2Rad - lat1Rad;
        double dLon = lng2Rad - lng1Rad;
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return RADIUS_WORD * c;
    }

}
