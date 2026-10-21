// Exercício 5 – Enumeração para Status de Pedido

enum StatusPedido {
    AGUARDANDO_PAGAMENTO, PAGO, ENVIADO, ENTREGUE, CANCELADO
}

class Pedido {
    private int numero;
    private double valor;
    private StatusPedido status;

    public Pedido(int numero, double valor) {
        this.numero = numero;
        this.valor = valor;
        this.status = StatusPedido.AGUARDANDO_PAGAMENTO; // status inicial
    }

    public StatusPedido getStatus() { return status; }

    public void alterarStatus(StatusPedido novoStatus) {
        this.status = novoStatus;
    }

    public void exibirMensagem() {
        System.out.printf("Pedido #%d (R$ %.2f) - %s: ", numero, valor, status);
        switch (status) {
            case AGUARDANDO_PAGAMENTO:
                System.out.println("aguardando a confirmação do pagamento.");
                break;
            case PAGO:
                System.out.println("pagamento confirmado; pedido em separação.");
                break;
            case ENVIADO:
                System.out.println("pedido despachado para a transportadora.");
                break;
            case ENTREGUE:
                System.out.println("pedido entregue ao cliente.");
                break;
            case CANCELADO:
                System.out.println("pedido cancelado.");
                break;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Pedido p1 = new Pedido(101, 150.00);
        Pedido p2 = new Pedido(102, 320.50);
        Pedido p3 = new Pedido(103, 75.90);
        Pedido p4 = new Pedido(104, 999.99);
        Pedido p5 = new Pedido(105, 45.00);

        System.out.println("=== Estado inicial ===");
        p1.exibirMensagem();

        System.out.println("\n=== Acompanhando o pedido 102 ===");
        p2.alterarStatus(StatusPedido.PAGO);
        p2.exibirMensagem();
        p2.alterarStatus(StatusPedido.ENVIADO);
        p2.exibirMensagem();

        p3.alterarStatus(StatusPedido.ENTREGUE);
        p4.alterarStatus(StatusPedido.CANCELADO);
        p5.alterarStatus(StatusPedido.PAGO);

        System.out.println("\n=== Todos os pedidos ===");
        Pedido[] pedidos = { p1, p2, p3, p4, p5 };
        for (Pedido p : pedidos) {
            p.exibirMensagem();
        }
    }
}
