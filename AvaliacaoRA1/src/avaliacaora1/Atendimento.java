package avaliacaora1;

public class Atendimento extends Elemento{
    // O atributo "static" permite que esta vari�vel seja compartilhada entre todas as inst�ncias desta classe.
    private static int contadorId = 1;
    private String nome;
    
    // M�todo construtor de Cliente.
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
        // System.out.println("Id: " + id + "\nNome: " + nome + "\nDescri��o: " + descricao + "\n");
        System.out.println("Id: " + id + " | Nome: " + nome +" | Descri��o: " + descricao + "\n");
    }
}
