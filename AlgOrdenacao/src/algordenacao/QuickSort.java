package algordenacao;

import java.util.Random;

public class QuickSort {
    // Atributos para rastrear o número de trocas e iterações
    private static long trocas;
    private static long iteracoes;

    // Método principal do Quick Sort
    public static void quickSort(int[] x, int inferior, int superior) {
        if (inferior >= superior) return;

        // Particiona e obtém a posição do pivô
        int pivo = particiona(x, inferior, superior);

        // Ordena as sub-arrays à esquerda e à direita do pivô
        quickSort(x, inferior, pivo - 1);
        quickSort(x, pivo + 1, superior);
    }

    // Método que realiza a partição e retorna a posição do pivô
    public static int particiona(int[] x, int inferior, int superior) {
        int pivo = x[inferior]; // O pivô é o primeiro elemento
        int i = inferior + 1;
        int j = superior;

        while (i <= j) {
            iteracoes++; // Conta as iterações principais

            // Move i para a direita até encontrar um elemento maior que o pivô
            while (i <= j && x[i] <= pivo) {
                i++;
                iteracoes++; // Iteração do laço interno
            }

            // Move j para a esquerda até encontrar um elemento menor que o pivô
            while (i <= j && x[j] > pivo) {
                j--;
                iteracoes++; // Iteração do laço interno
            }

            // Troca os elementos se i ainda for menor que j
            if (i < j) {
                troca(x, i, j);
            }
        }

        // Coloca o pivô na posição correta
        troca(x, inferior, j);
        return j; // Retorna a posição do pivô
    }

    // Método para trocar dois elementos no array
    public static void troca(int[] x, int i, int j) {
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
        trocas++; // Conta cada troca realizada
    }
    
    public static void setTrocas(long trocas){
        QuickSort.trocas = trocas;
    }
    
    public static void setIteracoes(long iteracoes){
        QuickSort.iteracoes = iteracoes;
    }
    
    public static long getTrocas(){
        return QuickSort.trocas;
    }
    
    public static long getIteracoes(){
        return QuickSort.iteracoes;
    }
}
