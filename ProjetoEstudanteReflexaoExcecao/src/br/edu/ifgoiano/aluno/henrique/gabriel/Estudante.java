package br.edu.ifgoiano.aluno.henrique.gabriel;

/**
 * Representa um Estudante no sistema acadêmico, gerenciando seu nome
 * e saldo financeiro para despesas diárias, como refeições no bandejão.
 *
 * @author Henrique Gabriel Barbosa Guida Rodrigues
 * @version 1.0
 * @see SaldoInsuficienteException
 */
public class Estudante {

    /**
     * Nome completo do estudante.
     */
    private String nome;

    /**
     * Saldo financeiro disponível do estudante em reais (R$).
     */
    private double dinheiro;

    /**
     * Construtor da classe Estudante.
     *
     * @param nome     Nome do estudante.
     * @param dinheiro Saldo financeiro inicial em reais.
     */
    public Estudante(String nome, double dinheiro) {
        this.nome = nome;
        this.dinheiro = dinheiro;
    }

    /**
     * Realiza a compra de uma refeição no bandejão universitário.
     * Debita o valor do saldo do estudante caso haja recursos suficientes;
     * caso contrário, interrompe a operação lançando uma exceção de saldo insuficiente.
     *
     * @param valor Custo da refeição em reais (R$).
     * @throws SaldoInsuficienteException Se o valor da refeição for superior ao saldo disponível.
     */
    public void comprarLancheNoBandejao(double valor) {
        if (valor > this.dinheiro) {
            // Dispara a exceção personalizada
            throw new SaldoInsuficienteException("O estudante " + this.nome +
                    " tentou almoçar por R$ " + valor + ", mas tem apenas R$ " + this.dinheiro + ".");
        }
        this.dinheiro -= valor;
        System.out.println(this.nome + " almoçou com sucesso. Saldo atual: R$ " + this.dinheiro);
    }

    /**
     * Obtém o nome do estudante.
     *
     * @return O nome do estudante.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Define ou atualiza o nome do estudante.
     *
     * @param nome Novo nome para o estudante.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o saldo financeiro atual do estudante em reais.
     *
     * @return O valor em dinheiro disponível.
     */
    public double getDinheiro() {
        return this.dinheiro;
    }

    /**
     * Define ou atualiza o saldo financeiro do estudante.
     *
     * @param dinheiro Novo saldo em reais.
     */
    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }
}