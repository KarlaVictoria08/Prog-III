// Exercício 1 – Lista de Números (ArrayList<Integer>)
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<>();
        final int QUANTIDADE = 10;

        System.out.println("Digite " + QUANTIDADE + " números inteiros:");
        while (numeros.size() < QUANTIDADE) {
            System.out.print("Número " + (numeros.size() + 1) + ": ");
            String entrada = sc.nextLine().trim();
            try {
                numeros.add(Integer.parseInt(entrada));
            } catch (NumberFormatException e) {
                System.out.println("  Valor inválido. Digite um número inteiro.");
            }
        }

        System.out.println("\nNúmeros cadastrados: " + numeros);

        int soma = 0;
        for (int n : numeros) {
            soma += n;
        }
        double media = (double) soma / numeros.size();
        System.out.println("Soma:  " + soma);
        System.out.printf("Média: %.2f%n", media);

        numeros.removeIf(n -> n % 2 == 0);
        System.out.println("\nLista após remover os pares: " + numeros);

        sc.close();
    }
}
