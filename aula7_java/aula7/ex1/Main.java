// Exercício 1 – Leitura de Arquivo de Texto
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

        // try-with-resources: os três fluxos são fechados automaticamente,
        // na ordem inversa da abertura, mesmo se ocorrer uma exceção.
        try (FileInputStream fis = new FileInputStream(caminho);
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(isr)) {

            System.out.println("\n----- Conteúdo de " + caminho + " -----");
            String linha;
            int numero = 0;
            while ((linha = br.readLine()) != null) {
                numero++;
                System.out.printf("%3d | %s%n", numero, linha);
            }
            System.out.println("----- Fim do arquivo (" + numero + " linha(s)) -----");

        } catch (FileNotFoundException e) {
            System.out.println("Não foi possível abrir o arquivo: ele não existe, é um diretório "
                    + "ou não há permissão de leitura.");
        } catch (IOException e) {
            System.out.println("Erro de leitura do arquivo: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
