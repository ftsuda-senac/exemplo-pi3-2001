/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.exemplo;

/**
 *
 * @author fernando.tsuda
 */
public class Principal {

    public static void main(String[] args) {

        System.out.println("================================================================================");
        System.out.println("Exemplo PI3");
        System.out.println("================================================================================");
        for (int i = 0; i < 20; i++) {
            System.out.println("Hello World");
        }
        for (int i = 0; i < 100; i++) {
            System.out.println("Valor i: " + i);
        }
        vetor();
        impressao();
    }

    static int[] vetor() {
        int[] vetor = new int[7];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = i;
        }

        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
        return vetor;
    }

    static void impressao() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Foram realizadas " + i + " alterações até o momento");
        }
    }

}
