package plataforma.modelo;

import plataforma.interfaces.Corredor;

public class CorredorProfissional extends Atleta implements Corredor {

    public CorredorProfissional(String nome, int idade, NivelAtleta nivel) {
        super(nome, idade, nivel);
    }

    @Override
    public void correr() {
        System.out.println(getNome() + " está correndo.");
    }

    @Override
    public void exibirModalidades() {
        System.out.println("Modalidades: corrida");
    }
}
