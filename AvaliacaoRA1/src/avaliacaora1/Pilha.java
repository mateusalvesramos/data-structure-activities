package avaliacaora1;

// Classe para armazenar histórico de solicitações de serviço.
public class Pilha {
    private No topo;
    
    // Verifica se a pilha está vazia.
    public boolean isVazia(){
        return topo == null;
    }
    
    public void empilhar(Solicitacao nova_solicitacao){
        // Cria um novo objeto nó para incluir a solicitação a ser adicionada.
        No novo_no = new No(nova_solicitacao);
        
        // Define o "proximo" do novo elemento adicionado como o topo atual.
        novo_no.setProximo(topo);
        
        // Atualiza a referência para o topo da pilha (último elemento a ser inserido).
        topo = novo_no;
        System.out.println("Solicitação registrada com sucesso!");
    }
    
    public void desempilhar(){
        if(isVazia()){
            System.out.println("A pilha está vazia!");
        }else{
            
            // Armazena a Elemento (solicitação) a ser excluída para mostrar posteriormente
            Elemento removido = topo.getElemento();
            topo = topo.getProximo();
            System.out.println("A solicitação abaixo foi removida:");
            removido.imprimir_dados();
        }
    }
    
    public void imprimir_pilha(){
        if(isVazia()){
            System.out.println("A pilha está vazia!");
        }else{
            No atual = topo;
            
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("               Solicitações");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            // Percorre todas as solicitações e as imprime.
            while(atual != null){
                atual.getElemento().imprimir_dados();
                atual = atual.getProximo();
            }
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        }
    }
    
}
