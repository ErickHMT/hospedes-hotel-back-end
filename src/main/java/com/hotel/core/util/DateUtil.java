package com.hotel.core.util;

import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;

public class DateUtil {

    @Value("${hotel.parametro.hora.limite.diaria}")
    private static String horaLimiteDiaria;

    @Value("${hotel.parametro.minuto.limite.diaria}")
    private static String minutosLimiteDiaria;

    public static boolean isFinalDeSemana(DayOfWeek dia) {
        return (dia.getValue() == Calendar.SATURDAY)
                || (dia.getValue() == Calendar.SUNDAY);
    }

    public static boolean deveCobrarDiariaExtra() {
        LocalDateTime dataAtual = LocalDateTime.now();
        String hrLimite = horaLimiteDiaria;
        String minLimite = minutosLimiteDiaria;

        return dataAtual.getHour() > Integer.parseInt(hrLimite)
                && dataAtual.getMinute() > Integer.parseInt(minLimite);
    }
}
