package pilha;

public class Pilha {
    private int capacidade = 3;
    private int topo = -1;
    private int dados[] = new int[capacidade];

    public boolean cheia(){
        if (topo == capacidade - 1){
            return true;
        }
        return false;
    }

    public boolean vazia(){
        if(topo == -1){
            return true;
        }
        return false;
    }

    public void insere(int dado){
        if(cheia()){
            System.out.println("Não foi possível inserir um novo valor, pois a pilha está cheia!");
        }else{
            topo += 1;
            dados[topo] = dado;
            System.out.println("O dado " + dado + " foi inserido com sucesso à pilha!");
        }
    }

    public void remove(){
        if(vazia()){
            System.out.println("Não foi possível remover um valor, pois a pilha está vazia!");
        }else{
            int dado_removido = dados[topo];
            topo -= 1;
            System.out.println("O dado " + dado_removido + " foi removido com sucesso da pilha!");
        }
    }

    public void imprime(){

        System.out.println("Conteúdo da pilha:");

        if(vazia()){
            System.out.println("A pilha está vazia!");
        }else {
            for (int i = topo; i > -1; i--) {
                System.out.println(dados[i]);
            }
        }
    }

}
