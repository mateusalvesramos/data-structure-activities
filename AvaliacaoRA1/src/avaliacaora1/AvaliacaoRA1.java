package avaliacaora1;

public class AvaliacaoRA1 {

    public static void main(String[] args) {
        Pilha pilha_solicitacoes = new Pilha();
        Fila fila_atendimentos = new Fila();
/*
        pilha_solicitacoes.empilhar(new Solicitacao("REQ001", "Instalação de software", "2024-08-20 10:30"));
        pilha_solicitacoes.empilhar(new Solicitacao("REQ002", "Manutenção preventiva", "2024-08-20 11:00"));
        pilha_solicitacoes.empilhar(new Solicitacao("REQ003", "Atualização de sistema", "2024-08-20 11:30"));
        
        pilha_solicitacoes.imprimir_pilha();
        
        pilha_solicitacoes.desempilhar();
        
        pilha_solicitacoes.imprimir_pilha();
        
        pilha_solicitacoes.desempilhar();
        
        pilha_solicitacoes.imprimir_pilha();
        
        pilha_solicitacoes.desempilhar();
        
        pilha_solicitacoes.imprimir_pilha();
        
        pilha_solicitacoes.desempilhar();
      */  
        fila_atendimentos.enfileirar(new Atendimento("CLI001", "Maria Silva", "Dúvida sobre produto"));
        fila_atendimentos.enfileirar(new Atendimento("CLI002", "João Souza", "Reclamação de serviço"));
        fila_atendimentos.enfileirar(new Atendimento("CLI003", "Ana Costa", "Solicitação de reembolso"));
        
        fila_atendimentos.imprimir_fila();
        
        fila_atendimentos.desenfileirar();
        
        fila_atendimentos.imprimir_fila();
        
        fila_atendimentos.desenfileirar();
        
        fila_atendimentos.imprimir_fila();
        
        fila_atendimentos.desenfileirar();
        
        fila_atendimentos.imprimir_fila();
        
        fila_atendimentos.desenfileirar();
    }
    
}
