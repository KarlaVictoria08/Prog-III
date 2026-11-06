// Exercício 3 – Cadastro e Consulta de Pessoas (HashMap<String, Integer>)
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> pessoas = new HashMap<>();
        final int MINIMO = 5;

        System.out.println("=== Cadastro de " + MINIMO + " pessoas ===");
        while (pessoas.size() < MINIMO) {
            System.out.print("\nNome da pessoa " + (pessoas.size() + 1) + ": ");
            String nome = sc.nextLine().trim();
            if (nome.isEmpty()) {
                System.out.println("  O nome não pode ser vazio.");
                continue;
            }
            if (pessoas.containsKey(nome)) {
                System.out.println("  " + nome + " já está cadastrado(a).");
                continue;
            }
            System.out.print("Idade: ");
            try {
                int idade = Integer.parseInt(sc.nextLine().trim());
                if (idade < 0) {
                    System.out.println("  A idade não pode ser negativa.");
                    continue;
                }
                pessoas.put(nome, idade);
            } catch (NumberFormatException e) {
                System.out.println("  Idade inválida. Digite um número inteiro.");
            }
        }

        System.out.println("\nPessoas cadastradas: " + pessoas);

        // Consulta
        System.out.print("\nInforme um nome para consultar: ");
        String consulta = sc.nextLine().trim();
        if (pessoas.containsKey(consulta)) {
            System.out.println(consulta + " tem " + pessoas.get(consulta) + " anos.");
        } else {
            System.out.println("O nome \"" + consulta + "\" não está cadastrado.");
        }

        // Remoção
        System.out.print("\nInforme um nome para remover: ");
        String remover = sc.nextLine().trim();
        Integer removida = pessoas.remove(remover); // retorna null se a chave não existir
        if (removida != null) {
            System.out.println(remover + " (" + removida + " anos) foi removido(a).");
        } else {
            System.out.println("Não foi possível remover: \"" + remover + "\" não está cadastrado.");
        }

        System.out.println("\nMapa atualizado: " + pessoas);
        sc.close();
    }
}
