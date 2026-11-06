// Exercício 6 – Controle de Estoque (HashMap<String, Integer>)
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Map<String, Integer> estoque = new HashMap<>();

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n===== Controle de Estoque =====");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Consultar quantidade");
            System.out.println("3 - Atualizar quantidade");
            System.out.println("4 - Remover produto");
            System.out.println("5 - Exibir todos os produtos");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = lerInteiro();

            switch (opcao) {
                case 1: cadastrar(); break;
                case 2: consultar(); break;
                case 3: atualizar(); break;
                case 4: remover();   break;
                case 5: exibir();    break;
                case 0: System.out.println("Encerrando o controle de estoque."); break;
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

    static String lerNome() {
        System.out.print("Nome do produto: ");
        return sc.nextLine().trim();
    }

    static int lerQuantidade() {
        System.out.print("Quantidade: ");
        int q = lerInteiro();
        if (q < 0) {
            System.out.println("Quantidade inválida: informe um inteiro maior ou igual a zero.");
        }
        return q;
    }

    static void cadastrar() {
        String nome = lerNome();
        if (nome.isEmpty()) {
            System.out.println("O nome não pode ser vazio.");
            return;
        }
        if (estoque.containsKey(nome)) {
            System.out.println("O produto \"" + nome + "\" já existe. Use a opção 3 para atualizar.");
            return;
        }
        int q = lerQuantidade();
        if (q < 0) return;
        estoque.put(nome, q);
        System.out.println("Produto \"" + nome + "\" cadastrado com " + q + " unidade(s).");
    }

    static void consultar() {
        String nome = lerNome();
        Integer q = estoque.get(nome); // null se o produto não existir
        if (q == null) {
            System.out.println("Produto \"" + nome + "\" não encontrado.");
        } else {
            System.out.println("Produto \"" + nome + "\": " + q + " unidade(s).");
        }
    }

    static void atualizar() {
        String nome = lerNome();
        if (!estoque.containsKey(nome)) {
            System.out.println("Produto \"" + nome + "\" não encontrado.");
            return;
        }
        int q = lerQuantidade();
        if (q < 0) return;
        int anterior = estoque.put(nome, q); // put substitui e retorna o valor antigo
        System.out.println("Quantidade de \"" + nome + "\" atualizada de " + anterior + " para " + q + ".");
    }

    static void remover() {
        String nome = lerNome();
        Integer removido = estoque.remove(nome);
        if (removido == null) {
            System.out.println("Produto \"" + nome + "\" não encontrado; nada foi removido.");
        } else {
            System.out.println("Produto \"" + nome + "\" removido (tinha " + removido + " unidade(s)).");
        }
    }

    static void exibir() {
        if (estoque.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        System.out.println("Produtos em estoque:");
        for (Map.Entry<String, Integer> item : estoque.entrySet()) {
            System.out.println("  " + item.getKey() + ": " + item.getValue() + " unidade(s)");
        }
    }
}
