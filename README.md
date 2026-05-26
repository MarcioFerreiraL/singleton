# Padrão de Projeto: Singleton em Java

Este repositório contém implementações e estudos práticos sobre o padrão de projeto criacional **Singleton**. O projeto explora desde as abordagens mais simples até implementações avançadas com foco em segurança de concorrência, garantindo que o código seja robusto para uso real.

## 🎯 Objetivo
Demonstrar a correta aplicação do Singleton em diferentes cenários utilizando a linguagem Java, analisando as vantagens, desvantagens e os impactos na performance de cada abordagem testada.

## 📂 Estrutura das Implementações

As seguintes abordagens foram implementadas e encontram-se no pacote base do projeto:

1. **`SimpleSingleton`**: Implementação clássica com *Lazy Initialization*. **Não é segura** para ambientes *multithread*.
2. **`SynchronizedSingleton`**: Resolve o problema de *race conditions* em múltiplas threads sincronizando o método inteiro, porém com custo elevado de performance devido ao bloqueio.
3. **`Singleton` (Double-Checked Locking)**: Otimiza o uso do `synchronized` checando a instância duas vezes e utilizando a palavra-chave `volatile` para garantir a consistência da memória entre as threads.
4. **`EagerSingleton`**: Instancia o objeto no momento do carregamento da classe. Seguro contra múltiplas threads, mas aloca memória mesmo que o objeto nunca chegue a ser utilizado.
5. **`BillPughSingleton`**: Utiliza uma classe estática interna. Excelente performance, garantindo *lazy initialization* e *thread-safety* de forma natural, sem exigir sincronização explícita.
6. **`EnumSingleton`**: Considerada a abordagem mais robusta e segura na plataforma Java. Evita completamente a criação de múltiplas instâncias, protegendo até mesmo contra serialização ou ataques via *Reflection*.

## 🌍 Casos de Uso Reais na Indústria

É essencial entender onde este padrão se aplica na prática. O Singleton é amplamente utilizado em:

* **Spring Framework (Injeção de Dependências)**: 
* **Sistemas de Logs**:
* **Configurações de Aplicativo**
* **Conexão com banco de dados** 