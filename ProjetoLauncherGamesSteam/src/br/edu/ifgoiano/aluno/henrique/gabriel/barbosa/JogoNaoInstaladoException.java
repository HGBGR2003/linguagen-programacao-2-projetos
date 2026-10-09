package br.edu.ifgoiano.aluno.henrique.gabriel.barbosa;

/**
 * Exceção lançada quando uma tentativa de executar um jogo falha
 * devido ao jogo não estar instalado ou não ser encontrado na biblioteca do usuário.
 *
 * @author Henrique Gabriel Barbosa
 * @version 1.0
 * @see java.lang.Exception
 * @see BibliotecaUsuario#jogar(String)
 */
public class JogoNaoInstaladoException extends Exception {

    /**
     * Constrói uma nova exceção {@code JogoNaoInstaladoException} com a mensagem de detalhe especificada.
     *
     * @param message a mensagem descrevendo o motivo específico da falha (jogo ausente ou não instalado)
     */
    public JogoNaoInstaladoException(String message) {
        super(message);
    }
}