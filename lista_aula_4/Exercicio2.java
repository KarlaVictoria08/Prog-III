enum NivelAcesso {
    BASICO,
    INTERMEDIARIO,
    ADMIN
}

class Usuario {
    private String nome;
    private NivelAcesso nivelAcesso;

    public Usuario(String nome, NivelAcesso nivelAcesso) {
        this.nome = nome;
        this.nivelAcesso = nivelAcesso;
    }

    public String getNome() {
        return nome;
    }

    public NivelAcesso getNivelAcesso() {
        return nivelAcesso;
    }

    public void exibirMensagemBoasVindas() {
        switch (nivelAcesso) {
            case BASICO:
                System.out.println("Usuário: " + nome + " | Acesso Restrito: Apenas visualização de relatórios públicos.");
                break;
            case INTERMEDIARIO:
                System.out.println("Usuário: " + nome + " | Acesso Moderado: Permissão para criar e editar conteúdos.");
                break;
            case ADMIN:
                System.out.println("Usuário: " + nome + " | Acesso Total: Controle total de configurações e usuários do sistema.");
                break;
        }
    }
}

public class Exercicio2 {
    public static void main(String[] args) {
        Usuario u1 = new Usuario("Ana", NivelAcesso.BASICO);
        Usuario u2 = new Usuario("Bruno", NivelAcesso.INTERMEDIARIO);
        Usuario u3 = new Usuario("Carla", NivelAcesso.ADMIN);

        u1.exibirMensagemBoasVindas();
        u2.exibirMensagemBoasVindas();
        u3.exibirMensagemBoasVindas();
    }
}