package plataforma.modelo;

import plataforma.interfaces.Ciclista;
import plataforma.interfaces.Corredor;
import plataforma.interfaces.Nadador;

// Uma única classe implementando múltiplas interfaces
public class Triatleta extends Atleta implements Corredor, Nadador, Ciclista {

    public Triatleta(String nome, int idade, NivelAtleta nivel) {
        super(nome, idade, nivel);
    }

    @Override
    public void correr()  { System.out.println(getNome() + " está correndo."); }

    @Override
    public void nadar()   { System.out.println(getNome() + " está nadando."); }

    @Override
    public void pedalar() { System.out.println(getNome() + " está pedalando."); }

    @Override
    public void exibirModalidades() {
        System.out.println("Modalidades: natação, ciclismo e corrida");
    }
}
