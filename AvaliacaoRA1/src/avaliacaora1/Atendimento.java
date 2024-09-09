package avaliacaora1;

public class Atendimento extends Elemento{
    private String nome;
    
    // M�todo construtor de Cliente.
    public Atendimento(String id, String nome, String descricao){
        // Invoca o construtor da superclasse (Elemento).
        super(id, descricao);
        this.nome = nome;
    }
    
    public void imprimir_dados(){
        System.out.println("Id: " + id + "\nNome: " + nome + "\nDescri��o: " + descricao + "\n");
    }
}
