package modelo;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class SemaforoCarro extends Carro {

    private Segmento segmentoAtual;
    private boolean emCruzamento;
    private Segmento[] caminhoCruzamento;
    private final Semaphore semaforo;

    public SemaforoCarro() {
        this.emCruzamento = false;
        this.caminhoCruzamento = new Segmento[4];
        this.semaforo = new Semaphore(1);
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

    private Segmento getProxNodoCima() {
        MalhaViaria malhaViaria = this.segmentoAtual.getMalhaViaria();
        Segmento proximoSegmento = malhaViaria.getNodo(this.segmentoAtual.getIdxLinha() - 1, this.segmentoAtual.getIdxColuna());
        return proximoSegmento;

    }

    private Segmento getProxNodoDireita() {
        MalhaViaria malhaViaria = this.segmentoAtual.getMalhaViaria();
        Segmento proximoNodo = malhaViaria.getNodo(this.segmentoAtual.getIdxLinha(), this.segmentoAtual.getIdxColuna() + 1);
        return proximoNodo;
    }

    private Segmento getProxNodoBaixo() {
        MalhaViaria malhaViaria = this.segmentoAtual.getMalhaViaria();
        Segmento proximoNodo = malhaViaria.getNodo(this.segmentoAtual.getIdxLinha() + 1, this.segmentoAtual.getIdxColuna());
        return proximoNodo;
    }

    private Segmento getProxNodoEsquerda() {
        MalhaViaria malhaViaria = this.segmentoAtual.getMalhaViaria();
        Segmento proximoNodo = malhaViaria.getNodo(this.segmentoAtual.getIdxLinha(), this.segmentoAtual.getIdxColuna() - 1);
        return proximoNodo;
    }

    private Segmento getProxNodoCima(Segmento nodoReferencia) {
        MalhaViaria malhaViaria = nodoReferencia.getMalhaViaria();
        Segmento proximoNodo = malhaViaria.getNodo(nodoReferencia.getIdxLinha() - 1, nodoReferencia.getIdxColuna());
        return proximoNodo;

    }

    private Segmento getProxNodoDireita(Segmento nodoReferencia) {
        MalhaViaria malhaViaria = nodoReferencia.getMalhaViaria();
        Segmento proximoNodo = malhaViaria.getNodo(nodoReferencia.getIdxLinha(), nodoReferencia.getIdxColuna() + 1);
        return proximoNodo;
    }

    private Segmento getProxNodoBaixo(Segmento nodoReferencia) {
        MalhaViaria malhaViaria = nodoReferencia.getMalhaViaria();
        Segmento proximoNodo = malhaViaria.getNodo(nodoReferencia.getIdxLinha() + 1, nodoReferencia.getIdxColuna());
        return proximoNodo;
    }

    private Segmento getProxNodoEsquerda(Segmento nodoReferencia) {
        MalhaViaria malhaViaria = nodoReferencia.getMalhaViaria();
        Segmento proximoNodo = malhaViaria.getNodo(nodoReferencia.getIdxLinha(), nodoReferencia.getIdxColuna() - 1);
        return proximoNodo;
    }

    private void SairMalhaViaria() {
        this.segmentoAtual.setCarro(null);
    }

    private Segmento getProxNodoNormal() {
        Segmento proximoNodo = null;
        Segmento a = null;
        Segmento b = null;
        switch (this.segmentoAtual.getDirecao()) {
            case "Estrada_Cima":
                proximoNodo = this.getProxNodoCima();
                break;
            case "Estrada_Direita":
                proximoNodo = this.getProxNodoDireita();
                break;
            case "Estrada_Baixo":
                proximoNodo = this.getProxNodoBaixo();
                break;
            case "Estrada_Esquerda":
                proximoNodo = this.getProxNodoEsquerda();
                break;
            case "Cruzamento_Cima":
                proximoNodo = this.getProxNodoCima();
                break;
            case "Cruzamento_Direita":
                proximoNodo = this.getProxNodoDireita();
                break;
            case "Cruzamento_Baixo":
                proximoNodo = this.getProxNodoBaixo();
                break;
            case "Cruzamento_Esquerda":
                proximoNodo = this.getProxNodoEsquerda();
                break;
            case "Cruzamento_Baixo_Direita":
                a = this.getProxNodoBaixo();
                b = this.getProxNodoDireita();
                proximoNodo = a.isCruzamento() ? b : a;
                break;
            case "Cruzamento_Baixo_Esquerda":
                a = this.getProxNodoBaixo();
                b = this.getProxNodoEsquerda();
                proximoNodo = a.isCruzamento() ? b : a;
                break;
            case "Cruzamento_Cima_Direita":
                a = this.getProxNodoCima();
                b = this.getProxNodoDireita();
                proximoNodo = a.isCruzamento() ? b : a;
                break;
            case "Cruzamento_Cima_Esquerda":
                a = this.getProxNodoCima();
                b = this.getProxNodoEsquerda();
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
                    proximoNodo = this.getProxNodoCima(nodoReferencia);
                }
                break;
            case "Cruzamento_Direita":
                if (forcaSairCruzamento) {
                    proximoNodo = this.getProxNodoCruzamento(ViagemTemporal, true, null, null, 0);
                    listaInteria[idxNodoAtual] = null;
                }
                else {
                    proximoNodo = this.getProxNodoDireita(nodoReferencia);
                }
                break;
            case "Cruzamento_Baixo":
                if (forcaSairCruzamento) {
                    proximoNodo = this.getProxNodoCruzamento(ViagemTemporal, true, null, null, 0);
                    listaInteria[idxNodoAtual] = null;
                }
                else {
                    proximoNodo = this.getProxNodoBaixo(nodoReferencia);
                }
                break;
            case "Cruzamento_Esquerda":
                if (forcaSairCruzamento) {
                    proximoNodo = this.getProxNodoCruzamento(ViagemTemporal, true, null, null, 0);
                    listaInteria[idxNodoAtual] = null;
                }
                else {
                    proximoNodo = this.getProxNodoEsquerda(nodoReferencia);
                }
                break;
            case "Cruzamento_Baixo_Direita":
                a = this.getProxNodoBaixo(nodoReferencia);
                b = this.getProxNodoDireita(nodoReferencia);
                if (forcaSairCruzamento) {
                    proximoNodo = a.isCruzamento() ? b : a;
                }
                else {
                    proximoNodo = par ? a : b;
                }
                break;
            case "Cruzamento_Baixo_Esquerda":
                a = this.getProxNodoBaixo(nodoReferencia);
                b = this.getProxNodoEsquerda(nodoReferencia);
                if (forcaSairCruzamento) {
                    proximoNodo = a.isCruzamento() ? b : a;
                }
                else {
                    proximoNodo = par ? a : b;
                }
                break;
            case "Cruzamento_Cima_Direita":
                a = this.getProxNodoCima(nodoReferencia);
                b = this.getProxNodoDireita(nodoReferencia);
                if (forcaSairCruzamento) {
                    proximoNodo = a.isCruzamento() ? b : a;
                }
                else {
                    proximoNodo = par ? a : b;
                }
                break;
            case "Cruzamento_Cima_Esquerda":
                a = this.getProxNodoCima(nodoReferencia);
                b = this.getProxNodoEsquerda(nodoReferencia);
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

    private void trataAndarNormal(Segmento nodoDestino) {
        if (nodoDestino.isCruzamento()) {
            this.emCruzamento = true;
        }
        else {
            if (nodoDestino.getCarro() == null) {
                this.andar(nodoDestino);
            }
        }
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

    private void esperar() {
        try {
            this.sleep(500);
        }
        catch (Exception e) {
        }
    }

    @Override
    public void run() {
        Segmento proximoNodo = null;
        while (true) {
            if (this.pararExecucao()) {
                break;
            }
            if (this.emCruzamento) {
                if (this.temCaminhoDefinido()) {
                    if (this.temCaminhoReservado()) {
                        this.trataAndarCruzamento();
                    }
                    else {
                        this.tentaReservarCaminhoCruzamento();
                        if (this.temCaminhoReservado()) {
                            this.trataAndarCruzamento();
                        }
                    }
                }
                else {
                    this.escolherCaminhoCruzamento(proximoNodo);
                    this.tentaReservarCaminhoCruzamento();
                    if (this.temCaminhoReservado()) {
                        this.trataAndarCruzamento();
                    }
                }
            }
            else {
                proximoNodo = this.getProxNodoNormal();
                this.trataAndarNormal(proximoNodo);
            }
            this.esperar();
        }
    }

}
