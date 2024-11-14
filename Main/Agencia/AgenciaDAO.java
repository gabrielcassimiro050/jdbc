package Main.Agencia;

import Main.Banco.Banco;
import Main.Conexao.Conexao;
import Main.Conexao.FalhaConexaoException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AgenciaDAO {
    private static int ID_POSICAO_TABELA = 1;
    private static int NUMERO_POSICAO_TABELA = 2;
    private static int BANCO_ID_POSICAO_TABELA = 3;

    public static void criaTabelaAgencia() throws FalhaConexaoException {
        try {
            // Estabelecer conexao
            Connection conexao = Conexao.obtemConexao();

            // Faço a consulta
            Statement stmt = conexao.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS agencias (id INT PRIMARY KEY," +
                    "nome VARCHAR(255) NOT NULL)");
        } catch (SQLException e) {
            throw new Error(e.getMessage());
        }
    }

    public static List<Agencia> obtemListaAlunos() throws FalhaConexaoException {

        try {
            // Estabelecer conexao
            Connection conexao = Conexao.obtemConexao();

            // Faço a consulta
            Statement stmt = conexao.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * from agencias ORDER BY nome;");

            // Crio a lista de alunos.
            List<Agencia> listaAgencias = new ArrayList<>();

            while(resultado.next()) {
                // Obtenho os dados
                Agencia agenciaTmp = new Agencia(resultado.getInt(ID_POSICAO_TABELA),
                        resultado.getString(NUMERO_POSICAO_TABELA),
                        resultado.getInt(BANCO_ID_POSICAO_TABELA));
                // Adiciono à lista de alunos
                listaAgencias.add(agenciaTmp);
            }

            // Retorna a lista de alunos preenchida
            return listaAgencias;

        } catch (SQLException | FalhaConexaoException e) {
            throw new Error(e.getMessage());
        }
    }
}
