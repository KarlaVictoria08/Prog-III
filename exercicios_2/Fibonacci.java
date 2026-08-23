public class Fibonacci {
    public static void main(String[] args) {
        int primeiro = 1;
        int segundo = 1;

        System.out.println(primeiro);
        System.out.println(segundo);

        for (int i = 3; i <= 30; i++) {
            int proximo = primeiro + segundo;

            System.out.println(proximo);

            primeiro = segundo;
            segundo = proximo;
        }
    }
}