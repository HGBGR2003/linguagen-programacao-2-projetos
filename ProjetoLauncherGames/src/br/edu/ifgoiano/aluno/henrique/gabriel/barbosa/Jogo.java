package br.edu.ifgoiano.aluno.henrique.gabriel.barbosa;

public class Jogo {
    private String id;
    private String titulo;
    private double preco;
    private boolean instalado;

    public Jogo(String id, String titulo, double preco, boolean instalado){
        this.id = id;
        this.titulo = titulo;
        this.preco = preco;
        this.instalado = instalado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPreco() {
        return preco;
    }

    public boolean isInstalado() {
        return instalado;
    }

    public void setInstalado(boolean instalado) {
        this.instalado = instalado;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
