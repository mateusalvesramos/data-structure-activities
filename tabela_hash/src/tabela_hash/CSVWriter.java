package tabela_hash;

import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {
    private String filePath;
    
    public CSVWriter(String filePath) {
        this.filePath = filePath;
        // Escreve o cabeçalho do CSV
        try (FileWriter writer = new FileWriter(filePath, false)) {
            writer.append("TamanhoTabela,QtdeElementos,FuncaoHash,Colisoes,TempoExecucao\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void escreverLinha(int tamanhoTabela, int qtdeElementos, String funcaoHash, int colisoes, double tempoExecucao) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.append(String.format("%d,%d,%s,%d,%.2f\n", tamanhoTabela, qtdeElementos, funcaoHash, colisoes, tempoExecucao));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

