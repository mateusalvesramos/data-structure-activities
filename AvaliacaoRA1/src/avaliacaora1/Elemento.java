package avaliacaora1;

// Classe abstrata que ser� herdada tanto por Solicitacao quanto por Cliente.
public abstract class Elemento {
    // A visibilidade protected garante que estes atributos seja acessados
    // apenas por classes do mesmo pacote ou que herdem esta classe abstrata.
    protected String id;
    protected String descricao;
    
    // M�todo construtor da superclasse.
    public Elemento(String id, String descricao){
        this.id = id;
        this.descricao = descricao;
    }
    
    // Assinatura dos m�todos que devem ser implementados nas subclasses.
    public abstract void imprimir_dados();
}
