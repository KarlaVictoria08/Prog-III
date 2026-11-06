// Exercício 4 – Catálogo de Livros (ArrayList<String>)
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> livros = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n===== Catálogo de Livros =====");
            System.out.println("1 - Adicionar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Pesquisar título");
            System.out.println("4 - Remover livro pelo índice");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = lerInteiro();

            switch (opcao) {
                case 1: adicionar(); break;
                case 2: listar();    break;
                case 3: pesquisar(); break;
                case 4: remover();   break;
                case 0: System.out.println("Encerrando o catálogo."); break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
        sc.close();
    }

    static int lerInteiro() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1; // tratado como opção/índice inválido
        }
    }

    static void adicionar() {
        System.out.print("Título do livro: ");
        String titulo = sc.nextLine().trim();
        if (titulo.isEmpty()) {
            System.out.println("Operação não realizada: o título não pode ser vazio.");
            return;
        }
        livros.add(titulo);
        System.out.println("Livro \"" + titulo + "\" adicionado no índice " + (livros.size() - 1) + ".");
    }

    static void listar() {
        if (livros.isEmpty()) {
            System.out.println("O catálogo está vazio.");
            return;
        }
        System.out.println("Livros cadastrados (" + livros.size() + "):");
        for (int i = 0; i < livros.size(); i++) {
            System.out.println("  [" + i + "] " + livros.get(i));
        }
    }

    static void pesquisar() {
        System.out.print("Título a pesquisar: ");
        String busca = sc.nextLine().trim();
        boolean encontrou = false;
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).equalsIgnoreCase(busca)) {
                System.out.println("Livro encontrado no índice " + i + ": " + livros.get(i));
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum livro com o título \"" + busca + "\" foi encontrado.");
        }
    }

    static void remover() {
        if (livros.isEmpty()) {
            System.out.println("Operação não realizada: o catálogo está vazio.");
            return;
        }
        listar();
        System.out.print("Índice do livro a remover: ");
        int indice = lerInteiro();
        if (indice < 0 || indice >= livros.size()) {
            System.out.println("Operação não realizada: índice inválido. Use um valor entre 0 e "
                    + (livros.size() - 1) + ".");
            return;
        }
        String removido = livros.remove(indice);
        System.out.println("Livro \"" + removido + "\" removido com sucesso.");
    }
}
