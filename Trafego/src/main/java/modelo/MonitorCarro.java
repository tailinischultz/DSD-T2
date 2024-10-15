package modelo;

import java.util.Random;

public class MonitorCarro extends Carro {

    public MonitorCarro(MalhaViaria malhaViaria) {
        super.setEmCruzamento(false);
        super.setMalhaViaria(malhaViaria);
    }
    
    private synchronized void andar(Segmento proxSegmento){
        if(proxSegmento.getCarro() == null){
            super.getSegmentoAtual().setCarro(null);
            super.setSegmentoAtual(proxSegmento);
            super.getSegmentoAtual().setCarro(this);
        }
    }

    private synchronized void reservarCaminho() {
        for (Segmento segmento : super.getCaminhoCruzamento()) {
            if (segmento.getReserva() != null) {    
                return;
            }
        }

        for (Segmento segmento : super.getCaminhoCruzamento()) {
            segmento.setReserva(this);
        }
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
        Segmento proximoSegmento = null;
        while (super.getSegmentoAtual().getMalhaViaria().estaEmExecucao() && !super.getSegmentoAtual().isSaida()) {
            if (super.isEmCruzamento()) {
                if (super.cruzamentoLivre()) {
                    if (super.temCaminhoReservado()) {
                        this.andarNoCruzamento();
                    } else {
                        this.reservarCaminho();
                        if (super.temCaminhoReservado()) {
                            this.andarNoCruzamento();
                        }
                    }
                } else {
                    super.escolherCaminhoCruzamento(proximoSegmento);
                    this.reservarCaminho();
                    if (super.temCaminhoReservado()) {
                        this.andarNoCruzamento();
                    }
                }
            } else {
                proximoSegmento = super.getProximoSegmento();
                if (proximoSegmento.isCruzamento()) {
                    super.setEmCruzamento(true);
                } else {
                    this.andar(proximoSegmento);
                }
            }
            try {
                MonitorCarro.sleep(r.nextInt(500) + 2000);
            } catch (InterruptedException e) {
            }
        }
        super.getSegmentoAtual().setCarro(null);
        super.getMalhaViaria().diminuirCarroCirculando();
    }
}
