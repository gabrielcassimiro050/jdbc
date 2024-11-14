package Main.Agencia;
import Main.Banco.Banco;
import Main.Conta.Conta;
import java.util.*;

public class Agencia {
    private int id, id_banco;
    private String numero;
    private Banco banco;
    private List<Conta> contas;

    public Agencia(int id, String numero, int id_banco) {
        this.id = id;
        this.numero = numero;
        this.id_banco = id_banco;
        this.contas = new ArrayList<Conta>();
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
        this.id_banco = banco.getId();
    }

    public int getId() {
        return id;
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