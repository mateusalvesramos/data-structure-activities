package algordenacao;

import java.util.Random;

public class CountingSort {

    public static class Metricas_ordenacao {
        public long tempo_execucao;  // Em milissegundos
        public int trocas;           // Contagem de trocas
        public int iteracoes;      // Contagem de itera��es
    }

    public static Metricas_ordenacao countingSort(int[] arr, int size) {
        Metricas_ordenacao metrics = new Metricas_ordenacao();
        long startTime = System.currentTimeMillis();

        int max = localiza_maximo(arr, size);
        int[] count = new int[max + 1];
        int[] output = new int[size];

        // Etapa 1: Contagem das ocorr�ncias de cada valor
        for (int i = 0; i < size; i++) {
            count[arr[i]]++;
            metrics.iteracoes++;
        }

        // Etapa 2: Modifica��o do array de contagem para armazenar �ndices finais
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
            metrics.iteracoes++;
        }

        // Etapa 3: Constru��o do array de sa�da ordenado
        for (int i = size - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
            metrics.trocas++;
            metrics.iteracoes++;
        }

        // Copiando o array de sa�da ordenado de volta para o array original
        for (int i = 0; i < size; i++) {
            arr[i] = output[i];
        }

        metrics.tempo_execucao = System.currentTimeMillis() - startTime;
        return metrics;
    }

    // Fun��o auxiliar para encontrar o valor m�ximo no array
    private static int localiza_maximo(int[] arr, int size) {
        int max = arr[0];
        for (int i = 1; i < size; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}

