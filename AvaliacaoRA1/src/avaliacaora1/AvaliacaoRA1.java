package avaliacaora1;

public class AvaliacaoRA1 {

    public static void main(String[] args) {
        Pilha pilha_solicitacoes = new Pilha();
        Fila fila_atendimentos = new Fila();
        
        InteracaoUsuario interacao = new InteracaoUsuario(pilha_solicitacoes, fila_atendimentos);
        interacao.executarInterface();
        
        /*
        // Exemplos fornecidos pelo professor (array de objetos)
        Atendimento[] filaAtendimento = new Atendimento[] {
            new Atendimento("CLI001", "Maria Silva", "D�vida sobre produto"),
            new Atendimento("CLI002", "Jo�o Souza", "Reclama��o de servi�o"),
            new Atendimento("CLI003", "Ana Costa", "Solicita��o de reembolso"),
            new Atendimento("CLI004", "Pedro Alves", "Informa��es de entrega"),
            new Atendimento("CLI005", "Carla Dias", "Agendamento de visita"),
            new Atendimento("CLI006", "Lucas Martins", "Altera��o de pedido"),
            new Atendimento("CLI007", "Patr�cia Rocha", "Cancelamento de contrato"),
            new Atendimento("CLI008", "Rafael Lima", "Renova��o de assinatura"),
            new Atendimento("CLI009", "Fernanda Gomes", "Suporte para instala��o"),
            new Atendimento("CLI010", "Carlos Eduardo", "Pedido de or�amento")
        };
        
        Solicitacao[] historico = new Solicitacao[] {
            new Solicitacao("REQ001", "Instala��o de software", "2024-08-20 10:30"),
            new Solicitacao("REQ002", "Manuten��o preventiva", "2024-08-20 11:00"),
            new Solicitacao("REQ003", "Atualiza��o de sistema", "2024-08-20 11:30"),
            new Solicitacao("REQ004", "Suporte t�cnico", "2024-08-20 12:00"),
            new Solicitacao("REQ005", "Troca de equipamento", "2024-08-20 12:30"),
            new Solicitacao("REQ006", "Consulta de garantia", "2024-08-20 13:00"),
            new Solicitacao("REQ007", "Reparo de impressora", "2024-08-20 13:30"),
            new Solicitacao("REQ008", "Configura��o de rede", "2024-08-20 14:00"),
            new Solicitacao("REQ009", "Restaura��o de dados", "2024-08-20 14:30"),
            new Solicitacao("REQ010", "Consulta t�cnica", "2024-08-20 15:00")
        };
        
        // Empilhando/enfileirando os atendimentos de clientes e hist�rico de solicita��es 
        for(Solicitacao solicitacao : historico){
            pilha_solicitacoes.empilhar(solicitacao);
        }
        
        pilha_solicitacoes.imprimir_pilha();
        
        for(Atendimento atendimento : filaAtendimento){
            fila_atendimentos.enfileirar(atendimento);
        }
        
        fila_atendimentos.imprimir_fila();
        */
        

    }
    
}
