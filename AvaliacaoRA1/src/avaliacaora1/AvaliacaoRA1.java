package avaliacaora1;

public class AvaliacaoRA1 {

    public static void main(String[] args) {
        Pilha pilha_solicitacoes = new Pilha();
        Fila fila_atendimentos = new Fila();
/*
        pilha_solicitacoes.empilhar(new Solicitacao("REQ001", "Instala��o de software", "2024-08-20 10:30"));
        pilha_solicitacoes.empilhar(new Solicitacao("REQ002", "Manuten��o preventiva", "2024-08-20 11:00"));
        pilha_solicitacoes.empilhar(new Solicitacao("REQ003", "Atualiza��o de sistema", "2024-08-20 11:30"));
        
        pilha_solicitacoes.imprimir_pilha();
        
        pilha_solicitacoes.desempilhar();
        
        pilha_solicitacoes.imprimir_pilha();
        
        pilha_solicitacoes.desempilhar();
        
        pilha_solicitacoes.imprimir_pilha();
        
        pilha_solicitacoes.desempilhar();
        
        pilha_solicitacoes.imprimir_pilha();
        
        pilha_solicitacoes.desempilhar();
      */  
        fila_atendimentos.enfileirar(new Atendimento("CLI001", "Maria Silva", "D�vida sobre produto"));
        fila_atendimentos.enfileirar(new Atendimento("CLI002", "Jo�o Souza", "Reclama��o de servi�o"));
        fila_atendimentos.enfileirar(new Atendimento("CLI003", "Ana Costa", "Solicita��o de reembolso"));
        
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
