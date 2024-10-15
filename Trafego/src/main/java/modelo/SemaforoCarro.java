package modelo;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class SemaforoCarro extends Carro {

    private Semaphore semaforo;

    public SemaforoCarro(MalhaViaria malhaViaria, Semaphore semaforo) {
        super.setEmCruzamento(false);
        this.semaforo = semaforo;
        super.setMalhaViaria(malhaViaria);
    }

    private void andar(Segmento proxSegmento) {
        try {
            this.semaforo.acquire();
        } catch (InterruptedException ex) {
            System.out.println("Thread interrompida. Abortando método run()");
        }
        if (proxSegmento.getCarro() != null) {
            this.semaforo.release();
        } else {
            super.getSegmentoAtual().setCarro(null);
            super.setSegmentoAtual(proxSegmento);
            super.getSegmentoAtual().setCarro(this);
            this.semaforo.release();
        }
    }

    private void reservarCaminho() {
        try {
            this.semaforo.acquire();
        }
        catch (InterruptedException ex) {}
        
                for (Segmento seg : super.getCaminhoCruzamento()) {
            if (seg.getReserva() != null) {
                this.semaforo.release();
                return;
            }
        }

        for (Segmento seg : super.getCaminhoCruzamento()) {
            seg.setReserva(this);
        }
        this.semaforo.release();
    }

    private void andarNoCruzamento() {
        for (Segmento seg : super.getCaminhoCruzamento()) {
            this.andar(seg);
            seg.setReserva(null);
            super.getCaminhoCruzamento().remove(seg);
            break;
        }

        if (super.getCaminhoCruzamento().isEmpty()) {
            super.setEmCruzamento(false);
        }
    }

    @Override
    public void run() {
        Random r = new Random();
        Segmento proximoNodo = null;
        while (super.getSegmentoAtual().getMalhaViaria().estaEmExecucao() && !super.getSegmentoAtual().isSaida()) {
            
            if (super.isEmCruzamento()) {
                
                if (this.cruzamentoLivre()) {
                    if (this.temCaminhoReservado()) {
                        this.andarNoCruzamento();
                    } else {
                        this.reservarCaminho();
                        if (this.temCaminhoReservado()) {
                            this.andarNoCruzamento();
                        }
                    }
                } else {
                    this.escolherCaminhoCruzamento(proximoNodo);
                    this.reservarCaminho();
                    if (this.temCaminhoReservado()) {
                        this.andarNoCruzamento();
                    }
                }
                
            } else {
                
                proximoNodo = super.getProximoSegmento();
                if (proximoNodo.isCruzamento()) {
                    super.setEmCruzamento(true);
                } else {
                    this.andar(proximoNodo);
                }
                
            }
            
            try {
                SemaforoCarro.sleep(r.nextInt(500)+2000);
            } catch (InterruptedException e) {
            }
            
        }
        
        super.getSegmentoAtual().setCarro(null);
        super.getMalhaViaria().diminuirCarroCirculando();
    }

}
