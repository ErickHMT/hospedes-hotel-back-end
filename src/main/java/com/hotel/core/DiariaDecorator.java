package com.hotel.core;

import com.hotel.core.util.DateUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Component
public class DiariaDecorator {

    private String vlDiariaSemana = "120";
    private String vlDiariaFimDeSemana = "150";

    private DayOfWeek dia;

    public DiariaDecorator(){
        this.dia = LocalDateTime.now().getDayOfWeek();
    }

    public DiariaDecorator(final LocalDateTime dia) {
        this.dia = dia.getDayOfWeek();
    }

    public BigDecimal getValorDiaria() {
        return DateUtil.isFinalDeSemana(dia)
                ? new BigDecimal(this.vlDiariaFimDeSemana)
                : new BigDecimal(this.vlDiariaSemana);
    }

}
