// Exercício 1 – Divisão Segura
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int TESTES = 3;

        System.out.println("=== Divisão Segura ===");
        System.out.println("Serão realizados " + TESTES + " testes.\n");

        for (int i = 1; i <= TESTES; i++) {
            System.out.println("Teste " + i + ":");
            try {
                System.out.print("  Dividendo (inteiro): ");
                int a = Integer.parseInt(sc.nextLine().trim());
                System.out.print("  Divisor (inteiro): ");
                int b = Integer.parseInt(sc.nextLine().trim());

                int resultado = a / b; // lança ArithmeticException se b == 0
                System.out.println("  Resultado: " + a + " / " + b + " = " + resultado);
            } catch (ArithmeticException e) {
                System.out.println("  Não é possível dividir por zero. Informe um divisor diferente de 0.");
            } catch (NumberFormatException e) {
                System.out.println("  Entrada inválida: digite apenas números inteiros.");
            }
            System.out.println();
        }

        System.out.println("Fim dos testes.");
        sc.close();
    }
}
