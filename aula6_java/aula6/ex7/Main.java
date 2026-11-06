// Exercício 7 – Desafio Integrador: Registro de Notas (Map<String, List<Double>>)
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Map<String, List<Double>> notas = new HashMap<>();

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n===== Registro de Notas =====");
            System.out.println("1 - Cadastrar aluno / adicionar notas");
            System.out.println("2 - Listar alunos e médias");
            System.out.println("3 - Consultar aluno");
            System.out.println("4 - Remover aluno");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = lerInteiro();

            switch (opcao) {
                case 1: cadastrar(); break;
                case 2: listar();    break;
                case 3: consultar(); break;
                case 4: remover();   break;
                case 0: System.out.println("Encerrando o registro de notas."); break;
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

    static double calcularMedia(List<Double> lista) {
        if (lista.isEmpty()) return 0.0;
        double soma = 0;
        for (double n : lista) {
            soma += n;
        }
        return soma / lista.size();
    }

    static void exibirAluno(String nome) {
        List<Double> lista = notas.get(nome);
        System.out.printf("  %-15s Notas: %-25s Média: %.2f%n", nome, lista, calcularMedia(lista));
    }

    static void cadastrar() {
        System.out.print("Nome do aluno: ");
        String nome = sc.nextLine().trim();
        if (nome.isEmpty()) {
            System.out.println("O nome não pode ser vazio.");
            return;
        }

        if (!notas.containsKey(nome)) {
            notas.put(nome, new ArrayList<>());
            System.out.println("Aluno " + nome + " cadastrado.");
        } else {
            System.out.println("Aluno " + nome + " já existe; as novas notas serão adicionadas.");
        }

        List<Double> lista = notas.get(nome);
        System.out.println("Digite as notas (0 a 10). Deixe em branco para terminar.");
        while (true) {
            System.out.print("  Nota " + (lista.size() + 1) + ": ");
            String entrada = sc.nextLine().trim();
            if (entrada.isEmpty()) break;
            try {
                double nota = Double.parseDouble(entrada.replace(',', '.'));
                if (nota < 0 || nota > 10) {
                    System.out.println("  Nota fora do intervalo 0 a 10; não registrada.");
                } else {
                    lista.add(nota);
                }
            } catch (NumberFormatException e) {
                System.out.println("  Valor inválido; digite um número.");
            }
        }
        exibirAluno(nome);
    }

    static void listar() {
        if (notas.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        System.out.println("Alunos cadastrados:");
        for (String nome : notas.keySet()) {
            exibirAluno(nome);
        }
    }

    static void consultar() {
        System.out.print("Nome do aluno: ");
        String nome = sc.nextLine().trim();
        if (notas.containsKey(nome)) {
            exibirAluno(nome);
        } else {
            System.out.println("Aluno \"" + nome + "\" não encontrado.");
        }
    }

    static void remover() {
        System.out.print("Nome do aluno a remover: ");
        String nome = sc.nextLine().trim();
        if (notas.remove(nome) != null) {
            System.out.println("Aluno " + nome + " removido.");
            listar();
        } else {
            System.out.println("Aluno \"" + nome + "\" não encontrado; nada foi removido.");
        }
    }
}
