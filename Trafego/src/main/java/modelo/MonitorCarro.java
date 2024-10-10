package modelo;

import java.util.Random;

public class MonitorCarro extends Carro {

    private Segmento segmentoAtual;
    private boolean emCruzamento;
    private Segmento[] caminhoACruzar;
    private final MalhaViaria malhaViaria;

    public MonitorCarro(MalhaViaria malhaViaria) {
        this.emCruzamento = false;
        this.caminhoACruzar = new Segmento[4];
        this.malhaViaria = malhaViaria;
    }

    public Segmento getSegmentoAtual() {
        return segmentoAtual;
    }

    @Override
    public void setSegmentoAtual(Segmento segmentoAtual) {
        this.segmentoAtual=segmentoAtual;
    }
    
    private synchronized void andar(Segmento segmentoAIr){
        if(segmentoAIr.getCarro() == null){
            this.segmentoAtual.setCarro(null);
            this.segmentoAtual = segmentoAIr;
            this.segmentoAtual.setCarro(this);
        }
    }
    
    private Segmento getProxNodoNormal() {
        Segmento proximoSegmento = null;
        Segmento a = null;
        Segmento b = null;
        switch (this.segmentoAtual.getDirecao()) {
            case "Estrada_Cima":
                proximoSegmento = this.malhaViaria.getProxSegmentoCima(this.segmentoAtual);
                break;
            case "Estrada_Direita":
                proximoSegmento = this.malhaViaria.getProxSegmentoDireita(this.segmentoAtual);
                break;
            case "Estrada_Baixo":
                proximoSegmento = this.malhaViaria.getProxSegmentoBaixo(this.segmentoAtual);
                break;
            case "Estrada_Esquerda":
                proximoSegmento = this.malhaViaria.getProxSegmentoEsquerda(this.segmentoAtual);
                break;
            case "Cruzamento_Cima":
                proximoSegmento = this.malhaViaria.getProxSegmentoCima(this.segmentoAtual);
                break;
            case "Cruzamento_Direita":
                proximoSegmento = this.malhaViaria.getProxSegmentoDireita(this.segmentoAtual);
                break;
            case "Cruzamento_Baixo":
                proximoSegmento = this.malhaViaria.getProxSegmentoBaixo(this.segmentoAtual);
                break;
            case "Cruzamento_Esquerda":
                proximoSegmento = this.malhaViaria.getProxSegmentoEsquerda(this.segmentoAtual);
                break;
            case "Cruzamento_Baixo_Direita":
                a = this.malhaViaria.getProxSegmentoBaixo(this.segmentoAtual);
                b = this.malhaViaria.getProxSegmentoDireita(this.segmentoAtual);

                proximoSegmento = a.isCruzamento() ? b : a;

                break;
            case "Cruzamento_Baixo_Esquerda":
                a = this.malhaViaria.getProxSegmentoBaixo(this.segmentoAtual);
                b = this.malhaViaria.getProxSegmentoEsquerda(this.segmentoAtual);

                proximoSegmento = a.isCruzamento() ? b : a;

                break;
            case "Cruzamento_Cima_Direita":
                a = this.malhaViaria.getProxSegmentoCima(this.segmentoAtual);
                b = this.malhaViaria.getProxSegmentoDireita(this.segmentoAtual);

                proximoSegmento = a.isCruzamento() ? b : a;

                break;
            case "Cruzamento_Cima_Esquerda":
                a = this.malhaViaria.getProxSegmentoCima(this.segmentoAtual);
                b = this.malhaViaria.getProxSegmentoEsquerda(this.segmentoAtual);

                proximoSegmento = a.isCruzamento() ? b : a;

                break;
        }
        return proximoSegmento;
    }
    private Segmento getProximoSegmentoCruzamento(Segmento segmentoDeReferencia, boolean forcaSairCruzamento, Segmento segmentoRefAnterior, Segmento[] listaCaminho, int idxSegmentoAtual) {
        Segmento proximoSegmento = null;
        Segmento a = null;
        Segmento b = null;
        Random random = new Random();
        boolean par = random.nextInt(500) % 2 == 0;

        switch (segmentoDeReferencia.getDirecao()) {
            case "Cruzamento_Cima":
                if (forcaSairCruzamento) {
                    proximoSegmento = this.getProximoSegmentoCruzamento(segmentoRefAnterior, true, null, null, 0);
                    listaCaminho[idxSegmentoAtual] = null;
                }
                else {
                    proximoSegmento = this.malhaViaria.getProxSegmentoCima(segmentoDeReferencia);
                }
                break;
            case "Cruzamento_Direita":
                if (forcaSairCruzamento) {
                    proximoSegmento = this.getProximoSegmentoCruzamento(segmentoRefAnterior, true, null, null, 0);
                    listaCaminho[idxSegmentoAtual] = null;
                }
                else {
                    proximoSegmento = this.malhaViaria.getProxSegmentoDireita(segmentoDeReferencia);
                }
                break;
            case "Cruzamento_Baixo":
                if (forcaSairCruzamento) {
                    proximoSegmento = this.getProximoSegmentoCruzamento(segmentoRefAnterior, true, null, null, 0);
                    listaCaminho[idxSegmentoAtual] = null;
                }
                else {
                    proximoSegmento = this.malhaViaria.getProxSegmentoBaixo(segmentoDeReferencia);
                }
                break;
            case "Cruzamento_Esquerda":
                if (forcaSairCruzamento) {
                    proximoSegmento = this.getProximoSegmentoCruzamento(segmentoRefAnterior, true, null, null, 0);
                    listaCaminho[idxSegmentoAtual] = null;
                }
                else {
                    proximoSegmento = this.malhaViaria.getProxSegmentoEsquerda(segmentoDeReferencia);
                }
                break;
            case "Cruzamento_Baixo_Direita":
                a = this.malhaViaria.getProxSegmentoBaixo(segmentoDeReferencia);
                b = this.malhaViaria.getProxSegmentoDireita(segmentoDeReferencia);
                if (forcaSairCruzamento) {
                    proximoSegmento = a.isCruzamento() ? b : a;
                }
                else {
                    proximoSegmento = par ? a : b;
                }
                break;
            case "Cruzamento_Baixo_Esquerda":
                a = this.malhaViaria.getProxSegmentoBaixo(segmentoDeReferencia);
                b = this.malhaViaria.getProxSegmentoEsquerda(segmentoDeReferencia);
                if (forcaSairCruzamento) {
                    proximoSegmento = a.isCruzamento() ? b : a;
                }
                else {
                    proximoSegmento = par ? a : b;
                }
                break;
            case "Cruzamento_Cima_Direita":
                a = this.malhaViaria.getProxSegmentoCima(segmentoDeReferencia);
                b = this.malhaViaria.getProxSegmentoDireita(segmentoDeReferencia);
                if (forcaSairCruzamento) {
                    proximoSegmento = a.isCruzamento() ? b : a;
                }
                else {
                    proximoSegmento = par ? a : b;
                }
                break;
            case "Cruzamento_Cima_Esquerda":
                a = this.malhaViaria.getProxSegmentoCima(segmentoDeReferencia);
                b = this.malhaViaria.getProxSegmentoEsquerda(segmentoDeReferencia);
                if (forcaSairCruzamento) {
                    proximoSegmento = a.isCruzamento() ? b : a;
                }
                else {
                    proximoSegmento = par ? a : b;
                }
                break;
        }

        return proximoSegmento;
    }
    private boolean temCaminhoDefinido() {
        boolean encontrouCaminho = false;
        for (Segmento segmento : caminhoACruzar) {
            if (segmento != null) {
                encontrouCaminho = true;
            }
        }
        return encontrouCaminho;
    }

