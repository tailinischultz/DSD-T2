package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MalhaViaria {

    private Segmento[][] segmentos;

    private boolean emExecucao;
    
    public MalhaViaria() {
        this.emExecucao = true;
    }
    
    public int[][] lerDocumento(String path) throws FileNotFoundException, IOException {
        try (BufferedReader buffRead = new BufferedReader(new FileReader(path))) {
            int qtdLinhas = Integer.parseInt(buffRead.readLine().trim());
            int qtdColunas = Integer.parseInt(buffRead.readLine().trim());
            
            int[][] matrizLida = new int[qtdLinhas][qtdColunas];

            for (int i = 0; i < qtdLinhas; i++) {
                String[] linha = buffRead.readLine().trim().split("\t");
                for (int j = 0; j < qtdColunas; j++) {
                    matrizLida[i][j] = Integer.parseInt(linha[j]);
                }
            }
           
            for (int i = 0; i < matrizLida.length; i++){
                for (int j = 0; j < matrizLida[0].length; j++){
                    System.out.print(matrizLida[i][j] + " ");
                }
                    System.out.println();
            }

            return matrizLida;
        }
    }  
    
    public Segmento[][] identificarSegmentos(int [][] matrizLida){
        
        this.segmentos = new Segmento[matrizLida.length][matrizLida[0].length];
        for (int i = 0; i < matrizLida.length; i++){
            for (int j = 0; j < matrizLida[0].length; j++){    
                switch (matrizLida[i][j]) {
                    case 0: 
                        this.segmentos[i][j] = new Segmento(null, i, j, false, "");
                        break;
                    case 1:
                        if (i == 0){
                            this.segmentos[i][j] = new Segmento("Estrada_Cima", i, j, true, "|");
                            break;
                        }else{
                            this.segmentos[i][j] = new Segmento("Estrada_Cima", i, j, false, "|");
                            break;
                        }
                    case 2:
                        if (j == matrizLida[0].length - 1){
                            this.segmentos[i][j] = new Segmento("Estrada_Direita", i, j, true, "-");
                            break; 
                        }else{
                            this.segmentos[i][j] = new Segmento("Estrada_Direita", i, j, false, "-");
                            break;                            
                        }
                    case 3:
                        if (i == matrizLida.length - 1){
                            this.segmentos[i][j] = new Segmento("Estrada_Baixo", i, j, true, "|");
                            break;
                        }else{
                            this.segmentos[i][j] = new Segmento("Estrada_Baixo", i, j, false, "|");
                            break;
                        }
                    case 4:
                        if(j == 0){
                            this.segmentos[i][j] = new Segmento("Estrada_Esquerda", i, j, true, "-");
                            break;
                        }else{
                            this.segmentos[i][j] = new Segmento("Estrada_Esquerda", i, j, false, "-");
                            break;
                        }
                    case 5:
                        this.segmentos[i][j] = new Segmento("Cruzamento_Cima", i, j, false, "+");
                        break;
                    case 6:
                        this.segmentos[i][j] = new Segmento("Cruzamento_Direita", i, j, false, "+");
                        break;
                    case 7:
                        this.segmentos[i][j] = new Segmento("Cruzamento_Baixo", i, j, false, "+");
                        break;
                    case 8:
                        this.segmentos[i][j] = new Segmento("Cruzamento_Esquerda", i, j, false, "+");
                        break;
                    case 9:
                        this.segmentos[i][j] = new Segmento("Cruzamento_Cima_Direita", i, j, false, "+");
                        break;
                    case 10:
                        this.segmentos[i][j] = new Segmento("Cruzamento_Cima_Esquerda", i, j, false, "+");
                        break;
                    case 11:
                        this.segmentos[i][j] = new Segmento("Cruzamento_Direita_Baixo", i, j, false, "+");
                        break;
                    case 12:
                        this.segmentos[i][j] = new Segmento("Cruzamento_Baixo_Esquerda", i, j, false, "+");
                        break;
                }
            }
        }

        for (int i = 0; i < segmentos.length; i++) {
            for (int j = 0; j < segmentos[0].length; j++) {
                System.out.print(segmentos[i][j].getCaracter() + " ");
            }
            System.out.println();
        }

        return this.segmentos;
    }

    public void paraExecucao() {
        this.emExecucao = false;
    }

    public boolean estaEmExecucao() {
        return this.emExecucao;
    }

    public Segmento getNodo(int idxLinha, int idxColuna) {
        return this.segmentos[idxLinha][idxColuna];
    }

    public void setNodo(int idxLinha, int idxColuna, Segmento nodo) {
        this.segmentos[idxLinha][idxColuna] = nodo;
    }

    public void setListaSegmentos(Segmento[][] nodos) {
        this.segmentos = nodos;
    }

    public Segmento[][] getListaSegmentos() {
        return segmentos;
    }

}
