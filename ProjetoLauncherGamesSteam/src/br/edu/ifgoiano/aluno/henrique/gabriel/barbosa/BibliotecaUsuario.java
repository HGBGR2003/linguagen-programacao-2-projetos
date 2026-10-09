package br.edu.ifgoiano.aluno.henrique.gabriel.barbosa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Representa a biblioteca pessoal de jogos de um usuário na plataforma.
 * <p>
 * Gerencia o saldo do usuário, catálogo de jogos adquiridos, histórico de jogos
 * executados e as conquistas desbloqueadas.
 * </p>
 *
 * @author Henrique Gabriel Barbosa
 * @version 1.0
 */
public class BibliotecaUsuario {

    /**
     * Saldo disponível na conta do usuário para a compra de novos jogos.
     */
    private double saldo;

    /**
     * Nome de identificação do usuário.
     */
    private String nomeUsuario;

    /**
     * Catálogo contendo os jogos adquiridos pelo usuário, indexados pelo seu identificador único.
     */
    private Map<String, Jogo> catalogosJogos;

    /**
     * Lista cronológica de jogos executados pelo usuário.
     */
    private List<Jogo> historicoJogados;

    /**
     * Conjunto de conquistas únicas desbloqueadas pelo usuário.
     */
    private Set<String> conquistasDesbloqueadas;

    /**
     * Construtor para inicializar uma nova biblioteca de usuário com saldo inicial e coleções vazias.
     *
     * @param nomeUsuario o nome do usuário proprietário da biblioteca
     * @param saldo o saldo inicial disponível para compras
     */
    public BibliotecaUsuario(String nomeUsuario, double saldo) {
        this.nomeUsuario = nomeUsuario;
        this.saldo = saldo;
        this.catalogosJogos = new HashMap<>();
        this.historicoJogados = new ArrayList<>();
        this.conquistasDesbloqueadas = new HashSet<>();
    }

    /**
     * Realiza a compra de um jogo caso o usuário possua saldo suficiente.
     * <p>
     * Se a transação for bem-sucedida, o valor do jogo é deduzido do saldo e o
     * jogo é adicionado ao catálogo do usuário.
     * </p>
     *
     * @param jogo o objeto {@link Jogo} a ser comprado
     * @throws SaldoInsuficienteException se o saldo atual for menor do que o preço do jogo
     */
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

    /**
     * Inicia a execução de um jogo da biblioteca.
     * <p>
     * Valida se o jogo está presente no catálogo e se encontra instalado antes de adicioná-lo
     * ao histórico de jogos executados.
     * </p>
     *
     * @param idJogo o identificador único do jogo a ser jogado
     * @throws JogoNaoInstaladoException se o jogo não existir na biblioteca ou se não estiver instalado
     */
    public void jogar(String idJogo) throws JogoNaoInstaladoException {
        Jogo jogo = catalogosJogos.get(idJogo);

        if (jogo == null) {
            throw new JogoNaoInstaladoException(
                    "Jogo com id '" + idJogo + "' nao encontrado na biblioteca.");
        }

        if (!jogo.isInstalado()) {
            throw new JogoNaoInstaladoException("O jogo '" + jogo.getTitulo() + "' (id: " + idJogo
                    + ") nao esta instalado. Faça o download primeiro.");
        }

        historicoJogados.add(jogo);
        System.out.printf("[JOGAR] Iniciando '%s'... Boa jogatina!%n", jogo.getTitulo());
    }

    /**
     * Registra uma nova conquista obtida pelo usuário.
     * <p>
     * Como a estrutura interna utiliza um {@link Set}, conquistas duplicadas não são adicionadas novamente.
     * </p>
     *
     * @param nomeConquista o nome ou descrição da conquista a ser desbloqueada
     */
    public void ganharConquitas(String nomeConquista) {
        boolean adicionandoConquista = conquistasDesbloqueadas.add(nomeConquista);
        if (adicionandoConquista) {
            System.out.printf("[CONQUISTA] Nova conquista desbloqueada: '%s'!%n", nomeConquista);
        } else {
            System.out.printf("[CONQUISTA] '%s' ja foi desbloqueada anteriormente. "
                    + "O Set nao permite duplicatas.%n", nomeConquista);
        }
        System.out.println("  Conquistas atuais: " + conquistasDesbloqueadas);
    }

    /**
     * Realiza o download e a instalação de um jogo presente no catálogo do usuário.
     *
     * @param idJogo o identificador único do jogo que deve ser baixado e instalado
     */
    public void baixarJogo(String idJogo) {
        Jogo jogo = catalogosJogos.get(idJogo);
        if (jogo != null) {
            System.out.printf("[DOWNLOAD] Baixando e instalando '%s'...%n", jogo.getTitulo());
            System.out.printf("[DOWNLOAD] '%s' instalado com sucesso!%n", jogo.getTitulo());
            jogo.setInstalado(true);
        } else {
            System.out.printf("[DOWNLOAD] Jogo com id '%s' nao encontrado no catalogo.%n", idJogo);
        }
    }

    /**
     * Obtém o saldo financeiro atual do usuário.
     *
     * @return o valor do saldo disponível em reais (R$)
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Obtém o nome de identificação do usuário.
     *
     * @return o nome do usuário
     */
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    /**
     * Obtém o mapa de jogos adquiridos pelo usuário.
     *
     * @return um {@link Map} onde as chaves são os IDs dos jogos e os valores são as instâncias de {@link Jogo}
     */
    public Map<String, Jogo> getCatalogosJogos() {
        return catalogosJogos;
    }

    /**
     * Obtém a lista com o histórico de jogos que foram executados.
     *
     * @return uma {@link List} contendo os objetos {@link Jogo} executados
     */
    public List<Jogo> getHistoricoJogados() {
        return historicoJogados;
    }

    /**
     * Obtém o conjunto de todas as conquistas desbloqueadas até o momento.
     *
     * @return um {@link Set} contendo os nomes das conquistas desbloqueadas
     */
    public Set<String> getConquistasDesbloqueadas() {
        return conquistasDesbloqueadas;
    }
}