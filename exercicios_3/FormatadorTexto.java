public class FormatadorTexto {
    public static void main(String[] args) {

        String frase = " Programação Orientada a Objetos com Java ";

        frase = frase.trim();

        System.out.println("Frase: " + frase);

        System.out.println("Quantidade de caracteres: " + frase.length());

        System.out.println("Maiúsculas: " + frase.toUpperCase());

        System.out.println("Substituição: " + frase.replace("Java", "Linguagem Java"));

        System.out.println("Caractere na posição 5: " + frase.charAt(5));
    }
}