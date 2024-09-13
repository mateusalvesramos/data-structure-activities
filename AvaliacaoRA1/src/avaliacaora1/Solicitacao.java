package avaliacaora1;

import java.time.LocalDate;

public class Solicitacao extends Elemento{
    // O atributo "static" permite que esta vari�vel seja compartilhada entre todas as inst�ncias desta classe.
    private static int contadorId = 1;
    private LocalDate data_hora;
    
    public Solicitacao(String descricao){
        super(descricao);
        this.id = gerarId();
        data_hora = LocalDate.now();
    }
    
    public String gerarId(){
        return "REQ" + String.format("%03d", contadorId++);
    }
    
    public void imprimir_dados(){
        // System.out.println("Id: " + id + "\nDescri��o: " + descricao + "\nData e hora: " + data_hora + "\n");
        System.out.println("Id: " + id + " | Descri��o: " + descricao + " | Data e hora: " + data_hora + "\n");
    }
}
