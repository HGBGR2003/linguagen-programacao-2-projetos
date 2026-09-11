package br.edu.ifgoiano.aluno.henrique.gabriel;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Utilitário de inspeção dinâmica de classes em tempo de execução via Java Reflection API.
 * Realiza a análise e exibição detalhada de metadados da classe {@code Estudante},
 * incluindo construtores, atributos (campos), métodos, tipos de dados e modificadores de visibilidade.
 *
 * @author Henrique Gabriel Barbosa Guida Rodrigues
 * @version 1.0
 */
public class InspetorReflexao {

    /**
     * Construtor padrão da classe InspetorReflexao.
     */
    public InspetorReflexao() {
    }

    /**
     * Ponto de entrada do programa que executa a inspeção reflexiva na classe {@code Estudante}.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        try {
            // Obtenção da classe de forma dinâmica pelo nome totalmente qualificado
            Class<?> classeEstudante = Class.forName("br.edu.ifgoiano.aluno.henrique.gabriel.Estudante");

            System.out.println("=== Inspecionando a Classe: " + classeEstudante.getName() + " ===");

            // 1. Obtendo Construtores
            System.out.println("\n--- Construtores Detectados ---");
            for (Constructor<?> c : classeEstudante.getDeclaredConstructors()) {
                System.out.println("Construtor encontrado com " + c.getParameterCount() + " parâmetros.");
                System.out.println("Tipos de parâmetros (em ordem): " + Arrays.toString(c.getParameterTypes()));
                System.out.println("-------------------------");
            }

            // 2. Obtendo Atributos (Campos)
            System.out.println("\n--- Variáveis Encontradas ---");
            for (Field f : classeEstudante.getDeclaredFields()) {
                int modificadoresVariaveis = f.getModifiers();
                String visibilidade = Modifier.isPublic(modificadoresVariaveis) ? "Público"
                        : Modifier.isPrivate(modificadoresVariaveis) ? "Privado"
                        : Modifier.isProtected(modificadoresVariaveis) ? "Protegido"
                        : "Pacote";

                System.out.println("Variável Encontrada: " + f.getName());
                System.out.println("Tipo de dado: " + f.getType().getSimpleName());
                System.out.println("Visibilidade: " + visibilidade);
                System.out.println("-------------------------");
            }

            // 3. Obtendo Métodos
            System.out.println("\n--- Métodos Encontrados ---");
            for (Method m : classeEstudante.getDeclaredMethods()) {
                int modificadoresMetodos = m.getModifiers();
                String visibilidade = Modifier.isPublic(modificadoresMetodos) ? "Público"
                        : Modifier.isPrivate(modificadoresMetodos) ? "Privado"
                        : Modifier.isProtected(modificadoresMetodos) ? "Protegido"
                        : "Pacote";

                System.out.println("Método encontrado: " + m.getName());
                System.out.println("Quantidade de argumentos: " + m.getParameterCount());
                System.out.println("Tipo de retorno: " + m.getReturnType().getSimpleName());
                System.out.println("Visibilidade: " + visibilidade);
                System.out.println("-------------------------");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("[ERRO DE REFLEXÃO] A classe Estudante não foi localizada!");
        }
    }
}