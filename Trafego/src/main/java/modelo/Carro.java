package modelo;

import java.util.Random;

public abstract class Carro extends Thread {

    private final String nome = "🚘";
    private Segmento segmentoAtual;
    private MalhaViaria malhaViaria;
    private boolean emCruzamento;
    private Segmento[] caminhoCruzamento;

    public Segmento getProximoSegmento() {
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

    public Segmento getProximoSegmentoCruzamento(Segmento segmentoDeReferencia, boolean forcaSairCruzamento, Segmento segmentoRefAnterior, Segmento[] listaCaminho, int idxSegmentoAtual) {
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
                } else {
                    proximoSegmento = this.malhaViaria.getProxSegmentoCima(segmentoDeReferencia);
                }
                break;
            case "Cruzamento_Direita":
                if (forcaSairCruzamento) {
                    proximoSegmento = this.getProximoSegmentoCruzamento(segmentoRefAnterior, true, null, null, 0);
                    listaCaminho[idxSegmentoAtual] = null;
                } else {
                    proximoSegmento = this.malhaViaria.getProxSegmentoDireita(segmentoDeReferencia);
                }
                break;
            case "Cruzamento_Baixo":
                if (forcaSairCruzamento) {
                    proximoSegmento = this.getProximoSegmentoCruzamento(segmentoRefAnterior, true, null, null, 0);
                    listaCaminho[idxSegmentoAtual] = null;
                } else {
                    proximoSegmento = this.malhaViaria.getProxSegmentoBaixo(segmentoDeReferencia);
                }
                break;
            case "Cruzamento_Esquerda":
                if (forcaSairCruzamento) {
                    proximoSegmento = this.getProximoSegmentoCruzamento(segmentoRefAnterior, true, null, null, 0);
                    listaCaminho[idxSegmentoAtual] = null;
                } else {
                    proximoSegmento = this.malhaViaria.getProxSegmentoEsquerda(segmentoDeReferencia);
                }
                break;
            case "Cruzamento_Baixo_Direita":
                a = this.malhaViaria.getProxSegmentoBaixo(segmentoDeReferencia);
                b = this.malhaViaria.getProxSegmentoDireita(segmentoDeReferencia);
                if (forcaSairCruzamento) {
                    proximoSegmento = a.isCruzamento() ? b : a;
                } else {
                    proximoSegmento = par ? a : b;
                }
                break;
            case "Cruzamento_Baixo_Esquerda":
                a = this.malhaViaria.getProxSegmentoBaixo(segmentoDeReferencia);
                b = this.malhaViaria.getProxSegmentoEsquerda(segmentoDeReferencia);
                if (forcaSairCruzamento) {
                    proximoSegmento = a.isCruzamento() ? b : a;
                } else {
                    proximoSegmento = par ? a : b;
                }
                break;
            case "Cruzamento_Cima_Direita":
                a = this.malhaViaria.getProxSegmentoCima(segmentoDeReferencia);
                b = this.malhaViaria.getProxSegmentoDireita(segmentoDeReferencia);
                if (forcaSairCruzamento) {
                    proximoSegmento = a.isCruzamento() ? b : a;
                } else {
                    proximoSegmento = par ? a : b;
                }
                break;
            case "Cruzamento_Cima_Esquerda":
                a = this.malhaViaria.getProxSegmentoCima(segmentoDeReferencia);
                b = this.malhaViaria.getProxSegmentoEsquerda(segmentoDeReferencia);
                if (forcaSairCruzamento) {
                    proximoSegmento = a.isCruzamento() ? b : a;
                } else {
                    proximoSegmento = par ? a : b;
                }
                break;
        }

        return proximoSegmento;
    }

    public boolean temCaminhoDefinido() {
        boolean encontrouCaminho = false;
        for (Segmento segmento : caminhoCruzamento) {
            if (segmento != null) {
                encontrouCaminho = true;
            }
        }
        return encontrouCaminho;
    }

    public void escolherCaminhoCruzamento(Segmento nodoIniCruzamento) {
        this.caminhoCruzamento[0] = nodoIniCruzamento;
        Segmento viagemNoTempo = null;
        for (int i = 1; i <= 3; i++) {
            Segmento prox = this.getProximoSegmentoCruzamento(this.caminhoCruzamento[(i - 1)], (i == 3), viagemNoTempo, this.caminhoCruzamento, (i - 1));
            this.caminhoCruzamento[i] = prox;
            viagemNoTempo = this.caminhoCruzamento[(i - 1)];
            if (!prox.isCruzamento()) {
                break;
            }
        }

        Segmento[] caminhoCruzamentoAux = new Segmento[4];
        int contIdxAtual = 0;
        for (Segmento nodo : this.caminhoCruzamento) {
            if (nodo != null) {
                caminhoCruzamentoAux[contIdxAtual] = nodo;
                contIdxAtual++;
            }
        }
        this.caminhoCruzamento = caminhoCruzamentoAux;
    }

    public boolean temCaminhoReservado() {
        for (Segmento segmento : this.caminhoCruzamento) {
            if (segmento != null) {
                return segmento.getReserva() == this;
            }
        }
        return false;
    }
    

    public String getNome() {
        return nome;
    }

    public Segmento getSegmentoAtual() {
        return segmentoAtual;
    }

    public void setSegmentoAtual(Segmento segmento) {
        this.segmentoAtual = segmento;
    }

    public MalhaViaria getMalhaViaria() {
        return malhaViaria;
    }

    public void setMalhaViaria(MalhaViaria malhaViaria) {
        this.malhaViaria = malhaViaria;
    }

    public boolean isEmCruzamento() {
        return emCruzamento;
    }

    public void setEmCruzamento(boolean emCruzamento) {
        this.emCruzamento = emCruzamento;
    }

    public Segmento[] getCaminhoCruzamento() {
        return caminhoCruzamento;
    }

    public void setCaminhoCruzamento(Segmento[] caminhoCruzamento) {
        this.caminhoCruzamento = caminhoCruzamento;
    }

}
