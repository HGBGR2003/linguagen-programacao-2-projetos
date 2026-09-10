package br.edu.ifgoiano.aluno.henrique.gabriel;

public class Main {
    static void main() {
        Estudante estudante = new Estudante("Maria", 5);
        try {
            estudante.comprarLancheNoBandejao(15);
        }catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }
    }
}

