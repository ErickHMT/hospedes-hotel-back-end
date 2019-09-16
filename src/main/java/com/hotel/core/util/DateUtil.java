package com.hotel.core.util;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class DateUtil {

    private static String horaLimiteDiaria = "16";
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
