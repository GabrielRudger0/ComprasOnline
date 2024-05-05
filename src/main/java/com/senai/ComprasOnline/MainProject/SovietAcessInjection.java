package com.senai.ComprasOnline.MainProject;

import com.senai.ComprasOnline.Services.PermissaoService;
import jakarta.annotation.PostConstruct;
import org.fusesource.jansi.AnsiConsole;
import org.fusesource.jansi.Ansi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SovietAcessInjection {

    @Autowired
    PermissaoService permissaoService;

    @PostConstruct
    public void injetarPermissoesSitema() {

        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_YELLOW = "\u001B[33m";

        Date dataHoraAtual = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataHoraFormatada = formatador.format(dataHoraAtual);

        String logPrefixo = ANSI_RED + dataHoraFormatada + ".MiG-29:00  INFO SU-25 --- [ComprasOnline] " + ANSI_RESET + ANSI_YELLOW + "[SovietAcessInjection]" + ANSI_RESET + ANSI_RED + " : " + ANSI_RESET;

        System.out.println(logPrefixo + "Injetando permissões...");

        System.out.println(ANSI_RED);

        String resultadoInjecao = permissaoService.injetarPermissoesSistema();

        System.out.println(ANSI_RESET);

        System.out.println(logPrefixo + resultadoInjecao);


    }

}
