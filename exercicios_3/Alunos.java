import java.util.ArrayList;
import java.util.Iterator;

public class Alunos {
    public static void main(String[] args) {

        ArrayList<String> alunos = new ArrayList<>();

        alunos.add("Ana");
        alunos.add("Bruno");
        alunos.add("Carlos");
        alunos.add("Daniela");
        alunos.add("Eduardo");

        System.out.println("Lista de alunos:");

        Iterator<String> iterator = alunos.iterator();

        while (iterator.hasNext()) {
            String nome = iterator.next();
            System.out.println(nome);
        }

        alunos.remove("Carlos");

        System.out.println("\nLista atualizada:");

        iterator = alunos.iterator();

        while (iterator.hasNext()) {
            String nome = iterator.next();
            System.out.println(nome);
        }
    }
}