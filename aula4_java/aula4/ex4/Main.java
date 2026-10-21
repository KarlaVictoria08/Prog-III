// Exercício 4 – Sistema de Pagamentos com Interfaces

interface Pagamento {
    void processarPagamento(double valor);
    void cancelarPagamento();
}

class PagamentoCartao implements Pagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.printf("[Cartão] Compra de R$ %.2f aprovada pela operadora.%n", valor);
    }

    @Override
    public void cancelarPagamento() {
        System.out.println("[Cartão] Estorno solicitado; o valor volta na próxima fatura.");
    }
}

class PagamentoPix implements Pagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.printf("[Pix] Transferência de R$ %.2f concluída instantaneamente.%n", valor);
    }

    @Override
    public void cancelarPagamento() {
        System.out.println("[Pix] Devolução do Pix enviada para a conta de origem.");
    }
}

class PagamentoBoleto implements Pagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.printf("[Boleto] Boleto de R$ %.2f gerado; compensação em até 3 dias úteis.%n", valor);
    }

    @Override
    public void cancelarPagamento() {
        System.out.println("[Boleto] Boleto cancelado antes do vencimento.");
    }
}

public class Main {
    public static void main(String[] args) {
        // Referências do tipo da interface Pagamento
        Pagamento[] pagamentos = {
            new PagamentoCartao(),
            new PagamentoPix(),
            new PagamentoBoleto()
        };
        double[] valores = { 250.00, 89.90, 1200.00 };

        for (int i = 0; i < pagamentos.length; i++) {
            System.out.println("--- " + pagamentos[i].getClass().getSimpleName() + " ---");
            pagamentos[i].processarPagamento(valores[i]);
            pagamentos[i].cancelarPagamento();
            System.out.println();
        }
    }
}
