package Main.Banco;

import Main.Agencia.Agencia;

import java.util.*;

public class Banco {
    private int id;
    private String nome;
    private List<Agencia> agencias;

    public Banco(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.agencias = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
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