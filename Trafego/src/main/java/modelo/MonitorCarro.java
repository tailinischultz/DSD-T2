package modelo;

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
        return "";
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
                //if (this.temCaminhoDefinido()) {
                //if (this.temCaminhoReservado()) {
                //    this.trataAndarCruzamento();
                //}
                //else {
                //    this.tentaReservarCaminhoCruzamento();
                //    if (this.temCaminhoReservado()) {
                //        this.trataAndarCruzamento();
                //    }
                // }
                //}
                // else {
                //     this.escolherCaminhoCruzamento(proximoNodo);
                //     this.tentaReservarCaminhoCruzamento();
                //    if (this.temCaminhoReservado()) {
                // this.trataAndarCruzamento();
                // }
                // }
            } else {
                proximoSegmento = this.getProxNodoNormal();
                this.andarUmaCasaNormal(proximoSegmento);
            }
            this.esperar();
        }
    }
}
