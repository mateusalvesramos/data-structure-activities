package algordenacao;

import static algordenacao.CountingSort.countingSort;
import static algordenacao.QuickSort.quickSort;
import java.util.Random;

public class AlgOrdenacao {
    public static void main(String[] args) {
        int[] tamanhosVetores = {1000, 10000, 100000, 500000, 1000000};
        Random random = new Random(42); // Seed

        // Contagem e apresenta��o dos resultados do Counting Sort
        System.out.println("-=-=-=-=-=- Counting Sort -=-=-=-=-=-");
        for (int tamanho : tamanhosVetores) {
            long tempoExecucaoTotal = 0;
            int totalTrocas = 0;
            int totalIteracoes = 0;

            System.out.println("Tamanho do vetor: " + tamanho);

            // Rodando o algoritmo 5 vezes para tirar as m�dias
            for (int i = 0; i < 5; i++) {
                int[] data = new int[tamanho];
                for (int j = 0; j < tamanho; j++) {
                    data[j] = random.nextInt(1000000); // Gera valores de no m�ximo 999999
                }

                CountingSort.Metricas_ordenacao metricas = countingSort(data, tamanho);
                tempoExecucaoTotal += metricas.tempo_execucao;
                totalTrocas += metricas.trocas;
                totalIteracoes += metricas.iteracoes;
            }

            // Calculando e exibindo a m�dia
            System.out.printf("M�dia de tempo de execu��o: %.2f ms\n", (double) tempoExecucaoTotal / 5);
            System.out.printf("M�dia de trocas: %d\n", totalTrocas / 5);
            System.out.printf("M�dia de itera��es: %d\n", totalIteracoes / 5);
            System.out.println();
        }

        // Contagem e apresenta��o dos resultados do Quick Sort
        System.out.println("-=-=-=-=-=- Quick Sort -=-=-=-=-=-");
        
        for (int tamanho : tamanhosVetores) {
            long tempoExecucaoTotal = 0;
            long totalTrocas = 0;
            long totalIteracoes = 0;
            int rodadas = 5;

            System.out.println("Tamanho do vetor: " + tamanho);

            for (int i = 0; i < rodadas; i++) {
                int[] data = new int[tamanho]; // Criar o vetor do mesmo tamanho
                for (int j = 0; j < tamanho; j++) {
                    data[j] = random.nextInt(1000000); // Preenchendo da mesma forma que no Counting Sort
                }

                // Resetando as m�tricas
                QuickSort.setTrocas(0);
                QuickSort.setIteracoes(0);
                
                // Medindo tempo de execu��o
                long inicio = System.nanoTime();
                quickSort(data, 0, data.length - 1);
                long fim = System.nanoTime();

                // Acumular os resultados
                tempoExecucaoTotal += (fim - inicio);
                totalTrocas += QuickSort.getTrocas();
                totalIteracoes += QuickSort.getIteracoes();
            }

            // Calcular m�dias
            double tempoMedio = (double) tempoExecucaoTotal / rodadas;
            long mediaTrocas = totalTrocas / rodadas;
            long mediaIteracoes = totalIteracoes / rodadas;

            // Exibir resultados no mesmo formato
            System.out.printf("M�dia de tempo de execu��o: %.2f ms\n", tempoMedio / 1_000_000); // Convertendo ns para ms
            System.out.printf("M�dia de trocas: %d\n", mediaTrocas);
            System.out.printf("M�dia de itera��es: %d\n", mediaIteracoes);
            System.out.println();
        }
    }
}