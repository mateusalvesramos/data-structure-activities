package avaliacaora2;

public class ArvoreBinariaMorse {
    private No raiz; // Aponta para o n� raiz da �rvore.
    
    // M�todo para incializar o n� ra�z da �rvore como um n� sem caractere, ou com caractere nulo.
    public void inicializar(){
        this.raiz = new No('\0');
    }
    
    // M�todo para a inser��o de um novo caractere na �rvore.
    // Recebe a C�digo morse, correspondente ao caracter a ser representado, e o pr�prio caracter.
    public void inserir(String codigo_morse, char caractere){
        // Definindo o n� atual como a raiz, para mais tarde realizar compara��es para inser��o.
        No atual = raiz;
        
        // La�o para percorrer cada simbolo em c�digo morse da String fornecida, onde a String � transformada em um array de caracteres.
        for(char simbolo : codigo_morse.toCharArray()){
            if(simbolo == '.'){
                if(atual.getEsquerdo() == null){
                    // Adicionar como sub�rvore � esquerda;
                    atual.setEsquerdo(new No('\0'));
                }
                // Define o n� atual como o n� � esquerda recem inserido.
                atual = atual.getEsquerdo();
            }else if(simbolo == '-'){
                if(atual.getDireito() == null){
                    // Adicionar como sub�rvore � direita;
                    atual.setDireito(new No('\0'));
                }
                // Define o n� atual como o n� � direta recem inserido.
                atual = atual.getDireito();
            }
        }
        // Adiciona o caractere passado como par�metro no novo n� inserido.
        atual.setCaractere(caractere);
    }
    
    // M�todo para exibir a �rvore em ordem.
    public void exibir(){
        exibir_recursivo(this.raiz, "");
    }
    
    /*
    private void exibir_recursivo(No atual){
        // Condi��o de parada da recurs�o.
        if(atual != null){
            exibir_recursivo(atual.getEsquerdo());
            // System.out.print(atual.getCaractere());
            System.out.print(atual.getCaractere());
            exibir_recursivo(atual.getDireito());
        }
    }*/
    
        // Exibi��o recursiva da �rvore
    private void exibir_recursivo(No no, String caminho) {
        if (no != null) {
            exibir_recursivo(no.getEsquerdo(), caminho + ".");
            if (no.getCaractere() != '\0') {
                System.out.println(caminho + " -> " + no.getCaractere());
            }
            exibir_recursivo(no.getDireito(), caminho + "-");
        }
    }
    
    // M�todo que realiza a busca pelo caracter correspondente, de acordo com o c�digo morse fornecido.
    public String buscar(String codigo_morse){
        
        // Ser� utilizada para concatenar todos os caracteres correspondentes ao c�digo morse.
        String resultado = "Tradu��o do c�digo morse: ";
        
        // Realizando a separa��o das representa��es das letras do c�digo morse de acordo com o espa�o.
        String[] letras_morse = codigo_morse.split(" ");
        
        // Percorrendo cada representa��o de palavra em c�digo morse.
        for(String letra : letras_morse){
            No atual = raiz;
            // La�o para percorrer cada simbolo da palavra em c�digo morse, onde a String � transformada em um array de caracteres.
            for(char simbolo : letra.toCharArray()){
                // Aqui ocorre a verifica��o para saber se o caracter a ser encontrado est� como sub�rvore � direita (.) ou � esquerda (-).
                if(simbolo == '.'){
                    // Atualiza o atual para a sub�rvore � esquerda.
                    atual = atual.getEsquerdo();    
                }else if(simbolo == '-'){
                    // Atualiza o atual para a sub�rvore � direita.
                    atual = atual.getDireito(); 
                // Caso o usu�rio insira qualquer caractere diferente de "." ou "-".
                }else{
                    throw new RuntimeException("Erro: s�mbolo em c�digo morse inv�lido!");
                }
                // Caso o n� atual seja seja nulo, retornar nulo.
                if(atual == null){
                    throw new RuntimeException("Erro: caractere n�o encontrado!");
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
