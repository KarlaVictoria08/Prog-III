// Exercício 3 – Validação de Raiz Quadrada

public class Main {

    // IllegalArgumentException é não verificada (unchecked); declará-la no throws
    // não é obrigatório, mas documenta para quem chama o método que ela pode ocorrer.
    public static double calcularRaiz(int numero) throws IllegalArgumentException {
        if (numero < 0) {
            throw new IllegalArgumentException(
                "Não existe raiz quadrada real de número negativo (valor recebido: " + numero + ").");
        }
        return Math.sqrt(numero);
    }

    public static void main(String[] args) {
        int[] testes = { 0, 25, 2, -9 };

        for (int n : testes) {
            try {
                double raiz = calcularRaiz(n);
                System.out.printf("Raiz quadrada de %d = %.4f%n", n, raiz);
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao calcular a raiz de " + n + ": " + e.getMessage());
            }
        }
    }
}
