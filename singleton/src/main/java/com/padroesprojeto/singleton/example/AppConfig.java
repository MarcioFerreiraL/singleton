package com.padroesprojeto.singleton.example;

public enum AppConfig {
    INSTANCE; // A instância é criada na inicialização da classe pelo Java

    private String apiBaseUrl;

    AppConfig() {
        // Inicialização padrão
        this.apiBaseUrl = "http://teste.com.br";
    }

    public String getApiBaseUrl() {
        return apiBaseUrl;
    }
}