package com.hotel.core.util;

import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;

public class DateUtil {

//    @Value("${hotel.parametro.hora.limite.diaria}")
    private static String horaLimiteDiaria = "16";

//    @Value("${hotel.parametro.minuto.limite.diaria}")
    private static String minutosLimiteDiaria = "30";

    public static boolean isFinalDeSemana(DayOfWeek dia) {

        return (dia == DayOfWeek.SATURDAY)
                || (dia == DayOfWeek.SUNDAY);
    }

    public static boolean deveCobrarDiariaExtra(LocalDateTime dia) {
        String hrLimite = horaLimiteDiaria;
        String minLimite = minutosLimiteDiaria;

        return dia.getHour() > Integer.parseInt(hrLimite)
                && dia.getMinute() > Integer.parseInt(minLimite);
    }
}
