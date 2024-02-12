package br.com.geckel.desafio.principal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import br.com.geckel.desafio.model.DadosCarros;
import br.com.geckel.desafio.model.Lista;
import br.com.geckel.service.ConsumoApi;
import br.com.geckel.service.ConverteDados;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";
    private ConverteDados conversor = new ConverteDados();


    public void exibeMenu() {
        var menu = """
                *** OPÇÕES ***
                Carro
                Moto
                Caminhão

                Digite uma das opções para consulta:
                """;
        System.out.println(menu);
        var nomeAutomovel = leitura.nextLine();

        if (nomeAutomovel.toLowerCase().contains("carr")) {
            ENDERECO = ENDERECO + "carros/marcas";
        } else if (nomeAutomovel.toLowerCase().contains("mot")) {
            ENDERECO = ENDERECO + "motos/marcas";
        } else {
            ENDERECO = ENDERECO + "caminhoes/marcas";
        }


        List<DadosCarros> dados = new ArrayList<>();

        var json = consumo.obterDados(ENDERECO);
        System.out.println(json);
        var marcas = conversor.obterDados(json, DadosCarros.class);
        marcas.stream()
                .sorted(Comparator.comparing(DadosCarros::codigo))
                .forEach(System.out::println);
        System.out.println(dados);

        System.out.println("Informe o código da marca para consulta: ");
        var codigoMarca = leitura.nextLine();

        ENDERECO = ENDERECO + "/" + codigoMarca + "/modelos";
        json = consumo.obterDados(ENDERECO);
        var modeloLista = conversor.obterDados(json, Lista.class);
        
        System.out.println(modeloLista);
    }

}
