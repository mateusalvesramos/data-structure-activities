package listacircular;

public class Node {
    // Aqui tive que utilizar Integer, pois com "int" não é possí­vel definir 
    // "information" como "null".
    private Integer information;    
    private Node next;
    
    public Node(){
        this.information = null;
        this.next = null;
    }
    
    public Integer getInformation(){
        return information;
    }
    
    public Node getNext(){
        return next;
    }
    
    public void setInformation(int information){
        this.information = information;
    }
    
    public void setNext(Node next){
        this.next = next;
    }
}
