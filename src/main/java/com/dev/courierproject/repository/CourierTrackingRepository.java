package com.dev.courierproject.repository;

import com.dev.courierproject.entity.CourierTracking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourierTrackingRepository extends JpaRepository<CourierTracking,Long> {

    List<CourierTracking> findAllByCourierIdOrderByTimeAsc(Long courierId);

    List<CourierTracking> findAllByCourierIdAndStoreOrderByTimeDesc(Long courierId,String store);
}
