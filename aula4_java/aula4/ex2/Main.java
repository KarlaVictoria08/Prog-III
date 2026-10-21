// Exercício 2 – Sistema de Funcionários com Classes Abstratas
import java.util.Scanner;

abstract class Funcionario {
    private String nome;
    private String matricula;
    private double salarioBase;

    public Funcionario(String nome, String matricula, double salarioBase) {
        this.nome = nome;
        this.matricula = matricula;
        this.salarioBase = salarioBase;
    }

    public String getNome()        { return nome; }
    public String getMatricula()   { return matricula; }
    public double getSalarioBase() { return salarioBase; }

    public abstract double calcularSalario();

    public void exibir() {
        System.out.printf("%-34s | Matrícula: %-6s | Base: R$ %9.2f | Final: R$ %9.2f%n",
                nome + " (" + getClass().getSimpleName() + ")", matricula,
                salarioBase, calcularSalario());
    }
}

class FuncionarioCLT extends Funcionario {
    private static final double ADICIONAL = 0.10; // 10%

    public FuncionarioCLT(String nome, String matricula, double salarioBase) {
        super(nome, matricula, salarioBase);
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() * (1 + ADICIONAL);
    }
}

class FuncionarioComissionado extends Funcionario {
    private double comissao;

    public FuncionarioComissionado(String nome, String matricula, double salarioBase, double comissao) {
        super(nome, matricula, salarioBase);
        this.comissao = comissao;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + comissao;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe a comissão de Carlos (R$): ");
        double comissaoCarlos = sc.nextDouble();
        System.out.print("Informe a comissão de Daniela (R$): ");
        double comissaoDaniela = sc.nextDouble();

        // Referências do tipo da classe abstrata Funcionario
        Funcionario[] funcionarios = {
            new FuncionarioCLT("Ana", "1001", 3000.00),
            new FuncionarioCLT("Bruno", "1002", 2500.00),
            new FuncionarioComissionado("Carlos", "2001", 2000.00, comissaoCarlos),
            new FuncionarioComissionado("Daniela", "2002", 1800.00, comissaoDaniela)
        };

        System.out.println("\n=== Folha de pagamento ===");
        for (Funcionario f : funcionarios) {
            f.exibir(); // polimorfismo: cada subclasse calcula do seu jeito
        }
        sc.close();
    }
}
