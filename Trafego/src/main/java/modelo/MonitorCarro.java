package modelo;

import java.util.Random;

public class MonitorCarro extends Carro {

    private String nomeCarro;
    private Segmento segmentoAtual;
    private boolean emCruzamento;
    private Segmento[] caminhoACruzar;

    public MonitorCarro(String nomeCarro) {
        this.nomeCarro = nomeCarro;
        this.emCruzamento = false;
        this.caminhoACruzar = new Segmento[4];
    }

    public String getNomeCarro() {
        return nomeCarro;
    }
    public void setNomeCarro(String nomeCarro) {
        this.nomeCarro = nomeCarro;
    }
    public Segmento getSegmentoAtual() {
        return segmentoAtual;
    }
    @Override
    public String getNome() {
        return "🚘";
    }
    @Override
    public void setSegmentoAtual(Segmento segmentoAtual) {
        this.segmentoAtual=segmentoAtual;
    }
    private synchronized void andarUmSegmento(Segmento segmentoAIr){
        if(segmentoAIr.getCarro()!=null){
            return;
        }else 
            this.segmentoAtual.setCarro(null);
            this.segmentoAtual = segmentoAIr;
            this.segmentoAtual.setCarro(this);
    }
    private Segmento getProximoSegmentoDireita(){
        MalhaViaria malhaViaria = this.segmentoAtual.getMalhaViaria();
        Segmento proximoSegmento = malhaViaria.getNodo(this.segmentoAtual.getIdxLinha(), this.segmentoAtual.getIdxColuna() + 1);
        return proximoSegmento;
    }
    private Segmento getProximoSegmentoEsquerda(){
        MalhaViaria malhaViaria = this.segmentoAtual.getMalhaViaria();
        Segmento proximoSegmento = malhaViaria.getNodo(this.segmentoAtual.getIdxLinha(), this.segmentoAtual.getIdxColuna()-1);
        return proximoSegmento;
    }
    private Segmento getProximoSegmentoCima(){
        MalhaViaria malhaViaria = this.segmentoAtual.getMalhaViaria();
        Segmento proximoSegmento = malhaViaria.getNodo(this.segmentoAtual.getIdxLinha()-1, this.segmentoAtual.getIdxColuna());
        return proximoSegmento;
    }
    private Segmento getProximoSegmentoBaixo(){
        MalhaViaria malhaViaria = this.segmentoAtual.getMalhaViaria();
        Segmento proximoSegmento = malhaViaria.getNodo(this.segmentoAtual.getIdxLinha()+1, this.segmentoAtual.getIdxColuna());
        return proximoSegmento;
    }
    private Segmento getProximoSegmentoDireita(Segmento segmentoDeReferencia) {
        MalhaViaria malhaViaria = segmentoDeReferencia.getMalhaViaria();
        Segmento proximoSegmento = malhaViaria.getNodo(segmentoDeReferencia.getIdxLinha(), segmentoDeReferencia.getIdxColuna() +1);
        return proximoSegmento;
    }
    private Segmento getProximoSegmentoEsquerda(Segmento segmentoDeReferencia) {
        MalhaViaria malhaViaria = segmentoDeReferencia.getMalhaViaria();
        Segmento proximoSegmento = malhaViaria.getNodo(segmentoDeReferencia.getIdxLinha(), segmentoDeReferencia.getIdxColuna() -1);
        return proximoSegmento;
    }
    private Segmento getProximoSegmentoCima(Segmento segmentoDeReferencia) {
        MalhaViaria malhaViaria = segmentoDeReferencia.getMalhaViaria();
        Segmento proximoSegmento = malhaViaria.getNodo(segmentoDeReferencia.getIdxLinha()-1, segmentoDeReferencia.getIdxColuna());
        return proximoSegmento;
    }
    private Segmento getProximoSegmentoBaixo(Segmento segmentoDeReferencia) {
        MalhaViaria malhaViaria = segmentoDeReferencia.getMalhaViaria();
        Segmento proximoSegmento = malhaViaria.getNodo(segmentoDeReferencia.getIdxLinha()+1, segmentoDeReferencia.getIdxColuna());
        return proximoSegmento;
    }
    private Segmento getProxNodoNormal() {
        Segmento proximoSegmento = null;
        Segmento a = null;
        Segmento b = null;
        switch (this.segmentoAtual.getDirecao()) {
            case "Estrada_Cima":
                proximoSegmento = this.getProximoSegmentoCima();
                break;
            case "Estrada_Direita":
                proximoSegmento = this.getProximoSegmentoDireita();
                break;
            case "Estrada_Baixo":
                proximoSegmento = this.getProximoSegmentoBaixo();
                break;
            case "Estrada_Esquerda":
                proximoSegmento = this.getProximoSegmentoEsquerda();
                break;
            case "Cruzamento_Cima":
                proximoSegmento = this.getProximoSegmentoCima();
                break;
            case "Cruzamento_Direita":
                proximoSegmento = this.getProximoSegmentoDireita();
                break;
            case "Cruzamento_Baixo":
                proximoSegmento = this.getProximoSegmentoBaixo();
                break;
            case "Cruzamento_Esquerda":
                proximoSegmento = this.getProximoSegmentoEsquerda();
                break;
            case "Cruzamento_Baixo_Direita":
                a = this.getProximoSegmentoBaixo();
                b = this.getProximoSegmentoDireita();

                proximoSegmento = a.isCruzamento() ? b : a;

                break;
            case "Cruzamento_Baixo_Esquerda":
                a = this.getProximoSegmentoBaixo();
                b = this.getProximoSegmentoEsquerda();

                proximoSegmento = a.isCruzamento() ? b : a;

                break;
            case "Cruzamento_Cima_Direita":
                a = this.getProximoSegmentoCima();
                b = this.getProximoSegmentoDireita();

                proximoSegmento = a.isCruzamento() ? b : a;

                break;
            case "Cruzamento_Cima_Esquerda":
                a = this.getProximoSegmentoCima();
                b = this.getProximoSegmentoEsquerda();

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
                    proximoSegmento = this.getProximoSegmentoCima(segmentoDeReferencia);
                }
                break;
            case "Cruzamento_Direita":
                if (forcaSairCruzamento) {
                    proximoSegmento = this.getProximoSegmentoCruzamento(segmentoRefAnterior, true, null, null, 0);
                    listaCaminho[idxSegmentoAtual] = null;
                }
                else {
                    proximoSegmento = this.getProximoSegmentoDireita(segmentoDeReferencia);
                }
                break;
            case "Cruzamento_Baixo":
                if (forcaSairCruzamento) {
                    proximoSegmento = this.getProximoSegmentoCruzamento(segmentoRefAnterior, true, null, null, 0);
                    listaCaminho[idxSegmentoAtual] = null;
                }
                else {
                    proximoSegmento = this.getProximoSegmentoBaixo(segmentoDeReferencia);
                }
                break;
            case "Cruzamento_Esquerda":
                if (forcaSairCruzamento) {
                    proximoSegmento = this.getProximoSegmentoCruzamento(segmentoRefAnterior, true, null, null, 0);
                    listaCaminho[idxSegmentoAtual] = null;
                }
                else {
                    proximoSegmento = this.getProximoSegmentoEsquerda(segmentoDeReferencia);
                }
                break;
            case "Cruzamento_baixo_Direita":
                a = this.getProximoSegmentoBaixo(segmentoDeReferencia);
                b = this.getProximoSegmentoDireita(segmentoDeReferencia);
                if (forcaSairCruzamento) {
                    proximoSegmento = a.isCruzamento() ? b : a;
                }
                else {
                    proximoSegmento = par ? a : b;
                }
                break;
            case "Cruzamento_Baixo_Esquerda":
                a = this.getProximoSegmentoBaixo(segmentoDeReferencia);
                b = this.getProximoSegmentoEsquerda(segmentoDeReferencia);
                if (forcaSairCruzamento) {
                    proximoSegmento = a.isCruzamento() ? b : a;
                }
                else {
                    proximoSegmento = par ? a : b;
                }
                break;
            case "Cruzamento_Cima_Direita":
                a = this.getProximoSegmentoCima(segmentoDeReferencia);
                b = this.getProximoSegmentoDireita(segmentoDeReferencia);
                if (forcaSairCruzamento) {
                    proximoSegmento = a.isCruzamento() ? b : a;
                }
                else {
                    proximoSegmento = par ? a : b;
                }
                break;
            case "Cruzamento_Cima_Esquerda":
                a = this.getProximoSegmentoCima(segmentoDeReferencia);
                b = this.getProximoSegmentoEsquerda(segmentoDeReferencia);
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
                this.andarUmSegmento(segmento);
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
    private void andarUmaCasaNormal(Segmento segmentoAIr) {
        if (segmentoAIr.isCruzamento()) {
            this.emCruzamento = true;
        }else if (segmentoAIr.getCarro() == null) {
            this.andarUmSegmento(segmentoAIr);
        }
    }
    
    private void SairMalhaViaria() {
        this.segmentoAtual.setCarro(null);
    }
    private boolean pararExecucao() {
        if (!this.segmentoAtual.getMalhaViaria().estaEmExecucao()) {
            return true;
        }

        if (this.segmentoAtual.isSaida()) {
            this.SairMalhaViaria();
            return true;
        }
        return false;
    }
    private void esperar() {
        try {
            this.sleep(500);
        }
        catch (Exception e) {
        }
    }
    
    @Override
    public void run() {
        Segmento proximoSegmento = null;
        while (true) {
            if (this.pararExecucao()) {
                break;
            }
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
                this.andarUmaCasaNormal(proximoSegmento);
            }
            this.esperar();
        }
    }
}
