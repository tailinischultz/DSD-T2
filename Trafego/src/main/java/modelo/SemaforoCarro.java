package modelo;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class SemaforoCarro extends Carro {

    private Segmento segmentoAtual;
    private boolean emCruzamento;
    private Segmento[] caminhoCruzamento;
    private final Semaphore semaforo;
    private MalhaViaria malhaViaria;

    public SemaforoCarro(MalhaViaria malhaViaria) {
        this.emCruzamento = false;
        this.caminhoCruzamento = new Segmento[4];
        this.semaforo = new Semaphore(1);
        this.malhaViaria = malhaViaria;
    }

    @Override
    public void setSegmentoAtual(Segmento segmento) {
        this.segmentoAtual = segmento;
    }
    
    public Segmento getNodoAtual() {
        return segmentoAtual;
    }

    public void setNodoAtual(Segmento segmentoAtual) {
        this.segmentoAtual = segmentoAtual;
    }

    private void andar(Segmento segmentoDestino) {
        try {
            this.semaforo.acquire();
        } catch (InterruptedException ex) {
            System.out.println("Thread interrompida. Abortando método run()");
        }
        if (segmentoDestino.getCarro() != null) {
            this.semaforo.release();
        } else {
            this.segmentoAtual.setCarro(null);
            this.segmentoAtual = segmentoDestino;
            this.segmentoAtual.setCarro(this);
            this.semaforo.release();
        }
    }

    private Segmento getProxNodoNormal() {
        Segmento proximoNodo = null;
        Segmento a;
        Segmento b;
        switch (this.segmentoAtual.getDirecao()) {
            case "Estrada_Cima":
                proximoNodo = this.malhaViaria.getProxSegmentoCima(this.segmentoAtual);
                break;
            case "Estrada_Direita":
                proximoNodo = this.malhaViaria.getProxSegmentoDireita(this.segmentoAtual);
                break;
            case "Estrada_Baixo":
                proximoNodo = this.malhaViaria.getProxSegmentoBaixo(this.segmentoAtual);
                break;
            case "Estrada_Esquerda":
                proximoNodo = this.malhaViaria.getProxSegmentoEsquerda(this.segmentoAtual);
                break;
            case "Cruzamento_Cima":
                proximoNodo = this.malhaViaria.getProxSegmentoCima(this.segmentoAtual);
                break;
            case "Cruzamento_Direita":
                proximoNodo = this.malhaViaria.getProxSegmentoDireita(this.segmentoAtual);
                break;
            case "Cruzamento_Baixo":
                proximoNodo = this.malhaViaria.getProxSegmentoBaixo(this.segmentoAtual);
                break;
            case "Cruzamento_Esquerda":
                proximoNodo = this.malhaViaria.getProxSegmentoEsquerda(this.segmentoAtual);
                break;
            case "Cruzamento_Baixo_Direita":
                a = this.malhaViaria.getProxSegmentoBaixo(this.segmentoAtual);
                b = this.malhaViaria.getProxSegmentoDireita(this.segmentoAtual);
                proximoNodo = a.isCruzamento() ? b : a;
                break;
            case "Cruzamento_Baixo_Esquerda":
                a = this.malhaViaria.getProxSegmentoBaixo(this.segmentoAtual);
                b = this.malhaViaria.getProxSegmentoEsquerda(this.segmentoAtual);
                proximoNodo = a.isCruzamento() ? b : a;
                break;
            case "Cruzamento_Cima_Direita":
                a = this.malhaViaria.getProxSegmentoCima(this.segmentoAtual);
                b = this.malhaViaria.getProxSegmentoDireita(this.segmentoAtual);
                proximoNodo = a.isCruzamento() ? b : a;
                break;
            case "Cruzamento_Cima_Esquerda":
                a = this.malhaViaria.getProxSegmentoCima(this.segmentoAtual);
                b = this.malhaViaria.getProxSegmentoEsquerda(this.segmentoAtual);
                proximoNodo = a.isCruzamento() ? b : a;
                break;
        }

        return proximoNodo;
    }

    private Segmento getProxNodoCruzamento(Segmento nodoReferencia, boolean forcaSairCruzamento, Segmento ViagemTemporal, Segmento[] listaInteria, int idxNodoAtual) {
        Segmento proximoNodo = null;
        Segmento a = null;
        Segmento b = null;
        Random rand = new Random();
        boolean par = rand.nextInt(500) % 2 == 0;

        switch (nodoReferencia.getDirecao()) {
            case "Cruzamento_Cima":
                if (forcaSairCruzamento) {
                    proximoNodo = this.getProxNodoCruzamento(ViagemTemporal, true, null, null, 0);
                    listaInteria[idxNodoAtual] = null;
                }
                else {
                    proximoNodo = this.malhaViaria.getProxSegmentoCima(nodoReferencia);
                }
                break;
            case "Cruzamento_Direita":
                if (forcaSairCruzamento) {
                    proximoNodo = this.getProxNodoCruzamento(ViagemTemporal, true, null, null, 0);
                    listaInteria[idxNodoAtual] = null;
                }
                else {
                    proximoNodo = this.malhaViaria.getProxSegmentoDireita(nodoReferencia);
                }
                break;
            case "Cruzamento_Baixo":
                if (forcaSairCruzamento) {
                    proximoNodo = this.getProxNodoCruzamento(ViagemTemporal, true, null, null, 0);
                    listaInteria[idxNodoAtual] = null;
                }
                else {
                    proximoNodo = this.malhaViaria.getProxSegmentoBaixo(nodoReferencia);
                }
                break;
            case "Cruzamento_Esquerda":
                if (forcaSairCruzamento) {
                    proximoNodo = this.getProxNodoCruzamento(ViagemTemporal, true, null, null, 0);
                    listaInteria[idxNodoAtual] = null;
                }
                else {
                    proximoNodo = this.malhaViaria.getProxSegmentoEsquerda(nodoReferencia);
                }
                break;
            case "Cruzamento_Baixo_Direita":
                a = this.malhaViaria.getProxSegmentoBaixo(nodoReferencia);
                b = this.malhaViaria.getProxSegmentoDireita(nodoReferencia);
                if (forcaSairCruzamento) {
                    proximoNodo = a.isCruzamento() ? b : a;
                }
                else {
                    proximoNodo = par ? a : b;
                }
                break;
            case "Cruzamento_Baixo_Esquerda":
                a = this.malhaViaria.getProxSegmentoBaixo(nodoReferencia);
                b = this.malhaViaria.getProxSegmentoEsquerda(nodoReferencia);
                if (forcaSairCruzamento) {
                    proximoNodo = a.isCruzamento() ? b : a;
                }
                else {
                    proximoNodo = par ? a : b;
                }
                break;
            case "Cruzamento_Cima_Direita":
                a = this.malhaViaria.getProxSegmentoCima(nodoReferencia);
                b = this.malhaViaria.getProxSegmentoDireita(nodoReferencia);
                if (forcaSairCruzamento) {
                    proximoNodo = a.isCruzamento() ? b : a;
                }
                else {
                    proximoNodo = par ? a : b;
                }
                break;
            case "Cruzamento_Cima_Esquerda":
                a = this.malhaViaria.getProxSegmentoCima(nodoReferencia);
                b = this.malhaViaria.getProxSegmentoEsquerda(nodoReferencia);
                if (forcaSairCruzamento) {
                    proximoNodo = a.isCruzamento() ? b : a;
                }
                else {
                    proximoNodo = par ? a : b;
                }
                break;
        }

        return proximoNodo;
    }

    private boolean temCaminhoDefinido() {
        boolean encontrouCaminho = false;
        for (Segmento nodo : caminhoCruzamento) {
            if (nodo != null) {
                encontrouCaminho = true;
            }
        }
        return encontrouCaminho;
    }

    private void escolherCaminhoCruzamento(Segmento nodoIniCruzamento) {
        this.caminhoCruzamento[0] = nodoIniCruzamento;
        Segmento viagemNoTempo = null;
        for (int i = 1; i <= 3; i++) {
            Segmento prox = this.getProxNodoCruzamento(this.caminhoCruzamento[(i - 1)], (i == 3), viagemNoTempo, this.caminhoCruzamento, (i - 1));
            this.caminhoCruzamento[i] = prox;
            viagemNoTempo = this.caminhoCruzamento[(i - 1)];
            if (!prox.isCruzamento()) {
                break;
            }
        }

        Segmento[] caminhoCruzamentoAux = new Segmento[4];
        int contIdxAtual = 0;
        for (Segmento nodo : caminhoCruzamento) {
            if (nodo != null) {
                caminhoCruzamentoAux[contIdxAtual] = nodo;
                contIdxAtual++;
            }
        }
        this.caminhoCruzamento = caminhoCruzamentoAux;
    }

    private void tentaReservarCaminhoCruzamento() {
        try {
            this.semaforo.acquire();
        }
        catch (InterruptedException ex) {}
        
        boolean livre = true;
        for (Segmento nodo : caminhoCruzamento) {
            if (nodo == null) {
                break;
            }
            if (nodo.getReserva() != null) {
                livre = false;
                break;
            }
        }

        if (!livre) {
            this.semaforo.release();
            return;
        }

        for (Segmento nodo : caminhoCruzamento) {
            if (nodo == null) {
                break;
            }
            nodo.setReserva(this);
        }
        this.semaforo.release();
    }

    private boolean temCaminhoReservado() {
        for (Segmento nodo : caminhoCruzamento) {
            if (nodo != null) {
                if (nodo.getReserva() == this) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        return false;
    }

    private void trataAndarCruzamento() {
        for (int i = 0; i < this.caminhoCruzamento.length; i++) {
            Segmento nodo = this.caminhoCruzamento[i];
            if (nodo != null) {
                this.andar(nodo);
                nodo.setReserva(null);
                this.caminhoCruzamento[i] = null;
                break;
            }
        }
        boolean andouTudo = true;
        for (int i = 0; i < this.caminhoCruzamento.length; i++) {
            if (this.caminhoCruzamento[i] != null) {
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
        Segmento proximoNodo = null;
        while (this.segmentoAtual.getMalhaViaria().estaEmExecucao() && !this.segmentoAtual.isSaida()) {
            if (this.emCruzamento) {
                
                if (this.temCaminhoDefinido()) {
                    if (this.temCaminhoReservado()) {
                        this.trataAndarCruzamento();
                    } else {
                        this.tentaReservarCaminhoCruzamento();
                        if (this.temCaminhoReservado()) {
                            this.trataAndarCruzamento();
                        }
                    }
                } else {
                    this.escolherCaminhoCruzamento(proximoNodo);
                    this.tentaReservarCaminhoCruzamento();
                    if (this.temCaminhoReservado()) {
                        this.trataAndarCruzamento();
                    }
                }
                
            } else {
                
                proximoNodo = this.getProxNodoNormal();
                if (proximoNodo.isCruzamento()) {
                    this.emCruzamento = true;
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
        
        this.segmentoAtual.setCarro(null);
    }

}
