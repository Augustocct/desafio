package br.com.geckel.desafio.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosCarros(@JsonAlias("nome") String marca,
                          @JsonAlias("codigo") Integer codigo

) {

       
}
