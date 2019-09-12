package com.hotel.core.util;

import com.hotel.core.ParametrosDiaria;

import java.time.LocalDateTime;
import java.util.Calendar;

public class DateUtil {

    public static boolean isFinalDeSemana() {
        Calendar c1 = Calendar.getInstance();
        return (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)  || (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY);
    }

    public static boolean deveCobrarDiariaExtra() {
        LocalDateTime dataAtual = LocalDateTime.now();
        String hrLimite = ParametrosDiaria.LIMITE_DIARIA.substring(0, 2);
        String minLimite = ParametrosDiaria.LIMITE_DIARIA.substring(3);

        return dataAtual.getHour() > Integer.parseInt(hrLimite)
                && dataAtual.getMinute() > Integer.parseInt(minLimite);
    }
}
