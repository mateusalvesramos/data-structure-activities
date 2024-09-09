package avaliacaora1;

public class Solicitacao extends Elemento{
    private String data_hora;
    
    public Solicitacao(String id, String descricao, String dataHora){
        super(id, descricao);
        this.data_hora = dataHora;
    }
    
    public void imprimir_dados(){
        System.out.println("id: " + id + "\nDescrição: " + descricao + "\nData e hora: " + data_hora + "\n");
    }
}
