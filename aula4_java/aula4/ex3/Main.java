// Exercício 3 – Triatleta e Interfaces

interface Corredor { void correr(); }
interface Nadador  { void nadar();  }
interface Ciclista { void pedalar(); }

class Triatleta implements Corredor, Nadador, Ciclista {
    private String nome;

    public Triatleta(String nome) { this.nome = nome; }

    public String getNome() { return nome; }

    @Override
    public void correr()  { System.out.println(nome + " está correndo."); }

    @Override
    public void nadar()   { System.out.println(nome + " está nadando."); }

    @Override
    public void pedalar() { System.out.println(nome + " está pedalando."); }

    public void mostrarModalidades() {
        System.out.println("Modalidades de " + nome + ": natação, ciclismo e corrida.");
        nadar();
        pedalar();
        correr();
    }
}

public class Main {
    public static void main(String[] args) {
        Triatleta t1 = new Triatleta("Mariana");
        Triatleta t2 = new Triatleta("Rafael");

        System.out.println("=== Chamadas diretas ===");
        t1.mostrarModalidades();
        System.out.println();
        t2.mostrarModalidades();

        System.out.println("\n=== Usando referências das interfaces ===");
        Corredor c = t1;
        Nadador  n = t2;
        Ciclista p = t1;
        c.correr();
        n.nadar();
        p.pedalar();
    }
}
