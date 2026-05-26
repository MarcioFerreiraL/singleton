package com.padroesprojeto.singleton.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/atendimento")
public class QueueController {

    private final QueueManager fila;

    // O Spring pega aquela ÚNICA instância que ele criou e injeta aqui
    @Autowired
    public QueueController(QueueManager fila) {
        this.fila = fila;
    }

    @GetMapping("/pegar-senha")
    public String pegarSenha() {
        int minhaSenha = fila.gerarProximaSenha();
        return "Sua senha é: " + minhaSenha;
    }

    @GetMapping("/painel")
    public String verPainel() {
        return "A última senha chamada foi: " + fila.getSenhaAtual();
    }
}