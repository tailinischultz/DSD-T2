package modelo;

import java.util.concurrent.Semaphore;

public class SemaforoCarro extends Carro {

    private final Semaphore semaforo;

    public SemaforoCarro(MalhaViaria malhaViaria) {
        super.setEmCruzamento(false);
        super.setCaminhoCruzamento(new Segmento[4]);
        this.semaforo = new Semaphore(1);
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
        
        boolean livre = true;
        for (Segmento seg : super.getCaminhoCruzamento()) {
            if (seg == null) {
                break;
            }
            if (seg.getReserva() != null) {
                livre = false;
                break;
            }
        }

        if (!livre) {
            this.semaforo.release();
            return;
        }

        for (Segmento seg : super.getCaminhoCruzamento()) {
            if (seg == null) {
                break;
            }
            seg.setReserva(this);
        }
        this.semaforo.release();
    }

    private void andarNoCruzamento() {
        for (int i = 0; i < super.getCaminhoCruzamento().length; i++) {
            Segmento nodo = super.getCaminhoCruzamento()[i];
            if (nodo != null) {
                this.andar(nodo);
                nodo.setReserva(null);
                super.getCaminhoCruzamento()[i] = null;
                break;
            }
        }
        boolean andouTudo = true;
        for (int i = 0; i < super.getCaminhoCruzamento().length; i++) {
            if (super.getCaminhoCruzamento()[i] != null) {
                andouTudo = false;
                break;
            }
        }
        if (andouTudo) {
            super.setEmCruzamento(false);
        }
    }

    @Override
    public void run() {
        Segmento proximoNodo = null;
        while (super.getSegmentoAtual().getMalhaViaria().estaEmExecucao() && !super.getSegmentoAtual().isSaida()) {
            
            if (super.isEmCruzamento()) {
                
                if (this.temCaminhoDefinido()) {
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
                    if (proximoNodo.getCarro() == null) {
                        this.andar(proximoNodo);
                    }
                }
                
            }
            
            
            try {
                SemaforoCarro.sleep(500);
            } catch (InterruptedException e) {
            }
            
        }
        
        super.getSegmentoAtual().setCarro(null);
    }

}
