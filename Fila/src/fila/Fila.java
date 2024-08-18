    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package fila;

    public class Fila {
        // Tanto o indicador do índice do 1º quanto do último elemento devem iniciar
        // em -1, ou seja, não indicam nenhum índice do array 
        private int first = 0; // Indica o índice do primeiro elemento da fila
        private int last = -1; // Infica o índice do último elemento da fila
        private int capacity = 5; // Indica a capacidade máxima do array da fila
        private int data[] = new int[capacity]; // Array que armazenará os dados da fila
        private int size = 0; // Variável que armazenará a quantidade de elementos na fila
        

        // Método que verifica se a lista está vazia
        public boolean isEmpty(){
            // Retornará true caso a fila contenha 0 elementos.
            return size == 0;
        }

        public boolean isFull(){
            // retormará true caso a quantidade de elementos da fila seja igual ao limite do tamanho da fila.
            return size == (capacity - 1);
        }

        public void insert(int value){
            if(isFull()){
                System.out.println("A fila está cheia, não podendo adicionar o valor: " + value);
            }else{
                // Avança um índice no vertor, mas caso o vetor chegue no final, por exemplo
                // índice 5, que utrapasse a capacidade de 5, cujo ínidice máximo é 4 (0, 1, 2, 3 e 4)
                // calcula o módulo (% resto) da divisão pelo novo índice pela quantidade máxima de
                // elementos do vetor. Caso os valores sejam iguais, esta operação dará 0, fazendo
                // com que se retorne ao início do vetor, possibilitando uma fila circular.
                last = (last + 1) % (capacity - 1);
                data[last] = value; // Adiciona o valor na última posição da fila.
                size++; // Acrescenta 1 ao nosso contador de quantidade de elementos.
                
                System.out.println("O valor " + value + " foi adicionando com sucesso!");
            }
        }
        
        // Remove o primeiro elemento da fila.
        public void remove(){
            if(isEmpty()){
                System.out.println("A fila está vazia!");
            }else{
                int deleted_data = data[first];
                
                // Mesma lógica da inserção. Avança um índice do vetor, sendo que
                // caso já esteja no último ínidice do vetor, se retorne à posição 0 (início do vetor),
                // garantindo uma lista circular.
                first = (first + 1) % (capacity - 1);
                size--; // Diminui 1 ao contador de quantidade de elementos.
                
                System.out.println("O valor inteiro " + deleted_data + " foi excluído da fila com sucesso!");
            }
        }

        public void print_queue(){
            if(isEmpty()){
                System.out.println("A fila está vazia!");
            }else{
                for(int i = 0; i < size; i++){
                    System.out.println(data[(first + i) % (capacity - 1)]);
                }
            }
        }
    }
