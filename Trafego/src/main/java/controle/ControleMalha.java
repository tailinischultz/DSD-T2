package controle;

import javax.swing.JTextArea;
import modelo.MalhaViaria;
import modelo.Segmento;

public class ControleMalha extends Thread {

    private MalhaViaria malhaViaria;
    private boolean emExecucao;
    private JTextArea jTextArea;

    public ControleMalha(MalhaViaria malhaViaria, JTextArea jTextArea) {
        this.malhaViaria = malhaViaria;
        this.jTextArea = jTextArea;
        this.emExecucao = true;
    }

    public void setEmExecucao(boolean emExecucao) {
        this.emExecucao = emExecucao;
    }

    @Override
    public void run() {
        String malhaPrint = "";
        while (this.emExecucao) {
            malhaPrint = "";
            for (int i = 0; i < this.malhaViaria.getListaSegmentos().length; i++) {
                for (int j = 0; j < this.malhaViaria.getListaSegmentos()[0].length; j++) {
                    Segmento segmento = this.malhaViaria.getListaSegmentos()[i][j];
                    if (segmento.getDirecao() == null) {
                        malhaPrint += segmento.getCaracter() + " ";
                    }
                    else {
                        malhaPrint += (segmento.getCarro() != null ? segmento.getCarro().getNome() : segmento.getCaracter());
                        malhaPrint += " ";
                    }

                }
                malhaPrint += "\n";
            }

            this.jTextArea.setText(malhaPrint);
            try {
                this.sleep(50);
            }
            catch (InterruptedException ex) {
            }
        }
    }

}
