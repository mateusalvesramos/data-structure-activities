package tabela_hash;

import java.util.Random;

public class Tabela {
    private int tamanho_tabela;
    private int qtde_comparacoes;
    private Registro tabela[];
    private Random aleatorio = new Random(1234); // Criando um objeto de random e passando a seed
    private int colisoes; // Inicializando o contador de colisões
    
    // Vetores para armazenar 5 valores eleatórios que foram inseridos, por meio de cada função Hash
    // Isso será utilizado para realizar a contagem de tempo das buscas
    private int buscas_modulo[] = new int[5];
    private int buscas_multiplicacao[] = new int[5];
    private int buscas_dobramento[] = new int[5];
    
    // Inteiros para armazenar o tamanho de cada um dos vetores acima, visto que não possível
    // utilizar o comando length.
    // Na verdade estas variáveis armazenam índice do último valor adicionado. No caso de um
    // vetor preenchido, o valor será 4, índice do último valor inserido.
    private int length_modulo;
    private int length_multilplicacao;
    private int length_dobramento;
    
    // Criação de objeto de FuncoesHash para que possamos chamar as funções Hash
    FuncoesHash funcoes = new FuncoesHash();
    
    public Tabela(int tamanho_tabela){
        this.tamanho_tabela = tamanho_tabela;
        tabela = new Registro[tamanho_tabela]; // Inicializando a tabela Hash de acordo com o tamanho informado
    }
    
    // Método para realizar a inserção nso vetores de valores aleatórios inseridos para busca
    public void inserir_vetor(int chave, int vetor[], int length){
        if(length < 4){
            vetor[length]= chave;
            length++;
        }
    }
    
    // Método para geração de códigos de registros randômicos
    public int codigo_aleatorio(){        
        // Aqui retornamos um número entre 10000000 e 999999999.
        // O valor passado para argumento no "nextInt()" é o limite (999999999) 
        // do valor randômico e o valor somado (10000000) é o valor mínimo gerado.
        return aleatorio.nextInt(999999999) + 10000000;
    }
    
    // A seguir, um método de inserção para cada função Hash criada acima
    
    public void inserir_modulo(int qtde_elementos/*, CSVWriter csvWriter*/){
        // Iniciando a contagem de tempo
        long tempoInicio = System.nanoTime();
        for(int i = 0; i < qtde_elementos; i++){
            int chave = codigo_aleatorio();
            int posicao = funcoes.hash_modulo(chave, tamanho_tabela);
            
            // Armazenando valores para futuras buscas
            // inserir_vetor(chave, buscas_modulo, length_modulo);
            
            if(tabela[posicao] == null){
                tabela[posicao] = new Registro(chave);
            }else{ // Aqui ocorreu uma colisão
                // Colisão - inserir de forma ordenada
                colisoes++;
                Registro atual = tabela[posicao];
                Registro anterior = null;
                
                // Criando um novo Nó para iserir na tabela
                Registro novoRegistro = new Registro(chave);

                // Percorre a lista encadeada para encontrar a posição correta
                // Enquanto o Nó atual for diferente de null (final da lista) e
                // o Nó atual possui o código de registro menos do que o código
                // do registro que iremos adicionar...
                while(atual != null && atual.getCodigo() < chave) {
                    anterior = atual;
                    atual = atual.getProximo();
                }
                // O While para quando encontrar um valor igual ou maior que 
                // o código do registro a ser adicionado.

                if (anterior == null) {
                    // Inserção no início da lista
                    novoRegistro.setProximo(tabela[posicao]);
                    tabela[posicao] = novoRegistro;
                } else {
                    // Inserção no meio ou no final da lista
                    anterior.setProximo(novoRegistro);
                    novoRegistro.setProximo(atual);
                }
            }
        }
        // Finalizando a contagem de tempo
        long tempoFim = System.nanoTime();
        
        // Calculando o intervalo de tempo e converte para segundos
        double duracao = (tempoFim - tempoInicio) / 1_000_000_000.0;
        
        System.out.println(String.format("Tabela de registros, com tamanho %d, preenchida com sucesso a partir da função Hash de resto ou módulo com %d elementos", tamanho_tabela, qtde_elementos));
        System.out.println("O total de colisões é " + colisoes);
        System.out.println("Tempo de execução: " + duracao + " segundos");
        //csvWriter.escreverLinha(tamanho_tabela, qtde_elementos, "Modulo", colisoes, duracao);
        System.out.println("\n");
    }
    
