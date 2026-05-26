package com.padroesprojeto.singleton;

import com.padroesprojeto.singleton.example.AppConfig;
import com.padroesprojeto.singleton.example.ReportService;
import com.padroesprojeto.singleton.example.DatabaseConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SingletonApplication {

	public static void main(String[] args) {
		System.out.println("Iniciando aplicação...");
		System.out.println("===========================================================");
		
		// Exemplo 1
		DatabaseConnection db1 = DatabaseConnection.getInstance();
		db1.executeQuery("SELECT * FROM clientes");

		DatabaseConnection db2 = DatabaseConnection.getInstance();
		System.out.println("São a mesma instância? " + (db1 == db2));

		System.out.println("===========================================================");

		// Exemplo 2
		String url = AppConfig.INSTANCE.getApiBaseUrl();
		System.out.println("Configuração carregada: " + url);
		
		System.out.println("===========================================================");

		// Exemplo 3
		ReportService.getInstance().gerarRelatorioFinanceiro();

		System.out.println("===========================================================");

		SpringApplication.run(SingletonApplication.class, args);
	}
}