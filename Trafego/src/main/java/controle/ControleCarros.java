package controle;

import java.util.concurrent.Semaphore;
import modelo.*;

public class ControleCarros extends Thread {

    private boolean executando;
    private MalhaViaria malha;
    private int tempo;
    private int qtdCarros;
    private boolean usaSemaforo;
    private Semaphore semaforo;


    public ControleCarros(MalhaViaria malha, boolean usaSemaforo, int tempo, int qtdCarros) {
        this.executando = true;
        this.malha = malha;
        this.tempo = tempo;
        this.qtdCarros = qtdCarros;
        this.usaSemaforo = usaSemaforo;
        this.semaforo = new Semaphore(1);
    }

    public void setExecutando(boolean executando) {
        this.executando = executando;
    }

    @Override
    public void run() {
        int idxListNodosEntrada = 0;
        Carro carro;
        Segmento segmento;

        while (this.executando) {

            segmento = malha.getSegmentosEntrada().get(idxListNodosEntrada);
            if (segmento.getCarro() == null && this.malha.getQtdCarrosCirculando() < this.qtdCarros) {

                carro = usaSemaforo ? new SemaforoCarro(this.malha, this.semaforo) : new MonitorCarro(this.malha);

                this.malha.adicionarCarroCirculando();
                segmento.setCarro(carro);
                carro.setSegmentoAtual(segmento);
                carro.start();
            }

            idxListNodosEntrada++;

            if (idxListNodosEntrada >= malha.getSegmentosEntrada().size()) {
                idxListNodosEntrada = 0;
            }

            try {
                ControleCarros.sleep(this.tempo);
            } catch (InterruptedException ex) {
            }
        }
    }

}
