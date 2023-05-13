package com.example.parking.control.services;

import com.example.parking.control.models.ParkingSpotModel;
import com.example.parking.control.repository.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingSpotService {

    @Autowired
    ParkingSpotRepository parkingSpotRepository;
@Transactional
    public Object save(ParkingSpotModel parkingSpotModel) {

        return parkingSpotRepository.save(parkingSpotModel);
    }
}
