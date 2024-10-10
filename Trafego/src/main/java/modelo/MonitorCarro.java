package modelo;

public class MonitorCarro extends Carro {

    public MonitorCarro(MalhaViaria malhaViaria) {
        super.setEmCruzamento(false);
        super.setCaminhoCruzamento(new Segmento[4]);
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
        boolean livre = true;
        for (Segmento segmento : super.getCaminhoCruzamento()) {
            if (segmento == null) {
                break;
            }
            if (segmento.getReserva() != null) {
                livre = false;
                break;
            }
        }

        if (!livre) {
            return;
        }

        for (Segmento segmento : super.getCaminhoCruzamento()) {
            if (segmento == null) {
                break;
            }
            segmento.setReserva(this);
        }
    }

    private void andarNoCruzamento() {
        for (int i = 0; i < super.getCaminhoCruzamento().length; i++) {
            Segmento segmento = super.getCaminhoCruzamento()[i];
            if (segmento != null) {
                this.andar(segmento);
                segmento.setReserva(null);
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
        Segmento proximoSegmento = null;
        while (super.getSegmentoAtual().getMalhaViaria().estaEmExecucao() && !super.getSegmentoAtual().isSaida()) {
            if (super.isEmCruzamento()) {
                if (super.temCaminhoDefinido()) {
                if (super.temCaminhoReservado()) {
                    this.andarNoCruzamento();
                }
                else {
                    this.reservarCaminho();
                    if (super.temCaminhoReservado()) {
                        this.andarNoCruzamento();
                    }
                 }
                }
                 else {
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
                } else if (proximoSegmento.getCarro() == null) {
                    this.andar(proximoSegmento);
                }
            }
            try {
                MonitorCarro.sleep(500);
            } catch (InterruptedException e) {
            }
        }
            super.getSegmentoAtual().setCarro(null);
    }
}
