package avaliacaora2;

public class No {
    // Defi��o de atributos.
    private char caractere; // Caracter de a->z, 0->9.
    private No filho_esquerdo; // Ponteiro para a sub�rvore � esquerda.
    private No filho_direito; // Ponteiro para a sub�rvore � direita.
    
    public No(char caractere){
        this.caractere = caractere;
        filho_esquerdo = null;
        filho_direito = null;
    }
    
    // M�todo que devolve o caractere definido no n�.
    public char getCaractere(){
        return this.caractere;
    }
    
    // M�todo que retorna a sub�revore � esquerda do n�.
    public No getEsquerdo(){
        return this.filho_esquerdo;
    }
    
    // M�todo que retorna a sub�revore � direita do n�.
    public No getDireito(){
        return this.filho_direito;
    }
    
    // M�todo que permite definir o caractere do n�.
    public void setCaractere(char caractere){
        this.caractere = caractere;
    }
    
    // M�todo que permite definir a sub�rvore � direita do n�.
    public void setDireito(No filho_direito){
        this.filho_direito = filho_direito;
    }
    
    // // M�todo que permite definir a sub�rvore � esquerda do n�.
    public void setEsquerdo(No filho_esquerdo){
        this.filho_esquerdo = filho_esquerdo;
    }
}
