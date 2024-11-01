package algordenacao;

import java.util.Random;

public class CountingSort {

    public static class Metricas_ordenacao {
        public long tempo_execucao;  // Em milissegundos
        public int trocas;           // Contagem de trocas
        public int iteracoes;      // Contagem de iterações
    }

    public static Metricas_ordenacao countingSort(int[] arr, int size) {
        Metricas_ordenacao metrics = new Metricas_ordenacao();
        long startTime = System.currentTimeMillis();

        int max = localiza_maximo(arr, size);
        int[] count = new int[max + 1];
        int[] output = new int[size];

        // Etapa 1: Contagem das ocorrências de cada valor
        for (int i = 0; i < size; i++) {
            count[arr[i]]++;
            metrics.iteracoes++;
        }

        // Etapa 2: Modificação do array de contagem para armazenar índices finais
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
            metrics.iteracoes++;
        }

        // Etapa 3: Construção do array de saída ordenado
        for (int i = size - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
            metrics.trocas++;
            metrics.iteracoes++;
        }

        // Copiando o array de saída ordenado de volta para o array original
        for (int i = 0; i < size; i++) {
            arr[i] = output[i];
        }

        metrics.tempo_execucao = System.currentTimeMillis() - startTime;
        return metrics;
    }

    // Função auxiliar para encontrar o valor máximo no array
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

