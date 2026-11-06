// Exercício 4 – Cópia de Arquivo (FileInputStream / FileOutputStream)
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Caminho do arquivo de origem: ");
        String origem = sc.nextLine().trim();
        System.out.print("Caminho do arquivo de destino: ");
        String destino = sc.nextLine().trim();
        sc.close();

        File arqOrigem = new File(origem);
        if (!arqOrigem.isFile()) {
            System.out.println("Erro: o arquivo de origem \"" + origem + "\" não existe ou não é um arquivo.");
            return;
        }

        long totalBytes = 0;
        // Fluxos de bytes: copiam o conteúdo exatamente como está,
        // por isso funcionam tanto para texto quanto para imagens.
        try (FileInputStream in = new FileInputStream(arqOrigem);
             FileOutputStream out = new FileOutputStream(destino)) {

            byte[] buffer = new byte[4096];
            int lidos;
            while ((lidos = in.read(buffer)) != -1) { // -1 indica fim do arquivo
                out.write(buffer, 0, lidos);
                totalBytes += lidos;
            }
            System.out.println("Cópia concluída: " + totalBytes + " bytes copiados para \"" + destino + "\".");

        } catch (FileNotFoundException e) {
            System.out.println("Erro ao abrir os arquivos: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Falha de leitura/escrita durante a cópia: " + e.getMessage());
        }
    }
}
