package br.edu.ifgoiano.aluno.henrique.gabriel;

import java.lang.reflect.Constructor;

public class InspetorReflexao {
    static void main() {
        try {
            // Obtenção da classe de forma dinâmica pela String de nome
            Class<?> classeEstudante = Class.forName("Estudante");

            System.out.println("=== Inspecionando a Classe: " + classeEstudante.getName() + " ===");

            // 1. Obtendo construtores
            System.out.println("\n--- Construtores Detectados ---");
            for (Constructor<?> c : classeEstudante.getDeclaredConstructors()) {
                System.out.println("Construtor encontrado com " + c.getParameterCount() + " parâmetros.");
                System.out.println("Tipos de parâmetros (em ordem): " + java.util.Arrays.toString(c.getParameterTypes()));
                System.out.println("-------------------------");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("[ERRO DE REFLEXÃO] A classe Estudante não foi localizada!");
        }
    }
}

