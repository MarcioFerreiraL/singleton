package com.padroesprojeto.singleton.versions;

public class Singleton {
    private static volatile Singleton instance;  
    // Sem volatile, pode reordenar as instruções ao inicializar

    private Singleton() {}  

    public static Singleton getInstance() {
        if (instance == null) { 
            synchronized (Singleton.class) {  
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}