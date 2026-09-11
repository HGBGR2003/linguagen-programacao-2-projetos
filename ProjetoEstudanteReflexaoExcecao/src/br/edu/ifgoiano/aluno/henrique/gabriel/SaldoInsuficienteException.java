package br.edu.ifgoiano.aluno.henrique.gabriel;

/**
 * Exceção personalizada de regra de negócio lançada quando um estudante tenta
 * realizar uma compra ou débito sem possuir saldo financeiro suficiente.
 * Estende {@link RuntimeException}, sendo uma exceção do tipo não-checada (unchecked).
 *
 * @author Henrique Gabriel Barbosa Guida Rodrigues
 * @version 1.0
 * @see RuntimeException
 * @see Estudante
 */
public class SaldoInsuficienteException extends RuntimeException {

    /**
     * Construtor da exceção personalizada.
     * Formata a mensagem de erro recebida aplicando o prefixo de alerta da aplicação.
     *
     * @param mensagem Descrição do motivo da insuficiência de saldo.
     */
    public SaldoInsuficienteException(String mensagem) {
        super(nomeDoMetodoFormatado(mensagem));
    }

    /**
     * Método utilitário privado para formatação e padronização da mensagem de erro da exceção.
     *
     * @param msg Mensagem original do erro.
     * @return Mensagem formatada com a tag de erro.
     */
    private static String nomeDoMetodoFormatado(String msg) {
        return "[FALÊNCIA ACADÊMICA] " + msg;
    }
}