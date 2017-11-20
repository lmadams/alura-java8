package com.alura.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Datas {

  public static void main(String[] args) {
    LocalDate hoje = LocalDate.now();
    System.out.println(hoje);

    LocalDate olimpiadas = LocalDate.of(2022, Month.JUNE, 5);

    Period periodo = Period.between(hoje, olimpiadas);
    System.out.println(periodo.getDays());

    LocalDate proximasOlimpiadas = olimpiadas.plusYears(4);
    System.out.println(proximasOlimpiadas);

    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    System.out.println(proximasOlimpiadas.format(formatador));

    DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
    LocalDateTime agora = LocalDateTime.now();
    System.out.println(agora.format(formatadorComHoras));

    YearMonth mes = YearMonth.now();
    System.out.println(mes);

    LocalTime intervalo = LocalTime.of(15, 30);
    System.out.println(intervalo);
  }
}
