// Exercício 6 – Sistema de Acesso com Enum e Classes

enum NivelAcesso {
    BASICO, INTERMEDIARIO, ADMIN
}

class Usuario {
    private String nome;
    private NivelAcesso nivel;

    public Usuario(String nome, NivelAcesso nivel) {
        this.nome = nome;
        this.nivel = nivel;
    }

    public String getNome()       { return nome; }
    public NivelAcesso getNivel() { return nivel; }

    public boolean verificarPermissao(String recurso) {
        switch (recurso) {
            case "CONSULTAR":
                return true; // todos os níveis podem consultar
            case "EDITAR":
                return nivel == NivelAcesso.INTERMEDIARIO || nivel == NivelAcesso.ADMIN;
            case "GERENCIAR_USUARIOS":
                return nivel == NivelAcesso.ADMIN;
            default:
                System.out.println("  Recurso desconhecido: " + recurso);
                return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Usuario[] usuarios = {
            new Usuario("Ana", NivelAcesso.BASICO),
            new Usuario("Bruno", NivelAcesso.INTERMEDIARIO),
            new Usuario("Carla", NivelAcesso.ADMIN)
        };
        String[] recursos = { "CONSULTAR", "EDITAR", "GERENCIAR_USUARIOS" };

        for (Usuario u : usuarios) {
            System.out.println(u.getNome() + " (" + u.getNivel() + "):");
            for (String r : recursos) {
                String resultado = u.verificarPermissao(r) ? "PERMITIDO" : "NEGADO";
                System.out.printf("  %-20s -> %s%n", r, resultado);
            }
            System.out.println();
        }

        System.out.println("Teste com recurso inexistente:");
        usuarios[2].verificarPermissao("EXCLUIR_SISTEMA");
    }
}
