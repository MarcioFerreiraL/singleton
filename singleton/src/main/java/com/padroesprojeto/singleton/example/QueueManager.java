package com.padroesprojeto.singleton.example;

import org.springframework.stereotype.Component;

/**
 * A anotação @Component avisa ao Spring: "Crie apenas UMA instância 
 * desta classe e use ela no sistema inteiro".
 */
@Component
public class QueueManager {

    private int senhaAtual = 0;

    public QueueManager() {
        System.out.println(">>> Gerenciador de Fila ligado! <<<");
    }

    // O 'synchronized' garante que se dois clientes clicarem no botão 
    // exatamente no mesmo milissegundo, eles não recebam a mesma senha.
    public synchronized int gerarProximaSenha() {
        senhaAtual++; // Aumenta o número da senha
        return senhaAtual;
    }

    public int getSenhaAtual() {
        return senhaAtual;
    }
}
