package com.hotel.core;

import com.hotel.core.util.DateUtil;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class DiariaDecorator {

    @Value("${hotel.parametro.valor.diaria.semana}")
    private static String vlDiariaSemana;

    @Value("${hotel.parametro.valor.diaria.fim.semana}")
    private static String vlDiariaFimDeSemana;

    private DayOfWeek dia;

    public DiariaDecorator(final LocalDateTime dia) {
        this.dia = dia.getDayOfWeek();
    }

    public BigDecimal getValorDiaria() {
        return DateUtil.isFinalDeSemana(dia)
                ? new BigDecimal(vlDiariaFimDeSemana)
                : new BigDecimal(vlDiariaSemana);
    }

}
