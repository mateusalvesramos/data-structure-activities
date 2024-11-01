package algordenacao;

import java.util.Random;

public class Vetor {
    private int seed = 123;
    Random random = new Random(seed);
    
   // M�todo para gerar um vetor aleat�rio com uma seed
    public int[] vetor_aleatorio(int tamanho_vetor) {
        int[] array = new int[tamanho_vetor];
        for (int i = 0; i < tamanho_vetor; i++) {
            array[i] = random.nextInt(1000000) + 1; // Valores de 0 at� tamanho - 1
        }
        return array;
    }
}
