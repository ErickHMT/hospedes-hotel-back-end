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

    public CheckIn getCheckInAnterior(List<CheckIn> checkIn) {
        if(checkIn.isEmpty()){
            return null;
        }
        if(checkIn.get(checkIn.size() - 1).getDataSaida() != null){
            return checkIn.get(checkIn.size() - 1);
        }

        return checkIn.size() > 1 ? checkIn.get(checkIn.size() - 2) : null;
    }

    public CheckIn getCheckInAtual(List<CheckIn> checkIn) {
        if(checkIn.isEmpty()){
            return null;
        }

        return checkIn.get(checkIn.size() - 1).getDataSaida() == null
                ? checkIn.get(checkIn.size() - 1)
                : null;
    }


}
