// Exercício 3 – Análise de Arquivos e Diretórios (File)
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe um caminho (arquivo ou diretório): ");
        String caminho = sc.nextLine().trim();
        File recurso = new File(caminho);

        System.out.println();
        if (!recurso.exists()) {
            System.out.println("O recurso \"" + caminho + "\" não existe.");
            System.out.println("Caminho absoluto verificado: " + recurso.getAbsolutePath());
            sc.close();
            return;
        }

        System.out.println("Existe:           sim");
        System.out.println("Caminho absoluto: " + recurso.getAbsolutePath());

        if (recurso.isFile()) {
            System.out.println("Tipo:             arquivo");
            System.out.println("Tamanho:          " + recurso.length() + " bytes");
        } else if (recurso.isDirectory()) {
            System.out.println("Tipo:             diretório");

            // Desafio adicional: listar o conteúdo do diretório
            File[] itens = recurso.listFiles();
            if (itens == null) {
                System.out.println("Não foi possível listar o conteúdo (sem permissão de leitura).");
            } else if (itens.length == 0) {
                System.out.println("O diretório está vazio.");
            } else {
                System.out.println("\nConteúdo (" + itens.length + " item(ns)):");
                for (File item : itens) {
                    if (item.isDirectory()) {
                        System.out.println("  [DIR]  " + item.getName());
                    } else {
                        System.out.printf("  [ARQ]  %-30s %d bytes%n", item.getName(), item.length());
                    }
                }
            }
        }
        sc.close();
    }
}
