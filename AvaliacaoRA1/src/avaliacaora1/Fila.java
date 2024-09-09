package avaliacaora1;

// Classe para representar a ordem de atendimento dos clientes.
public class Fila {
    private No primeiro;
    private No ultimo;
    
    public Fila(){
        primeiro = null;
        ultimo = null;
    }
    
    public boolean isVazia(){
        return primeiro == null;
    }
    
    // Inser��o de um novo elemento ao fim da fila.
    public void enfileirar(Atendimento novo_atendimento){
        // Cria um novo objeto n� para incluir o atendimento a ser adicionado.
        No novo_no = new No(novo_atendimento);
        
        // Caso a fila esteja vazia, adicionar novo n� e defini-lo como "primeiro" e "ultimo".
        if(isVazia()){
            primeiro = ultimo = novo_no;
            System.out.println("Atendimento registrado com sucesso!");
        }
        // Caso a lista n�o esteja vazia, adicionar ao fim da fila.
        else{
            // Define o indicador para o pr�ximo elemento do ultimo para 
            // o novo elemento adicionado da fila.
            ultimo.setProximo(novo_no);

            // Atualiza o �ltimo elemento da fila para o novo n� adicionado.
            ultimo = novo_no;
            System.out.println("Atendimento registrado com sucesso!");
        }
    }
    
    // A remo��o em uma fila ocorre a partir do primeiro elemento
    // last in, fist out.
    public void desenfileirar(){
        if(isVazia()){
            System.out.println("A fila est� vazia!");
        }else{
            // Armazena o Elemento (atendimento) a ser exclu�do para mostrar posteriormente.
            Elemento removido = primeiro.getElemento();
            
            // Atualiza o indicador para o primeiro elemento da fila, como o elemento
            // posterior ao primeiro, que ser� removido.
            primeiro = primeiro.getProximo();
            System.out.println("O atendimento abaixo foi removido com sucesso:");
            removido.imprimir_dados();
        }
    }
    
    public void imprimir_fila(){
        if(isVazia()){
            System.out.println("A fila est� vazia!");
        }else{
            No atual = primeiro;
            
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("               Atendimentos");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            // Percorre todas os atendimentos e os imprime.
            while(atual != null){
                atual.getElemento().imprimir_dados();
                atual = atual.getProximo();
            }
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        }
    }
}
