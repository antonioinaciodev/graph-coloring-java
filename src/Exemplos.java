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
}
