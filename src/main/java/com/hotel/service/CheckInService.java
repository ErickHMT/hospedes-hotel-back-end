package com.hotel.service;

import com.hotel.entity.CheckIn;
import com.hotel.entity.Hospede;
import com.hotel.repository.CheckInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckInService {

    @Autowired
    private CheckInRepository checkInRepository;

    public CheckIn save(CheckIn checkIn) {
        return checkInRepository.save(checkIn);
    }

    public List<CheckIn> findAll() {
        return checkInRepository.findAll();
    }


}
