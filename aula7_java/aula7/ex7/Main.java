// Exercício 7 – Desafio Integrador: Cadastro com Persistência em Arquivo
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/*
 * Formato de cada registro em alunos.txt (uma linha por aluno):
 *     nome;curso;nota
 * Exemplo:
 *     Ana Souza;Ciência da Computação;8.5
 */
public class Main {
    static final String ARQUIVO = "alunos.txt";
    static final String SEPARADOR = ";";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n===== Cadastro de Alunos (" + ARQUIVO + ") =====");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar registros");
            System.out.println("3 - Calcular média das notas");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = lerInteiro();

            switch (opcao) {
                case 1: cadastrar();    break;
                case 2: listar();       break;
                case 3: exibirMedia();  break;
                case 0: System.out.println("Encerrando o sistema."); break;
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

    // ---------- Cadastro (Scanner + PrintStream) ----------

    static void cadastrar() {
        System.out.print("Nome: ");
        String nome = sc.nextLine().trim();
        System.out.print("Curso: ");
        String curso = sc.nextLine().trim();
        System.out.print("Nota (0 a 10): ");
        String textoNota = sc.nextLine().trim().replace(',', '.');

        if (nome.isEmpty() || curso.isEmpty()) {
            System.out.println("Cadastro não realizado: nome e curso são obrigatórios.");
            return;
        }
        if (nome.contains(SEPARADOR) || curso.contains(SEPARADOR)) {
            System.out.println("Cadastro não realizado: nome e curso não podem conter \"" + SEPARADOR + "\".");
            return;
        }

        double nota;
        try {
            nota = Double.parseDouble(textoNota);
        } catch (NumberFormatException e) {
            System.out.println("Cadastro não realizado: a nota deve ser numérica.");
            return;
        }
        if (nota < 0 || nota > 10) {
            System.out.println("Cadastro não realizado: a nota deve estar entre 0 e 10.");
            return;
        }

        // FileOutputStream com append = true: acrescenta ao final sem apagar os registros anteriores
        try (PrintStream ps = new PrintStream(new FileOutputStream(ARQUIVO, true), true, "UTF-8")) {
            ps.println(nome + SEPARADOR + curso + SEPARADOR + nota);
            if (ps.checkError()) {
                System.out.println("Erro ao gravar o registro no arquivo.");
            } else {
                System.out.println("Aluno " + nome + " cadastrado e gravado em " + ARQUIVO + ".");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Não foi possível abrir " + ARQUIVO + " para gravação: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro de entrada/saída: " + e.getMessage());
        }
    }

    // ---------- Leitura (FileInputStream + InputStreamReader + BufferedReader) ----------

    // Retorna false (e informa o motivo) se o arquivo não existir ou estiver vazio
    static boolean arquivoDisponivel() {
        File f = new File(ARQUIVO);
        if (!f.exists()) {
            System.out.println("O arquivo " + ARQUIVO + " ainda não existe. Cadastre um aluno primeiro.");
            return false;
        }
        if (f.length() == 0) {
            System.out.println("O arquivo " + ARQUIVO + " está vazio.");
            return false;
        }
        return true;
    }

    static void listar() {
        if (!arquivoDisponivel()) return;

        try (FileInputStream fis = new FileInputStream(ARQUIVO);
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(isr)) {

            System.out.printf("%-4s %-25s %-25s %5s%n", "Nº", "Nome", "Curso", "Nota");
            String linha;
            int n = 0;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(SEPARADOR);
                if (campos.length != 3) {
                    System.out.println("  (linha ignorada, formato inválido: \"" + linha + "\")");
                    continue;
                }
                n++;
                System.out.printf("%-4d %-25s %-25s %5s%n", n, campos[0], campos[1], campos[2]);
            }
            System.out.println("Total de registros: " + n);

        } catch (IOException e) {
            System.out.println("Erro ao ler " + ARQUIVO + ": " + e.getMessage());
        }
    }

    // ---------- Cálculo da média ----------

    // Lê o arquivo e retorna a média das notas; lança IOException em caso de falha de leitura
    static double calcularMedia() throws IOException {
        double soma = 0;
        int quantidade = 0;

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(ARQUIVO), StandardCharsets.UTF_8))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(SEPARADOR);
                if (campos.length != 3) continue;
                try {
                    soma += Double.parseDouble(campos[2]);
                    quantidade++;
                } catch (NumberFormatException e) {
                    // nota corrompida no arquivo: o registro é desconsiderado
                }
            }
        }
        return quantidade == 0 ? 0.0 : soma / quantidade;
    }

    static void exibirMedia() {
        if (!arquivoDisponivel()) return;
        try {
            System.out.printf("Média das notas: %.2f%n", calcularMedia());
        } catch (IOException e) {
            System.out.println("Não foi possível calcular a média: " + e.getMessage());
        }
    }
}
