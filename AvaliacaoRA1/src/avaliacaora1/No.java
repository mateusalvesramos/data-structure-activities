package avaliacaora1;

public class No {
    // O atributo elemento aceita tanto objetos do tipo Solicitacao quanto do tipo
    // atendimento.
    private Elemento elemento;    
    private No proximo;
    
    public No(Elemento elemento){
        this.elemento = elemento;
        proximo = null;
    }
    
    public Elemento getElemento(){
        return elemento;
    }
    
    public No getProximo(){
        return proximo;
    }
    
    public void setElemento(Elemento elemento){
        this.elemento = elemento;
    }
    
    public void setProximo(No proximo){
        this.proximo = proximo;
    }
}
