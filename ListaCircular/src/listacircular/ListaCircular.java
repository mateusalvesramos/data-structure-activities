package listacircular;

public class ListaCircular {
        // Este atributo aponta para o primeiro elemento da lista
    private Node list;
    
    // Método contrutor que iniciar a lista como vazia
    public ListaCircular(){
        list = null;
    }

    //Inserindo elementos
    public void insert(int information){
        Node new_node = new Node();
        new_node.setInformation(information);
        
        if(list == null){
            list = new_node;
        }else{
            Node atual = list;
            while(atual.getNext() != list){
                atual = atual.getNext();
            }
            atual.setNext(new_node);
        }
        
        // Para novos nós a serem inseridos, definimos o próximo node como referência ao primeiro node.
        // Esta etapa é importantíssima para a lista circular!!!
        new_node.setNext(list);
    }
    
    // Imprimindo elementos da lista
    public void print_list(){
        // Verifica se a lista está vazia
        if(isEmpty()){
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("A lista está vazia! Não é possível remover elementos.");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            
            return;
        }
        
        Node atual = list;
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("                     LISTA                       ");
        
        // Tive que utilziar um do while aqui, diferentemente da lista encadeada, pois
        // Caso a lista tivesse apenas um elemento e usássemos o while normal, com a condição
        // "atual != list", este único elemento não seria impresso, visto que ele é o
        // mesmo node apontado pelo atributo "list".
        do{
            System.out.print(atual.getInformation() + " ");
            atual = atual.getNext();
        }while(atual != list);
        
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    }
    
    // Temos 3 tipos de exclusões: no início, no meio e no final da lista
    public void delete_on_list(int index){
        
        Node atual = list;
        // Variável que armazena a quatidades de nós existentes na lista
        // Fiz isso ao invés de ficar chamando o método a todo momento, na minha cabeça
        // isso irá causar mais processamento desnecessário.
        int num_nodes = number_elements(); 
        
        
        if(num_nodes == 0){
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("A lista está vazia! Não é possível remover elementos.");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        }
        
        else if(index > num_nodes){
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Digite uma posição válida, visto que a lista possui: " + num_nodes + " elementos.");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        }
        
        // Remoção no início da lista
        else if(index == 1){
            // Caso a lista tenha apenas um elemento...
            if(num_nodes == 1){
                // Tonar a lista vazia.
                list = null;
            // Caso a lista possua mais de um elemento...
            }else{
                Node last = list;
               // Laço de repetição para encontrarmos o último elemento da lista, a fim
               // de definirmos o próximo dele como o primeiro elemento.
               while(last.getNext() != list){
                   last = last.getNext();
               }
               
               // Caso a lista não tenha apenas um elemento, definir o primeiro elementos
               // da lista como o "próximo" do elemento a ser excluído
               list = list.getNext();
               
               // Agora que encontramos o último elemento da lista, podemos atualizar o
               // atributo "próximo" dele para indicar para o novo primeiro elemento da lista,
               // pois é uma lista circular.
               last.setNext(list);
            }
        }
        
        // Remoção no meio da lista
        else if(index < num_nodes){
            
            // Variável auxilixar na contagem do node atual durante o while.
            int num_of_node = 1;
            Node anterior = null;
            
            // Enquanto o "while" não chegar ao elemento a ser excluído...
            while(num_of_node != index + 1){
                // Se o node atual for o node da posição selecionada para ser excluída...
                if(num_of_node == index){
                    // Definir o "prócimo" do elemento anterior como o o node posteior do atual que será excluído.
                    anterior.setNext(atual.getNext());
                    // Apesar da IDE alertar que pode haver uma valor nulo em "anterior.setNext()", não haverá, visto que 
                    // isso só ocorrerá caso o primeiro elemento seja o elemento a ser excluído e isso já é tratado no primeiro
                    // "if" :).
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
            // Definimos o atibuto "proximo" do elemento anterior ao que queremos excluir como
            // uma referência ao primeiro elemento da lista.
            atual.setNext(list);
        }
    }
    
    // Método para contar a quantidade de elementos que há na lista. Método utilizado para verificar se  usuário
    // inseriu uma posição válida para realizar exclusão.
    public int number_elements(){
        Node atual = list;
        int number_of_nodes = 1;
        
        // Verifica se a lista está vazia. Caso esteja retorno o número 0 de elementos.
        if(isEmpty()){
            return 0;
        }
        // Se a lista possui mais de um elemento, contagem normal
        else{
            // Enquanto o atributo "próximo" do elemento atual for diferente 
            // do primeiro elemento da lista...
            while(atual.getNext() != list){
                // Pular para o próximo elemento da lista.
                atual = atual.getNext();
                // Adicionanar 1 ao contador de elementos da lista.
                number_of_nodes++;
            }
            // Se a lista possuir apenas um elemento
            if(atual == list){
                return 1;
            }
        }
        return number_of_nodes;
    }
    
    // Verifica se lista está vazia.
    public boolean isEmpty(){
        return list == null;
    }
}
