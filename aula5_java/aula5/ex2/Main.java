// Exercício 2 – Conversão de Texto para Número
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Digite um número inteiro: ");
            String texto = sc.nextLine();

            int numero = Integer.parseInt(texto.trim());
            System.out.println("Conversão realizada com sucesso. Valor inteiro: " + numero);
            System.out.println("O dobro do valor é: " + (numero * 2));
        } catch (NumberFormatException e) {
            System.out.println("Erro: o texto informado não representa um número inteiro válido.");
            System.out.println("Exemplos válidos: 42, -7, 0. Letras e números decimais (ex.: 3.5) não são aceitos.");
        } finally {
            // Executado sempre, com ou sem exceção
            System.out.println("Encerrando programa...");
            sc.close();
        }
    }
}
