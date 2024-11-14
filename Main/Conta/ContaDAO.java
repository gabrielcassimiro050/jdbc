package Main.Conta;

import Main.Conta.Conta;
import Main.Conexao.Conexao;
import Main.Conexao.FalhaConexaoException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContaDAO {
    private static int ID_POSICAO_TABELA = 1;
    private static int NUMERO_POSICAO_TABELA = 2;
    private static int AGENCIA_ID_POSICAO_TABELA = 3;

    public static void criaTabelaConta() throws FalhaConexaoException {
        try {
            // Estabelecer conexao
            Connection conexao = Conexao.obtemConexao();

            // Faço a consulta
            Statement stmt = conexao.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS contas (id INT PRIMARY KEY," +
                    "nome VARCHAR(255) NOT NULL)");
        } catch (SQLException e) {
            throw new Error(e.getMessage());
        }
    }

    public static List<Conta> obtemListaAlunos() throws FalhaConexaoException {

        try {
            // Estabelecer conexao
            Connection conexao = Conexao.obtemConexao();

            // Faço a consulta
            Statement stmt = conexao.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * from Contas ORDER BY nome;");

            // Crio a lista de alunos.
            List<Conta> listaContas = new ArrayList<>();

            while(resultado.next()) {
                // Obtenho os dados
                Conta contaTmp = new Conta(resultado.getInt(ID_POSICAO_TABELA),
                        resultado.getString(NUMERO_POSICAO_TABELA),
                        resultado.getInt(AGENCIA_ID_POSICAO_TABELA));
                // Adiciono à lista de alunos
                listaContas.add(contaTmp);
            }

            // Retorna a lista de alunos preenchida
            return listaContas;

        } catch (SQLException | FalhaConexaoException e) {
            throw new Error(e.getMessage());
        }
    }
}
