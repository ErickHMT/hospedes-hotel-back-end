package com.hotel.service;

import com.hotel.core.DiariaDecorator;
import com.hotel.core.GaragemDecorator;
import com.hotel.entity.CheckIn;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class FinanceiroService {

    public BigDecimal calculaValorDiaria(final CheckIn checkIn) {
        BigDecimal vlDiaria = BigDecimal.ZERO;

        if(checkIn == null) {
            return vlDiaria;
        }

        LocalDateTime dataEntrada = checkIn.getDataEntrada();
        LocalDateTime dataSaida = checkIn.getDataSaida() != null ? checkIn.getDataSaida() : LocalDateTime.now();

        for (LocalDateTime date = dataEntrada; date.isBefore(dataSaida.plusDays(1)); date = date.plusDays(1)){
            vlDiaria.add(new DiariaDecorator(date).getValorDiaria());
            vlDiaria.add(new GaragemDecorator(checkIn.getAdicionalVeiculo(), date).getValorDiaria());
        }

        return vlDiaria;
    }
}
