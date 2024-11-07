package Agencia;

import java.util.*;

class Agencia {
    private String numero;
    private Banco banco;
    private List<Conta> contas;

    public Agencia(String numero) {
        this.numero = numero;
        this.contas = new ArrayList<>();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void adicionarConta(Conta conta) {
        if (!contas.contains(conta)) {
            contas.add(conta);
            conta.setAgencia(this);
        }
    }

    public void removerConta(Conta conta) {
        if (contas.contains(conta)) {
            contas.remove(conta);
            conta.setAgencia(null);
        }
    }
}