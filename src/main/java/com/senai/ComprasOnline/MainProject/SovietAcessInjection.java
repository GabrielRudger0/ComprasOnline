package com.senai.ComprasOnline.MainProject;

import com.senai.ComprasOnline.Services.PermissaoService;
import jakarta.annotation.PostConstruct;
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
        Date dataHoraAtual = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataHoraFormatada = formatador.format(dataHoraAtual);

        String logPrefixo = dataHoraFormatada + ".MiG-29:00  INFO SU-25 --- [ComprasOnline] [  SovietAcessInjection]  : ";

        System.out.println(logPrefixo + "Injetando permissões...");

       // System.out.println(Ansi.Color.BLUE.toString() + "This is blue text with Jansi." + Ansi.RESET.toString());

        String resultadoInjecao = permissaoService.injetarPermissoesSistema();

        System.out.println(logPrefixo + resultadoInjecao);
    }

}
