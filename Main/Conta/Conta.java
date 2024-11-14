package Main.Conta;
import Main.Agencia.Agencia;
import Main.Cliente.Cliente;

import java.util.*;

public class Conta {
    private int id, id_agencia;
    private String numero;
    private Agencia agencia;
    private List<Cliente> clientes;

    public Conta(int id, String numero, int id_agencia) {
        this.id = id;
        this.numero = numero;
        this.id_agencia = id_agencia;
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
        this.id_agencia = agencia.getId();
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