package br.edu.allan.study.datas;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Horarios {

    public static void main(String[] args) {
        LocalTime hoje = LocalTime.now();
        System.out.println(hoje);
        
        LocalTime aniversarioHoraAlice = LocalTime.of(22, 33, 15);
        System.out.println(aniversarioHoraAlice);
        
        LocalDateTime hojeLocal = LocalDateTime.now();
        System.out.println(hojeLocal);
    }
}