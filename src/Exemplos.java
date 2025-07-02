import java.util.ArrayList;

public class Exemplos {
    
    public ArrayList<Grafo> grafos10(){
         ArrayList<Grafo> listaGrafos = new ArrayList<>();

        // Grafo 1: Linha
        Grafo g1 = new Grafo();
        for (int i = 1; i <= 10; i++) g1.addVertice(i);
        for (int i = 1; i < 10; i++) g1.addAresta(new int[]{i, i+1});
        listaGrafos.add(g1);

        // Grafo 2: Ciclo
        Grafo g2 = new Grafo();
        for (int i = 1; i <= 10; i++) g2.addVertice(i);
        for (int i = 1; i < 10; i++) g2.addAresta(new int[]{i, i+1});
        g2.addAresta(new int[]{10, 1});
        listaGrafos.add(g2);

        // Grafo 3: Estrela
        Grafo g3 = new Grafo();
        for (int i = 1; i <= 10; i++) g3.addVertice(i);
        for (int i = 2; i <= 10; i++) g3.addAresta(new int[]{1, i});
        listaGrafos.add(g3);

        // Grafo 4: Dois ciclos de 5 vértices conectados por uma aresta
        Grafo g4 = new Grafo();
        for (int i = 1; i <= 10; i++) g4.addVertice(i);
        for (int i = 1; i < 5; i++) g4.addAresta(new int[]{i, i+1});
        g4.addAresta(new int[]{5, 1});
        for (int i = 6; i < 10; i++) g4.addAresta(new int[]{i, i+1});
        g4.addAresta(new int[]{10, 6});
        g4.addAresta(new int[]{5, 6});
        listaGrafos.add(g4);

        // Grafo 5: Árvore binária incompleta
        Grafo g5 = new Grafo();
        for (int i = 1; i <= 10; i++) g5.addVertice(i);
        g5.addAresta(new int[]{1,2}); g5.addAresta(new int[]{1,3});
        g5.addAresta(new int[]{2,4}); g5.addAresta(new int[]{2,5});
        g5.addAresta(new int[]{3,6}); g5.addAresta(new int[]{3,7});
        g5.addAresta(new int[]{4,8}); g5.addAresta(new int[]{5,9});
        g5.addAresta(new int[]{6,10});
        listaGrafos.add(g5);

        // Grafo 6: Grafo bipartido (5+5)
        Grafo g6 = new Grafo();
        for (int i = 1; i <= 10; i++) g6.addVertice(i);
        for (int i = 1; i <= 5; i++)
            for (int j = 6; j <= 10; j++)
                if ((i+j)%2==0) g6.addAresta(new int[]{i, j});
        listaGrafos.add(g6);

        // Grafo 7: Grafo com triângulos desconexos
        Grafo g7 = new Grafo();
        for (int i = 1; i <= 10; i++) g7.addVertice(i);
        g7.addAresta(new int[]{1,2}); g7.addAresta(new int[]{2,3}); g7.addAresta(new int[]{3,1});
        g7.addAresta(new int[]{4,5}); g7.addAresta(new int[]{5,6}); g7.addAresta(new int[]{6,4});
        g7.addAresta(new int[]{7,8}); g7.addAresta(new int[]{8,9}); g7.addAresta(new int[]{9,7});
        g7.addAresta(new int[]{10,1});
        listaGrafos.add(g7);

        // Grafo 8: Grafo em "Y"
        Grafo g8 = new Grafo();
        for (int i = 1; i <= 10; i++) g8.addVertice(i);
        g8.addAresta(new int[]{1,2}); g8.addAresta(new int[]{2,3}); g8.addAresta(new int[]{3,4});
        g8.addAresta(new int[]{2,5}); g8.addAresta(new int[]{5,6});
        g8.addAresta(new int[]{2,7}); g8.addAresta(new int[]{7,8});
        g8.addAresta(new int[]{4,9}); g8.addAresta(new int[]{6,10});
        listaGrafos.add(g8);

        // Grafo 9: Grafo com cruzamento
        Grafo g9 = new Grafo();
        for (int i = 1; i <= 10; i++) g9.addVertice(i);
        g9.addAresta(new int[]{1,2}); g9.addAresta(new int[]{2,3}); g9.addAresta(new int[]{3,4});
        g9.addAresta(new int[]{4,5}); g9.addAresta(new int[]{5,1});
        g9.addAresta(new int[]{1,6}); g9.addAresta(new int[]{3,8});
        g9.addAresta(new int[]{6,7}); g9.addAresta(new int[]{7,8});
        g9.addAresta(new int[]{8,9}); g9.addAresta(new int[]{9,10}); g9.addAresta(new int[]{10,6});
        listaGrafos.add(g9);

        // Grafo 10: Grafo esparso aleatório
        Grafo g10 = new Grafo();
        for (int i = 1; i <= 10; i++) g10.addVertice(i);
        g10.addAresta(new int[]{1,3}); g10.addAresta(new int[]{2,5});
        g10.addAresta(new int[]{3,6}); g10.addAresta(new int[]{4,7});
        g10.addAresta(new int[]{5,8}); g10.addAresta(new int[]{6,9});
        g10.addAresta(new int[]{7,10}); g10.addAresta(new int[]{8,1});
        g10.addAresta(new int[]{9,2}); g10.addAresta(new int[]{10,4});
        listaGrafos.add(g10);

        return listaGrafos;
    }

