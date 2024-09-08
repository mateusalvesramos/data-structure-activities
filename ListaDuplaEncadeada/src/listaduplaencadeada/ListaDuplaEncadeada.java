/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaduplaencadeada;

/**
 *
 * @author r.alves10
 */
public class ListaDuplaEncadeada {
    private No cabeca;
    private No cauda;
    
    public ListaDuplaEncadeada(){
        cabeca = null;
        cauda = null;
    }
    
    public void inserir(int informacao){
        No novo_no = new No();
        novo_no.setInformacao(informacao);
        
        // Se a lista estiver vazia...
        if(isVazia()){
            // Define a "cabeca" (primeiro elemento) como o nó recém criado.
            cabeca = novo_no;
        // Se a lista n�o estiver vazia...
        }else{
            // Utilizamos o primeiro elemento da lista pra percorre-la
            No atual = cabeca;
            
            // Enquanto não encontrarmos o último elemento da lista...
            while(atual.getProximo() != null){
                // Pula para o próximo elemento.
                atual = atual.getProximo();
            }
            // Ao final, definimos o "proximo" do último elemento como o nó recém criado
            atual.setProximo(novo_no);
            
            // Definimos a cauda como sendo o nó recém criado, pois em ambos os
            // casos este será o último nó.
            cauda = novo_no;
        }
    }
    
    
    public void imprimir(){
        No atual = cabeca;
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("                     LISTA                       ");
        while(atual != null){
            System.out.print(atual.getInformacao() + " ");
            atual = atual.getProximo();
        }
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    }

    // Temos 3 tipos de exclusões: no início, no meio e no final da lista
    public void remove(int posicao){
        
        No atual = cabeca;
        int tamanho_lista = quantidade_elementos(); 
        
        
        if(tamanho_lista == 0){
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("A lista est� vazia! N�o � poss�vel remover elementos.");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        }
        
        // Caso a posi��o fornecida seja maior do que o tamanho da lista ou a posi��o inserida seja menor que 1, que � o primeiro elemento da lista
        else if(posicao > tamanho_lista || posicao < 1){
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Digite uma posi��o v�lida, visto que a lista possui: " + tamanho_lista + " elementos.");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        }
        
        // Remo��o no in�cio da lista
        else if(posicao == 1){
            // A cabeca agora aponta para o segundo elemento.
            cabeca = cabeca.getProximo();
            
            // O ponteiro para o n� anterior agora � null.
            cabeca.setAnterior(null);
        }
        
        // Remo��o no final da lista.
        else if(posicao == tamanho_lista){
            // Para isso, como j� sabemos o �ltimo elemento da lista, podemos usa-lo.
            No anterior = cauda.getAnterior();
            
            // Definimos que a partir de agora o n� anterior ao exclu�do �
            // a cauda da lista.
            cauda = anterior;
            
            // A refer�ncia para o pr�ximo n�, agora � definido como null.
            cauda.setProximo(null);
            
        }
        
        // Remo��o no meio da lista
        else if(posicao > 1 && posicao < tamanho_lista){
            // Percorrendo a lista at� encontrar o n� a ser removido.
            // Iniciando do �ndice 1.
            for(int i = 1; i < posicao; i++){
                atual = atual.getProximo();
            }
            
            No anterior = atual.getAnterior();
            No proximo = atual.getProximo();
            
            anterior.setProximo(proximo);
            proximo.setAnterior(anterior);
        }
    }
    
    public int quantidade_elementos(){
        No atual = cabeca;
        int contador_de_nos = 1;
        
        // Verifica se a lista está vazia. Caso esteja retorno o número 0 de elementos.
        if(isVazia()){
            return 0;
        }else{
            while(atual.getProximo() != null){
                atual = atual.getProximo();
                contador_de_nos++;
            }
        }
        return contador_de_nos;
    }

    public boolean isVazia(){
        return cabeca == null;
    }
}
