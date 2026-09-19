interface Corredor {
    void correr();
}

interface Nadador {
    void nadar();
}

interface Ciclista {
    void pedalar();
}

class Triatleta implements Corredor, Nadador, Ciclista {
    private String nome;

    public Triatleta(String nome) {
        this.nome = nome;
    }

    @Override
    public void correr() {
        System.out.println(nome + " está correndo na pista de atletismo.");
    }

    @Override
    public void nadar() {
        System.out.println(nome + " está nadando em águas abertas.");
    }

    @Override
    public void pedalar() {
        System.out.println(nome + " está pedalando no circuito de ciclismo.");
    }
}

public class Exercicio3 {
    public static void main(String[] args) {
        Triatleta atleta = new Triatleta("Lucas");

        System.out.println("--- Prova de Triatlo ---");
        atleta.nadar();
        atleta.pedalar();
        atleta.correr();
    }
}