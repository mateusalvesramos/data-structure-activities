package fila;


public class ImplementacaoFila {
    public static void main(String[] args) {
        Fila fila1 = new Fila();
        fila1.insert(1);
        fila1.insert(2);
        fila1.insert(3);
        fila1.insert(4);
        fila1.insert(5);
        
        fila1.print_queue();
        
        fila1.remove();
        
        fila1.print_queue();
        
        fila1.remove();
        fila1.remove();
        fila1.remove();
        
        fila1.print_queue();
    } 
}
