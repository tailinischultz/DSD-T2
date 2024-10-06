package controle;

import modelo.Carro;
import modelo.MalhaViaria;
import modelo.Segmento;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class ControleCarros extends Thread {

    private boolean executando;
    private MalhaViaria malha;
    private int tempoMiliseg;
    private ArrayList<Segmento> listSegmentosEntrada;
    private int qtdTotalCarros;
    private Semaphore semaforoMaster;
    private boolean usaSemaforo;


    private String getIdCarro(int numChar) {
        char id = (char) (65 + numChar);
        return id + "";
    }

    public void setQtdTotalCarros(int qtdTotalCarros) {
        this.qtdTotalCarros = qtdTotalCarros;
    }

    public void setTempoMiliseg(int tempoMiliseg) {
        this.tempoMiliseg = tempoMiliseg;
    }
    private void setSegmentoEntradaTopoBaixo() {
        Segmento[][] matrizSegmentos = this.malha.getListaSegmentos();
        for (int idxColuna = 0; idxColuna < matrizSegmentos[0].length; idxColuna++) {
            Segmento segmentoAtualTopo = matrizSegmentos[0][idxColuna];
            Segmento segmentoAtualBaixo = matrizSegmentos[matrizSegmentos.length - 1][idxColuna];
        }
    }

    private void setNodosEntradaDireitaEsquerda() {
        Segmento[][] matrizSegmentos = this.malha.getListaSegmentos();
        int colunaBordaDireita = (matrizSegmentos[0].length - 1);
        for (int idxLinha = 0; idxLinha < matrizSegmentos.length; idxLinha++) {
            Segmento segmentoAtualDireita = matrizSegmentos[idxLinha][colunaBordaDireita];
            Segmento segmentoAtualEsquerda = matrizSegmentos[idxLinha][0];

        }
    }

    @Override
    public void run() {
        Random random = new Random();
        boolean validaQtdCarros = this.qtdTotalCarros > 0;
        int contCarros = 0;
        int idxListNodosEntrada = 0;
        Carro carro;
        Segmento segmento;

        while (this.executando) {

            if (idxListNodosEntrada > this.listNodosEntrada.size() -1) {
                idxListNodosEntrada = 0;
            }

            segmento = this.listNodosEntrada.get(idxListNodosEntrada);

            if (segmento.getCarro() != null) {
                idxListNodosEntrada++;
                if (idxListNodosEntrada == this.listNodosEntrada.size() - 1) {
                    idxListNodosEntrada = 0;
                }
                continue;
            }
            if (usaSemaforo) {
                carro = new CarroSemaforo(this.getIdCarro(random.nextInt(26)), this.semaforoMaster);
            }
            else {
                carro = new CarroMonitor(this.getIdCarro(random.nextInt(26)));
            }
            segmento.setCarro(carro);
            carro.setNodoAtual(segmento);
            carro.start();

            if (validaQtdCarros) {
                contCarros++;
                if (contCarros >= this.qtdTotalCarros) {
                    this.emExecucao = false;
                }
            }
            if (idxListNodosEntrada == this.listNodosEntrada.size() - 1) {
                idxListNodosEntrada = 0;
            }
            else {
                idxListNodosEntrada++;
            }

            try {
                this.sleep(this.tempoMiliseg);
            }
            catch (InterruptedException ex) {}
        }

    }


}
