/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author User
 */
public class ConversorMatrizMalhaViaria {

    private Malha malhaViaria;

    public ConversorMatrizMalhaViaria(int [][] matrizConverter) {
        this.criaMatrizNodo(matrizConverter);
        this.identificaNodosSaida();
    }

    public Malha getMatrizConvertidaParaMalha() {
        return malhaViaria;
    }

    private void identificaNodosSaida() {
        this.identificaNodosSaidaTopoBaixo();
        this.identificarNodosSaidaDireitaEsquerda();
    }

    private void identificaNodosSaidaTopoBaixo() {
        Nodo[][] matrizNodos = malhaViaria.getNodos();
        for (int idxColuna = 0; idxColuna < matrizNodos[0].length; idxColuna++) {
            Nodo nodoAtualTopo = matrizNodos[0][idxColuna];
            Nodo nodoAtualBaixo = matrizNodos[matrizNodos.length - 1][idxColuna];
            this.identificaNodoSaida(nodoAtualTopo, Direcao.CIMA);
            this.identificaNodoSaida(nodoAtualBaixo, Direcao.BAIXO);
        }
    }

    private void identificarNodosSaidaDireitaEsquerda() {
        Nodo[][] matrizNodos = malhaViaria.getNodos();
        for (int idxLinha = 0; idxLinha < matrizNodos.length; idxLinha++) {
            Nodo nodoAtualDireita = matrizNodos[idxLinha][matrizNodos[idxLinha].length - 1];
            Nodo nodoAtualEsquerda = matrizNodos[idxLinha][0];
            this.identificaNodoSaida(nodoAtualDireita, Direcao.DIREITA);
            this.identificaNodoSaida(nodoAtualEsquerda, Direcao.ESQUERDA);
        }
    }

    private void identificaNodoSaida(Nodo nodo, Direcao direcao ) {
        if (nodo == null) {
            return;
        }
        if (nodo.getDirecao() == direcao) {
            nodo.setNodoDeSaida(true);
        }
    }

    private void criaMatrizNodo(int [][] matrizConverter) {
        Malha malhaViaria = new Malha();
        Nodo[][] matrizNodo = new Nodo[matrizConverter.length][matrizConverter[0].length];

        for (int idxLinha = 0; idxLinha < matrizConverter.length; idxLinha++) {
            for (int idxColuna = 0; idxColuna < matrizConverter[idxLinha].length; idxColuna++) {
                if (matrizConverter[idxLinha][idxColuna] == 0) {
                    continue;
                }
                Direcao direcao = FactoryDirecao.getDirecao(matrizConverter[idxLinha][idxColuna]);
                matrizNodo[idxLinha][idxColuna] = new Nodo(direcao, idxLinha, idxColuna, malhaViaria);
            }
        }
        malhaViaria.setNodos(matrizNodo);
        this.malhaViaria = malhaViaria;
    }
}
