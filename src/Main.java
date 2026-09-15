import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Banco banco = new Banco();

        int opcao;

        do {
            System.out.println("\n=========================");
            System.out.println("       BANCO JAVA");
            System.out.println("=========================");
            System.out.println("1 - Criar Conta");
            System.out.println("2 - Listar Contas");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Transferir");
            System.out.println("0 - Sair");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:

                    System.out.println("\n=== Criar Conta ===");

                    System.out.print("Número da conta: ");
                    int numero = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Titular: ");
                    String titular = scanner.nextLine();

                    boolean criada = banco.criarConta(numero, titular);

                    if (criada) {
                        System.out.println("Conta criada com sucesso!");
                    } else {
                        System.out.println("Já existe uma conta com esse número!");
                    }

                    break;

                case 2:
                    System.out.println("\n=== Contas Cadastradas ===");
                    banco.listarContas();
                    break;

                case 3:

                    System.out.println("\n=== Depósito ===");

                    System.out.println("Número da conta: ");
                    int numeroConta = scanner.nextInt();

                    System.out.println("Valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();


                    if (banco.depositar(numeroConta, valorDeposito)) {
                        System.out.println("Depósito realizado com sucesso!");
                    } else {
                        System.out.println("Não foi possível realizar o depósito!");
                    }

                    break;

                case 4:

                    System.out.println("\n=== Saque ===");

                    System.out.println("Número da conta: ");
                    int numeroContaSaque = scanner.nextInt();

                    System.out.println("Valor da saque: ");
                    double valorSaque = scanner.nextDouble();

                    if (banco.sacar(numeroContaSaque, valorSaque)) {
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Não foi possível realizar o saque!");
                    }

                    break;

                case 5:

                    System.out.println("\n=== Transferência ===");

                    System.out.println("Número da conta de origem: ");
                    int numeroContaTransferir = scanner.nextInt();

                    System.out.println("Número da conta de destino: ");
                    int numeroContaDestino = scanner.nextInt();

                    System.out.println("Valor da transferência");
                    double valorTransferencia = scanner.nextDouble();

                    if (banco.transferir(numeroContaTransferir, numeroContaDestino, valorTransferencia)) {
                        System.out.println("Transferência realizada com sucesso!");
                    } else {
                            System.out.println("Transferencia não realizada!");
                    }

                    break;

                case 0:
                    System.out.println("\nEncerrando sistema...");
                    break;

                default:
                    System.out.println("\nOpção inválida");
            }

        } while (opcao != 0);

    }

}