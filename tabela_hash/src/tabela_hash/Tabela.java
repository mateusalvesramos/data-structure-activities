package tabela_hash;

import java.util.Random;

public class Tabela {
    private int tamanho_tabela;
    private int qtde_comparacoes;
    private Registro tabela[];
    private Random aleatorio = new Random(1234); // Criando um objeto de random e passando a seed
    private int colisoes; // Inicializando o contador de colis�es
    
    // Vetores para armazenar 5 valores eleat�rios que foram inseridos, por meio de cada fun��o Hash
    // Isso ser� utilizado para realizar a contagem de tempo das buscas
    private int buscas_modulo[] = new int[5];
    private int buscas_multiplicacao[] = new int[5];
    private int buscas_dobramento[] = new int[5];
    
    // Inteiros para armazenar o tamanho de cada um dos vetores acima, visto que n�o poss�vel
    // utilizar o comando length.
    // Na verdade estas vari�veis armazenam �ndice do �ltimo valor adicionado. No caso de um
    // vetor preenchido, o valor ser� 4, �ndice do �ltimo valor inserido.
    private int length_modulo;
    private int length_multilplicacao;
    private int length_dobramento;
    
    // Cria��o de objeto de FuncoesHash para que possamos chamar as fun��es Hash
    FuncoesHash funcoes = new FuncoesHash();
    
    public Tabela(int tamanho_tabela){
        this.tamanho_tabela = tamanho_tabela;
        tabela = new Registro[tamanho_tabela]; // Inicializando a tabela Hash de acordo com o tamanho informado
    }
    
    // M�todo para realizar a inser��o nso vetores de valores aleat�rios inseridos para busca
    public void inserir_vetor(int chave, int vetor[], int length){
        if(length < 4){
            vetor[length]= chave;
            length++;
        }
    }
    
    // M�todo para gera��o de c�digos de registros rand�micos
    public int codigo_aleatorio(){        
        // Aqui retornamos um n�mero entre 10000000 e 999999999.
        // O valor passado para argumento no "nextInt()" � o limite (999999999) 
        // do valor rand�mico e o valor somado (10000000) � o valor m�nimo gerado.
        return aleatorio.nextInt(999999999) + 10000000;
    }
    
