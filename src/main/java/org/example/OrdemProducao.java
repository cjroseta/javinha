package org.example;

public class OrdemProducao extends OrdemBase implements Notificavel {

    public OrdemProducao(String sequencia, int ano, int mes) {
        super(sequencia, ano, mes);
    }

    @Override
    public String getTipo() {
        return "PROD";
    }

    @Override
    public void enviarNotificacao(String mensagem) {
        System.out.println("[Notificação PROD " + sequencia + "] " + mensagem);
    }
}