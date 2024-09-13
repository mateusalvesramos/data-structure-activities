package avaliacaora1;

public class Atendimento extends Elemento{
    // O atributo "static" permite que esta variável seja compartilhada entre todas as instâncias desta classe.
    private static int contadorId = 1;
    private String nome;
    
    // Método construtor de Cliente.
    public Atendimento(String nome, String descricao){
        // Invoca o construtor da superclasse (Elemento).
        super(descricao);
        this.id = gerarId();
        this.nome = nome;
    }
    
    public String gerarId(){
        return "CLI" + String.format("%03d", contadorId++);
    }
    
    public void imprimir_dados(){
        // System.out.println("Id: " + id + "\nNome: " + nome + "\nDescrição: " + descricao + "\n");
        System.out.println("Id: " + id + " | Nome: " + nome +" | Descrição: " + descricao + "\n");
    }
}
