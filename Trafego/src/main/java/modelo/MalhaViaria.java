package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MalhaViaria {

    private Segmento[][] segmentos;
    private List<Segmento> segmentosEntrada;
    private int qtdCarrosCirculando;

    private boolean emExecucao;
    
    public MalhaViaria() {
        this.emExecucao = true;
        qtdCarrosCirculando = 0;
    }
    
    public Segmento[][] lerDocumento(String path) throws FileNotFoundException, IOException {
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
            
            return identificarSegmentos(matrizLida);
        }
    }  
    
    public Segmento[][] identificarSegmentos(int [][] matrizLida){
        
        this.segmentos = new Segmento[matrizLida.length][matrizLida[0].length];
        this.segmentosEntrada = new ArrayList();
        for (int i = 0; i < matrizLida.length; i++){
            for (int j = 0; j < matrizLida[0].length; j++){    
                switch (matrizLida[i][j]) {
                    case 0: 
                        this.segmentos[i][j] = new Segmento(null, i, j, false, false, "░",this);
                        break;
                    case 1:
                        if (i == 0){
                            this.segmentos[i][j] = new Segmento("Estrada_Cima", i, j, true, false, "▒",this);
                            break;
                        }else if(i == matrizLida.length - 1){
                            this.segmentos[i][j] = new Segmento("Estrada_Cima", i, j, false, true, "▒",this);
                            this.segmentosEntrada.add(this.segmentos[i][j]);
                            break;
                        }else{
                            this.segmentos[i][j] = new Segmento("Estrada_Cima", i, j, false, false, "▒",this);
                            break;
                        }
                    case 2:
                        if (j == matrizLida[0].length - 1){
                            this.segmentos[i][j] = new Segmento("Estrada_Direita", i, j, true, false, "▒",this);
                            break; 
                        }else if(j == 0){
                            this.segmentos[i][j] = new Segmento("Estrada_Direita", i, j, false, true, "▒",this);
                            this.segmentosEntrada.add(this.segmentos[i][j]);
                            break;
                        }else{
                            this.segmentos[i][j] = new Segmento("Estrada_Direita", i, j, false, false, "▒",this);
                            break;                            
                        }
                    case 3:
                        if (i == matrizLida.length - 1){
                            this.segmentos[i][j] = new Segmento("Estrada_Baixo", i, j, true, false, "▒",this);
                            break;
                        }else if (i == 0){
                            this.segmentos[i][j] = new Segmento("Estrada_Baixo", i, j, false, true, "▒",this);
                            this.segmentosEntrada.add(this.segmentos[i][j]);
                            break;
                        }else{
                            this.segmentos[i][j] = new Segmento("Estrada_Baixo", i, j, false, false, "▒",this);
                            break;
                        }
                    case 4:
                        if(j == 0){
                            this.segmentos[i][j] = new Segmento("Estrada_Esquerda", i, j, true, false, "▒",this);
                            break;
                        }else if(j == matrizLida[0].length - 1){
                            this.segmentos[i][j] = new Segmento("Estrada_Esquerda", i, j, false, true, "▒",this);
                            this.segmentosEntrada.add(this.segmentos[i][j]);
                            break;
                        }else{
                            this.segmentos[i][j] = new Segmento("Estrada_Esquerda", i, j, false, false, "▒",this);
                            break;
                        }
                    case 5:
                        this.segmentos[i][j] = new Segmento("Cruzamento_Cima", i, j, false, false, "▓",this);
                        break;
                    case 6:
                        this.segmentos[i][j] = new Segmento("Cruzamento_Direita", i, j, false, false, "▓",this);
                        break;
                    case 7:
                        this.segmentos[i][j] = new Segmento("Cruzamento_Baixo", i, j, false, false, "▓",this);
                        break;
                    case 8:
                        this.segmentos[i][j] = new Segmento("Cruzamento_Esquerda", i, j, false,false, "▓",this);
                        break;
                    case 9:
                        this.segmentos[i][j] = new Segmento("Cruzamento_Cima_Direita", i, j, false,false, "▓",this);
                        break;
                    case 10:
                        this.segmentos[i][j] = new Segmento("Cruzamento_Cima_Esquerda", i, j, false,false, "▓",this);
                        break;
                    case 11:
                        this.segmentos[i][j] = new Segmento("Cruzamento_Baixo_Direita", i, j, false,false, "▓",this);
                        break;
                    case 12:
                        this.segmentos[i][j] = new Segmento("Cruzamento_Baixo_Esquerda", i, j, false, false, "▓",this);
                        break;
                }
            }
        }

        return this.segmentos;
    }
    
    public Segmento getProxSegmentoBaixo(Segmento segmento) {
        return this.getNodo(segmento.getIdxLinha() + 1, segmento.getIdxColuna());
    }

    public Segmento getProxSegmentoCima(Segmento segmento) {
        return this.getNodo(segmento.getIdxLinha() - 1, segmento.getIdxColuna());
    }

    public Segmento getProxSegmentoDireita(Segmento segmento) {
        return this.getNodo(segmento.getIdxLinha(), segmento.getIdxColuna() + 1);
    }

    public Segmento getProxSegmentoEsquerda(Segmento segmento) {
        return this.getNodo(segmento.getIdxLinha(), segmento.getIdxColuna() - 1);
    }

    public List<Segmento> getSegmentosEntrada() {
        return segmentosEntrada;
    }

    public void setSegmentosEntrada(List<Segmento> segmentosEntrada) {
        this.segmentosEntrada = segmentosEntrada;
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

    public int getQtdCarrosCirculando() {
        return qtdCarrosCirculando;
    }

    public void adicionarCarroCirculando(){
        this.qtdCarrosCirculando++;
    }
    
    public void diminuirCarroCirculando(){
        this.qtdCarrosCirculando--;
    }
}