    public ArrayList<Grafo> grafos20() {
    ArrayList<Grafo> listaGrafos = new ArrayList<>();

    // Grafo 1: Linha
    Grafo g1 = new Grafo();
    for (int i = 1; i <= 20; i++) g1.addVertice(i);
    for (int i = 1; i < 20; i++) g1.addAresta(new int[]{i, i+1});
    listaGrafos.add(g1);

    // Grafo 2: Ciclo
    Grafo g2 = new Grafo();
    for (int i = 1; i <= 20; i++) g2.addVertice(i);
    for (int i = 1; i < 20; i++) g2.addAresta(new int[]{i, i+1});
    g2.addAresta(new int[]{20, 1});
    listaGrafos.add(g2);

    // Grafo 3: Estrela
    Grafo g3 = new Grafo();
    for (int i = 1; i <= 20; i++) g3.addVertice(i);
    for (int i = 2; i <= 20; i++) g3.addAresta(new int[]{1, i});
    listaGrafos.add(g3);

    // Grafo 4: Dois ciclos de 10 vértices conectados por uma aresta
    Grafo g4 = new Grafo();
    for (int i = 1; i <= 20; i++) g4.addVertice(i);
    for (int i = 1; i < 10; i++) g4.addAresta(new int[]{i, i+1});
    g4.addAresta(new int[]{10, 1});
    for (int i = 11; i < 20; i++) g4.addAresta(new int[]{i, i+1});
    g4.addAresta(new int[]{20, 11});
    g4.addAresta(new int[]{10, 11});
    listaGrafos.add(g4);

    // Grafo 5: Árvore binária incompleta
    Grafo g5 = new Grafo();
    for (int i = 1; i <= 20; i++) g5.addVertice(i);
    for (int i = 1; i <= 10; i++) {
        if (2*i <= 20) g5.addAresta(new int[]{i, 2*i});
        if (2*i+1 <= 20) g5.addAresta(new int[]{i, 2*i+1});
    }
    listaGrafos.add(g5);

    // Grafo 6: Grafo bipartido (10+10)
    Grafo g6 = new Grafo();
    for (int i = 1; i <= 20; i++) g6.addVertice(i);
    for (int i = 1; i <= 10; i++)
        for (int j = 11; j <= 20; j++)
            if ((i+j)%3==0) g6.addAresta(new int[]{i, j});
    listaGrafos.add(g6);

    // Grafo 7: Grafo com quadrados desconexos
    Grafo g7 = new Grafo();
    for (int i = 1; i <= 20; i++) g7.addVertice(i);
    for (int k = 0; k < 5; k++) {
        int base = 4*k+1;
        g7.addAresta(new int[]{base, base+1});
        g7.addAresta(new int[]{base+1, base+2});
        g7.addAresta(new int[]{base+2, base+3});
        g7.addAresta(new int[]{base+3, base});
    }
    listaGrafos.add(g7);

    // Grafo 8: Grafo em "Y" duplo
    Grafo g8 = new Grafo();
    for (int i = 1; i <= 20; i++) g8.addVertice(i);
    g8.addAresta(new int[]{1,2}); g8.addAresta(new int[]{2,3}); g8.addAresta(new int[]{3,4});
    g8.addAresta(new int[]{2,5}); g8.addAresta(new int[]{5,6}); g8.addAresta(new int[]{6,7});
    g8.addAresta(new int[]{2,8}); g8.addAresta(new int[]{8,9}); g8.addAresta(new int[]{9,10});
    g8.addAresta(new int[]{4,11}); g8.addAresta(new int[]{6,12}); g8.addAresta(new int[]{10,13});
    g8.addAresta(new int[]{13,14}); g8.addAresta(new int[]{14,15}); g8.addAresta(new int[]{15,16});
    g8.addAresta(new int[]{13,17}); g8.addAresta(new int[]{17,18}); g8.addAresta(new int[]{18,19});
    g8.addAresta(new int[]{16,20});
    listaGrafos.add(g8);

    // Grafo 9: Grafo com cruzamentos e ciclos
    Grafo g9 = new Grafo();
    for (int i = 1; i <= 20; i++) g9.addVertice(i);
    for (int i = 1; i < 10; i++) g9.addAresta(new int[]{i, i+1});
    g9.addAresta(new int[]{10, 1});
    for (int i = 11; i < 20; i++) g9.addAresta(new int[]{i, i+1});
    g9.addAresta(new int[]{20, 11});
    g9.addAresta(new int[]{5, 15}); g9.addAresta(new int[]{7, 17});
    g9.addAresta(new int[]{3, 13}); g9.addAresta(new int[]{8, 18});
    listaGrafos.add(g9);

    // Grafo 10: Grafo esparso aleatório
    Grafo g10 = new Grafo();
    for (int i = 1; i <= 20; i++) g10.addVertice(i);
    g10.addAresta(new int[]{1,4}); g10.addAresta(new int[]{2,7});
    g10.addAresta(new int[]{3,8}); g10.addAresta(new int[]{4,12});
    g10.addAresta(new int[]{5,9}); g10.addAresta(new int[]{6,13});
    g10.addAresta(new int[]{7,14}); g10.addAresta(new int[]{8,15});
    g10.addAresta(new int[]{9,16}); g10.addAresta(new int[]{10,17});
    g10.addAresta(new int[]{11,18}); g10.addAresta(new int[]{12,19});
    g10.addAresta(new int[]{13,20}); g10.addAresta(new int[]{14,1});
    g10.addAresta(new int[]{15,2}); g10.addAresta(new int[]{16,3});
    g10.addAresta(new int[]{17,5}); g10.addAresta(new int[]{18,6});
    g10.addAresta(new int[]{19,8}); g10.addAresta(new int[]{20,10});
    listaGrafos.add(g10);

    return listaGrafos;
}

public ArrayList<Grafo> grafos40() {
    ArrayList<Grafo> listaGrafos = new ArrayList<>();

    // Grafo 1: Linha
    Grafo g1 = new Grafo();
    for (int i = 1; i <= 40; i++) g1.addVertice(i);
    for (int i = 1; i < 40; i++) g1.addAresta(new int[]{i, i+1});
    listaGrafos.add(g1);

    // Grafo 2: Ciclo
    Grafo g2 = new Grafo();
    for (int i = 1; i <= 40; i++) g2.addVertice(i);
    for (int i = 1; i < 40; i++) g2.addAresta(new int[]{i, i+1});
    g2.addAresta(new int[]{40, 1});
    listaGrafos.add(g2);

    // Grafo 3: Estrela
    Grafo g3 = new Grafo();
    for (int i = 1; i <= 40; i++) g3.addVertice(i);
    for (int i = 2; i <= 40; i++) g3.addAresta(new int[]{1, i});
    listaGrafos.add(g3);

    // Grafo 4: Dois ciclos de 20 vértices conectados por uma aresta
    Grafo g4 = new Grafo();
    for (int i = 1; i <= 40; i++) g4.addVertice(i);
    for (int i = 1; i < 20; i++) g4.addAresta(new int[]{i, i+1});
    g4.addAresta(new int[]{20, 1});
    for (int i = 21; i < 40; i++) g4.addAresta(new int[]{i, i+1});
    g4.addAresta(new int[]{40, 21});
    g4.addAresta(new int[]{20, 21});
    listaGrafos.add(g4);

    // Grafo 5: Árvore binária incompleta
    Grafo g5 = new Grafo();
    for (int i = 1; i <= 40; i++) g5.addVertice(i);
    for (int i = 1; i <= 20; i++) {
        if (2*i <= 40) g5.addAresta(new int[]{i, 2*i});
        if (2*i+1 <= 40) g5.addAresta(new int[]{i, 2*i+1});
    }
    listaGrafos.add(g5);

    // Grafo 6: Grafo bipartido (20+20)
    Grafo g6 = new Grafo();
    for (int i = 1; i <= 40; i++) g6.addVertice(i);
    for (int i = 1; i <= 20; i++)
        for (int j = 21; j <= 40; j++)
            if ((i+j)%4==0) g6.addAresta(new int[]{i, j});
    listaGrafos.add(g6);

    // Grafo 7: Grafo com quadrados desconexos
    Grafo g7 = new Grafo();
    for (int i = 1; i <= 40; i++) g7.addVertice(i);
    for (int k = 0; k < 10; k++) {
        int base = 4*k+1;
        g7.addAresta(new int[]{base, base+1});
        g7.addAresta(new int[]{base+1, base+2});
        g7.addAresta(new int[]{base+2, base+3});
        g7.addAresta(new int[]{base+3, base});
    }
    listaGrafos.add(g7);

    // Grafo 8: Grafo em "Y" duplo expandido
    Grafo g8 = new Grafo();
    for (int i = 1; i <= 40; i++) g8.addVertice(i);
    g8.addAresta(new int[]{1,2}); g8.addAresta(new int[]{2,3}); g8.addAresta(new int[]{3,4});
    g8.addAresta(new int[]{2,5}); g8.addAresta(new int[]{5,6}); g8.addAresta(new int[]{6,7});
    g8.addAresta(new int[]{2,8}); g8.addAresta(new int[]{8,9}); g8.addAresta(new int[]{9,10});
    g8.addAresta(new int[]{4,11}); g8.addAresta(new int[]{6,12}); g8.addAresta(new int[]{10,13});
    g8.addAresta(new int[]{13,14}); g8.addAresta(new int[]{14,15}); g8.addAresta(new int[]{15,16});
    g8.addAresta(new int[]{13,17}); g8.addAresta(new int[]{17,18}); g8.addAresta(new int[]{18,19});
    g8.addAresta(new int[]{16,20});
    // Repete a estrutura para os vértices 21 a 40
    g8.addAresta(new int[]{21,22}); g8.addAresta(new int[]{22,23}); g8.addAresta(new int[]{23,24});
    g8.addAresta(new int[]{22,25}); g8.addAresta(new int[]{25,26}); g8.addAresta(new int[]{26,27});
    g8.addAresta(new int[]{22,28}); g8.addAresta(new int[]{28,29}); g8.addAresta(new int[]{29,30});
    g8.addAresta(new int[]{24,31}); g8.addAresta(new int[]{26,32}); g8.addAresta(new int[]{30,33});
    g8.addAresta(new int[]{33,34}); g8.addAresta(new int[]{34,35}); g8.addAresta(new int[]{35,36});
    g8.addAresta(new int[]{33,37}); g8.addAresta(new int[]{37,38}); g8.addAresta(new int[]{38,39});
    g8.addAresta(new int[]{36,40});
    // Conecta as duas estruturas
    g8.addAresta(new int[]{20,21});
    listaGrafos.add(g8);

    // Grafo 9: Grafo com cruzamentos e ciclos
    Grafo g9 = new Grafo();
    for (int i = 1; i <= 40; i++) g9.addVertice(i);
    for (int i = 1; i < 20; i++) g9.addAresta(new int[]{i, i+1});
    g9.addAresta(new int[]{20, 1});
    for (int i = 21; i < 40; i++) g9.addAresta(new int[]{i, i+1});
    g9.addAresta(new int[]{40, 21});
    g9.addAresta(new int[]{10, 30}); g9.addAresta(new int[]{15, 35});
    g9.addAresta(new int[]{5, 25}); g9.addAresta(new int[]{8, 28});
    listaGrafos.add(g9);

    // Grafo 10: Grafo esparso aleatório
    Grafo g10 = new Grafo();
    for (int i = 1; i <= 40; i++) g10.addVertice(i);
    g10.addAresta(new int[]{1,5}); g10.addAresta(new int[]{2,10});
    g10.addAresta(new int[]{3,15}); g10.addAresta(new int[]{4,20});
    g10.addAresta(new int[]{5,25}); g10.addAresta(new int[]{6,30});
    g10.addAresta(new int[]{7,35}); g10.addAresta(new int[]{8,40});
    g10.addAresta(new int[]{9,13}); g10.addAresta(new int[]{11,17});
    g10.addAresta(new int[]{12,19}); g10.addAresta(new int[]{14,21});
    g10.addAresta(new int[]{16,23}); g10.addAresta(new int[]{18,27});
    g10.addAresta(new int[]{22,29}); g10.addAresta(new int[]{24,31});
    g10.addAresta(new int[]{26,33}); g10.addAresta(new int[]{28,37});
    g10.addAresta(new int[]{32,39}); g10.addAresta(new int[]{34,38});
    listaGrafos.add(g10);

    return listaGrafos;
}

public ArrayList<Grafo> grafos80() {
    ArrayList<Grafo> listaGrafos = new ArrayList<>();

    // Grafo 1: Linha
    Grafo g1 = new Grafo();
    for (int i = 1; i <= 80; i++) g1.addVertice(i);
    for (int i = 1; i < 80; i++) g1.addAresta(new int[]{i, i+1});
    listaGrafos.add(g1);

    // Grafo 2: Ciclo
    Grafo g2 = new Grafo();
    for (int i = 1; i <= 80; i++) g2.addVertice(i);
    for (int i = 1; i < 80; i++) g2.addAresta(new int[]{i, i+1});
    g2.addAresta(new int[]{80, 1});
    listaGrafos.add(g2);

    // Grafo 3: Estrela
    Grafo g3 = new Grafo();
    for (int i = 1; i <= 80; i++) g3.addVertice(i);
    for (int i = 2; i <= 80; i++) g3.addAresta(new int[]{1, i});
    listaGrafos.add(g3);

    // Grafo 4: Dois ciclos de 40 vértices conectados por uma aresta
    Grafo g4 = new Grafo();
    for (int i = 1; i <= 80; i++) g4.addVertice(i);
    for (int i = 1; i < 40; i++) g4.addAresta(new int[]{i, i+1});
    g4.addAresta(new int[]{40, 1});
    for (int i = 41; i < 80; i++) g4.addAresta(new int[]{i, i+1});
    g4.addAresta(new int[]{80, 41});
    g4.addAresta(new int[]{40, 41});
    listaGrafos.add(g4);

    // Grafo 5: Árvore binária incompleta
    Grafo g5 = new Grafo();
    for (int i = 1; i <= 80; i++) g5.addVertice(i);
    for (int i = 1; i <= 40; i++) {
        if (2*i <= 80) g5.addAresta(new int[]{i, 2*i});
        if (2*i+1 <= 80) g5.addAresta(new int[]{i, 2*i+1});
    }
    listaGrafos.add(g5);

    // Grafo 6: Grafo bipartido (40+40)
    Grafo g6 = new Grafo();
    for (int i = 1; i <= 80; i++) g6.addVertice(i);
    for (int i = 1; i <= 40; i++)
        for (int j = 41; j <= 80; j++)
            if ((i+j)%5==0) g6.addAresta(new int[]{i, j});
    listaGrafos.add(g6);

    // Grafo 7: Grafo com quadrados desconexos
    Grafo g7 = new Grafo();
    for (int i = 1; i <= 80; i++) g7.addVertice(i);
    for (int k = 0; k < 20; k++) {
        int base = 4*k+1;
        g7.addAresta(new int[]{base, base+1});
        g7.addAresta(new int[]{base+1, base+2});
        g7.addAresta(new int[]{base+2, base+3});
        g7.addAresta(new int[]{base+3, base});
    }
    listaGrafos.add(g7);

    // Grafo 8: Grafo em "Y" duplo expandido
    Grafo g8 = new Grafo();
    for (int i = 1; i <= 80; i++) g8.addVertice(i);
    // Estrutura 1 (1-40)
    g8.addAresta(new int[]{1,2}); g8.addAresta(new int[]{2,3}); g8.addAresta(new int[]{3,4});
    g8.addAresta(new int[]{2,5}); g8.addAresta(new int[]{5,6}); g8.addAresta(new int[]{6,7});
    g8.addAresta(new int[]{2,8}); g8.addAresta(new int[]{8,9}); g8.addAresta(new int[]{9,10});
    g8.addAresta(new int[]{4,11}); g8.addAresta(new int[]{6,12}); g8.addAresta(new int[]{10,13});
    g8.addAresta(new int[]{13,14}); g8.addAresta(new int[]{14,15}); g8.addAresta(new int[]{15,16});
    g8.addAresta(new int[]{13,17}); g8.addAresta(new int[]{17,18}); g8.addAresta(new int[]{18,19});
    g8.addAresta(new int[]{16,20});
    g8.addAresta(new int[]{21,22}); g8.addAresta(new int[]{22,23}); g8.addAresta(new int[]{23,24});
    g8.addAresta(new int[]{22,25}); g8.addAresta(new int[]{25,26}); g8.addAresta(new int[]{26,27});
    g8.addAresta(new int[]{22,28}); g8.addAresta(new int[]{28,29}); g8.addAresta(new int[]{29,30});
    g8.addAresta(new int[]{24,31}); g8.addAresta(new int[]{26,32}); g8.addAresta(new int[]{30,33});
    g8.addAresta(new int[]{33,34}); g8.addAresta(new int[]{34,35}); g8.addAresta(new int[]{35,36});
    g8.addAresta(new int[]{33,37}); g8.addAresta(new int[]{37,38}); g8.addAresta(new int[]{38,39});
    g8.addAresta(new int[]{36,40});
    g8.addAresta(new int[]{20,21});
    // Estrutura 2 (41-80)
    g8.addAresta(new int[]{41,42}); g8.addAresta(new int[]{42,43}); g8.addAresta(new int[]{43,44});
    g8.addAresta(new int[]{42,45}); g8.addAresta(new int[]{45,46}); g8.addAresta(new int[]{46,47});
    g8.addAresta(new int[]{42,48}); g8.addAresta(new int[]{48,49}); g8.addAresta(new int[]{49,50});
    g8.addAresta(new int[]{44,51}); g8.addAresta(new int[]{46,52}); g8.addAresta(new int[]{50,53});
    g8.addAresta(new int[]{53,54}); g8.addAresta(new int[]{54,55}); g8.addAresta(new int[]{55,56});
    g8.addAresta(new int[]{53,57}); g8.addAresta(new int[]{57,58}); g8.addAresta(new int[]{58,59});
    g8.addAresta(new int[]{56,60});
    g8.addAresta(new int[]{61,62}); g8.addAresta(new int[]{62,63}); g8.addAresta(new int[]{63,64});
    g8.addAresta(new int[]{62,65}); g8.addAresta(new int[]{65,66}); g8.addAresta(new int[]{66,67});
    g8.addAresta(new int[]{62,68}); g8.addAresta(new int[]{68,69}); g8.addAresta(new int[]{69,70});
    g8.addAresta(new int[]{64,71}); g8.addAresta(new int[]{66,72}); g8.addAresta(new int[]{70,73});
    g8.addAresta(new int[]{73,74}); g8.addAresta(new int[]{74,75}); g8.addAresta(new int[]{75,76});
    g8.addAresta(new int[]{73,77}); g8.addAresta(new int[]{77,78}); g8.addAresta(new int[]{78,79});
    g8.addAresta(new int[]{76,80});
    g8.addAresta(new int[]{60,61});
    // Conecta as duas grandes estruturas
    g8.addAresta(new int[]{40,41});
    listaGrafos.add(g8);

    // Grafo 9: Grafo com cruzamentos e ciclos
    Grafo g9 = new Grafo();
    for (int i = 1; i <= 80; i++) g9.addVertice(i);
    for (int i = 1; i < 40; i++) g9.addAresta(new int[]{i, i+1});
    g9.addAresta(new int[]{40, 1});
    for (int i = 41; i < 80; i++) g9.addAresta(new int[]{i, i+1});
    g9.addAresta(new int[]{80, 41});
    g9.addAresta(new int[]{20, 60}); g9.addAresta(new int[]{30, 70});
    g9.addAresta(new int[]{10, 50}); g9.addAresta(new int[]{15, 55});
    g9.addAresta(new int[]{5, 45}); g9.addAresta(new int[]{8, 48});
    listaGrafos.add(g9);

    // Grafo 10: Grafo esparso aleatório
    Grafo g10 = new Grafo();
    for (int i = 1; i <= 80; i++) g10.addVertice(i);
    g10.addAresta(new int[]{1,8}); g10.addAresta(new int[]{2,16});
    g10.addAresta(new int[]{3,24}); g10.addAresta(new int[]{4,32});
    g10.addAresta(new int[]{5,40}); g10.addAresta(new int[]{6,48});
    g10.addAresta(new int[]{7,56}); g10.addAresta(new int[]{9,17});
    g10.addAresta(new int[]{10,25}); g10.addAresta(new int[]{11,33});
    g10.addAresta(new int[]{12,41}); g10.addAresta(new int[]{13,49});
    g10.addAresta(new int[]{14,57}); g10.addAresta(new int[]{15,65});
    g10.addAresta(new int[]{18,26}); g10.addAresta(new int[]{19,34});
    g10.addAresta(new int[]{20,42}); g10.addAresta(new int[]{21,50});
    g10.addAresta(new int[]{22,58}); g10.addAresta(new int[]{23,66});
    g10.addAresta(new int[]{27,35}); g10.addAresta(new int[]{28,43});
    g10.addAresta(new int[]{29,51}); g10.addAresta(new int[]{30,59});
    g10.addAresta(new int[]{31,67}); g10.addAresta(new int[]{36,44});
    g10.addAresta(new int[]{37,52}); g10.addAresta(new int[]{38,60});
    g10.addAresta(new int[]{39,68}); g10.addAresta(new int[]{45,53});
    g10.addAresta(new int[]{46,61}); g10.addAresta(new int[]{47,69});
    g10.addAresta(new int[]{54,62}); g10.addAresta(new int[]{55,70});
    g10.addAresta(new int[]{63,71}); g10.addAresta(new int[]{64,72});
    g10.addAresta(new int[]{73,74}); g10.addAresta(new int[]{75,76});
    g10.addAresta(new int[]{77,78}); g10.addAresta(new int[]{79,80});
    listaGrafos.add(g10);
        return listaGrafos;
}

}
