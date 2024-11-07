package Banco;

import Agencia.Agencia;

import java.util.*;

class Banco {
    private String nome;
    private List<Agencia> agencias;

    public Banco(String nome) {
        this.nome = nome;
        this.agencias = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Agencia> getAgencias() {
        return agencias;
    }

    public void adicionarAgencia(Agencia agencia) {
        if (!agencias.contains(agencia)) {
            agencias.add(agencia);
            agencia.setBanco(this);
        }
    }

    public void removerAgencia(Agencia agencia) {
        if (agencias.contains(agencia)) {
            agencias.remove(agencia);
            agencia.setBanco(null);
        }
    }
}