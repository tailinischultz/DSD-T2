package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Carro extends Thread {

    private final String nome = "🚘";
    private Segmento segmentoAtual;
    private MalhaViaria malhaViaria;
    private boolean emCruzamento;
    private List<Segmento> caminhoCruzamento;
    
    public Carro (){
        this.caminhoCruzamento = new ArrayList<Segmento>();
    }

    public Segmento getProximoSegmento() {
        switch (this.segmentoAtual.getDirecao()) {
            case "Estrada_Cima":
                return this.malhaViaria.getProxSegmentoCima(this.segmentoAtual);
            case "Estrada_Direita":
                return this.malhaViaria.getProxSegmentoDireita(this.segmentoAtual);
            case "Estrada_Baixo":
                return this.malhaViaria.getProxSegmentoBaixo(this.segmentoAtual);
            case "Estrada_Esquerda":
                return this.malhaViaria.getProxSegmentoEsquerda(this.segmentoAtual);
            case "Cruzamento_Cima":
                return this.malhaViaria.getProxSegmentoCima(this.segmentoAtual);
            case "Cruzamento_Direita":
                return this.malhaViaria.getProxSegmentoDireita(this.segmentoAtual);
            case "Cruzamento_Baixo":
                return this.malhaViaria.getProxSegmentoBaixo(this.segmentoAtual);
            case "Cruzamento_Esquerda":
                return this.malhaViaria.getProxSegmentoEsquerda(this.segmentoAtual);
            case "Cruzamento_Baixo_Direita":
                return this.malhaViaria.getProxSegmentoBaixo(this.segmentoAtual).isCruzamento() ? this.malhaViaria.getProxSegmentoDireita(this.segmentoAtual) : this.malhaViaria.getProxSegmentoBaixo(this.segmentoAtual);
            case "Cruzamento_Baixo_Esquerda":
                return this.malhaViaria.getProxSegmentoBaixo(this.segmentoAtual).isCruzamento() ? this.malhaViaria.getProxSegmentoEsquerda(this.segmentoAtual) : this.malhaViaria.getProxSegmentoBaixo(this.segmentoAtual);
            case "Cruzamento_Cima_Direita":
                return this.malhaViaria.getProxSegmentoCima(this.segmentoAtual).isCruzamento() ? this.malhaViaria.getProxSegmentoDireita(this.segmentoAtual) : this.malhaViaria.getProxSegmentoCima(this.segmentoAtual);
            case "Cruzamento_Cima_Esquerda":
                return this.malhaViaria.getProxSegmentoCima(this.segmentoAtual).isCruzamento() ? this.malhaViaria.getProxSegmentoEsquerda(this.segmentoAtual) : this.malhaViaria.getProxSegmentoCima(this.segmentoAtual);
        }
        return null;
    }

    public Segmento getProximoSegmentoCruzamento(Segmento segmentoDeReferencia, boolean forcaSairCruzamento, Segmento segmentoRefAnterior, List<Segmento> listaCaminho, int idxSegmentoAtual) {
        Segmento proximoSegmento = null;
        Segmento a = null;
        Segmento b = null;
        Random random = new Random();
        boolean par = random.nextInt(500) % 2 == 0;

        switch (segmentoDeReferencia.getDirecao()) {
            case "Cruzamento_Cima":
                if (forcaSairCruzamento) {
                    proximoSegmento = this.getProximoSegmentoCruzamento(segmentoRefAnterior, true, null, null, 0);
                    listaCaminho.remove(idxSegmentoAtual);
                } else {
                    proximoSegmento = this.malhaViaria.getProxSegmentoCima(segmentoDeReferencia);
                }
                break;
            case "Cruzamento_Direita":
                if (forcaSairCruzamento) {
                    proximoSegmento = this.getProximoSegmentoCruzamento(segmentoRefAnterior, true, null, null, 0);
                    listaCaminho.remove(idxSegmentoAtual);
                } else {
                    proximoSegmento = this.malhaViaria.getProxSegmentoDireita(segmentoDeReferencia);
                }
                break;
            case "Cruzamento_Baixo":
                if (forcaSairCruzamento) {
                    proximoSegmento = this.getProximoSegmentoCruzamento(segmentoRefAnterior, true, null, null, 0);
                    listaCaminho.remove(idxSegmentoAtual);
                } else {
                    proximoSegmento = this.malhaViaria.getProxSegmentoBaixo(segmentoDeReferencia);
                }
                break;
            case "Cruzamento_Esquerda":
                if (forcaSairCruzamento) {
                    proximoSegmento = this.getProximoSegmentoCruzamento(segmentoRefAnterior, true, null, null, 0);
                    listaCaminho.remove(idxSegmentoAtual);
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

    public boolean cruzamentoLivre() {
        boolean encontrouCaminho = false;
        for (Segmento segmento : caminhoCruzamento) {
            if (segmento != null) {
                encontrouCaminho = true;
            }
        }
        return encontrouCaminho;
    }

    public void escolherCaminhoCruzamento(Segmento primeiroSegmento) {
        this.caminhoCruzamento.add(primeiroSegmento);
        Segmento segmentoAnterior = null;
        for (int i = 1; i <= 3; i++) {
            Segmento proximoSegmento = this.getProximoSegmentoCruzamento(this.caminhoCruzamento.get(i - 1), (i == 3), segmentoAnterior, this.caminhoCruzamento, (i - 1));
            this.caminhoCruzamento.add(proximoSegmento);
            segmentoAnterior = this.caminhoCruzamento.get(i - 1);
            if (!proximoSegmento.isCruzamento()) {
                break;
            }
        }
    }

    public boolean temCaminhoReservado() {
        for (Segmento segmento : this.caminhoCruzamento) {
            return segmento.getReserva() == this;
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

    public List<Segmento> getCaminhoCruzamento() {
        return caminhoCruzamento;
    }

    public void setCaminhoCruzamento(List<Segmento> caminhoCruzamento) {
        this.caminhoCruzamento = caminhoCruzamento;
    }

}
