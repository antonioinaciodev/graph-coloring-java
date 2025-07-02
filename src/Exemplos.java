import java.util.ArrayList;
import java.util.Random;

public class Exemplos {

    // O método grafos10() foi removido.

    public ArrayList<Grafo> grafos20() {
        ArrayList<Grafo> listaGrafos = new ArrayList<>();
        int n = 20;

        // Grafo 1: Linha com arestas extras
        Grafo g1 = new Grafo();
        for (int i = 1; i <= n; i++) g1.addVertice(i);
        for (int i = 1; i < n; i++) g1.addAresta(new int[]{i, i+1});
        //--ADENSAMENTO--
        g1.addAresta(new int[]{1, 5});
        g1.addAresta(new int[]{6, 12});
        g1.addAresta(new int[]{13, 19});
        listaGrafos.add(g1);

        // Grafo 2: Ciclo com cordas
        Grafo g2 = new Grafo();
        for (int i = 1; i <= n; i++) g2.addVertice(i);
        for (int i = 1; i < n; i++) g2.addAresta(new int[]{i, i+1});
        g2.addAresta(new int[]{n, 1});
        //--ADENSAMENTO--
        for (int i = 1; i <= n; i++) {
            g2.addAresta(new int[]{i, ((i + 4) % n) + 1});
        }
        listaGrafos.add(g2);

        // Grafo 3: Estrela com arestas entre folhas
        Grafo g3 = new Grafo();
        for (int i = 1; i <= n; i++) g3.addVertice(i);
        for (int i = 2; i <= n; i++) g3.addAresta(new int[]{1, i});
        //--ADENSAMENTO--
        g3.addAresta(new int[]{2, 3});
        g3.addAresta(new int[]{4, 5});
        g3.addAresta(new int[]{6, 7});
        g3.addAresta(new int[]{8, 10});
        g3.addAresta(new int[]{12, 15});
        listaGrafos.add(g3);

        // Grafo 4: Dois ciclos (10-v) com múltiplas pontes
        Grafo g4 = new Grafo();
        int half = n / 2;
        for (int i = 1; i <= n; i++) g4.addVertice(i);
        for (int i = 1; i < half; i++) g4.addAresta(new int[]{i, i+1});
        g4.addAresta(new int[]{half, 1});
        for (int i = half + 1; i < n; i++) g4.addAresta(new int[]{i, i+1});
        g4.addAresta(new int[]{n, half + 1});
        //--ADENSAMENTO--
        g4.addAresta(new int[]{1, half + 1});
        g4.addAresta(new int[]{3, half + 3});
        g4.addAresta(new int[]{5, half + 5});
        g4.addAresta(new int[]{7, half + 7});
        listaGrafos.add(g4);

        // Grafo 5: Árvore binária com arestas extras
        Grafo g5 = new Grafo();
        for (int i = 1; i <= n; i++) g5.addVertice(i);
        for (int i = 1; i <= n / 2; i++) {
            if (2*i <= n) g5.addAresta(new int[]{i, 2*i});
            if (2*i+1 <= n) g5.addAresta(new int[]{i, 2*i+1});
        }
        //--ADENSAMENTO--
        g5.addAresta(new int[]{4, 7}); // Conecta sub-árvores
        g5.addAresta(new int[]{5, 6});
        g5.addAresta(new int[]{8, 12});
        g5.addAresta(new int[]{9, 15});
        listaGrafos.add(g5);

        // Grafo 6: Grafo bipartido denso (10+10)
        Grafo g6 = new Grafo();
        for (int i = 1; i <= n; i++) g6.addVertice(i);
        for (int i = 1; i <= half; i++) {
            for (int j = half + 1; j <= n; j++) {
                //--ADENSAMENTO--
                if ((i + j) % 3 == 0) {
                    g6.addAresta(new int[]{i, j});
                }
            }
        }
        listaGrafos.add(g6);

        // Grafo 7: Componentes C4 conectados
        Grafo g7 = new Grafo();
        for (int i = 1; i <= n; i++) g7.addVertice(i);
        int numComponentes = n/4;
        for (int k = 0; k < numComponentes; k++) {
            int base = 4*k + 1;
            g7.addAresta(new int[]{base, base+1});
            g7.addAresta(new int[]{base+1, base+2});
            g7.addAresta(new int[]{base+2, base+3});
            g7.addAresta(new int[]{base+3, base});
        }
        //--ADENSAMENTO-- (Conectando os quadrados)
        for (int k = 0; k < numComponentes - 1; k++) {
            int base1 = 4*k + 1;
            int base2 = 4*(k+1) + 1;
            g7.addAresta(new int[]{base1, base2});
            g7.addAresta(new int[]{base1 + 1, base2 + 2});
        }
        listaGrafos.add(g7);

        // Grafo 8: Roda (Wheel Graph) W_20
        Grafo g8 = new Grafo();
        for (int i = 1; i <= n; i++) g8.addVertice(i);
        // Vértice central conectado a todos
        for (int i = 2; i <= n; i++) g8.addAresta(new int[]{1, i});
        // Ciclo externo
        for (int i = 2; i < n; i++) g8.addAresta(new int[]{i, i + 1});
        g8.addAresta(new int[]{n, 2});
        listaGrafos.add(g8);


        // Grafo 9: Grade (Grid Graph) 4x5
        Grafo g9 = new Grafo();
        int rows = 4, cols = 5;
        for (int i = 1; i <= n; i++) g9.addVertice(i);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int u = i * cols + j + 1;
                if (j + 1 < cols) {
                    int v = u + 1;
                    g9.addAresta(new int[]{u,v});
                }
                if (i + 1 < rows) {
                    int v = u + cols;
                    g9.addAresta(new int[]{u,v});
                }
            }
        }
        listaGrafos.add(g9);

        // Grafo 10: Grafo aleatório denso
        Grafo g10 = new Grafo();
        for (int i = 1; i <= n; i++) g10.addVertice(i);
        Random rand = new Random();
        int numArestas = n * 2; // Aumentando o número de arestas
        for(int i = 0; i < numArestas; i++){
            int u = rand.nextInt(n) + 1;
            int v = rand.nextInt(n) + 1;
            if(u != v) g10.addAresta(new int[]{u,v});
        }
        listaGrafos.add(g10);

        return listaGrafos;
    }

