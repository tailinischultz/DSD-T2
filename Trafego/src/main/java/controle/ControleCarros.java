package controle;

import modelo.*;

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

    public void setExecutando(boolean executando) {
        this.executando = executando;
    }

    @Override
    public void run() {
        int contCarros = 0;
        int idxListNodosEntrada = 0;
        Carro carro;
        Segmento segmento;

        while (this.executando) {
            
            segmento = malha.getSegmentosEntrada().get(idxListNodosEntrada);
            idxListNodosEntrada++;

            if (segmento.getCarro() == null) {

                if (usaSemaforo) {
                    carro = new SemaforoCarro(this.malha);
                } else {
                    carro = new MonitorCarro(this.malha);
                }

                segmento.setCarro(carro);
                carro.setSegmentoAtual(segmento);
                carro.start();

                contCarros++;
                if (contCarros >= this.qtdCarros) {
                    this.executando = false;
                }
            }
            
            if (idxListNodosEntrada >= malha.getSegmentosEntrada().size() - 1) {
                idxListNodosEntrada = 0;
            }
            
            try {
                ControleCarros.sleep(this.tempo);
            } catch (InterruptedException ex) {
            }
        }

    }

}
