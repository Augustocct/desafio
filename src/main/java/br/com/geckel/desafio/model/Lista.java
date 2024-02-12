package br.com.geckel.desafio.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record Lista(List<DadosCarros> modelos) {
}
