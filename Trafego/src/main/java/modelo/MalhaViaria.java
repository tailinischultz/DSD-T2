package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MalhaViaria {

    private Segmento[][] segmentos;
    private String path;

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

            return matrizLida;
        }
    }  
                    
    //i == 0 ---- Percorrendo todas as colunas da linha zero ---- ESTRADA_CIMA
    //i == 9 ----- Percorrendo todas as colunas da linha segmentos.length - 1 ---- ESTRADA_BAIXO
    //j == 0 ----- Percorrendo todas as linhas da coluna zero ----- ESTRADA_ESQUERDA
    //j == 16 ----- Percorrendo todas as linhas da coluna segmentos[0].length - 1 ---- ESTRADA_DIREITA
    
    public Segmento[][] identificarSegmentos(int [][] matrizLida){
        
        for (int i = 0; i < matrizLida.length; i++){
            for (int j = 0; j < matrizLida[0].length; j++){                
                switch (matrizLida[i][j]) {
                    case 0: 
                        this.segmentos[i][j] = new Segmento(null, i, j, this, false);
                        break;
                    case 1:
                        if (i == 0){
                            this.segmentos[i][j] = new Segmento("Estrada_Cima", i, j, this, true);
                            break;
                        }else{
                            this.segmentos[i][j] = new Segmento("Estrada_Cima", i, j, this, false);
                            break;
                        }
                    case 2:
                        if (j == matrizLida[0].length - 1){
                            this.segmentos[i][j] = new Segmento("Estrada_Direita", i, j, this, true);
                            break; 
                        }else{
                            this.segmentos[i][j] = new Segmento("Estrada_Direita", i, j, this, false);
                            break;                            
                        }
                    case 3:
                        if (i == matrizLida.length - 1){
                            this.segmentos[i][j] = new Segmento("Estrada_Baixo", i, j, this, true);
                            break;
                        }else{
                            this.segmentos[i][j] = new Segmento("Estrada_Baixo", i, j, this, false);
                            break;
                        }
                    case 4:
                        if(j == 0){
                            this.segmentos[i][j] = new Segmento("Estrada_Esquerda", i, j, this, true);
                            break;
                        }else{
                            this.segmentos[i][j] = new Segmento("Estrada_Esquerda", i, j, this, false);
                            break;
                        }
                    case 5:
                        this.segmentos[i][j] = new Segmento("Cruzamento_Cima", i, j, this, false);
                        break;
                    case 6:
                        this.segmentos[i][j] = new Segmento("Cruzamento_Direita", i, j, this, false);
                        break;
                    case 7:
                        this.segmentos[i][j] = new Segmento("Cruzamento_Baixo", i, j, this, false);
                        break;
                    case 8:
                        this.segmentos[i][j] = new Segmento("Cruzamento_Esquerda", i, j, this, false);
                        break;
                    case 9:
                        this.segmentos[i][j] = new Segmento("Cruzamento_Cima_Direita", i, j, this, false);
                        break;
                    case 10:
                        this.segmentos[i][j] = new Segmento("Cruzamento_Cima_Esquerda", i, j, this, false);
                        break;
                    case 11:
                        this.segmentos[i][j] = new Segmento("Cruzamento_Direita_Baixo", i, j, this, false);
                        break;
                    case 12:
                        this.segmentos[i][j] = new Segmento("Cruzamento_Baixo_Esquerda", i, j, this, false);
                        break;
                }
            }
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

    public void setNodos(Segmento[][] nodos) {
        this.segmentos = nodos;
    }

    public Segmento[][] getNodos() {
        return segmentos;
    }

}
