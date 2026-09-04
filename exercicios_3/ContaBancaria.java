import java.util.ArrayList;
import java.util.Iterator;

public class ContaBancaria {
    int numero;
    String titular;
    double saldo;

    public ContaBancaria(int numero, String titular, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    public static void main(String[] args) {

        ArrayList<ContaBancaria> contas = new ArrayList<>();

        contas.add(new ContaBancaria(101, "Ana", 1500.00));
        contas.add(new ContaBancaria(102, "Bruno", 2500.00));
        contas.add(new ContaBancaria(103, "Carlos", 1000.00));

        Iterator<ContaBancaria> iterator = contas.iterator();

        double totalSaldo = 0;

        while (iterator.hasNext()) {
            ContaBancaria conta = iterator.next();

            System.out.println("Número: " + conta.numero);
            System.out.println("Titular: " + conta.titular);

            totalSaldo += conta.saldo;
        }

        System.out.println("Saldo total: R$ " + totalSaldo);
    }
}