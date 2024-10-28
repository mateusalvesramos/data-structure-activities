package tabela_hash;

public class Registro {
    // Código do registro que tem 9 digitos
    private int codigo;
    private Registro proximo;
    
    // Inicializa o registro com o código inserido e com o ponteiro para o 
    // próximo elemento como null
    public Registro(int codigo){
        this.codigo = codigo;
        proximo = null;
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public Registro getProximo(){
        return proximo;
    }
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    public void setProximo(Registro proximo){
        this.proximo = proximo;
    }
    
    public int imprimirCodigo(){
        // System.out.println("Registro: " + codigo);
        return codigo;
    }
}
