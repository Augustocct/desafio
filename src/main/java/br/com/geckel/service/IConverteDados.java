package br.com.geckel.service;

public interface IConverteDados {
    <T> T  obterDados(String json, Class<T> classe);
}