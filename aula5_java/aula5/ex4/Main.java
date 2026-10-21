// Exercício 4 – Acesso a Posições de um Vetor
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nomes = { "Ana", "Bruno", "Carla", "Daniel", "Eduarda" };

        System.out.println("=== Consulta de nomes ===");
        System.out.println("O vetor possui " + nomes.length + " nomes (índices de 0 a " + (nomes.length - 1) + ").");
        System.out.println("Digite 'sair' para encerrar.\n");

        while (true) {
            System.out.print("Informe o índice: ");
            String entrada = sc.nextLine().trim();

            if (entrada.equalsIgnoreCase("sair")) {
                break;
            }

            try {
                int indice = Integer.parseInt(entrada);
                System.out.println("Nome na posição " + indice + ": " + nomes[indice]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Posição inexistente. Informe um índice entre 0 e " + (nomes.length - 1) + ".");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida: digite um número inteiro.");
            }
            System.out.println();
        }

        System.out.println("Programa encerrado.");
        sc.close();
    }
}
