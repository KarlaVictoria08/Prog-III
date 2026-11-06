// Exercício 6 – Organização de Arquivos com a Classe File
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static File diretorio;

    public static void main(String[] args) {
        System.out.print("Informe o caminho de um diretório: ");
        diretorio = new File(sc.nextLine().trim());

        int opcao;
        do {
            System.out.println("\n===== Diretório: " + diretorio.getPath() + " =====");
            System.out.println("1 - Verificar se o diretório existe");
            System.out.println("2 - Criar o diretório");
            System.out.println("3 - Listar arquivos e subdiretórios");
            System.out.println("4 - Exibir caminho absoluto e tamanho dos arquivos");
            System.out.println("5 - Criar novo arquivo de texto no diretório");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = lerInteiro();

            switch (opcao) {
                case 1: verificar();    break;
                case 2: criarDiretorio(); break;
                case 3: listar();       break;
                case 4: detalhar();     break;
                case 5: criarArquivo(); break;
                case 0: System.out.println("Encerrando."); break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
        sc.close();
    }

    static int lerInteiro() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // Verifica se o caminho corresponde a um diretório válido antes das operações
    static boolean diretorioValido() {
        if (!diretorio.exists()) {
            System.out.println("Operação não concluída: o diretório não existe (use a opção 2 para criá-lo).");
            return false;
        }
        if (!diretorio.isDirectory()) {
            System.out.println("Operação não concluída: o caminho informado é um arquivo, não um diretório.");
            return false;
        }
        return true;
    }

    static void verificar() {
        if (!diretorio.exists()) {
            System.out.println("O diretório não existe.");
        } else if (diretorio.isDirectory()) {
            System.out.println("O diretório existe.");
        } else {
            System.out.println("O caminho existe, mas corresponde a um arquivo, não a um diretório.");
        }
    }

    static void criarDiretorio() {
        if (diretorio.exists()) {
            System.out.println("Operação não concluída: o caminho já existe.");
            return;
        }
        // mkdirs() cria também os diretórios intermediários que faltarem
        if (diretorio.mkdirs()) {
            System.out.println("Diretório criado: " + diretorio.getAbsolutePath());
        } else {
            System.out.println("Operação não concluída: não foi possível criar o diretório (verifique permissões).");
        }
    }

    static void listar() {
        if (!diretorioValido()) return;
        File[] itens = diretorio.listFiles();
        if (itens == null) {
            System.out.println("Operação não concluída: sem permissão para listar o diretório.");
        } else if (itens.length == 0) {
            System.out.println("O diretório está vazio.");
        } else {
            for (File item : itens) {
                System.out.println((item.isDirectory() ? "  [DIR] " : "  [ARQ] ") + item.getName());
            }
        }
    }

    static void detalhar() {
        if (!diretorioValido()) return;
        System.out.println("Caminho absoluto: " + diretorio.getAbsolutePath());
        File[] itens = diretorio.listFiles();
        if (itens == null) {
            System.out.println("Operação não concluída: sem permissão para listar o diretório.");
            return;
        }
        int arquivos = 0;
        for (File item : itens) {
            if (item.isFile()) {
                System.out.printf("  %-30s %8d bytes  (%s)%n", item.getName(), item.length(), item.getAbsolutePath());
                arquivos++;
            }
        }
        if (arquivos == 0) {
            System.out.println("Não há arquivos neste diretório.");
        }
    }

    static void criarArquivo() {
        if (!diretorioValido()) return;
        System.out.print("Nome do novo arquivo (ex.: notas.txt): ");
        String nome = sc.nextLine().trim();
        if (nome.isEmpty()) {
            System.out.println("Operação não concluída: o nome não pode ser vazio.");
            return;
        }
        if (!nome.toLowerCase().endsWith(".txt")) {
            nome += ".txt";
        }
        File novo = new File(diretorio, nome);
        try {
            // createNewFile() retorna false se o arquivo já existir
            if (novo.createNewFile()) {
                System.out.println("Arquivo criado: " + novo.getAbsolutePath());
            } else {
                System.out.println("Operação não concluída: o arquivo \"" + nome + "\" já existe.");
            }
        } catch (IOException e) {
            System.out.println("Operação não concluída: erro ao criar o arquivo (" + e.getMessage() + ").");
        }
    }
}
