package modelo;

public abstract class Carro extends Thread{
    
    private String nome = "🚘";
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public abstract void setSegmentoAtual(Segmento nodo);
    
}
