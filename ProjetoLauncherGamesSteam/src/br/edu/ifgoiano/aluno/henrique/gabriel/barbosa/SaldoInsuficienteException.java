package br.edu.ifgoiano.aluno.henrique.gabriel.barbosa;

/**
 * Exceção não checada lançada quando um usuário tenta adquirir um jogo,
 * mas o saldo atual em sua conta é insuficiente para cobrir o valor da transação.
 *
 * @author Henrique Gabriel Barbosa
 * @version 1.0
 * @see java.lang.RuntimeException
 * @see BibliotecaUsuario#comprarJogo(Jogo)
 */
public class SaldoInsuficienteException extends RuntimeException {

    /**
     * Constrói uma nova exceção {@code SaldoInsuficienteException} com a mensagem de detalhe especificada.
     *
     * @param message a mensagem descrevendo o saldo atual e o valor necessário para a compra
     */
    public SaldoInsuficienteException(String message) {
        super(message);
    }
}