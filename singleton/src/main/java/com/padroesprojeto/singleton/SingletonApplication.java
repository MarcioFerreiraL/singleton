package com.padroesprojeto.singleton;

import com.padroesprojeto.singleton.example.AppConfig;
import com.padroesprojeto.singleton.example.ReportService;
import com.padroesprojeto.singleton.example.DatabaseConnection;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SingletonApplication {

	public static void main(String[] args) {
		// Exemplo 1
		DatabaseConnection db1 = DatabaseConnection.getInstance();
		db1.executeQuery("SELECT * FROM clientes");

		// Esta variável apontará para a mesma instância do db1
		DatabaseConnection db2 = DatabaseConnection.getInstance();

		// Verifica se são a mesma instância
		System.out.println("São a mesma instância? " + (db1 == db2));

		// Exemplo 2
		// Acesso direto, sem necessidade de chamar getInstance()
		String url = AppConfig.INSTANCE.getApiBaseUrl();
		System.out.println("Configuração carregada: " + url);

		// Exemplo 3
		ReportService.getInstance().gerarRelatorioFinanceiro();
	}


}
