package avaliacaora2;

public class ArvoreBinariaMorse {
    private No raiz; // Aponta para o nó raiz da árvore.
    
    // Método para incializar o nó raíz da árvore como um nó sem caractere, ou com caractere nulo.
    public void inicializar(){
        this.raiz = new No('\0');
    }
    
    // Método para a inserção de um novo caractere na árvore.
    // Recebe a Código morse, correspondente ao caracter a ser representado, e o próprio caracter.
    public void inserir(String codigo_morse, char caractere){
        // Definindo o nó atual como a raiz, para mais tarde realizar comparações para inserção.
        No atual = raiz;
        
        // Laço para percorrer cada simbolo em código morse da String fornecida, onde a String é transformada em um array de caracteres.
        for(char simbolo : codigo_morse.toCharArray()){
            if(simbolo == '.'){
                if(atual.getEsquerdo() == null){
                    // Adicionar como subárvore à esquerda;
                    atual.setEsquerdo(new No('\0'));
                }
                // Define o nó atual como o nó à esquerda recem inserido.
                atual = atual.getEsquerdo();
            }else if(simbolo == '-'){
                if(atual.getDireito() == null){
                    // Adicionar como subárvore à direita;
                    atual.setDireito(new No('\0'));
                }
                // Define o nó atual como o nó à direta recem inserido.
                atual = atual.getDireito();
            }
        }
        // Adiciona o caractere passado como parâmetro no novo nó inserido.
        atual.setCaractere(caractere);
    }
    
    // Método para exibir a árvore em ordem.
    public void exibir(){
        exibir_recursivo(this.raiz, "");
    }
    
    /*
    private void exibir_recursivo(No atual){
        // Condição de parada da recursão.
        if(atual != null){
            exibir_recursivo(atual.getEsquerdo());
            // System.out.print(atual.getCaractere());
            System.out.print(atual.getCaractere());
            exibir_recursivo(atual.getDireito());
        }
    }*/
    
        // Exibição recursiva da árvore
    private void exibir_recursivo(No no, String caminho) {
        if (no != null) {
            exibir_recursivo(no.getEsquerdo(), caminho + ".");
            if (no.getCaractere() != '\0') {
                System.out.println(caminho + " -> " + no.getCaractere());
            }
            exibir_recursivo(no.getDireito(), caminho + "-");
        }
    }
    
    // Método que realiza a busca pelo caracter correspondente, de acordo com o código morse fornecido.
    public String buscar(String codigo_morse){
        
        // Será utilizada para concatenar todos os caracteres correspondentes ao código morse.
        String resultado = "Tradução do código morse: ";
        
        // Realizando a separação das representações das letras do código morse de acordo com o espaço.
        String[] letras_morse = codigo_morse.split(" ");
        
        // Percorrendo cada representação de palavra em código morse.
        for(String letra : letras_morse){
            No atual = raiz;
            // Laço para percorrer cada simbolo da palavra em código morse, onde a String é transformada em um array de caracteres.
            for(char simbolo : letra.toCharArray()){
                // Aqui ocorre a verificação para saber se o caracter a ser encontrado está como subárvore à direita (.) ou à esquerda (-).
                if(simbolo == '.'){
                    // Atualiza o atual para a subárvore à esquerda.
                    atual = atual.getEsquerdo();    
                }else if(simbolo == '-'){
                    // Atualiza o atual para a subárvore à direita.
                    atual = atual.getDireito(); 
                // Caso o usuário insira qualquer caractere diferente de "." ou "-".
                }else{
                    throw new RuntimeException("Erro: símbolo em código morse inválido!");
                }
                // Caso o nó atual seja seja nulo, retornar nulo.
                if(atual == null){
                    throw new RuntimeException("Erro: caractere não encontrado!");
                }
            }
            if(atual != null){
                resultado += atual.getCaractere();
            }else{
                System.out.println("Atual nulo!");
            }
            
        }
        return resultado;
    }
}
