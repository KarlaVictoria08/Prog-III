public class Produto {
    int id;
    String nome;
    double preco;

    void aplicarDesconto(double porcentagem) {
        preco = preco - (preco * porcentagem / 100);
    }

    void exibirDetalhes() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Preço: R$ " + preco);
        System.out.println();
    }

    public static void main(String[] args) {

        Produto produto1 = new Produto();
        produto1.id = 1;
        produto1.nome = "Notebook";
        produto1.preco = 3000.00;

        Produto produto2 = new Produto();
        produto2.id = 2;
        produto2.nome = "Mouse";
        produto2.preco = 100.00;

        produto1.aplicarDesconto(10);
        produto2.aplicarDesconto(15);

        produto1.exibirDetalhes();
        produto2.exibirDetalhes();
    }
}