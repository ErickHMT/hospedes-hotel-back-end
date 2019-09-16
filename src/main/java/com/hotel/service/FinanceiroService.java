package com.hotel.service;

import com.hotel.core.DiariaDecorator;
import com.hotel.core.GaragemDecorator;
import com.hotel.core.util.DateUtil;
import com.hotel.entity.CheckIn;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class FinanceiroService {

    public BigDecimal getValorEstadia(final CheckIn checkIn) {
        BigDecimal vlDiaria = BigDecimal.ZERO;

        if(checkIn == null) {
            return vlDiaria;
        }

        LocalDateTime dataEntrada = checkIn.getDataEntrada();
        LocalDateTime dataSaida = checkIn.getDataSaida() != null ? checkIn.getDataSaida() : LocalDateTime.now();

        for (LocalDateTime date = dataEntrada; date.isBefore(dataSaida.plusDays(1)); date = date.plusDays(1)){
            vlDiaria = vlDiaria.add(calculaValorDiaria(date, checkIn.getAdicionalVeiculo()));
        }
        if(DateUtil.deveCobrarDiariaExtra(dataSaida)){
            vlDiaria = vlDiaria.add(calculaValorDiaria(dataSaida, checkIn.getAdicionalVeiculo()));
        }

        return vlDiaria;
    }

    private BigDecimal calculaValorDiaria(LocalDateTime date, Boolean adicionalVeiculo) {
        BigDecimal vlTotal = BigDecimal.ZERO;

        BigDecimal valorDiaria = new DiariaDecorator(date).getValorDiaria();
        BigDecimal valorAdicionalGaragem = new GaragemDecorator(adicionalVeiculo, date).getValorDiaria();

        vlTotal = vlTotal.add(valorDiaria);
        vlTotal = vlTotal.add(valorAdicionalGaragem);
        return vlTotal;
    }
}
