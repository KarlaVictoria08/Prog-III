// Exercício 6 – Registro de Produto com Tratamento de Erros
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Descrição do produto: ");
            String descricao = sc.nextLine().trim();

            System.out.print("Preço unitário (ex.: 12.50): ");
            double preco = Double.parseDouble(sc.nextLine().trim().replace(',', '.'));

            System.out.print("Quantidade em estoque: ");
            int quantidade = Integer.parseInt(sc.nextLine().trim());

            if (preco < 0) {
                throw new IllegalArgumentException("O preço não pode ser negativo (informado: " + preco + ").");
            }
            if (quantidade < 0) {
                throw new IllegalArgumentException("A quantidade não pode ser negativa (informada: " + quantidade + ").");
            }

            double total = preco * quantidade;
            System.out.println("\nProduto registrado com sucesso!");
            System.out.println("Descrição:   " + descricao);
            System.out.printf("Preço:       R$ %.2f%n", preco);
            System.out.println("Quantidade:  " + quantidade);
            System.out.printf("Valor total do estoque: R$ %.2f%n", total);

        } catch (NumberFormatException e) {
            System.out.println("Erro: preço e quantidade devem ser numéricos "
                    + "(preço pode ter casas decimais; quantidade deve ser inteira).");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            System.out.println("Registro de produto encerrado.");
            sc.close();
        }
    }
}
