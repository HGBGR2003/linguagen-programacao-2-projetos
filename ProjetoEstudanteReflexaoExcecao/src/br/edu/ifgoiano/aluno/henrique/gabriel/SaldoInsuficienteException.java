package br.edu.ifgoiano.aluno.henrique.gabriel;

public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException(String mensagem) {
        super(nomeDoMetodoFormatado(mensagem));
    }

    private static String nomeDoMetodoFormatado(String msg) {
        return "[FALÊNCIA ACADÊMICA] " + msg;
    }
}
