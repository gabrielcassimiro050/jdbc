package Main.Conexao;

public class FalhaConexaoException extends Exception {

    public FalhaConexaoException(String mensagem) {
        super(mensagem);
    }
}