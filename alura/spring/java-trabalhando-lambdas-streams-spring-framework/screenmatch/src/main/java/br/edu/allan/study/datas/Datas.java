package br.edu.allan.study.datas;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.util.Date;

public class Datas {

    public static void main(String[] args) {

        String pattern = "E, dd MMMM yyyy HH:mm:ss z";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        System.out.println(date);

        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);
        
        hoje = LocalDate.now();
        System.out.println(hoje);

        LocalDate aniversarioAlice = LocalDate.of(2005, Month.SEPTEMBER, 15);
        System.out.println(aniversarioAlice);

        int idade =  hoje.getYear() - aniversarioAlice.getYear();
        System.out.println(idade);
        
        Period periodo = Period.between(hoje, aniversarioAlice);
        System.out.println(periodo);
        
    }
}