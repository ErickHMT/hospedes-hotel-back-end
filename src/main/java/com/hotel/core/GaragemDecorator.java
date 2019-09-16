package com.hotel.core;

import com.hotel.core.util.DateUtil;
import com.hotel.entity.CheckIn;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class GaragemDecorator {

    private String vlGaragemSemana = "15";
    private String vlGaragemFimDeSemana = "20";

    private final boolean hasCar;
    private final DayOfWeek data;

    public GaragemDecorator(final Boolean hasCar, final LocalDateTime dia) {
        this.hasCar = hasCar == null ? false : hasCar;
        this.data = dia.getDayOfWeek();
    }

    public BigDecimal getValorDiaria() {
        return this.hasCar
                ? calculaValor()
                : BigDecimal.ZERO;
    }

    private BigDecimal calculaValor() {
        return DateUtil.isFinalDeSemana(this.data)
                ? new BigDecimal(vlGaragemFimDeSemana)
                : new BigDecimal(vlGaragemSemana);
    }

}
