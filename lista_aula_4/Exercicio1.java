abstract class ContaBancaria {
    protected double saldo;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public abstract boolean sacar(double valor);
    public abstract void depositar(double valor);
}

class ContaCorrente extends ContaBancaria {
    private static final double TAXA_SAQUE = 1.00;

    public ContaCorrente(double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public boolean sacar(double valor) {
        double valorTotal = valor + TAXA_SAQUE;
        if (valor > 0 && saldo >= valorTotal) {
            saldo -= valorTotal;
            System.out.println("Saque de R$ " + valor + " realizado na Conta Corrente (Taxa: R$ 1,00).");
            return true;
        }
        System.out.println("Saque de R$ " + valor + " recusado na Conta Corrente. Saldo insuficiente.");
        return false;
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado na Conta Corrente.");
        }
    }
}

class ContaPoupanca extends ContaBancaria {

    public ContaPoupanca(double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado na Conta Poupança (Sem taxa).");
            return true;
        }
        System.out.println("Saque de R$ " + valor + " recusado na Conta Poupança. Saldo insuficiente.");
        return false;
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado na Conta Poupança.");
        }
    }
}

public class Exercicio1 {
    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente(100.00);
        ContaPoupanca cp = new ContaPoupanca(100.00);

        System.out.println("--- Teste Conta Corrente ---");
        System.out.println("Saldo inicial CC: R$ " + cc.getSaldo());
        cc.depositar(50.00);
        cc.sacar(30.00); // Deduz R$ 30,00 + R$ 1,00 taxa
        System.out.println("Saldo final CC: R$ " + cc.getSaldo());

        System.out.println("\n--- Teste Conta Poupança ---");
        System.out.println("Saldo inicial CP: R$ " + cp.getSaldo());
        cp.depositar(50.00);
        cp.sacar(30.00); // Deduz R$ 30,00 sem taxa
        System.out.println("Saldo final CP: R$ " + cp.getSaldo());
    }
}
