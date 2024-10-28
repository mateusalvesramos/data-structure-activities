package avaliacaora2;

import java.util.Scanner;

public class AvaliacaoRA2 {
    public static void main(String[] args) {
        ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();
        Interface menu = new Interface();
        
        arvore.inicializar();
        arvore.inserir(".-", 'A');
        arvore.inserir("-...", 'B');
        arvore.inserir("-.-.", 'C');
        arvore.inserir("-..", 'D');
        arvore.inserir(".", 'E');
        arvore.inserir("..-.", 'F');
        arvore.inserir("--.", 'G');
        arvore.inserir("....", 'H');
        arvore.inserir("..", 'I');
        arvore.inserir(".---", 'J');
        arvore.inserir("-.-", 'K');
        arvore.inserir(".-..", 'L');
        arvore.inserir("--", 'M');
        arvore.inserir("-.", 'N');
        arvore.inserir("---", 'O');
        arvore.inserir(".--.", 'P');
        arvore.inserir("--.-", 'Q');
        arvore.inserir(".-.", 'R');
        arvore.inserir("...", 'S');
        arvore.inserir("-", 'T');
        arvore.inserir("..-", 'U');
        arvore.inserir("...-", 'V');
        arvore.inserir(".--", 'W');
        arvore.inserir("-..-", 'X');
        arvore.inserir("-.--", 'Y');
        arvore.inserir("--..", 'Z');
        arvore.inserir(".----", '1');
        arvore.inserir("..---", '2');
        arvore.inserir("...--", '3');
        arvore.inserir("....-", '4');
        arvore.inserir(".....", '5');
        arvore.inserir("-....", '6');
        arvore.inserir("--...", '7');
        arvore.inserir("---..", '8');
        arvore.inserir("----.", '9');
        arvore.inserir("-----", '0');
        
        menu.executarInterface(arvore);
        // System.out.println(arvore.buscar("-- .- - . ..- ..."));
    }
    
}
