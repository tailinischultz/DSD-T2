package modelo;

public abstract class Carro extends Thread{
    public abstract String getNome();
    public abstract void setSegmentoAtual(Segmento nodo);
}