    // A seguir, um m�todo de inser��o para cada fun��o Hash criada acima
    
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
            }else{ // Aqui ocorreu uma colis�o
                // Colis�o - inserir de forma ordenada
                colisoes++;
                Registro atual = tabela[posicao];
                Registro anterior = null;
                
                // Criando um novo N� para iserir na tabela
                Registro novoRegistro = new Registro(chave);

                // Percorre a lista encadeada para encontrar a posi��o correta
                // Enquanto o N� atual for diferente de null (final da lista) e
                // o N� atual possui o c�digo de registro menos do que o c�digo
                // do registro que iremos adicionar...
                while(atual != null && atual.getCodigo() < chave) {
                    anterior = atual;
                    atual = atual.getProximo();
                }
                // O While para quando encontrar um valor igual ou maior que 
                // o c�digo do registro a ser adicionado.

                if (anterior == null) {
                    // Inser��o no in�cio da lista
                    novoRegistro.setProximo(tabela[posicao]);
                    tabela[posicao] = novoRegistro;
                } else {
                    // Inser��o no meio ou no final da lista
                    anterior.setProximo(novoRegistro);
                    novoRegistro.setProximo(atual);
                }
            }
        }
        // Finalizando a contagem de tempo
        long tempoFim = System.nanoTime();
        
        // Calculando o intervalo de tempo e converte para segundos
        double duracao = (tempoFim - tempoInicio) / 1_000_000_000.0;
        
        System.out.println(String.format("Tabela de registros, com tamanho %d, preenchida com sucesso a partir da fun��o Hash de resto ou m�dulo com %d elementos", tamanho_tabela, qtde_elementos));
        System.out.println("O total de colis�es � " + colisoes);
        System.out.println("Tempo de execu��o: " + duracao + " segundos");
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
            }else{ // Aqui ocorreu uma colis�o
                // Colis�o - inserir de forma ordenada
                colisoes++;
                Registro atual = tabela[posicao];
                Registro anterior = null;
                
                // Criando um novo N� para iserir na tabela
                Registro novoRegistro = new Registro(chave);

                // Percorre a lista encadeada para encontrar a posi��o correta
                // Enquanto o N� atual for diferente de null (final da lista) e
                // o N� atual possui o c�digo de registro menos do que o c�digo
                // do registro que iremos adicionar...
                while(atual != null && atual.getCodigo() < chave) {
                    anterior = atual;
                    atual = atual.getProximo();
                }
                // O While para quando encontrar um valor igual ou maior que 
                // o c�digo do registro a ser adicionado.

                if (anterior == null) {
                    // Inser��o no in�cio da lista
                    // Neste caso o loop While n�o foi executado e a lista n�o
                    // possui elementos
                    novoRegistro.setProximo(tabela[posicao]);
                    tabela[posicao] = novoRegistro;
                } else {
                    // Inser��o no meio ou no final da lista
                    anterior.setProximo(novoRegistro);
                    novoRegistro.setProximo(atual);
                }
            }
        }
        // Finalizando a contagem de tempo
        long tempoFim = System.nanoTime();
        
        // Calculando o intervalo de tempo e converte para segundos
        double duracao = (tempoFim - tempoInicio) / 1_000_000_000.0;
        
        System.out.println(String.format("Tabela de registros, com tamanho %d, preenchida com sucesso a partir da fun��o Hash de multipli��o com %d elementos", tamanho_tabela, qtde_elementos));
        System.out.println("O total de colis�es � " + colisoes);
        System.out.println("Tempo de execu��o: " + duracao + " segundos");
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
            }else{ // Aqui ocorreu uma colis�o
                // Colis�o - inserir de forma ordenada
                colisoes++;
                Registro atual = tabela[posicao];
                Registro anterior = null;
                
                // Criando um novo N� para iserir na tabela
                Registro novoRegistro = new Registro(chave);

                // Percorre a lista encadeada para encontrar a posi��o correta
                // Enquanto o N� atual for diferente de null (final da lista) e
                // o N� atual possui o c�digo de registro menos do que o c�digo
                // do registro que iremos adicionar...
                while(atual != null && atual.getCodigo() < chave) {
                    anterior = atual;
                    atual = atual.getProximo();
                }
                // O While para quando encontrar um valor igual ou maior que 
                // o c�digo do registro a ser adicionado.

                if (anterior == null) {
                    // Inser��o no in�cio da lista
                    novoRegistro.setProximo(tabela[posicao]);
                    tabela[posicao] = novoRegistro;
                } else {
                    // Inser��o no meio ou no final da lista
                    anterior.setProximo(novoRegistro);
                    novoRegistro.setProximo(atual);
                }
            }
        }
        // Finalizando a contagem de tempo
        long tempoFim = System.nanoTime();
        
        // Calculando o intervalo de tempo e converte para segundos
        double duracao = (tempoFim - tempoInicio) / 1_000_000_000.0;
        
        System.out.println(String.format("Tabela de registros, com tamanho %d, preenchida com sucesso a partir da fun��o Hash de dobramento com %d elementos.", tamanho_tabela, qtde_elementos));
        System.out.println("O total de colis�es � " + colisoes);
        System.out.println("Tempo de execu��o: " + duracao + " segundos");
        //csvWriter.escreverLinha(tamanho_tabela, qtde_elementos, "Dobramento", colisoes, duracao);
        System.out.println("\n");
    }
    
    public void buscar_modulo(int chave){
        qtde_comparacoes = 0; // Resetando a qntde de compara��es
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
            System.out.println("O c�digo do registro encontrado �: " + encontrado.imprimirCodigo());
        }else{
            System.out.println("Registro com o c�digo " + chave + " n�o encontrado.");
        }
        
        System.out.println("Total de compara��es: " + qtde_comparacoes);
        System.out.println("Tempo de busca (ns): " + duracao);
        System.out.println("\n");
    }
    
    public void buscar_multiplicacao(int chave){
        qtde_comparacoes = 0; // Resetando a qntde de compara��es
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
            System.out.println("O c�digo do registro encontrado �: " + encontrado.imprimirCodigo());
        }else{
            System.out.println("Registro com o c�digo " + chave + " n�o encontrado.");
        }
        System.out.println("Total de compara��es: " + qtde_comparacoes);
        System.out.println("Tempo de busca (ns): " + duracao);
        System.out.println("\n");
    }
    
    public void buscar_dobramento(int chave){
        qtde_comparacoes = 0; // Resetando a qntde de compara��es
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
            System.out.println("O c�digo do registro encontrado �: " + encontrado.imprimirCodigo());
        }else{
            System.out.println("Registro com o c�digo " + chave + " n�o encontrado.");
        }
        
        System.out.println("Total de compara��es: " + qtde_comparacoes);
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
    System.out.println("Conte�do da Tabela Hash:");
    for (int i = 0; i < tamanho_tabela; i++) {
        System.out.print("Posi��o " + i + ": ");
        Registro atual = tabela[i];

        if (atual == null) {
            System.out.println("NULL");
        } else {
            // Percorrer a lista encadeada e imprimir todos os registros nesta posi��o
            while (atual != null) {
                System.out.print(atual.imprimirCodigo() + " -> ");
                atual = atual.getProximo();
            }
            System.out.println("NULL"); // Indica o final da lista encadeada
        }
    }
}
}