    public void inserir_multiplicacao(int qtde_elementos/*, CSVWriter csvWriter*/){
        // Iniciando a contagem de tempo
        long tempoInicio = System.nanoTime();
        for(int i = 0; i < qtde_elementos; i++){
            int chave = codigo_aleatorio();
            
            // Armazenando valores para futuras buscas
            // inserir_vetor(chave, buscas_multiplicacao, length_multilplicacao);
            
            int posicao = funcoes.hash_multiplicacao(chave, tamanho_tabela);
            if(tabela[posicao] == null){
                tabela[posicao] = new Registro(chave);
            }else{ // Aqui ocorreu uma colisão
                // Colisão - inserir de forma ordenada
                colisoes++;
                Registro atual = tabela[posicao];
                Registro anterior = null;
                
                // Criando um novo Nó para iserir na tabela
                Registro novoRegistro = new Registro(chave);

                // Percorre a lista encadeada para encontrar a posição correta
                // Enquanto o Nó atual for diferente de null (final da lista) e
                // o Nó atual possui o código de registro menos do que o código
                // do registro que iremos adicionar...
                while(atual != null && atual.getCodigo() < chave) {
                    anterior = atual;
                    atual = atual.getProximo();
                }
                // O While para quando encontrar um valor igual ou maior que 
                // o código do registro a ser adicionado.

                if (anterior == null) {
                    // Inserção no início da lista
                    // Neste caso o loop While não foi executado e a lista não
                    // possui elementos
                    novoRegistro.setProximo(tabela[posicao]);
                    tabela[posicao] = novoRegistro;
                } else {
                    // Inserção no meio ou no final da lista
                    anterior.setProximo(novoRegistro);
                    novoRegistro.setProximo(atual);
                }
            }
        }
        // Finalizando a contagem de tempo
        long tempoFim = System.nanoTime();
        
        // Calculando o intervalo de tempo e converte para segundos
        double duracao = (tempoFim - tempoInicio) / 1_000_000_000.0;
        
        System.out.println(String.format("Tabela de registros, com tamanho %d, preenchida com sucesso a partir da função Hash de multiplição com %d elementos", tamanho_tabela, qtde_elementos));
        System.out.println("O total de colisões é " + colisoes);
        System.out.println("Tempo de execução: " + duracao + " segundos");
        //csvWriter.escreverLinha(tamanho_tabela, qtde_elementos, "Multiplicacao", colisoes, duracao);
        System.out.println("\n");
    }
    
    public void inserir_dobramento(int qtde_elementos/*, CSVWriter csvWriter*/){
        // Iniciando a contagem de tempo
        long tempoInicio = System.nanoTime();
        for(int i = 0; i < qtde_elementos; i++){
            int chave = codigo_aleatorio();
            int posicao = funcoes.hash_dobramento(chave, tamanho_tabela);
            
            // Armazenando valores para futuras buscas
            // inserir_vetor(chave, buscas_dobramento, length_dobramento);
            
            if(tabela[posicao] == null){
                tabela[posicao] = new Registro(chave);
            }else{ // Aqui ocorreu uma colisão
                // Colisão - inserir de forma ordenada
                colisoes++;
                Registro atual = tabela[posicao];
                Registro anterior = null;
                
                // Criando um novo Nó para iserir na tabela
                Registro novoRegistro = new Registro(chave);

                // Percorre a lista encadeada para encontrar a posição correta
                // Enquanto o Nó atual for diferente de null (final da lista) e
                // o Nó atual possui o código de registro menos do que o código
                // do registro que iremos adicionar...
                while(atual != null && atual.getCodigo() < chave) {
                    anterior = atual;
                    atual = atual.getProximo();
                }
                // O While para quando encontrar um valor igual ou maior que 
                // o código do registro a ser adicionado.

                if (anterior == null) {
                    // Inserção no início da lista
                    novoRegistro.setProximo(tabela[posicao]);
                    tabela[posicao] = novoRegistro;
                } else {
                    // Inserção no meio ou no final da lista
                    anterior.setProximo(novoRegistro);
                    novoRegistro.setProximo(atual);
                }
            }
        }
        // Finalizando a contagem de tempo
        long tempoFim = System.nanoTime();
        
        // Calculando o intervalo de tempo e converte para segundos
        double duracao = (tempoFim - tempoInicio) / 1_000_000_000.0;
        
        System.out.println(String.format("Tabela de registros, com tamanho %d, preenchida com sucesso a partir da função Hash de dobramento com %d elementos.", tamanho_tabela, qtde_elementos));
        System.out.println("O total de colisões é " + colisoes);
        System.out.println("Tempo de execução: " + duracao + " segundos");
        //csvWriter.escreverLinha(tamanho_tabela, qtde_elementos, "Dobramento", colisoes, duracao);
        System.out.println("\n");
    }
    
