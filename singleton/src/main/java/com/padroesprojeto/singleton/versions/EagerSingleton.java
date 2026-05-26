package com.padroesprojeto.singleton;
// inialização antecipada
public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        if (instance == null) {
            // instance = new EagerSingleton();
            // na inicialização ja é criada a instancia
        }
        return instance;
    }
}