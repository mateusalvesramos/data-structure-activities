package pilha;

public class ImplementacaoPilha {
    public static void main(String[] args){
        Pilha pilha1 = new Pilha();

        // Inserindo 3 valores da pilha, atingindo o limite da capacidade
        pilha1.insere(1);
        pilha1.insere(2);
        pilha1.insere(3);

        // Imprimindo os valores da pilha
        pilha1.imprime();

        // Tentando inserir um valor com a pilha cheia
        pilha1.insere(1);

        // Removendo os três valores da pilha
        pilha1.remove();
        pilha1.remove();
        pilha1.remove();

        // Tentando remover um valor da pilha vazia
        pilha1.remove();
    }
}
