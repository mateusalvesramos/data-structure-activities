package lista;

public class Lista {
    private Node first;
    
    public Lista(){
        first = null;
    }
    
    public void insert(int information){
        Node new_node = new Node();
        new_node.setInformation(information);
        
        if(first == null){
            first = new_node;
        }else{
            Node atual = first;
            while(atual.getNext() != null){
                atual = atual.getNext();
            }
            atual.setNext(new_node);
        }
    }
    
    public void print_list(){
        Node atual = first;
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("                     LISTA                       ");
        while(atual != null){
            System.out.print(atual.getInformation() + " ");
            atual = atual.getNext();
        }
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    }
    
    // Temos 3 tipos de exclus�es: no�in�cio, no meio e no final da lista
    public void delete_on_list(int index){
        
        Node atual = first;
        int num_nodes = number_elements(); 
        
        
        if(num_nodes == 0){
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("A lista est� vazia! N�o � poss�vel remover elementos.");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        }
        
        else if(index > num_nodes){
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Digite uma posi��o v�lida, visto que a lista possui: " + num_nodes + " elementos.");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        }
        
        // Remo��o no in�cio da lista
        else if(index == 1){
            first = first.getNext();
        }
        
        // Remo��o no meio da lista
        else if(index < num_nodes){
            int num_of_node = 1;
            Node anterior = null;
            
            // Enquanto o "while" n�o chegar ao elemento a ser exclu�do...
            while(num_of_node != index + 1){
                // Se o node atual for o node da posi��o selecionada para ser exclu�da...
                if(num_of_node == index){
                    // Definir o "pr�cimo" do elemento anterior como o o node posteior do atual que ser� exclu�do.
                    anterior.setNext(atual.getNext());
                    // Apesar da IDE alertar que pode haver uma valor nulo em "anterior.setNext()", n�o haver�, visto que 
                    // isso s� ocorrer� caso o primeiro elemento seja o elemento a ser exclu�do e isso j� � tratado no primeiro
                    // "if" :).
                }
                anterior = atual;
                atual = atual.getNext();
                num_of_node++;
            }
        }
        
        // Remo��o no final da lista
        else if(index == num_nodes){
            int num_of_nodes = 1;
            
            // Enquanto o "while" n�o chegar no elemento anterior ao elemento a ser exclu�do...
            while(num_of_nodes != (index - 1)){
                atual = atual.getNext();
                num_of_nodes++;
            }
            atual.setNext(null);
        }
    }
    
    public int number_elements(){
        Node atual = first;
        int number_of_nodes = 1;
        
        // Verifica se a lista est� vazia. Caso esteja retorno o n�mero 0 de elementos.
        if(isEmpty()){
            return 0;
        }else{
            while(atual.getNext() != null){
                atual = atual.getNext();
                number_of_nodes++;
            }
        }
        return number_of_nodes;
    }
    
    public boolean isEmpty(){
        return first == null;
    }
}
