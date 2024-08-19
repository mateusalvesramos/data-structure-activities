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
    
    // Temos 3 tipos de exclusões: no´início, no meio e no final da lista
    public void delete_on_list(int index){
        Node atual = first;
        int num_nodes = number_elements(); 
        
        if(num_nodes == 0){
            System.out.println("A lista está vazia! Não é possível remover elementos.");
        }
        
        else if(index > num_nodes){
            System.out.println("Digite uma posição válida, visto que a lista possui: " + num_nodes + " elementos.");
        }
        
        // Remoção no início da lista
        else if(index == 1){
            first = first.getNext();
            System.out.println("Elemento da posição " + index + " da lista foi removido com sucesso da lista!");
        }
        
        // Remoção no meio da lista
        else if(index < num_nodes){
            int num_of_node = 1;
            Node anterior = null;
            
            // Enquanto o "while" não chegar ao elemento a ser excluído...
            while(num_of_node != index + 1){
                // Se o node atual for o node da posição selecionada para ser excluída...
                if(num_of_node == index){
                    // Definir o "prócimo" do elemento anterior como o o node posteior do atual que será excluído.
                    anterior.setNext(atual.getNext());
                }
                anterior = atual;
                atual = atual.getNext();
                num_of_node++;
            }
        }
        
        // Remoção no final da lista
        else if(index == num_nodes){
            int num_of_nodes = 1;
            
            // Enquanto o "while" não chegar no elemento anterior ao elemento a ser excluído...
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
        
        while(atual.getNext() != null){
            atual = atual.getNext();
            number_of_nodes++;
        }
        
        return number_of_nodes;
    }
}
