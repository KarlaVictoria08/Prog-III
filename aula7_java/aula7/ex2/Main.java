// Exercício 2 – Registro de Texto em Arquivo (PrintStream)
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final String ARQUIVO = "anotacoes.txt";
        int linhasGravadas = 0;

        System.out.println("Digite suas anotações. Digite FIM para encerrar.");

        try (PrintStream ps = new PrintStream(ARQUIVO, "UTF-8")) {
            while (true) {
                System.out.print("> ");
                if (!sc.hasNextLine()) break;
                String linha = sc.nextLine();
                if (linha.trim().equals("FIM")) {
                    break; // a palavra FIM não é gravada
                }
                ps.println(linha); // cada entrada em uma linha diferente
                linhasGravadas++;
            }

            // PrintStream não lança IOException; os erros são consultados com checkError()
            if (ps.checkError()) {
                System.out.println("\nOcorreu um problema durante a gravação em " + ARQUIVO + ".");
            } else {
                System.out.println("\nGravação concluída: " + linhasGravadas
                        + " linha(s) salvas em " + ARQUIVO + ".");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Não foi possível criar ou abrir o arquivo " + ARQUIVO + ": " + e.getMessage());
        } catch (java.io.UnsupportedEncodingException e) {
            System.out.println("Codificação de caracteres não suportada.");
        } finally {
            sc.close();
        }
    }
}
