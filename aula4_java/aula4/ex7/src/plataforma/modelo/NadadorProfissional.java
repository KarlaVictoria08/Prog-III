package plataforma.modelo;

import plataforma.interfaces.Nadador;

public class NadadorProfissional extends Atleta implements Nadador {

    public NadadorProfissional(String nome, int idade, NivelAtleta nivel) {
        super(nome, idade, nivel);
    }

    @Override
    public void nadar() {
        System.out.println(getNome() + " está nadando.");
    }

    @Override
    public void exibirModalidades() {
        System.out.println("Modalidades: natação");
    }
}
