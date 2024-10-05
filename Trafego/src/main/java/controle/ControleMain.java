package controle;

import java.io.IOException;
import modelo.MalhaViaria;
import visao.Tela;

public class ControleMain {
    
    private Tela view;
    private MalhaViaria malhaViaria;
    ControleMalha desenharMalhaViaria;
    
    public void setView(Tela view) {
        this.view = view;
        this.malhaViaria = new MalhaViaria();
    }
    
    public void criarMalhaViaria(String path) throws IOException{
        this.malhaViaria.identificarSegmentos( this.malhaViaria.lerDocumento(path));        
    }
    
    public void iniciarMonitor(int tempo, int numCarros){
        ControleMalha desenharMalhaViaria = new ControleMalha(this.malhaViaria, this.view.getTextArea());
        desenharMalhaViaria.start();
    }
    
    public void iniciarSemaforo(int tempo, int numCarros){
        this.desenharMalhaViaria = new ControleMalha(this.malhaViaria, this.view.getTextArea());
        desenharMalhaViaria.start();
    }
    
    public void aguardar(){
    }
    
    public void encerrar(){
        desenharMalhaViaria.setEmExecucao(false);
    }
}
