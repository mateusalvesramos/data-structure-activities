/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listaduplaencadeada;

/**
 *
 * @author r.alves10
 */
public class ImplementacaoListaDuplaEncadeada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaDuplaEncadeada lista = new ListaDuplaEncadeada();
        
        lista.inserir(1);
        lista.inserir(2);
        lista.inserir(3);
        lista.inserir(4);
        lista.inserir(5);
        lista.inserir(6);
        lista.inserir(7);
        lista.inserir(8);
        
        lista.imprimir();
        
        // Exclus�o no in�cio da lista
        //lista.remove(1);
        // lista.imprimir();
        
        // Exclus�o no meio da lista.
        // lista.remove(4);
        // lista.imprimir();
        
        // Exclus�o no final da lista.
        lista.remove(8);
    }
    
}
