// Exercício 5 – Método com Exceção Propagada

/*
 * Diferença entre throw e throws:
 *
 * - throw  -> é um COMANDO usado dentro do corpo de um método para LANÇAR
 *             uma exceção naquele momento. Recebe um objeto de exceção.
 *             Ex.: throw new IdadeInvalidaException("...");
 *
 * - throws -> é uma DECLARAÇÃO feita na assinatura do método, informando
 *             que ele PODE lançar (ou repassar) determinadas exceções e que
 *             quem o chama deve tratá-las ou também declará-las.
 *             Ex.: public static void validarIdade(int idade) throws IdadeInvalidaException
 *
 * Para exceções verificadas (checked), como a IdadeInvalidaException abaixo,
 * que estende Exception, o uso de throws é obrigatório; para exceções não
 * verificadas (RuntimeException e subclasses), é opcional.
 */

// Exceção personalizada verificada (checked)
class IdadeInvalidaException extends Exception {
    public IdadeInvalidaException(String mensagem) {
        super(mensagem);
    }
}

public class Main {

    // Lança a exceção com throw e a declara com throws
    public static void validarIdade(int idade) throws IdadeInvalidaException {
        if (idade < 0) {
            throw new IdadeInvalidaException("Idade inválida: " + idade + ". A idade não pode ser negativa.");
        }
        System.out.println("Idade " + idade + " validada com sucesso.");
    }

    // Método intermediário: não trata a exceção, apenas a propaga (throws)
    public static void cadastrarPessoa(String nome, int idade) throws IdadeInvalidaException {
        System.out.println("Cadastrando " + nome + "...");
        validarIdade(idade);
        System.out.println(nome + " cadastrado(a).");
    }

    public static void main(String[] args) {
        String[] nomes  = { "Ana", "Bruno", "Carla" };
        int[]    idades = { 20, -3, 0 };

        for (int i = 0; i < nomes.length; i++) {
            try {
                cadastrarPessoa(nomes[i], idades[i]);
            } catch (IdadeInvalidaException e) {
                // A exceção lançada em validarIdade é tratada aqui, dois níveis acima
                System.out.println("Cadastro não realizado. " + e.getMessage());
            }
            System.out.println();
        }
    }
}
