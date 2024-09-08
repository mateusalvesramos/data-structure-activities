/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaduplaencadeada;

/**
 *
 * @author r.alves10
 */
public class No {
    private No proximo;
    private No anterior;
    private Integer informacao;
    
    public No(){
        proximo = null;
        anterior = null;
        informacao = null;
    }
    
    public Integer getInformacao(){
        return informacao;
    }
    
    public No getProximo(){
        return proximo;
    }
    
    public No getAnterior(){
        return anterior;
    }
    
    public void setInformacao(Integer informacao){
        this.informacao = informacao;
    }
    
    public void setProximo(No proximo){
        this.proximo = proximo;
    }
    
    public void setAnterior(No anterior){
        this.anterior = anterior;
    }
}
