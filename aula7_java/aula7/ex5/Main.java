// Exercício 5 – Contagem de Linhas, Palavras e Caracteres
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe o caminho do arquivo de texto: ");
        String caminho = sc.nextLine().trim();
        sc.close();

        int linhas = 0, palavras = 0, caracteres = 0;
        String maiorLinha = null;
        int numeroMaiorLinha = 0;

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(caminho), StandardCharsets.UTF_8))) {

            String linha;
            while ((linha = br.readLine()) != null) { // readLine() retorna null no fim do arquivo
                linhas++;
                caracteres += linha.length(); // não conta as quebras de linha

                String limpa = linha.trim();
                if (!limpa.isEmpty()) {
                    palavras += limpa.split("\\s+").length;
                }

                if (maiorLinha == null || linha.length() > maiorLinha.length()) {
                    maiorLinha = linha;
                    numeroMaiorLinha = linhas;
                }
            }

            System.out.println("\nLinhas:     " + linhas);
            System.out.println("Palavras:   " + palavras);
            System.out.println("Caracteres: " + caracteres + " (sem contar as quebras de linha)");
            if (maiorLinha == null) {
                System.out.println("O arquivo está vazio.");
            } else {
                System.out.println("Maior linha: nº " + numeroMaiorLinha + ", com "
                        + maiorLinha.length() + " caracteres:");
                System.out.println("  \"" + maiorLinha + "\"");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado ou sem permissão de leitura: " + caminho);
        } catch (IOException e) {
            System.out.println("Erro durante a leitura: " + e.getMessage());
        }
    }
}
