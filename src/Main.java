public class Main {
    public static void main(String[] args) {
        Conta conta1 = new Conta(1001, "Felipe");
        Conta conta2 = new Conta(1222, "Maria");

        conta1.mostrarDados();
        System.out.println();

        conta2.mostrarDados();

        conta1.depositar(500);
        conta2.depositar(1000);

        System.out.println();

        conta1.mostrarDados();

        System.out.println();

        conta2.mostrarDados();

        System.out.println();

        boolean saqueRealizado = conta1.sacar(300);

        System.out.println("Saque realizado ? " + saqueRealizado);

        conta1.mostrarDados();

        boolean transferencia = conta1.transferir(conta2, 100);

        System.out.println("\nTransferencia ? " + transferencia);

        System.out.println();

        conta1.mostrarDados();

        System.out.println();

        conta2.mostrarDados();



    }

}