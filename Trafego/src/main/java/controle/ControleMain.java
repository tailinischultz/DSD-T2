package controle;

import java.io.IOException;
import modelo.MalhaViaria;
import visao.Tela;

public class ControleMain {
    
    private Tela view;
    private MalhaViaria malhaViaria;
    
    public void setView(Tela view) {
        this.view = view;
    }
    
    public void criarMalhaViaria(String path) throws IOException{
        MalhaViaria novaMalha = new MalhaViaria();
        
        int segmentos[][] = novaMalha.lerDocumento(path);
        
        for (int i = 0; i < segmentos.length; i++){
            for (int j = 0; j < segmentos[0].length; j++){
                System.out.print(segmentos[i][j] + " ");
            }
            System.out.println("");
        }
        
    }
}
