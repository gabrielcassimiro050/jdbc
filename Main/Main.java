package Main;

import Main.Banco.BancoDAO;
import Main.Conexao.FalhaConexaoException;

public class Main {
    public static void main(String[] args) throws FalhaConexaoException {
        BancoDAO.criaTabelaBanco();
    }
}