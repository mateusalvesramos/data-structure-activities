package lista;

import java.util.Scanner;

public class ImplementacaoLista {

    public static void main(String[] args) {
        // Cria��o de um objeto do tipo "Scanner" para realizar a leitura do teclado
        Scanner teclado = new Scanner(System.in);
        Lista lista = new Lista();
        int option;
        int new_value;
        
        do{
            System.out.println("Digite uma das op��es de manipula��o da lista:");
            System.out.println(" 1. Adicionar um elemento na lista; \n 2. Excluir um elemento da lista; \n 0. Sair.");
            option = teclado.nextInt();
            
            switch(option){
                case 1: 
                    System.out.println("Digite o valor inteiro a ser inserido na lista: ");
                    new_value = teclado.nextInt();
                    lista.insert(new_value);
                    lista.print_list();
                    break;

                case 2:
                    System.out.println("Digite a posi��o do elemento no qual voc� deseja remover:");
                    int index = teclado.nextInt();
                    lista.delete_on_list(index);
                    lista.print_list();
                    break;
                default:
                    System.out.println("Digite uma das op��es v�lidas!");
                    break; // Redund�ncia, esta linha � desnecess�ria
            }
        }while(option != 0);
    }
    
}
