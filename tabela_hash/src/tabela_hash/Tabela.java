package tabela_hash;

import java.util.Random;

public class Tabela {
    private int tamanho_tabela;
    private int qtde_comparacoes;
    private Registro tabela[];
    private Random aleatorio = new Random(12345); // Criando um objeto de random e passando a seed
    private int colisoes; // Inicializando o contador de colis�es
    
    // Cria��o de objeto de FuncoesHash para que possamos chamar as fun��es Hash
    FuncoesHash funcoes = new FuncoesHash();
    
    public Tabela(int tamanho_tabela){
        this.tamanho_tabela = tamanho_tabela;
        tabela = new Registro[tamanho_tabela]; // Inicializando a tabela Hash de acordo com o tamanho informado
    }
    
    // M�todo para gera��o de c�digos de registros rand�micos
    public int codigo_aleatorio(){        
        // Aqui retornamos um n�mero entre 10000000 e 999999999.
        // O valor passado para argumento no "nextInt()" � o limite (999999999) 
        // do valor rand�mico e o valor somado (10000000) � o valor m�nimo gerado.
        return aleatorio.nextInt(999999999) + 10000000;
    }
    
    // A seguir, um m�todo de inser��o para cada fun��o Hash criada acima
    
    public void inserir_modulo(int qtde_elementos){
        for(int i = 0; i < qtde_elementos; i++){
            int chave = codigo_aleatorio();
            int posicao = funcoes.hash_modulo(chave, tamanho_tabela);
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
        System.out.println(String.format("Tabela de registros, com tamanho %d, preenchida com sucesso a partir da fun��o Hash de resto ou m�dulo", tamanho_tabela));
        System.out.println("O total de colis�es � " + colisoes);
    }
    
    public void inserir_multiplicacao(int qtde_elementos){
        for(int i = 0; i < qtde_elementos; i++){
            int chave = codigo_aleatorio();
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
        System.out.println(String.format("Tabela de registros, com tamanho %d, preenchida com sucesso a partir da fun��o Hash de multipli��o", tamanho_tabela));
        System.out.println("O total de colis�es � " + colisoes);
    }
    
    public void inserir_dobramento(int qtde_elementos){
        for(int i = 0; i < qtde_elementos; i++){
            int chave = codigo_aleatorio();
            int posicao = funcoes.hash_dobramento(chave, tamanho_tabela);
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
        System.out.println(String.format("Tabela de registros, com tamanho %d, preenchida com sucesso a partir da fun��o Hash de dobramento", tamanho_tabela));
        System.out.println("O total de colis�es � " + colisoes);
    }
    
    public void buscar_modulo(int chave){
        int posicao = funcoes.hash_modulo(chave, tamanho_tabela);
        Registro encontrado = tabela[posicao];
        while(encontrado.getCodigo() != chave){
            encontrado = encontrado.getProximo();
            qtde_comparacoes++;
        }
        System.out.println("O c�digo do registro encontrado �: " + encontrado.imprimirCodigo());
        System.out.println("Total de compara��es: " + qtde_comparacoes);
    }
    
    public void buscar_multiplicacao(int chave){
        int posicao = funcoes.hash_multiplicacao(chave, tamanho_tabela);
        Registro encontrado = tabela[posicao];
        while(encontrado.getCodigo() != chave){
            encontrado = encontrado.getProximo();
            qtde_comparacoes++;
        }
        System.out.println("O c�digo do registro encontrado �: " + encontrado.imprimirCodigo());
        System.out.println("Total de compara��es: " + qtde_comparacoes);
    }
    
    public void buscar_dobramento(int chave){
        int posicao = funcoes.hash_dobramento(chave, tamanho_tabela);
        Registro encontrado = tabela[posicao];
        while(encontrado.getCodigo() != chave){
            encontrado = encontrado.getProximo();
            qtde_comparacoes++;
        }
        System.out.println("O c�digo do registro encontrado �: " + encontrado.imprimirCodigo());
        System.out.println("Total de compara��es: " + qtde_comparacoes);
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
