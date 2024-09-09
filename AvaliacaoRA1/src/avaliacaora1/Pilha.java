package avaliacaora1;

// Classe para armazenar hist�rico de solicita��es de servi�o.
public class Pilha {
    private No topo;
    
    // Verifica se a pilha est� vazia.
    public boolean isVazia(){
        return topo == null;
    }
    
    public void empilhar(Solicitacao nova_solicitacao){
        // Cria um novo objeto n� para incluir a solicita��o a ser adicionada.
        No novo_no = new No(nova_solicitacao);
        
        // Define o "proximo" do novo elemento adicionado como o topo atual.
        novo_no.setProximo(topo);
        
        // Atualiza a refer�ncia para o topo da pilha (�ltimo elemento a ser inserido).
        topo = novo_no;
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
