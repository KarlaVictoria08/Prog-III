import java.util.Scanner;

public class operacoes {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        double numero1 = entrada.nextDouble();

        System.out.print("Digite o segundo número: ");
        double numero2 = entrada.nextDouble();

        System.out.print("Digite a operação (+, -, *, /): ");
        char operacao = entrada.next().charAt(0);

        double resultado;

        if (operacao == '+') {
            resultado = numero1 + numero2;
            System.out.println("Resultado: " + resultado);
        } else if (operacao == '-') {
            resultado = numero1 - numero2;
            System.out.println("Resultado: " + resultado);
        } else if (operacao == '*') {
            resultado = numero1 * numero2;
            System.out.println("Resultado: " + resultado);
        } else if (operacao == '/') {
            resultado = numero1 / numero2;
            System.out.println("Resultado: " + resultado);
        } else {
            System.out.println("Operação inválida!");
        }

        entrada.close();
    }
}