package com.hotel.service;

import com.hotel.core.ParametrosDiaria;
import com.hotel.core.util.DateUtil;
import com.hotel.entity.CheckIn;

import java.time.LocalDateTime;

public class CalculaValorHospedagem {

    public static Double getValorTotalHospedagem(CheckIn checkIn) {
        Double vlTotalHospedagem = 0.0;
        LocalDateTime dataEntrada = checkIn.getDataEntrada();
        LocalDateTime dataAtual = LocalDateTime.now();

        for (LocalDateTime date = dataEntrada; date.isBefore(dataAtual.plusDays(1)); date = date.plusDays(1)){
            vlTotalHospedagem += getValorDiaria(checkIn);
        }

        if(DateUtil.deveCobrarDiariaExtra()) {
            System.out.println("SERÁ REALIZADA A COBRANÇA DE DIÁRIA ADICIONAL! horário limite: " + ParametrosDiaria.LIMITE_DIARIA);
            vlTotalHospedagem += getValorDiaria(checkIn);
        }

        return vlTotalHospedagem;
    }

    private static Double getValorDiaria(CheckIn checkIn) {
        if (DateUtil.isFinalDeSemana()) {
            return getValorDiariaFinalDeSemana(checkIn);
        }

        return getValorDiariaSemana(checkIn);
    }

    private static Double getValorDiariaFinalDeSemana(CheckIn checkIn) {
        Double vlTotal = ParametrosDiaria.VL_DIARIA_FINAL_SEMANA;
        if(checkIn.getAdicionalVeiculo()){
            vlTotal += ParametrosDiaria.VL_GARAGEM_FINAL_SEMANA;
        }

        return vlTotal;
    }

    private static Double getValorDiariaSemana(CheckIn checkIn) {
        Double vlTotal = ParametrosDiaria.VL_DIARIA_SEMANA;
        if(checkIn.getAdicionalVeiculo()){
            vlTotal += ParametrosDiaria.VL_GARAGEM_SEMANA;
        }

        return vlTotal;
    }

}
