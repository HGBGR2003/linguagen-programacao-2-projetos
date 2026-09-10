package br.edu.ifgoiano.aluno.henrique.gabriel;

public class Estudante {
    private String nome;
    private double dinheiro;

    public Estudante(String nome, double dinheiro) {
        this.nome = nome;
        this.dinheiro = dinheiro;
    }

    public void comprarLancheNoBandejao(double valor) {
        if (valor > this.dinheiro) {
            // Dispara nossa exceção personalizada usando 'throw'
            throw new SaldoInsuficienteException("O estudante " + this.nome +
                    " tentou almoçar por R$ " + valor + ", mas tem apenas R$ " + this.dinheiro + ".");
        }
        this.dinheiro -= valor;
        System.out.println(this.nome + " almoçou com sucesso. Saldo atual: R$ " + this.dinheiro);
    }
}
