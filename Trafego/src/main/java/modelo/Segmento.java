
package modelo;

public class Segmento {

    private Carro carro;
    private Carro reserva;
    private MalhaViaria malhaViaria;
    private String direcao;
    private boolean saida;
    private int idxLinha;
    private int idxColuna;

    public Segmento(String direcao, int idxLinha, int idxColuna, MalhaViaria malhaViaria, boolean saida) {
        this.direcao = direcao;
        this.idxLinha = idxLinha;
        this.idxColuna = idxColuna;
        this.malhaViaria = malhaViaria;
        this.saida = saida;
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

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public boolean isSaida() {
        return saida;
    }

    public void setSaida(boolean saida) {
        this.saida = saida;
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

    public MalhaViaria getMalhaViaria() {
        return malhaViaria;
    }

    public boolean isCruzamento() {
        return this.direcao == "Cruzamento_Cima"           ||
                this.direcao == "Cruzamento_Baixo"          ||
                this.direcao == "Cruzamento_Direita"        ||
                this.direcao == "Cruzamento_Esquerda"       ||
                this.direcao == "Cruzamento_Baixo_Direita" ||
                this.direcao == "Cruzamento_Baixo_Esquerda" ||
                this.direcao == "Cruzamento_Cima_Direta"   ||
                this.direcao == "Cruzamento_Cima_Esquerda";
    }


}

