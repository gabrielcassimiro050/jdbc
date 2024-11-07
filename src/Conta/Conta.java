package Conta;

import Agencia.Agencia;
import Cliente.Cliente;

import java.util.*;

class Conta {
    private String numero;
    private Agencia agencia;
    private List<Cliente> clientes;

    public Conta(String numero) {
        this.numero = numero;
        this.clientes = new ArrayList<>();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void adicionarCliente(Cliente cliente) {
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
            cliente.adicionarConta(this);
        }
    }

    public void removerCliente(Cliente cliente) {
        if (clientes.contains(cliente)) {
            clientes.remove(cliente);
            cliente.removerConta(this);
        }
    }
}