    private void escolherCaminhoCruzamento(Segmento segmentoIniCruzamento) {
        this.caminhoACruzar[0] = segmentoIniCruzamento;
        Segmento armazenaPassoAnterior = null;
        for (int i = 1; i <= 3; i++) {
            Segmento prox = this.getProximoSegmentoCruzamento(this.caminhoACruzar[(i - 1)], (i == 3), armazenaPassoAnterior, this.caminhoACruzar, (i - 1));
            this.caminhoACruzar[i] = prox;
            armazenaPassoAnterior = this.caminhoACruzar[(i - 1)];
            if (!prox.isCruzamento()) {
                break;
            }
        }

        Segmento[] caminhoCruzamentoAux = new Segmento[4];
        int contIdxAtual = 0;
        for (Segmento segmento : caminhoACruzar) {
            if (segmento != null) {
                caminhoCruzamentoAux[contIdxAtual] = segmento;
                contIdxAtual++;
            }
        }
        this.caminhoACruzar = caminhoCruzamentoAux;
    }

    private synchronized void tentaReservarCaminhoCruzamento() {
        boolean livre = true;
        for (Segmento segmento : caminhoACruzar) {
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

        for (Segmento segmento :caminhoACruzar) {
            if (segmento == null) {
                break;
            }
            segmento.setReserva(this);
        }
    }

    private boolean temCaminhoReservado() {
        for (Segmento segmento : caminhoACruzar) {
            if (segmento != null) {
                if (segmento.getReserva() == this) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        return false;
    }

    private void andarNoCruzamento() {
        for (int i = 0; i < this.caminhoACruzar.length; i++) {
            Segmento segmento = this.caminhoACruzar[i];
            if (segmento != null) {
                this.andar(segmento);
                segmento.setReserva(null);
                this.caminhoACruzar[i] = null;
                break;
            }
        }
        boolean andouTudo = true;
        for (int i = 0; i < this.caminhoACruzar.length; i++) {
            if (this.caminhoACruzar[i] != null) {
                andouTudo = false;
                break;
            }
        }
        if (andouTudo) {
            this.emCruzamento = false;
        }
    }
    
    @Override
    public void run() {
        Segmento proximoSegmento = null;
        while (this.segmentoAtual.getMalhaViaria().estaEmExecucao() && !this.segmentoAtual.isSaida()) {
            if (this.emCruzamento) {
                if (this.temCaminhoDefinido()) {
                if (this.temCaminhoReservado()) {
                    this.andarNoCruzamento();
                }
                else {
                    this.tentaReservarCaminhoCruzamento();
                    if (this.temCaminhoReservado()) {
                        this.andarNoCruzamento();
                    }
                 }
                }
                 else {
                     this.escolherCaminhoCruzamento(proximoSegmento);
                     this.tentaReservarCaminhoCruzamento();
                    if (this.temCaminhoReservado()) {
                 this.andarNoCruzamento();
                 }
                 }
            } else {
                proximoSegmento = this.getProxNodoNormal();
                if (proximoSegmento.isCruzamento()) {
                    this.emCruzamento = true;
                } else if (proximoSegmento.getCarro() == null) {
                    this.andar(proximoSegmento);
                }
            }
            try {
                MonitorCarro.sleep(500);
            } catch (InterruptedException e) {
            }
        }
            this.segmentoAtual.setCarro(null);
    }
}