public ArrayList<Grafo> grafos40() {
    ArrayList<Grafo> listaGrafos = new ArrayList<>();
    int n = 40;
    int half = n / 2;

    // Grafo 1: Ciclo com cordas
    Grafo g1 = new Grafo();
    for (int i = 1; i <= n; i++) g1.addVertice(i);
    for (int i = 1; i < n; i++) g1.addAresta(new int[]{i, i + 1});
    g1.addAresta(new int[]{n, 1});
    //--ADENSAMENTO--
    for (int i = 1; i <= n; i++) {
        g1.addAresta(new int[]{i, ((i + 7) % n) + 1});
        g1.addAresta(new int[]{i, ((i + 13) % n) + 1});
    }
    listaGrafos.add(g1);

    // Grafo 2: Roda (Wheel Graph) W_40
    Grafo g2 = new Grafo();
    for (int i = 1; i <= n; i++) g2.addVertice(i);
    for (int i = 2; i <= n; i++) g2.addAresta(new int[]{1, i}); // Centro
    for (int i = 2; i < n; i++) g2.addAresta(new int[]{i, i + 1}); // Aro
    g2.addAresta(new int[]{n, 2});
    listaGrafos.add(g2);

    // Grafo 3: Dois ciclos (20-v) com múltiplas pontes
    Grafo g3 = new Grafo();
    for (int i = 1; i <= n; i++) g3.addVertice(i);
    for (int i = 1; i < half; i++) g3.addAresta(new int[]{i, i+1});
    g3.addAresta(new int[]{half, 1});
    for (int i = half + 1; i < n; i++) g3.addAresta(new int[]{i, i+1});
    g3.addAresta(new int[]{n, half + 1});
    //--ADENSAMENTO--
    for (int i = 1; i <= 5; i++) {
        g3.addAresta(new int[]{i, half + i});
        g3.addAresta(new int[]{i*2, half + i*3});
    }
    listaGrafos.add(g3);
    
    // Grafo 4: Grafo Bipartido Denso (20+20)
    Grafo g4 = new Grafo();
    for (int i = 1; i <= n; i++) g4.addVertice(i);
    for (int i = 1; i <= half; i++) {
        for (int j = half + 1; j <= n; j++) {
            //--ADENSAMENTO--
            if ((i + j) % 4 == 0 || (i+j) % 5 == 1) {
                g4.addAresta(new int[]{i, j});
            }
        }
    }
    listaGrafos.add(g4);

    // Grafo 5: Componentes C5 conectados
    Grafo g5 = new Grafo();
    for (int i = 1; i <= n; i++) g5.addVertice(i);
    int numComponentes = n/5;
    for (int k = 0; k < numComponentes; k++) {
        int base = 5*k + 1;
        g5.addAresta(new int[]{base, base+1}); 
        g5.addAresta(new int[]{base+1, base+2});
        g5.addAresta(new int[]{base+2, base+3});
        g5.addAresta(new int[]{base+3, base+4});
        g5.addAresta(new int[]{base+4, base});
    }
    //--ADENSAMENTO--
    for (int k = 0; k < numComponentes - 1; k++) {
        int base1 = 5*k + 1;
        int base2 = 5*(k+1) + 1;
        g5.addAresta(new int[]{base1, base2});
        g5.addAresta(new int[]{base1 + 1, base2 + 2});
    }
    g5.addAresta(new int[]{1, 5*3+1});
    listaGrafos.add(g5);

    // Grafo 6-9: Variações de grafos aleatórios
     for (int i = 6; i <= 9; i++){
        Grafo g = new Grafo();
        for (int k = 1; k <= n; k++) g.addVertice(k);
        Random rand = new Random(i); // Semente fixa para reprodutibilidade
        int numArestas = n * (i-2); // Aumentando a densidade a cada grafo
        for(int j = 0; j < numArestas; j++){
            int u = rand.nextInt(n) + 1;
            int v = rand.nextInt(n) + 1;
            if(u != v) g.addAresta(new int[]{u,v});
        }
        listaGrafos.add(g);
    }

    // Grafo 10: Grafo aleatório muito denso
    Grafo g10 = new Grafo();
    for (int i = 1; i <= n; i++) g10.addVertice(i);
    Random rand = new Random();
    int numArestas = n * 8; 
    for(int i = 0; i < numArestas; i++){
        int u = rand.nextInt(n) + 1;
        int v = rand.nextInt(n) + 1;
        if(u != v) g10.addAresta(new int[]{u,v});
    }
    listaGrafos.add(g10);

    return listaGrafos;
}

    public ArrayList<Grafo> grafos80() {
        ArrayList<Grafo> listaGrafos = new ArrayList<>();
        int n = 80;
        int half = n / 2;

        // Grafo 1: Ciclo com cordas
        Grafo g1 = new Grafo();
        for (int i = 1; i <= n; i++) g1.addVertice(i);
        for (int i = 1; i < n; i++) g1.addAresta(new int[]{i, i + 1});
        g1.addAresta(new int[]{n, 1});
        //--ADENSAMENTO--
        for (int i = 1; i <= n; i++) {
            g1.addAresta(new int[]{i, ((i + 9) % n) + 1});
            g1.addAresta(new int[]{i, ((i + 21) % n) + 1});
        }
        listaGrafos.add(g1);

        // Grafo 2: Roda (Wheel Graph) W_80
        Grafo g2 = new Grafo();
        for (int i = 1; i <= n; i++) g2.addVertice(i);
        for (int i = 2; i <= n; i++) g2.addAresta(new int[]{1, i}); // Centro
        for (int i = 2; i < n; i++) g2.addAresta(new int[]{i, i + 1}); // Aro
        g2.addAresta(new int[]{n, 2});
        listaGrafos.add(g2);

        // Grafo 3: Dois ciclos (40-v) com múltiplas pontes
        Grafo g3 = new Grafo();
        for (int i = 1; i <= n; i++) g3.addVertice(i);
        for (int i = 1; i < half; i++) g3.addAresta(new int[]{i, i+1});
        g3.addAresta(new int[]{half, 1});
        for (int i = half + 1; i < n; i++) g3.addAresta(new int[]{i, i+1});
        g3.addAresta(new int[]{n, half + 1});
        //--ADENSAMENTO--
        for (int i = 1; i <= 10; i++) {
            g3.addAresta(new int[]{i, half + i});
            g3.addAresta(new int[]{i*2, half + i*3});
        }
        listaGrafos.add(g3);
        
        // Grafo 4: Grafo Bipartido Denso (40+40)
        Grafo g4 = new Grafo();
        for (int i = 1; i <= n; i++) g4.addVertice(i);
        for (int i = 1; i <= half; i++) {
            for (int j = half + 1; j <= n; j++) {
                //--ADENSAMENTO--
                if ((i + j) % 5 == 0 || (i+j) % 7 == 1) {
                    g4.addAresta(new int[]{i, j});
                }
            }
        }
        listaGrafos.add(g4);

        // Grafo 5: Componentes C4 conectados
        Grafo g5 = new Grafo();
        for (int i = 1; i <= n; i++) g5.addVertice(i);
        int numComponentes = n/4;
        for (int k = 0; k < numComponentes; k++) {
            int base = 4*k + 1;
            g5.addAresta(new int[]{base, base+1}); g5.addAresta(new int[]{base+1, base+2});
            g5.addAresta(new int[]{base+2, base+3}); g5.addAresta(new int[]{base+3, base});
        }
        //--ADENSAMENTO--
        for (int k = 0; k < numComponentes - 1; k++) {
            int base1 = 4*k + 1;
            int base2 = 4*(k+1) + 1;
            g5.addAresta(new int[]{base1, base2});
            g5.addAresta(new int[]{base1 + 1, base2 + 2});
        }
        g5.addAresta(new int[]{1, 4*4+1}); // Conecta primeiro ao quinto
        g5.addAresta(new int[]{2, 4*8+2}); // e outros mais distantes
        listaGrafos.add(g5);

        // Grafo 6-9: Variações de grafos aleatórios
         for (int i = 6; i <= 9; i++){
            Grafo g = new Grafo();
            for (int k = 1; k <= n; k++) g.addVertice(k);
            Random rand = new Random(i); // Semente fixa para reprodutibilidade
            int numArestas = n * i; // Aumentando a densidade a cada grafo
            for(int j = 0; j < numArestas; j++){
                int u = rand.nextInt(n) + 1;
                int v = rand.nextInt(n) + 1;
                if(u != v) g.addAresta(new int[]{u,v});
            }
            listaGrafos.add(g);
        }

        // Grafo 10: Grafo aleatório muito denso
        Grafo g10 = new Grafo();
        for (int i = 1; i <= n; i++) g10.addVertice(i);
        Random rand = new Random();
        int numArestas = n * 10; 
        for(int i = 0; i < numArestas; i++){
            int u = rand.nextInt(n) + 1;
            int v = rand.nextInt(n) + 1;
            if(u != v) g10.addAresta(new int[]{u,v});
        }
        listaGrafos.add(g10);

        return listaGrafos;
    }

    public ArrayList<Grafo> grafos160() {
        ArrayList<Grafo> listaGrafos = new ArrayList<>();
        int n = 160;
        int half = n / 2;

        // Grafo 1: Ciclo com cordas
        Grafo g1 = new Grafo();
        for (int i = 1; i <= n; i++) g1.addVertice(i);
        for (int i = 1; i < n; i++) g1.addAresta(new int[]{i, i + 1});
        g1.addAresta(new int[]{n, 1});
        //--ADENSAMENTO--
        for (int i = 1; i <= n; i++) {
            g1.addAresta(new int[]{i, ((i + 14) % n) + 1});
            g1.addAresta(new int[]{i, ((i + 31) % n) + 1});
        }
        listaGrafos.add(g1);

        // Grafo 2: Roda (Wheel Graph) W_160
        Grafo g2 = new Grafo();
        for (int i = 1; i <= n; i++) g2.addVertice(i);
        for (int i = 2; i <= n; i++) g2.addAresta(new int[]{1, i});
        for (int i = 2; i < n; i++) g2.addAresta(new int[]{i, i + 1});
        g2.addAresta(new int[]{n, 2});
        listaGrafos.add(g2);

        // Grafo 3: Dois ciclos (80-v) com múltiplas pontes
        Grafo g3 = new Grafo();
        for (int i = 1; i <= n; i++) g3.addVertice(i);
        for (int i = 1; i < half; i++) g3.addAresta(new int[]{i, i+1});
        g3.addAresta(new int[]{half, 1});
        for (int i = half + 1; i < n; i++) g3.addAresta(new int[]{i, i+1});
        g3.addAresta(new int[]{n, half + 1});
        //--ADENSAMENTO--
        for (int i = 1; i <= 20; i++) {
            g3.addAresta(new int[]{i, half + i});
            g3.addAresta(new int[]{i*2, half + i*3});
             g3.addAresta(new int[]{i*3, half + i*2});
        }
        listaGrafos.add(g3);

        // Grafo 4: Grafo Bipartido Denso (80+80)
        Grafo g4 = new Grafo();
        for (int i = 1; i <= n; i++) g4.addVertice(i);
        for (int i = 1; i <= half; i++) {
            for (int j = half + 1; j <= n; j++) {
                if ((i + j) % 7 == 0 || (i+j) % 11 == 0 || (i+j) % 13 == 0) {
                    g4.addAresta(new int[]{i, j});
                }
            }
        }
        listaGrafos.add(g4);
        
        // Grafo 5: Componentes C4 conectados
        Grafo g5 = new Grafo();
        for (int i = 1; i <= n; i++) g5.addVertice(i);
        int numComponentes = n/4;
        for (int k = 0; k < numComponentes; k++) {
            int base = 4*k + 1;
            g5.addAresta(new int[]{base, base+1}); g5.addAresta(new int[]{base+1, base+2});
            g5.addAresta(new int[]{base+2, base+3}); g5.addAresta(new int[]{base+3, base});
        }
        //--ADENSAMENTO--
        for (int k = 0; k < numComponentes - 1; k++) {
            int base1 = 4*k + 1;
            int base2 = 4*(k+1) + 1;
            g5.addAresta(new int[]{base1, base2});
            g5.addAresta(new int[]{base1 + 1, base2 + 2});
        }
        g5.addAresta(new int[]{1, 4*10+1}); 
        g5.addAresta(new int[]{2, 4*20+2});
        g5.addAresta(new int[]{3, 4*30+3});
        listaGrafos.add(g5);
        
        // Grafo 6-9: Variações de grafos aleatórios
        for (int i = 6; i <= 9; i++){
            Grafo g = new Grafo();
            for (int k = 1; k <= n; k++) g.addVertice(k);
            Random rand = new Random(i); 
            int numArestas = n * (i + 4) ; // Aumentando a densidade
            for(int j = 0; j < numArestas; j++){
                int u = rand.nextInt(n) + 1;
                int v = rand.nextInt(n) + 1;
                if(u != v) g.addAresta(new int[]{u,v});
            }
            listaGrafos.add(g);
        }

        // Grafo 10: Grafo aleatório muito denso
        Grafo g10 = new Grafo();
        for (int i = 1; i <= n; i++) g10.addVertice(i);
        Random rand = new Random();
        int numArestas = n * 20; 
        for(int i = 0; i < numArestas; i++){
            int u = rand.nextInt(n) + 1;
            int v = rand.nextInt(n) + 1;
            if(u != v) g10.addAresta(new int[]{u,v});
        }
        listaGrafos.add(g10);

        return listaGrafos;
    }
}