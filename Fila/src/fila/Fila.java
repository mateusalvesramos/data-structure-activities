    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package fila;

    public class Fila {
        // Tanto o indicador do índice do 1º quanto do último elemento devem iniciar
        // em -1, ou seja, não indicam nenhum índice do array 
        private int first = -1; // Indica o índice do primeiro elemento da fila
        private int last = -1; // Infica o índice do último elemento da fila
        private int capacity = 5; // Indica a capacidade máxima do array da fila
        private int data[] = new int[capacity]; // Array que armazenará os dados da
        // fila

        // Como iniciamos o "fist" e o "last" com -1, que indicam respectivamente o 
        // índice do primeiro e do último elemento da fila, sabemos que caso ambos
        // sejam == -1, a fila está vazia.
        public boolean isEmpty(){
            return (first == -1) && (last == -1);
        }

        // Para sabermos se a fila está cheia, realizaremos a substração entre índice 
        // do último elemento e do primeiro, por fim, adicionamos 1 ao valor da diferença
        // e com isso obeteremos a quantidade de elementos presente na fila
        //. e. g. "last" = 4 e "first" = 0 == 4-0 == 4 + 1 == 5, ou seja, nesta fila
        // temos 5 lementos.

        // Por fim, comparamos se a quantidade de elementos na fila supera a capacidade
        // definida no construtor da classe.
        public boolean isFull(){
            return (last - first) + 1 == (capacity);
        }

        public void insert(int value){
            if(isFull()){
                System.out.println("A lista está cheia e com isso não porde ter "
                        + "dados inseridos");
            }
            else{

                // Aqui verificamos se o ultimo elemento não está no final da fila.
                // Caso esteja, verificamos se no ínicio/meio da fila há espaço vago
                // antes do indicador do primeiro elemento.
                if(last == (capacity - 1)){
                    // Aqui colocarmos o indicador do último elemento para o índice 0:
                    last -= capacity -1;

                    // Enquanto o índice do último elemento ("last") for diferente do que o 
                    // índice do primeiro elemento ("first"), ou seja, enquanto houver 
                    // espaço vago antes do indicador do primeiro elemento (first), fazer
                    // o acréscimo até que o indicador do último elemento ("last") encontrar
                    // o último índice vago antes do indicador do primeiro elemento ("first").
                    while(last != first){
                        last += 1;
                    }
                }

                // Caso o índicador do último elemento ("last") não estiver ao final do
                // array, é sinal de que há índices vagos à frente e com isso só temos
                // que tomar cuidado para que não seja p índice do primeiro elemento ("first")
                else{
                    last += 1;

                    /* NÃO É NECESSÁRIO REALIZAR ESTA VERIFICAÇÃO, VISTO QUE NO ÍNICIO 
                    JÁ VERIFICAMOS SE A FILA ESTÁ CHEIA

                    // Se o "last" for igual ao "fist" diminuímos um valor e permancemos
                    // no índice atual, pois a fila está cheia
                    if(last == first){
                        last -= 1;
                    }
                    */
                }

                // Inserindo o valor/dado indicado no método de inserção no índice do 
                // último elemento da fila, ou seja, aidicionando ao final da fila.
                data[last] = value;
                System.out.println("O valor " + value + " foi inserido ao final da fila!");
            }
        }

        public void remove(){
            // Se a fila não estiver vazia...
            if(!isEmpty()){
                // Guardar o valor que será removido para ser mostrado após a remoção
                int value_remove = data[first];

                // Vericando se o incador de primeiro elemento da fila está ao final
                // do array, assim como fizemos quando inserimos um novo elemento na
                // fila.
                if(first == (capacity - 1)){
                    // Aqui colocarmos o indicador para o primeiro elemento ("first") no 
                    // índice 0:
                    first -= capacity -1;
                }

                // Se não ("else"), ou seja, se o inficador "first" do primeiro 
                // elemento da fila não estiver ao fim do array, então apenas adicionar
                // um à ele, com isso colocando ele um ínfice a frente.
                first += 1;
            }
            else{
                System.out.println("A lista está vazia e com isso não pode ter dados "
                        + "removidos");
            }
        }

        public void print_queue(){

            // Se o indicador do primeiro elemento for menos que o último, ou seja,
            // o indicador do primeiro elemento estiver antes do último elemento,
            // vá imprimindo os elementos até chegar no último elemento
            if(first < last){
                for(int i = first; i <= last ; i++){
                    System.out.println(data[i]);
                }
            }

            // Se a fila tenha apenas um elemento, imprima ele.
            else if(first == last){
                System.out.println(data[first]);
            }

            // Se o primeiro elemento estiver depois do último elemento.
            else if(first > last){

                // Imprima do primeiro elemento até que se chegue ao final do array.
                for(int i = first; i < capacity - 1; i++){
                    System.out.println(data[i]);
                }

                // Se "first" estiver ao final do array
                if(first == capacity -1){

                    // Define uma variável "temp" para indicar onde está o primeiro
                    // elemento

                    int temp = first;

                    // Faz com que o indicador do primeiro elemento volte ao índice 0
                    temp -= capacity -1;

                    for(int i = temp; temp <= last; i++){
                        System.out.println(data[i]);
                    }
                }
            }
        }
    }
