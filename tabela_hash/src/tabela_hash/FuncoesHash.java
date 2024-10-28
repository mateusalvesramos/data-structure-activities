package tabela_hash;

import java.util.Random;
        
public class FuncoesHash { 
    // As funções Hash receberão o código do registro para que possa haver a operação de Hash
    
    // Este método calcula o resto da divisão entre a chave e o tamanho da tabela, que retorna
    // um valor que obedecerá o tamanho da tabela
    public int hash_modulo(int chave, int tamanho_tabela){
        return chave % tamanho_tabela;
    }
    
    // Este método utiliza uma constante que será multiplicada. Um valor utilizado para isso
    // é o coeficiente 0.6180339887 (conjugado da razão áurea).
    public int hash_multiplicacao(int chave, int tamanho_tabela){
        double coeficiente = 0.6180339887;
        // Primeiro realizamos a multiplicação entre a chave e o coeficiente e 
        // tiramos o módulo desse produto em relação a 1, para que tenhamos a 
        // parte fracionária.
        double parte_fracionaria = chave * coeficiente % 1;
        // Por fim, multiplicamos o tamnho da tabela pela parte fracionária e 
        // arredondamos para baixo (cast para int)
        return (int)(tamanho_tabela * parte_fracionaria);
    }
    
    // Este método realiza a separação do código de registro em partes menores,
    // no caso em 3 partes. Soma as partes e obtem o módulo (resto) em relação
    // ao tamanho da tabela.
    public int hash_dobramento(int chave, int tamanho_tabela){
        // Primeiramente, faremos a separação dos 9 digitos em 3 partes iguais
        int parte1 = chave / 1000000; // 3 primeiros dígitos
        int parte2 = (chave / 1000) % 1000; // 3 dígitos do meio
        int parte3 = chave % 1000; // 3 últimos dígitos
        
        // Agora, realizamos a soma destas 3 partes
        int soma_partes = parte1 + parte2 + parte3;
        
        // Por fim, retornamos o resto da divisão desta soma pelo tamanho da tabela
        return soma_partes % tamanho_tabela;
    }
}
