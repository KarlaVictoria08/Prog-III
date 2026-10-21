package plataforma.modelo;

public abstract class Atleta {
    private String nome;
    private int idade;
    private NivelAtleta nivel;

    public Atleta(String nome, int idade, NivelAtleta nivel) {
        setNome(nome);
        setIdade(idade);
        this.nivel = nivel;
    }

    public String getNome()       { return nome; }
    public int getIdade()         { return idade; }
    public NivelAtleta getNivel() { return nivel; }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do atleta não pode ser vazio.");
        }
        this.nome = nome.trim();
    }

    public void setIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("A idade não pode ser negativa: " + idade);
        }
        this.idade = idade;
    }

    public abstract void exibirModalidades();

    public void exibirInformacoes() {
        System.out.println("Nome:  " + nome);
        System.out.println("Idade: " + idade + " anos");
        System.out.println("Nível: " + nivel);
        System.out.println("Tipo:  " + getClass().getSimpleName());
        exibirModalidades();
    }
}
