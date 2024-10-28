package tabela_hash;

import java.util.Random;
        
public class FuncoesHash { 
    // As fun��es Hash receber�o o c�digo do registro para que possa haver a opera��o de Hash
    
    // Este m�todo calcula o resto da divis�o entre a chave e o tamanho da tabela, que retorna
    // um valor que obedecer� o tamanho da tabela
    public int hash_modulo(int chave, int tamanho_tabela){
        return chave % tamanho_tabela;
    }
    
    // Este m�todo utiliza uma constante que ser� multiplicada. Um valor utilizado para isso
    // � o coeficiente 0.6180339887 (conjugado da raz�o �urea).
    public int hash_multiplicacao(int chave, int tamanho_tabela){
        double coeficiente = 0.6180339887;
        // Primeiro realizamos a multiplica��o entre a chave e o coeficiente e 
        // tiramos o m�dulo desse produto em rela��o a 1, para que tenhamos a 
        // parte fracion�ria.
        double parte_fracionaria = chave * coeficiente % 1;
        // Por fim, multiplicamos o tamnho da tabela pela parte fracion�ria e 
        // arredondamos para baixo (cast para int)
        return (int)(tamanho_tabela * parte_fracionaria);
    }
    
    // Este m�todo realiza a separa��o do c�digo de registro em partes menores,
    // no caso em 3 partes. Soma as partes e obtem o m�dulo (resto) em rela��o
    // ao tamanho da tabela.
    public int hash_dobramento(int chave, int tamanho_tabela){
        // Primeiramente, faremos a separa��o dos 9 digitos em 3 partes iguais
        int parte1 = chave / 1000000; // 3 primeiros d�gitos
        int parte2 = (chave / 1000) % 1000; // 3 d�gitos do meio
        int parte3 = chave % 1000; // 3 �ltimos d�gitos
        
        // Agora, realizamos a soma destas 3 partes
        int soma_partes = parte1 + parte2 + parte3;
        
        // Por fim, retornamos o resto da divis�o desta soma pelo tamanho da tabela
        return soma_partes % tamanho_tabela;
    }
}
