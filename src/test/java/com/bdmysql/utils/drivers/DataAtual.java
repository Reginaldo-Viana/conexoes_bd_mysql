package com.bdmysql.utils.drivers;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DataAtual {

    public static String formatarDataHoraEmTexto(LocalDateTime dateTime, String padronizacao) {
        DateTimeFormatter formatadorDataTime = DateTimeFormatter.ofPattern(padronizacao);
        String data_atual_string = formatadorDataTime.format(dateTime);
        return data_atual_string;
    }

    public static LocalDateTime retornarDataHoraAtual(String zoneOffset) {
        Instant instantOfNow = Instant.now().plusSeconds(1);
        LocalDateTime data_atual = LocalDateTime.ofInstant(instantOfNow, ZoneOffset.of(zoneOffset));
        return data_atual;
    }
    public static String DataHoje(){
        String dateDay = formatarDataHoraEmTexto(retornarDataHoraAtual("-03:00"), "yyyy-MM-dd");
        return dateDay;
    }
}
