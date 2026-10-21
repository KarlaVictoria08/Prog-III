// Exercício 1 – Sistema de Contas Bancárias

abstract class ContaBancaria {
    private String titular;
    protected double saldo;

    public ContaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public String getTitular() { return titular; }
    public double getSaldo()   { return saldo; }

    public abstract boolean sacar(double valor);
    public abstract void depositar(double valor);

    public void exibirSaldo() {
        System.out.printf("%s (%s) - Saldo: R$ %.2f%n",
                titular, getClass().getSimpleName(), saldo);
    }
}

class ContaCorrente extends ContaBancaria {
    private static final double TAXA_SAQUE = 1.00;

    public ContaCorrente(String titular, double saldoInicial) {
        super(titular, saldoInicial);
    }

    @Override
    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Depósito inválido: o valor deve ser positivo.");
            return;
        }
        saldo += valor;
        System.out.printf("Depósito de R$ %.2f realizado na conta corrente de %s.%n", valor, getTitular());
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Saque inválido: o valor deve ser positivo.");
            return false;
        }
        double total = valor + TAXA_SAQUE;
        if (total > saldo) {
            System.out.printf("Saque de R$ %.2f negado para %s: saldo insuficiente "
                    + "(necessário R$ %.2f com a taxa, disponível R$ %.2f).%n",
                    valor, getTitular(), total, saldo);
            return false;
        }
        saldo -= total;
        System.out.printf("Saque de R$ %.2f + taxa de R$ %.2f realizado na conta corrente de %s.%n",
                valor, TAXA_SAQUE, getTitular());
        return true;
    }
}

class ContaPoupanca extends ContaBancaria {

    public ContaPoupanca(String titular, double saldoInicial) {
        super(titular, saldoInicial);
    }

    @Override
    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Depósito inválido: o valor deve ser positivo.");
            return;
        }
        saldo += valor;
        System.out.printf("Depósito de R$ %.2f realizado na poupança de %s.%n", valor, getTitular());
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Saque inválido: o valor deve ser positivo.");
            return false;
        }
        if (valor > saldo) {
            System.out.printf("Saque de R$ %.2f negado para %s: saldo insuficiente (disponível R$ %.2f).%n",
                    valor, getTitular(), saldo);
            return false;
        }
        saldo -= valor;
        System.out.printf("Saque de R$ %.2f realizado na poupança de %s (sem taxa).%n", valor, getTitular());
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        ContaBancaria cc = new ContaCorrente("Ana", 100.00);
        ContaBancaria cp = new ContaPoupanca("Bruno", 50.00);

        System.out.println("=== Operações válidas ===");
        cc.depositar(200.00);   // 300,00
        cc.sacar(50.00);        // 300 - 51 = 249,00
        cp.depositar(150.00);   // 200,00
        cp.sacar(80.00);        // 120,00

        System.out.println("\n=== Saques inválidos ===");
        cc.sacar(249.00);       // precisa de 250,00 com a taxa -> negado
        cp.sacar(500.00);       // saldo insuficiente -> negado
        cc.sacar(-10.00);       // valor negativo -> negado
        cp.depositar(0);        // depósito inválido

        System.out.println("\n=== Saque exato (conta corrente) ===");
        cc.sacar(248.00);       // 248 + 1 = 249 -> saldo fica 0,00

        System.out.println("\n=== Saldos finais ===");
        cc.exibirSaldo();
        cp.exibirSaldo();
    }
}
