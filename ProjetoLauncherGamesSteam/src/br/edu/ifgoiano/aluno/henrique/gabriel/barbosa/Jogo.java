package br.edu.ifgoiano.aluno.henrique.gabriel.barbosa;

/**
 * Representa um jogo disponível ou adquirido na plataforma.
 * <p>
 * Armazena as informações básicas sobre o título, tais como identificador único,
 * nome/título, preço e o estado de instalação no dispositivo do usuário.
 * </p>
 *
 * @author Henrique Gabriel Barbosa
 * @version 1.0
 */
public class Jogo {

    /**
     * Identificador único do jogo no sistema.
     */
    private String id;

    /**
     * Título comercial do jogo.
     */
    private String titulo;

    /**
     * Preço do jogo em reais (R$).
     */
    private double preco;

    /**
     * Indica se o jogo está baixado e instalado localmente.
     */
    private boolean instalado;

    /**
     * Construtor para criar uma nova instância de Jogo com todos os atributos.
     *
     * @param id identificador único do jogo
     * @param titulo título ou nome do jogo
     * @param preco preço do jogo
     * @param instalado define se o jogo inicia já instalado ({@code true}) ou não ({@code false})
     */
    public Jogo(String id, String titulo, double preco, boolean instalado) {
        this.id = id;
        this.titulo = titulo;
        this.preco = preco;
        this.instalado = instalado;
    }

    /**
     * Obtém o identificador único do jogo.
     *
     * @return o identificador {@code id} do jogo
     */
    public String getId() {
        return id;
    }

    /**
     * Atualiza o identificador único do jogo.
     *
     * @param id o novo identificador a ser atribuído
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtém o título do jogo.
     *
     * @return o título do jogo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Atualiza o título do jogo.
     *
     * @param titulo o novo título do jogo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtém o preço de venda do jogo.
     *
     * @return o preço do jogo em reais (R$)
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Atualiza o preço de venda do jogo.
     *
     * @param preco o novo preço do jogo
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Verifica se o jogo está instalado no sistema local.
     *
     * @return {@code true} se o jogo estiver instalado; {@code false} caso contrário
     */
    public boolean isInstalado() {
        return instalado;
    }

    /**
     * Define o estado de instalação do jogo.
     *
     * @param instalado {@code true} para marcar como instalado, ou {@code false} caso contrário
     */
    public void setInstalado(boolean instalado) {
        this.instalado = instalado;
    }
}