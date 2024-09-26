/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author User
 */
public class Nodo {

    private Carro carro;
    private Carro reserva;
    private Malha malhaViaria;
    private Direcao direcao;
    private boolean nodoDeSaida;
    private int idxLinha;
    private int idxColuna;

    public Nodo(Direcao direcao, int idxLinha, int idxColuna, Malha malhaViaria) {
        this.direcao = direcao;
        this.nodoDeSaida = false;
        this.idxLinha = idxLinha;
        this.idxColuna = idxColuna;
        this.malhaViaria = malhaViaria;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Carro getReserva() {
        return reserva;
    }

    public void setReserva(Carro reserva) {
        this.reserva = reserva;
    }

    public Direcao getDirecao() {
        return direcao;
    }

    public void setDirecao(Direcao direcao) {
        this.direcao = direcao;
    }

    public boolean isNodoDeSaida() {
        return nodoDeSaida;
    }

    public void setNodoDeSaida(boolean nodoDeSaida) {
        this.nodoDeSaida = nodoDeSaida;
    }

    public int getIdxLinha() {
        return idxLinha;
    }

    public void setIdxLinha(int idxLinha) {
        this.idxLinha = idxLinha;
    }

    public int getIdxColuna() {
        return idxColuna;
    }

    public void setIdxColuna(int idxColuna) {
        this.idxColuna = idxColuna;
    }

    public Malha getMalhaViaria() {
        return malhaViaria;
    }

    //Verifica se o nodo atual é um cruzamento baseado na definição na classe Direcao
    public boolean isCruzamento() {
        return this.direcao == Direcao.CRUZAMENTO_CIMA           ||
                this.direcao == Direcao.CRUZAMENTO_BAIXO          ||
                this.direcao == Direcao.CRUZAMENTO_DIREITA        ||
                this.direcao == Direcao.CRUZAMENTO_ESQUERDA       ||
                this.direcao == Direcao.CRUZAMENTO_BAIXO_DIREITA  ||
                this.direcao == Direcao.CRUZAMENTO_BAIXO_ESQUERDA ||
                this.direcao == Direcao.CRUZAMENTO_CIMA_DIREITA   ||
                this.direcao == Direcao.CRUZAMENTO_CIMA_ESQUERDA;
    }
    //
    @Override
    public String toString() {
        return String.format("Nodo linha="+idxLinha+", coluna="+idxColuna+"direção="+direcao +"nodoDeSaida="+nodoDeSaida);

    }
}

