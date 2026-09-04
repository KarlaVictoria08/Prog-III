public class Contador {
    static int totalObjetos = 0;

    public Contador() {
        totalObjetos++;
    }

    static void mostrarTotal() {
        System.out.println("Total de objetos criados: " + totalObjetos);
    }

    public static void main(String[] args) {
        Contador objeto1 = new Contador();
        Contador objeto2 = new Contador();
        Contador objeto3 = new Contador();
        Contador objeto4 = new Contador();

        Contador.mostrarTotal();
    }
}