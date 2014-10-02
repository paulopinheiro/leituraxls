package br.com.paulopinheiro.leituraxls;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class Main {
    public static void main (String[] args) throws FileNotFoundException, IOException, InvalidFormatException {
        if (args.length < 1) System.out.println("Informe o path do arquivo");
        System.out.println("Verificando o arquivo");
        Resumo resumo = new Resumo(args[0]);
        System.out.println("Resultados:");
        System.out.println("\tEstilos existentes: " + resumo.quantEstilosExistentes());
        System.out.println("\tEstilos resumidos: " + resumo.quantEstilosResumidos());
    }
}
