package controle;

import modelo.*;

import java.util.Random;

public class ControleCarros extends Thread {

    private boolean executando;
    private MalhaViaria malha;
    private int tempo;
    private int qtdCarros;
    private boolean usaSemaforo;

    public ControleCarros(MalhaViaria malha, boolean usaSemaforo, int tempo, int qtdCarros) {
        this.executando = true;
        this.malha = malha;
        this.tempo = tempo;
        this.qtdCarros = qtdCarros;
        this.usaSemaforo = usaSemaforo;
    }
    private String getIdCarro(int numChar) {
        char id = (char) (65 + numChar);
        return id + "";
    }

    @Override
    public void run() {
        Random random = new Random();
        boolean validaQtdCarros = this.qtdCarros > 0;
        int contCarros = 0;
        int idxListNodosEntrada = 0;
        Carro carro;
        Segmento segmento;

        while (this.executando) {

            if (idxListNodosEntrada > (malha.getSegmentosEntrada().size()-1)) {
                idxListNodosEntrada = 0;
            }

            segmento = malha.getSegmentosEntrada().get(idxListNodosEntrada);

            if (segmento.getCarro() != null) {
                idxListNodosEntrada++;
                if (idxListNodosEntrada == malha.getSegmentosEntrada().size() - 1) {
                    idxListNodosEntrada = 0;
                }
                continue;
            }
            if (usaSemaforo) {
                carro = new SemaforoCarro();
            }
            else {
                carro = new MonitorCarro();
            }

            segmento.setCarro(carro);
            carro.setSegmentoAtual(segmento);
            carro.start();

            if (validaQtdCarros) {
                contCarros++;
                if (contCarros >= this.qtdCarros) {
                    this.executando = false;
                }
            }
            if (idxListNodosEntrada == malha.getSegmentosEntrada().size() - 1) {
                idxListNodosEntrada = 0;
            }
            else {
                idxListNodosEntrada++;
            }

            try {
                this.sleep(this.tempo);
            }
            catch (InterruptedException ex) {}
        }

    }


}
