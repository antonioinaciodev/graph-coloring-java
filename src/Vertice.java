import java.util.ArrayList;

public class Vertice {
    private int num;
    private int grau;
    private ArrayList<Integer> adjacencia = new ArrayList<Integer>();
    private int cor = -1;

    public  Vertice(int num){
        this.num = num;
    }

    public int getNum(){
        return this.num;
    }

    public int getCor(){
        return this.cor;
    }

    public int getGrau(){
        return this.grau;
    }

    public ArrayList<Integer> getAdjacencia(){
        return this.adjacencia;
    }

    public void setCor(int cor){
        this.cor = cor;
    }

    public void addAdjacencia(int num){
        if (!this.adjacencia.contains(num)) {
            this.adjacencia.add(num);
            this.grau = this.adjacencia.size();
        }
    }

}
