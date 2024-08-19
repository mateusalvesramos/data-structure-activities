package listacircular;

public class ListaCircular {
        // Este atributo aponta para o primeiro elemento da lista
    private Node list;
    
    // M�todo contrutor que iniciar a lista como vazia
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
        
        // Para novos n�s a serem inseridos, definimos o pr�ximo node como refer�ncia ao primeiro node.
        // Esta etapa � important�ssima para a lista circular!!!
        new_node.setNext(list);
    }
    
    // Imprimindo elementos da lista
    public void print_list(){
        // Verifica se a lista est� vazia
        if(isEmpty()){
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("A lista est� vazia! N�o � poss�vel remover elementos.");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            
            return;
        }
        
        Node atual = list;
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("                     LISTA                       ");
        
        // Tive que utilziar um do while aqui, diferentemente da lista encadeada, pois
        // Caso a lista tivesse apenas um elemento e us�ssemos o while normal, com a condi��o
        // "atual != list", este �nico elemento n�o seria impresso, visto que ele � o
        // mesmo node apontado pelo atributo "list".
        do{
            System.out.print(atual.getInformation() + " ");
            atual = atual.getNext();
        }while(atual != list);
        
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    }
    
    // Temos 3 tipos de exclus�es: no in�cio, no meio e no final da lista
    public void delete_on_list(int index){
        
        Node atual = list;
        // Vari�vel que armazena a quatidades de n�s existentes na lista
        // Fiz isso ao inv�s de ficar chamando o m�todo a todo momento, na minha cabe�a
        // isso ir� causar mais processamento desnecess�rio.
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
            // Caso a lista tenha apenas um elemento...
            if(num_nodes == 1){
                // Tonar a lista vazia.
                list = null;
            // Caso a lista possua mais de um elemento...
            }else{
                Node last = list;
               // La�o de repeti��o para encontrarmos o �ltimo elemento da lista, a fim
               // de definirmos o pr�ximo dele como o primeiro elemento.
               while(last.getNext() != list){
                   last = last.getNext();
               }
               
               // Caso a lista n�o tenha apenas um elemento, definir o primeiro elementos
               // da lista como o "pr�ximo" do elemento a ser exclu�do
               list = list.getNext();
               
               // Agora que encontramos o �ltimo elemento da lista, podemos atualizar o
               // atributo "pr�ximo" dele para indicar para o novo primeiro elemento da lista,
               // pois � uma lista circular.
               last.setNext(list);
            }
        }
        
        // Remo��o no meio da lista
        else if(index < num_nodes){
            
            // Vari�vel auxilixar na contagem do node atual durante o while.
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
            // Definimos o atibuto "proximo" do elemento anterior ao que queremos excluir como
            // uma refer�ncia ao primeiro elemento da lista.
            atual.setNext(list);
        }
    }
    
    // M�todo para contar a quantidade de elementos que h� na lista. M�todo utilizado para verificar se  usu�rio
    // inseriu uma posi��o v�lida para realizar exclus�o.
    public int number_elements(){
        Node atual = list;
        int number_of_nodes = 1;
        
        // Verifica se a lista est� vazia. Caso esteja retorno o n�mero 0 de elementos.
        if(isEmpty()){
            return 0;
        }
        // Se a lista possui mais de um elemento, contagem normal
        else{
            // Enquanto o atributo "pr�ximo" do elemento atual for diferente 
            // do primeiro elemento da lista...
            while(atual.getNext() != list){
                // Pular para o pr�ximo elemento da lista.
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
    
    // Verifica se lista est� vazia.
    public boolean isEmpty(){
        return list == null;
    }
}
