package br.edu.ifgoiano.aluno.henrique.gabriel;

/**
 * Classe principal de teste para demonstrar o tratamento de exceções personalizadas.
 * Simula a tentativa de compra de refeição por um {@link Estudante} com saldo inferior ao valor
 * necessário, capturando e tratando a exceção {@link SaldoInsuficienteException}.
 *
 * @author Henrique Gabriel Barbosa Guida Rodrigues
 * @version 1.0
 * @see Estudante
 * @see SaldoInsuficienteException
 */
public class Main {

    /**
     * Construtor padrão da classe Main.
     */
    public Main() {
    }

    /**
     * Ponto de entrada do programa de teste de exceções.
     * Instancia um estudante e executa o bloco {@code try-catch} para tratamento da falha de saldo.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        Estudante estudante = new Estudante("Maria", 5);
        try {
            estudante.comprarLancheNoBandejao(15);
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }
    }
}