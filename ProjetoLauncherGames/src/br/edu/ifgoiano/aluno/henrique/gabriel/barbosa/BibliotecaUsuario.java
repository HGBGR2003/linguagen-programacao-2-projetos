package br.edu.ifgoiano.aluno.henrique.gabriel.barbosa;

import java.util.*;

public class BibliotecaUsuario {
    private double saldo;
    private String nomeUsuario;
    private Map<String, Jogo> catalogosJogos;
    private List<Jogo> historicoJogados;
    private Set<String> conquistasDesbloqueadas;

    public BibliotecaUsuario(String nomeUsuario, double saldo) {
        this.nomeUsuario = nomeUsuario;
        this.saldo = saldo;
        this.catalogosJogos = new HashMap<>();
        this.historicoJogados = new ArrayList<>();
        this.conquistasDesbloqueadas = new HashSet<>();
    }

    public void comprarJogo(Jogo jogo) throws SaldoInsuficienteException {
        if (saldo < jogo.getPreco()) {
            throw new SaldoInsuficienteException(
                    String.format("Saldo insuficiente! Saldo atual: R$%.2f | Preco de '%s': R$%.2f",
                            saldo, jogo.getTitulo(), jogo.getPreco()));
        }

        saldo -= jogo.getPreco();
        catalogosJogos.put(jogo.getId(), jogo);
        System.out.printf("[COMPRA] '%s' adquirido com sucesso! Saldo restante: R$%.2f%n",
                jogo.getTitulo(), saldo);
    }

    public void jogar(String idJogo) throws JogoNaoInstaladoException {
        Jogo jogo = catalogosJogos.get(idJogo);

        if (jogo.equals(null)) {
            throw new JogoNaoInstaladoException(
                    "Jogo com id '" + idJogo + "' nao encontrado na biblioteca.");
        }

        if (!jogo.isInstalado()) {
            throw new JogoNaoInstaladoException("O jogo '" + jogo.getTitulo() + "' (id: " + idJogo
                    + ") nao esta instalado. Faca o download primeiro.");
        }

        historicoJogados.add(jogo);
        System.out.printf("[JOGAR] Iniciando '%s'... Boa jogatina!%n", jogo.getTitulo());
    }

    public void ganharConquita(String nomeConquista){

    }

    public void baixarJogo(String idJogo){

    }

    public double getSaldo() {
        return saldo;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public Map<String, Jogo> getCatalogosJogos() {
        return catalogosJogos;
    }

    public List<Jogo> getHistoricoJogados() {
        return historicoJogados;
    }

    public Set<String> getConquistasDesbloqueadas() {
        return conquistasDesbloqueadas;
    }
}
