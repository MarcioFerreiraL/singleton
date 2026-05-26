package com.padroesprojeto.singleton.example;

public class DatabaseConnection {

    // O uso de 'volatile' garante a visibilidade da variável entre threads
    private static volatile DatabaseConnection instance;

    // Construtor privado para impedir instanciação externa
    private DatabaseConnection() {
        System.out.println("Conectando ao banco de dados...");
    }

    public static DatabaseConnection getInstance() {
        // Primeira checagem
        if (instance == null) {
            // Sincroniza apenas na primeira criação
            synchronized (DatabaseConnection.class) {
                // Segunda checagem
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    public void executeQuery(String query) {
        System.out.println("Executando: " + query);
    }
}
