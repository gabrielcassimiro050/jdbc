package Main.Banco;

import Main.Conexao.Conexao;
import Main.Conexao.FalhaConexaoException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BancoDAO {
    private static final int ID_POSICAO_TABELA = 1;
    private static final int NOME_POSICAO_TABELA = 2;

    public static void criaTabelaBanco() throws  FalhaConexaoException {
        try {
            // Estabelecer conexao
            Connection conexao = Conexao.obtemConexao();

            // Faço a consulta
            Statement stmt = conexao.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS bancos (id INT PRIMARY KEY," +
                    "nome VARCHAR(255) NOT NULL)");
        } catch (SQLException e) {
            throw new Error(e.getMessage());
        }
    }

    public static List<Banco> obtemListaAlunos() throws FalhaConexaoException {

        try {
            // Estabelecer conexao
            Connection conexao = Conexao.obtemConexao();

            // Faço a consulta
            Statement stmt = conexao.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * from alunos ORDER BY nome;");

            // Crio a lista de alunos.
            List<Banco> listaBancos = new ArrayList<>();

            while(resultado.next()) {
                // Obtenho os dados
                Banco bancoTmp = new Banco(resultado.getInt(ID_POSICAO_TABELA),
                        resultado.getString(NOME_POSICAO_TABELA));
                // Adiciono à lista de alunos
                listaBancos.add(bancoTmp);
            }

            // Retorna a lista de alunos preenchida
            return listaBancos;

        } catch (SQLException | FalhaConexaoException e) {
            throw new Error(e.getMessage());
        }
    }

}
