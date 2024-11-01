package algordenacao;

import java.util.Random;

public class QuickSort {
    // Atributos para rastrear o n�mero de trocas e itera��es
    private static long trocas;
    private static long iteracoes;

    // M�todo principal do Quick Sort
    public static void quickSort(int[] x, int inferior, int superior) {
        if (inferior >= superior) return;

        // Particiona e obt�m a posi��o do piv�
        int pivo = particiona(x, inferior, superior);

        // Ordena as sub-arrays � esquerda e � direita do piv�
        quickSort(x, inferior, pivo - 1);
        quickSort(x, pivo + 1, superior);
    }

    // M�todo que realiza a parti��o e retorna a posi��o do piv�
    public static int particiona(int[] x, int inferior, int superior) {
        int pivo = x[inferior]; // O piv� � o primeiro elemento
        int i = inferior + 1;
        int j = superior;

        while (i <= j) {
            iteracoes++; // Conta as itera��es principais

            // Move i para a direita at� encontrar um elemento maior que o piv�
            while (i <= j && x[i] <= pivo) {
                i++;
                iteracoes++; // Itera��o do la�o interno
            }

            // Move j para a esquerda at� encontrar um elemento menor que o piv�
            while (i <= j && x[j] > pivo) {
                j--;
                iteracoes++; // Itera��o do la�o interno
            }

            // Troca os elementos se i ainda for menor que j
            if (i < j) {
                troca(x, i, j);
            }
        }

        // Coloca o piv� na posi��o correta
        troca(x, inferior, j);
        return j; // Retorna a posi��o do piv�
    }

    // M�todo para trocar dois elementos no array
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
