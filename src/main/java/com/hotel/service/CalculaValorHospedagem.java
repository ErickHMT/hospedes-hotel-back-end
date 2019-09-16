package com.hotel.service;

import com.hotel.core.util.DateUtil;
import com.hotel.entity.CheckIn;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Deprecated
public class CalculaValorHospedagem {

/*    @Value("${hotel.parametro.valor.diaria.semana}")
    private static BigDecimal vlDiariaSemana;

    @Value("${hotel.parametro.valor.diaria.fim.semana}")
    private static BigDecimal vlDiariaFimDeSemana;

    @Value("${hotel.parametro.valor.garagem.semana}")
    private static BigDecimal vlGaragemSemana;

    @Value("${hotel.parametro.valor.garagem.fim.semana}")
    private static BigDecimal vlGaragemFimDeSemana;

    public static BigDecimal getValorTotalHospedagem(CheckIn checkIn) {
        BigDecimal vlTotalHospedagem = BigDecimal.ZERO;
        LocalDateTime dataEntrada = checkIn.getDataEntrada();
        LocalDateTime dataAtual = LocalDateTime.now();

        for (LocalDateTime date = dataEntrada; date.isBefore(dataAtual.plusDays(1)); date = date.plusDays(1)){
            vlTotalHospedagem.add(getValorDiaria(date));
        }

        if(DateUtil.deveCobrarDiariaExtra()) {
            System.out.println("Hora limite excedida! SERÁ REALIZADA A COBRANÇA DE DIÁRIA ADICIONAL!");
            vlTotalHospedagem.add(getValorDiaria(date));
        }

        return vlTotalHospedagem;
    }

    private static BigDecimal getValorDiaria(LocalDateTime checkIn) {
        if (DateUtil.isFinalDeSemana(checkIn)) {
            return getValorDiariaFinalDeSemana(checkIn);
        }

        return getValorDiariaSemana(checkIn);
    }

    private static BigDecimal getValorDiariaFinalDeSemana(LocalDateTime checkIn) {
        BigDecimal vlTotal = vlDiariaFimDeSemana;
        if(checkIn.getAdicionalVeiculo()){
            vlTotal.add(vlGaragemFimDeSemana);
        }

        return vlTotal;
    }

    private static BigDecimal getValorDiariaSemana(LocalDateTime checkIn) {
        BigDecimal vlTotal = vlDiariaSemana;
        if(checkIn.getAdicionalVeiculo()){
            vlTotal.add(vlGaragemSemana);
        }

        return vlTotal;
    }*/

}
