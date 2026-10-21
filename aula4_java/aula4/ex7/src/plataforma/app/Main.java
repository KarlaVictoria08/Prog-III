package plataforma.app;

import plataforma.interfaces.Ciclista;
import plataforma.interfaces.Corredor;
import plataforma.interfaces.Nadador;
import plataforma.modelo.*;

public class Main {
    public static void main(String[] args) {
        // 1) Referências da classe abstrata Atleta
        Atleta[] atletas = {
            new CorredorProfissional("João", 28, NivelAtleta.PROFISSIONAL),
            new NadadorProfissional("Beatriz", 22, NivelAtleta.AMADOR),
            new Triatleta("Mariana", 31, NivelAtleta.PROFISSIONAL),
            new Triatleta("Pedro", 19, NivelAtleta.NOVATO)
        };

        System.out.println("===== Informações dos atletas =====");
        for (Atleta a : atletas) {
            a.exibirInformacoes();
            System.out.println("-----------------------------------");
        }

        // 2) Referências das interfaces para executar as modalidades
        System.out.println("\n===== Execução das modalidades =====");
        for (Atleta a : atletas) {
            System.out.println(a.getNome() + " [" + a.getNivel() + "]:");
            if (a instanceof Nadador) {
                Nadador n = (Nadador) a;
                n.nadar();
            }
            if (a instanceof Ciclista) {
                Ciclista c = (Ciclista) a;
                c.pedalar();
            }
            if (a instanceof Corredor) {
                Corredor c = (Corredor) a;
                c.correr();
            }
            System.out.println();
        }

        // 3) Uma mesma classe implementando múltiplas interfaces
        System.out.println("===== Múltiplas interfaces =====");
        Triatleta t = (Triatleta) atletas[2];
        Corredor comoCorredor = t;
        Nadador  comoNadador  = t;
        Ciclista comoCiclista = t;
        System.out.println(t.getNome() + " é Corredor? " + (t instanceof Corredor));
        System.out.println(t.getNome() + " é Nadador?  " + (t instanceof Nadador));
        System.out.println(t.getNome() + " é Ciclista? " + (t instanceof Ciclista));
        comoCorredor.correr();
        comoNadador.nadar();
        comoCiclista.pedalar();

        // 4) Validações (desafio adicional)
        System.out.println("\n===== Testes de validação =====");
        try {
            new CorredorProfissional("Lucas", -5, NivelAtleta.NOVATO);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        try {
            new NadadorProfissional("   ", 20, NivelAtleta.AMADOR);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
