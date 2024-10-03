package controle;

import java.io.IOException;
import modelo.MalhaViaria;
import modelo.Segmento;
import visao.Tela;

public class ControleMain {
    
    private Tela view;
    private MalhaViaria malhaViaria;
    
    public ControleMain(){
        this.malhaViaria = new MalhaViaria();
    }
    
    public void setView(Tela view) {
        this.view = view;
    }
    
    public void criarMalhaViaria(String path) throws IOException{
        this.malhaViaria.identificarSegmentos( this.malhaViaria.lerDocumento(path));
    }
    
    public void desenharMalhaViaria(int tempo){
        String malhaPrint = "";
        Segmento[][] segmentosMalha = malhaViaria.getListaSegmentos();
        while (true) { //Ajustar
            malhaPrint = "";
            for (int i = 0; i < segmentosMalha.length; i++) {
                for (int j = 0; j < segmentosMalha[i].length; j++) {
                    Segmento segmento = segmentosMalha[i][j];
                    if (segmento == null) {
                        malhaPrint += " ";
                    }
                    else {
                        malhaPrint += (segmento.getCarro() != null ? segmento.getCarro().getNome() : segmento.getCaracter());
                        malhaPrint += " ";
                    }

                }
                malhaPrint += "\n";
            }

            this.view.getTextArea().setText(malhaPrint);
        }
    }
    
    public void iniciarMonitor(int tempo, int numCarros){
        //this.desenharMalhaViaria(tempo);
        
    }
    
    public void iniciarSemaforo(int tempo, int numCarros){
        //this.desenharMalhaViaria(tempo);

    }
    
    public void aguardar(){
        
    }
    
    public void encerrar(){
        
    }
}