    public void buscar_modulo(int chave){
        qtde_comparacoes = 0; // Resetando a qntde de comparações
        long inicio = System.nanoTime();
        int posicao = funcoes.hash_modulo(chave, tamanho_tabela);
        Registro encontrado = tabela[posicao];
        
        while(encontrado != null && encontrado.getCodigo() != chave){
            qtde_comparacoes++;
            encontrado = encontrado.getProximo();
        }
        
        // Convertendo nanosegundos para milisegundos
        double duracao = (System.nanoTime() - inicio);
        
        // Verificando se o item realmente foi encontrado (!= null)
        if(encontrado != null){
            System.out.println("O código do registro encontrado é: " + encontrado.imprimirCodigo());
        }else{
            System.out.println("Registro com o código " + chave + " não encontrado.");
        }
        
        System.out.println("Total de comparações: " + qtde_comparacoes);
        System.out.println("Tempo de busca (ns): " + duracao);
        System.out.println("\n");
    }
    
    public void buscar_multiplicacao(int chave){
        qtde_comparacoes = 0; // Resetando a qntde de comparações
        long inicio = System.nanoTime();
        int posicao = funcoes.hash_multiplicacao(chave, tamanho_tabela);
        Registro encontrado = tabela[posicao];
        
        while(encontrado != null && encontrado.getCodigo() != chave){
            qtde_comparacoes++;
            encontrado = encontrado.getProximo();
        }
        
        double duracao = (System.nanoTime() - inicio);
        
        // Verificando se o item realmente foi encontrado (!= null)
        if(encontrado != null){
            System.out.println("O código do registro encontrado é: " + encontrado.imprimirCodigo());
        }else{
            System.out.println("Registro com o código " + chave + " não encontrado.");
        }
        System.out.println("Total de comparações: " + qtde_comparacoes);
        System.out.println("Tempo de busca (ns): " + duracao);
        System.out.println("\n");
    }
    
    public void buscar_dobramento(int chave){
        qtde_comparacoes = 0; // Resetando a qntde de comparações
        long inicio = System.nanoTime();
        int posicao = funcoes.hash_dobramento(chave, tamanho_tabela);
        Registro encontrado = tabela[posicao];
        
        while(encontrado != null && encontrado.getCodigo() != chave){
            qtde_comparacoes++;
            encontrado = encontrado.getProximo(); 
        }
        double duracao = (System.nanoTime() - inicio);
        
        // Verificando se o item realmente foi encontrado (!= null)
        if(encontrado != null){
            System.out.println("O código do registro encontrado é: " + encontrado.imprimirCodigo());
        }else{
            System.out.println("Registro com o código " + chave + " não encontrado.");
        }
        
        System.out.println("Total de comparações: " + qtde_comparacoes);
        System.out.println("Tempo de busca (ns): " + duracao);
        System.out.println("\n");
    }
    
    public int[] getVetorModulo(){
        return buscas_modulo;
    }
    
    public int[] getVetorMultiplicacao(){
        return buscas_multiplicacao;
    }
    
    public int[] getVetordobramento(){
        return buscas_dobramento;
    }
    
    public void imprimir_tabela() {
    System.out.println("Conteúdo da Tabela Hash:");
    for (int i = 0; i < tamanho_tabela; i++) {
        System.out.print("Posição " + i + ": ");
        Registro atual = tabela[i];

        if (atual == null) {
            System.out.println("NULL");
        } else {
            // Percorrer a lista encadeada e imprimir todos os registros nesta posição
            while (atual != null) {
                System.out.print(atual.imprimirCodigo() + " -> ");
                atual = atual.getProximo();
            }
            System.out.println("NULL"); // Indica o final da lista encadeada
        }
    }
}
}
