// Exercício 5 – Cadastro de Participantes sem Duplicatas (HashSet<String>)
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> participantes = new HashSet<>();
        int tentativas = 0;

        System.out.println("Registre os participantes. Digite \"fim\" para encerrar.");
        while (true) {
            System.out.print("Nome: ");
            String nome = sc.nextLine().trim();
            if (nome.equalsIgnoreCase("fim")) {
                break;
            }
            if (nome.isEmpty()) {
                continue;
            }
            tentativas++;
            // add() retorna false quando o elemento já existe no conjunto
            if (participantes.add(nome)) {
                System.out.println("  " + nome + " registrado(a).");
            } else {
                System.out.println("  " + nome + " já estava inscrito(a); o conjunto não armazena duplicatas.");
            }
        }

        System.out.println("\nParticipantes únicos:");
        for (String p : participantes) {
            System.out.println("  - " + p);
        }
        System.out.println("Nomes digitados: " + tentativas
                + " | Participantes distintos: " + participantes.size());

        System.out.print("\nInforme um nome para verificar a inscrição: ");
        String busca = sc.nextLine().trim();
        if (participantes.contains(busca)) {
            System.out.println(busca + " está inscrito(a) no evento.");
        } else {
            System.out.println(busca + " não está inscrito(a) no evento.");
        }
        sc.close();
    }
}
