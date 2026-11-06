// Exercício 2 – Palavras Únicas (HashSet<String>)
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> palavras = new HashSet<>();

        System.out.println("Digite palavras (uma por linha). Digite \"fim\" para encerrar.");
        while (true) {
            System.out.print("> ");
            String palavra = sc.nextLine().trim();
            if (palavra.equalsIgnoreCase("fim")) {
                break;
            }
            if (palavra.isEmpty()) {
                continue;
            }
            if (!palavras.add(palavra)) {
                System.out.println("  \"" + palavra + "\" já foi digitada e não será repetida.");
            }
        }

        System.out.println("\nPalavras únicas:");
        for (String p : palavras) {
            System.out.println("  - " + p);
        }

        // contains() diferencia maiúsculas de minúsculas: "java" não é igual a "Java"
        if (palavras.contains("Java")) {
            System.out.println("\nA palavra \"Java\" foi digitada.");
        } else {
            System.out.println("\nA palavra \"Java\" não foi digitada.");
        }

        System.out.println("Quantidade de palavras distintas: " + palavras.size());
        sc.close();
    }
}
