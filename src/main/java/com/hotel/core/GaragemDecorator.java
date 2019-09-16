package com.hotel.core;

import com.hotel.core.util.DateUtil;
import com.hotel.entity.CheckIn;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class GaragemDecorator {

    @Value("${hotel.parametro.valor.garagem.semana}")
    private static BigDecimal vlGaragemSemana;

    @Value("${hotel.parametro.valor.garagem.fim.semana}")
    private static BigDecimal vlGaragemFimDeSemana;

    private final boolean hasCar;
    private final DayOfWeek data;

    public GaragemDecorator(final Boolean hasCar, final LocalDateTime dia) {
        this.hasCar = hasCar;
        this.data = dia.getDayOfWeek();
    }

    public BigDecimal getValorDiaria() {
        return this.hasCar
                ? calculaValor()
                : BigDecimal.ZERO;
    }

    private BigDecimal calculaValor() {
        return DateUtil.isFinalDeSemana(this.data)
                ? vlGaragemFimDeSemana
                : vlGaragemSemana;
    }

}
