package Main.Cliente;
import Main.Conta.Conta;

import java.util.*;

public class Cliente {
    private int id, id_conta;
    private String nome;
    private String cpf;
    private List<Conta> contas;

    public Cliente(int id, String nome, String cpf, int id_conta) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.id_conta = id_conta;
        this.contas = new ArrayList<Conta>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void adicionarConta(Conta conta) {
        if (!contas.contains(conta)) {
            contas.add(conta);
            conta.adicionarCliente(this);
        }
    }

    public void removerConta(Conta conta) {
        if (contas.contains(conta)) {
            contas.remove(conta);
            conta.removerCliente(this);
        }
    }
}