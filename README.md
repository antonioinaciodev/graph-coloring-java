# 🎨 Coloração de Grafos (Graph Coloring)

## 📌 Sobre o Projeto
Este repositório contém a implementação de três algoritmos clássicos de **Coloração de Grafos**, desenvolvido como trabalho prático para a disciplina de Teoria dos Grafos. O objetivo é determinar o número cromático (ou uma aproximação viável) para diferentes conjuntos de grafos, medindo o tempo de execução e a eficiência de cada abordagem.

O código foi refatorado focando em **Clean Code** e **Engenharia de Software**, utilizando o padrão de projeto arquitetural **Strategy** para garantir flexibilidade, fácil manutenção e escalabilidade nas execuções dos algoritmos.

## 🧠 Algoritmos Implementados
A aplicação testa e compara três abordagens diferentes:
1. **Guloso (Greedy):** Atribui a primeira cor disponível para cada vértice em ordem sequencial.
2. **Welsh-Powell:** Ordena os vértices em ordem decrescente de grau antes de aplicar a lógica de coloração, otimizando o uso de cores.
3. **DSatur (Degree of Saturation):** Escolhe dinamicamente o vértice com maior grau de saturação (maior número de cores adjacentes diferentes), oferecendo resultados mais precisos para grafos complexos.

## 🏗️ Arquitetura e Padrões (Strategy)
Em vez de utilizar uma classe principal inflada com múltiplos blocos de `if/else` e instâncias soltas, o projeto utiliza uma interface base (`ColoringAlgorithm`). 

Cada algoritmo é uma "estratégia" que assina esse contrato, permitindo que o maestro (`Main.java`) execute qualquer algoritmo de forma polimórfica, isolando a lógica matemática do motor de testes.

## ⚙️ Como Executar
O projeto não utiliza gerenciadores de dependência externos (puro Java). Para rodar a bateria de testes via terminal:

Compile todos os arquivos .java da pasta src:

Bash
javac -d bin src/*.java

2. Execute a classe Main:
   ```bash
   java -cp bin Main
   
(Nota: Se estiver usando o VS Code ou Eclipse, basta clicar em "Run" diretamente na classe Main.java).