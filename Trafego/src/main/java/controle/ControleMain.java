package controle;

import java.io.IOException;
import modelo.MalhaViaria;
import visao.Tela;

public class ControleMain {

    private Tela view;
    private MalhaViaria malhaViaria;
    ControleMalha desenharMalhaViaria;
    private ControleCarros adicionarCarros;

    public void setView(Tela view) {
        this.view = view;
        this.malhaViaria = new MalhaViaria();
    }

    public void criarMalhaViaria(String path) throws IOException{
        this.malhaViaria.lerDocumento(path);
    }

    public void iniciarMonitor(int tempo, int numCarros){
        this.desenharMalhaViaria = new ControleMalha(this.malhaViaria, this.view.getTextArea());
        desenharMalhaViaria.start();
        this.adicionarCarros = new ControleCarros(this.malhaViaria, false, tempo, numCarros);
        adicionarCarros.start();
    }

    public void iniciarSemaforo(int tempo, int numCarros){
        this.desenharMalhaViaria = new ControleMalha(this.malhaViaria, this.view.getTextArea());
        desenharMalhaViaria.start();
        this.adicionarCarros = new ControleCarros(this.malhaViaria, true, tempo, numCarros);
        adicionarCarros.start();
    }

    public void aguardar(){
        this.adicionarCarros.setExecutando(false);
    }

    public void encerrar(){
        desenharMalhaViaria.setEmExecucao(false);
        this.malhaViaria.paraExecucao();
        this.adicionarCarros.setExecutando(false);
    }
}
