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
            // Define a "cabeca" (primeiro elemento) como o nÃ³ recÃ©m criado.
            cabeca = novo_no;
        // Se a lista não estiver vazia...
        }else{
            // Utilizamos o primeiro elemento da lista pra percorre-la
            No atual = cabeca;
            
            // Enquanto nÃ£o encontrarmos o Ãºltimo elemento da lista...
            while(atual.getProximo() != null){
                // Pula para o prÃ³ximo elemento.
                atual = atual.getProximo();
            }
            // Ao final, definimos o "proximo" do Ãºltimo elemento como o nÃ³ recÃ©m criado
            atual.setProximo(novo_no);
            
            // Definimos a cauda como sendo o nÃ³ recÃ©m criado, pois em ambos os
            // casos este serÃ¡ o Ãºltimo nÃ³.
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

    // Temos 3 tipos de exclusÃµes: no inÃ­cio, no meio e no final da lista
    public void remove(int posicao){
        
        No atual = cabeca;
        int tamanho_lista = quantidade_elementos(); 
        
        
        if(tamanho_lista == 0){
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("A lista está vazia! Não é possí­vel remover elementos.");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        }
        
        // Caso a posição fornecida seja maior do que o tamanho da lista ou a posição inserida seja menor que 1, que é o primeiro elemento da lista
        else if(posicao > tamanho_lista || posicao < 1){
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Digite uma posição válida, visto que a lista possui: " + tamanho_lista + " elementos.");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        }
        
        // Remoção no iní­cio da lista
        else if(posicao == 1){
            // A cabeca agora aponta para o segundo elemento.
            cabeca = cabeca.getProximo();
            
            // O ponteiro para o nó anterior agora é null.
            cabeca.setAnterior(null);
        }
        
        // Remoção no final da lista.
        else if(posicao == tamanho_lista){
            // Para isso, como já sabemos o último elemento da lista, podemos usa-lo.
            No anterior = cauda.getAnterior();
            
            // Definimos que a partir de agora o nó anterior ao excluído é
            // a cauda da lista.
            cauda = anterior;
            
            // A referência para o próximo nó, agora é definido como null.
            cauda.setProximo(null);
            
        }
        
        // Remoção no meio da lista
        else if(posicao > 1 && posicao < tamanho_lista){
            // Percorrendo a lista até encontrar o nó a ser removido.
            // Iniciando do índice 1.
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
        
        // Verifica se a lista estÃ¡ vazia. Caso esteja retorno o nÃºmero 0 de elementos.
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
