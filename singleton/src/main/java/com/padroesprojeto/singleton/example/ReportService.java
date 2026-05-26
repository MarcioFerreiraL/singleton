package com.padroesprojeto.singleton.example;

public class ReportService {

    private ReportService() {
        System.out.println("Serviço de Relatórios inicializado.");
    }

    // A classe interna só é carregada quando getInstance é chamado
    private static class RelatorioHolder {
        private static final ReportService INSTANCE = new ReportService();
    }

    public static ReportService getInstance() {
        return RelatorioHolder.INSTANCE;
    }

    public void gerarRelatorioFinanceiro() {
        System.out.println("Gerando relatório do mês...");
    }
}