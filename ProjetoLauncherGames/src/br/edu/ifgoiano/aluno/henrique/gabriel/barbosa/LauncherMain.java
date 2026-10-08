package br.edu.ifgoiano.aluno.henrique.gabriel.barbosa;

public class LauncherMain {
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("       GAME LAUNCHER - Prototipo de Biblioteca Digital       ");
        System.out.println("=============================================================");
        System.out.println();

        BibliotecaUsuario biblioteca = new BibliotecaUsuario("Henrique", 150);
        System.out.printf("Usuario: %s | Saldo inicial: R$%.2f%n", biblioteca.getNomeUsuario(), biblioteca.getSaldo());
        System.out.println();

        Jogo cyberpunk = new Jogo("CP2077", "Cyberpunk 2077", 59.99, false);
        Jogo eldenRing = new Jogo("ER2022", "Elden Ring", 99.90, true);

        System.out.println("------------------------------------------------------------");
        System.out.println("CENARIO 1: Compra de jogos");
        System.out.println("------------------------------------------------------------");
        try {
            biblioteca.comprarJogo(cyberpunk);
            biblioteca.comprarJogo(eldenRing);
        } catch (SaldoInsuficienteException e) {
            System.out.println("[ERRO] " + e.getMessage());
            System.out.println("[INFO] Recarregue sua carteira para continuar comprando.");
        }

        System.out.println();

        System.out.println("------------------------------------------------------------");
        System.out.println("CENARIO 2: Jogar sem instalar");
        System.out.println("------------------------------------------------------------");
        biblioteca.getCatalogosJogos().put(eldenRing.getId(), eldenRing);
        try {
            biblioteca.jogar("ER2022");
            biblioteca.jogar("CP2077");
        } catch (JogoNaoInstaladoException e) {
            System.out.println("[ERRO] " + e.getMessage());
            System.out.println("[RECUPERACAO] Iniciando download automatico...");
            biblioteca.baixarJogo("CP2077");
            try {
                biblioteca.jogar("CP2077");
            } catch (JogoNaoInstaladoException e2) {
                System.out.println("[ERRO CRITICO] Falha mesmo apos download: " + e2.getMessage());
            }
        } finally {
            System.out.println();
            System.out.println("[FINALLY] Encerrando conexao com servidores Cloud Save...");
            System.out.println("[FINALLY] Status do usuario salvo com sucesso.");
            System.out.println("[FINALLY] Conexao encerrada.");
        }
        System.out.println();

        System.out.println("------------------------------------------------------------");
        System.out.println("CENARIO 3: Conquistas");
        System.out.println("------------------------------------------------------------");

        biblioteca.ganharConquitas("Primeira Vitoria");
        biblioteca.ganharConquitas("Explorador de Mundos");
        biblioteca.ganharConquitas("Primeira Vitoria");
        biblioteca.ganharConquitas("Caçador de Trofeus");
        biblioteca.ganharConquitas("Explorador de Mundos");

        System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.println("CENARIO 4: Historico de jogos");
        System.out.println("------------------------------------------------------------");
        try {
            biblioteca.jogar("ER2022");
            biblioteca.jogar("CP2077");
        } catch (JogoNaoInstaladoException e) {
            System.out.println("[ERRO] " + e.getMessage());
        } finally {
            System.out.println();
            System.out.println("[FINALLY] Sincronizando progresso com Cloud Save...");
            System.out.println("[FINALLY] Progresso sincronizado.");
        }
        System.out.println();
        System.out.println("Historico de jogos abertos (ordem cronologica):");
        for (int i = 0; i < biblioteca.getHistoricoJogados().size(); i++) {
            System.out.printf("  %d. %s%n", i + 1, biblioteca.getHistoricoJogados().get(i).getTitulo());
        }

        System.out.println();
        System.out.println("=============================================================");
        System.out.println("                      RESUMO FINAL                          ");
        System.out.println("=============================================================");
        System.out.printf("Usuario: %s%n", biblioteca.getNomeUsuario());
        System.out.printf("Saldo restante: R$%.2f%n", biblioteca.getSaldo());
        System.out.printf("Jogos no catalogo: %d%n", biblioteca.getCatalogosJogos().size());
        System.out.printf("Sessões jogadas: %d%n", biblioteca.getHistoricoJogados().size());
        System.out.printf("Conquistas unicas: %s%n", biblioteca.getConquistasDesbloqueadas());
        System.out.println("=============================================================");

    }
}
