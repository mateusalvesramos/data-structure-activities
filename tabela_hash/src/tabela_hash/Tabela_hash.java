package tabela_hash;

public class Tabela_hash {

    public static void main(String[] args) {
        // Inicializando o escritor de CSV
        // CSVWriter csvWriter = new CSVWriter("resultados_tabela_hash.csv");

        // Definindo tamanhos das tabelas e quantidades de elementos
        int[] tamanhosTabelas = {500000, 750000, 999999};
        int[] quantidadesElementos = {1000000, 5000000, 10000000};
        
        // Capturando valores para teste de busca
        int[] valores_buscas = new int[5];
        Tabela vetor = new Tabela(1);
        for(int i = 0; i < 5; i++){
            valores_buscas[i] = vetor.codigo_aleatorio();
        }
        

        // Para cada tamanho de tabela, executa os testes
        for (int tamanho : tamanhosTabelas) {
            for (int qtdeElementos : quantidadesElementos) {
                
                // Tabela com fun��o hash por m�todo do m�dulo
                Tabela tabelaModulo = new Tabela(tamanho);
                tabelaModulo.inserir_modulo(qtdeElementos/*, csvWriter*/);
                for(int i = 0; i < 5; i++){
                    tabelaModulo.buscar_modulo(valores_buscas[i]);
                }

                // Tabela com fun��o hash por m�todo da multiplica��o
                Tabela tabelaMultiplicacao = new Tabela(tamanho);
                tabelaMultiplicacao.inserir_multiplicacao(qtdeElementos/*, csvWriter*/);
                for(int i = 0; i < 5; i++){
                    tabelaMultiplicacao.buscar_multiplicacao(valores_buscas[i]);
                }

                // Tabela com fun��o hash por m�todo de dobramento
                Tabela tabelaDobramento = new Tabela(tamanho);
                tabelaDobramento.inserir_dobramento(qtdeElementos/*, csvWriter*/);
                for(int i = 0; i < 5; i++){
                    tabelaDobramento.buscar_dobramento(valores_buscas[i]);
                }
            }
        }

        System.out.println("Processo conclu�do.");
    }
    
}
