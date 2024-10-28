package avaliacaora2;

public class No {
    // Defição de atributos.
    private char caractere; // Caracter de a->z, 0->9.
    private No filho_esquerdo; // Ponteiro para a subárvore à esquerda.
    private No filho_direito; // Ponteiro para a subárvore à direita.
    
    public No(char caractere){
        this.caractere = caractere;
        filho_esquerdo = null;
        filho_direito = null;
    }
    
    // Método que devolve o caractere definido no nó.
    public char getCaractere(){
        return this.caractere;
    }
    
    // Método que retorna a subárevore à esquerda do nó.
    public No getEsquerdo(){
        return this.filho_esquerdo;
    }
    
    // Método que retorna a subárevore à direita do nó.
    public No getDireito(){
        return this.filho_direito;
    }
    
    // Método que permite definir o caractere do nó.
    public void setCaractere(char caractere){
        this.caractere = caractere;
    }
    
    // Método que permite definir a subárvore à direita do nó.
    public void setDireito(No filho_direito){
        this.filho_direito = filho_direito;
    }
    
    // // Método que permite definir a subárvore à esquerda do nó.
    public void setEsquerdo(No filho_esquerdo){
        this.filho_esquerdo = filho_esquerdo;
    }
}
