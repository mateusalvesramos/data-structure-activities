package lista;

import java.util.Scanner;

public class ImplementacaoLista {

    public static void main(String[] args) {
        // Criação de um objeto do tipo "Scanner" para realizar a leitura do teclado
        Scanner teclado = new Scanner(System.in);
        Lista lista = new Lista();
        int option;
        int new_value;
        
        do{
            System.out.println("Digite uma das opções de manipulação da lista:");
            System.out.println(" 1. Adicionar um elemento na lista; \n 2. Imprimir a lista; \n 3. Excluir um elemento da lista; \n 0. Sair.");
            option = teclado.nextInt();
            
            switch(option){
                case 1: 
                    System.out.println("Digite o valor inteiro a ser inserido na lista: ");
                    new_value = teclado.nextInt();
                    lista.insert(new_value);
                    break;
                case 2:
                    lista.print_list();
                    break;
                case 3:
                    System.out.println("Digite a posição do elemento no qual você deseja remover:");
                    int index = teclado.nextInt();
                    lista.delete_on_list(index);
                default:
                    System.out.println("Digite uma das opções válidas!");
                    break; // Redundância, esta linha é desnecessária
            }
        }while(option != 0);
    }
    
}
