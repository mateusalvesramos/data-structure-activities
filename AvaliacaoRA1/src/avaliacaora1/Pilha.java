package avaliacaora1;

// Classe para armazenar hist�rico de solicita��es de servi�o.
public class Pilha {
    private No topo; // Atributo para representar o �ltimo (topo) elemento da pilha.
    private No primeiro; // Atributo para representar o primeiro elemento da pilha.
            
    // M�todo construtor da pilha.
    public void Pilha(){
        this.topo = null;
    }

// Verifica se a pilha est� vazia.
    public boolean isVazia(){
        return topo == null;
    }
    
    public void empilhar(Solicitacao nova_solicitacao){
        // Cria um novo objeto n� para incluir a solicita��o a ser adicionada.
        No novo_no = new No(nova_solicitacao);
        
        // Verifica se pilha est� vazia, caso esteja, insere o primeiro elemento.
        if(isVazia()){
            // Define o novo elemento a ser inserido na pilha como primeiro e ultimo.
            topo = primeiro = novo_no;
        }else{
            // Define o "proximo" do atual topo, como o novo elemento (no) a ser inserido na pilha.
            //ctopo.setProximo(novo_no);
            
            novo_no.setProximo(topo);
            
            // Define o topo como o novo no a ser inserido.
            topo = novo_no;
        }
        
        System.out.println("Solicita��o registrada com sucesso!");
    }
    
    public void desempilhar(){
        if(isVazia()){
            System.out.println("A pilha est� vazia!");
        }else{
            
            // Armazena a Elemento (solicita��o) a ser exclu�da para mostrar posteriormente
            Elemento removido = topo.getElemento();
            topo = topo.getProximo();
            System.out.println("A solicita��o abaixo foi removida:");
            removido.imprimir_dados();
        }
    }
    
    public void imprimir_pilha(){
        if(isVazia()){
            System.out.println("A pilha est� vazia!");
        }else{
            No atual = topo;
            
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("               Solicita��es");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            // Percorre todas as solicita��es e as imprime.
            while(atual != null){
                atual.getElemento().imprimir_dados();
                atual = atual.getProximo();
            }
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        }
    }
    
}
