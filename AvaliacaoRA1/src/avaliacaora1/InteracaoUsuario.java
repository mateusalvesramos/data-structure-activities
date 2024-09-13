package avaliacaora1;

import java.util.Scanner;

public class InteracaoUsuario {
    private Pilha pilha;
    private Fila fila;
    Scanner teclado = new Scanner(System.in);
    
    public InteracaoUsuario(Pilha pilha, Fila fila){
        this.pilha = pilha;
        this.fila = fila;
    }
    
    public void mostrarMenu(){
        System.out.print("\n");
        System.out.println("Selecione uma das opções abaixo: \n");
        System.out.println("-=-=-=- Histórico de solicitações -=-=-=-");
        System.out.println("1. Imprimir histórico de solicitações;");
        System.out.println("2. Registrar nova solicitação;");
        System.out.println("3. Remover solicitação;\n");
        System.out.println("=-=-=-=-=- Ordem de atendimento -=-=-=-=-=");
        System.out.println("4. Imprimir ordem de atendimento");
        System.out.println("5. Registrar novo atendimento;");
        System.out.println("6. Remover atendimento;\n");
        System.out.println("0. Sair");
        System.out.print("\n");
    }
    
    public void inserirSolicitacao(){
        System.out.print("Digite a descrição da solicitação: ");
        String descricao = teclado.nextLine();
        
        System.out.print("\n");
        
        Solicitacao nova_solicitacao = new Solicitacao(descricao);
        pilha.empilhar(nova_solicitacao);
    }
    
    
    public void inserirAtendimento(){
        System.out.print("Digite o nome do cliente: ");
        String nome_cliente = teclado.nextLine();
        
        System.out.print("Digite a descrição do atendimento: ");
        String descricao = teclado.nextLine();
        
        System.out.print("\n");
        
        Atendimento novo_atendimento = new Atendimento(nome_cliente, descricao);
        fila.enfileirar(novo_atendimento);
    }
    
    public void executarInterface(){
        int opcao;
                
        do{
            mostrarMenu();
            opcao = teclado.nextInt();
            teclado.nextLine();  // Limpar buffer
        
            switch(opcao){
                // Imprimir histórico de solicitações.
                case 1:
                   pilha.imprimir_pilha();
                    break;
                // Registrar nova solicitação.
                case 2:
                    inserirSolicitacao();
                    break;
                // Remover solicitação.
                case 3:
                    pilha.desempilhar();
                    break;
                // Imprimir ordem de atendimento.
                case 4:
                    fila.imprimir_fila();
                    break;
                // Resgistrar novo atendimento.
                case 5:
                    inserirAtendimento();
                    break;
                // Remover atendimento.
                case 6:
                    fila.desenfileirar();
                    break;
                default:
                    System.out.println("Selecione uma opção válida!");
            }
        }while(opcao != 0);
    }
    
}
