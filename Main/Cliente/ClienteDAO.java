package Main.Cliente;

import Main.Cliente.Cliente;
import Main.Conexao.Conexao;
import Main.Conexao.FalhaConexaoException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private static int ID_POSICAO_TABELA = 1;
    private static int NUMERO_POSICAO_TABELA = 2;
    private static int CPF_POSICAO_TABELA = 3;
    private static int CONTA_ID_POSICAO_TABELA = 3;

    public static void criaTabelaCliente() throws FalhaConexaoException {
        try {
            // Estabelecer conexao
            Connection conexao = Conexao.obtemConexao();

            // Faço a consulta
            Statement stmt = conexao.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS Clientes (id INT PRIMARY KEY," +
                    "nome VARCHAR(255) NOT NULL)");
        } catch (SQLException e) {
            throw new Error(e.getMessage());
        }
    }

    public static List<Cliente> obtemListaAlunos() throws FalhaConexaoException {

        try {
            // Estabelecer conexao
            Connection conexao = Conexao.obtemConexao();

            // Faço a consulta
            Statement stmt = conexao.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * from Clientes ORDER BY nome;");

            // Crio a lista de alunos.
            List<Cliente> listaClientes = new ArrayList<>();

            while(resultado.next()) {
                // Obtenho os dados
                Cliente clienteTmp = new Cliente(resultado.getInt(ID_POSICAO_TABELA),
                        resultado.getString(NUMERO_POSICAO_TABELA),
                        resultado.getString(CPF_POSICAO_TABELA),
                        resultado.getInt(CONTA_ID_POSICAO_TABELA));
                // Adiciono à lista de alunos
                listaClientes.add(clienteTmp);
            }

            // Retorna a lista de alunos preenchida
            return listaClientes;

        } catch (SQLException | FalhaConexaoException e) {
            throw new Error(e.getMessage());
        }
    }
}
