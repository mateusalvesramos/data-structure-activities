package avaliacaora2;

import java.util.Scanner;

public class Interface {
    Scanner teclado = new Scanner(System.in);
    int opcao;
    
    public void executarInterface(ArvoreBinariaMorse arvore){
        do{
            System.out.println("\nSelecione uma das operações abaixo:\n\n1. Traduzir código morse\n2. Exibir árvore (in-ordem)\n0. Sair");
            opcao = teclado.nextInt();
            
            switch(opcao){
                case 1:
                    System.out.println("Digite o código morse que você deseja que seja traduzido (com separação de espaço entre as letras)");
                    // Limpa buffer do teclado
                    teclado.nextLine();
                    
                    // Realizando a leitura da entrada do usuário.
                    String codigo_morse = teclado.nextLine();
                    
                    // Aqui ocorre a captura de exceção caso o usuário insira algum caractere diferente de "-" ou ".".
                    try{
                        System.out.println(arvore.buscar(codigo_morse));

                    }catch(RuntimeException e){
                        System.out.println(e.getMessage());
                    }          
                    break;
                case 2:
                    arvore.exibir();
                    break;
                default:
                    System.out.println("Digite uma das opções válidas!");
            }
            
        }while(opcao != 0);
    }
}
