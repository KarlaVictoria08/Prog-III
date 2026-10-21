// Exercício 7 – Desafio Integrador: Cadastro de Alunos
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Aluno {
    private String nome;
    private int idade;
    private double nota;

    public Aluno(String nome, int idade, double nota) {
        this.nome = nome;
        this.idade = idade;
        this.nota = nota;
    }

    @Override
    public String toString() {
        return String.format("%s, %d anos, nota %.1f", nome, idade, nota);
    }
}

public class Main {

    // ---------- Métodos de validação ----------

    // NumberFormatException: texto que não representa um inteiro
    // IllegalArgumentException: idade negativa
    public static int validarIdade(String texto) throws NumberFormatException, IllegalArgumentException {
        int idade;
        try {
            idade = Integer.parseInt(texto.trim());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Idade inválida: \"" + texto + "\" não é um número inteiro.");
        }
        if (idade < 0) {
            throw new IllegalArgumentException("Idade inválida: " + idade + ". A idade não pode ser negativa.");
        }
        return idade;
    }

    public static double validarNota(String texto) throws NumberFormatException, IllegalArgumentException {
        double nota;
        try {
            nota = Double.parseDouble(texto.trim().replace(',', '.'));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Nota inválida: \"" + texto + "\" não é um número.");
        }
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("Nota inválida: " + nota + ". A nota deve estar entre 0 e 10.");
        }
        return nota;
    }

    public static String validarNome(String texto) throws IllegalArgumentException {
        if (texto == null || texto.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido: o nome não pode ser vazio.");
        }
        return texto.trim();
    }

    // Lê os dados de um aluno; as exceções de validação são propagadas para quem chamou
    public static Aluno lerAluno(Scanner sc) throws IllegalArgumentException {
        System.out.print("Nome: ");
        String nome = validarNome(sc.nextLine());
        System.out.print("Idade: ");
        int idade = validarIdade(sc.nextLine());
        System.out.print("Nota (0 a 10): ");
        double nota = validarNota(sc.nextLine());
        return new Aluno(nome, idade, nota);
    }

    // ---------- Programa principal ----------

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Aluno> aceitos = new ArrayList<>();
        int rejeitados = 0;
        boolean continuar = true;

        System.out.println("=== Cadastro de Alunos ===");

        while (continuar) {
            System.out.println("\n--- Cadastro nº " + (aceitos.size() + rejeitados + 1) + " ---");
            try {
                Aluno a = lerAluno(sc);
                aceitos.add(a);
                System.out.println("Cadastro ACEITO: " + a);
            } catch (NumberFormatException e) {
                // NumberFormatException é subclasse de IllegalArgumentException,
                // por isso precisa vir antes no encadeamento de catch
                rejeitados++;
                System.out.println("Cadastro REJEITADO. " + e.getMessage());
            } catch (IllegalArgumentException e) {
                rejeitados++;
                System.out.println("Cadastro REJEITADO. " + e.getMessage());
            } finally {
                System.out.print("Deseja cadastrar outro aluno? (s/n): ");
                String resp = sc.hasNextLine() ? sc.nextLine().trim() : "n";
                continuar = resp.equalsIgnoreCase("s");
            }
        }

        System.out.println("\n=== Resumo ===");
        System.out.println("Cadastros aceitos:    " + aceitos.size());
        System.out.println("Cadastros rejeitados: " + rejeitados);
        if (!aceitos.isEmpty()) {
            System.out.println("\nAlunos cadastrados:");
            for (Aluno a : aceitos) {
                System.out.println("  - " + a);
            }
        }
        sc.close();
    }
}
