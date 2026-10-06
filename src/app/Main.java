package app;
import model.Conta;
import service.Banco;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Banco banco = new Banco();

        banco.carregarContas();

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
            System.out.println("6 - Ver Extrato");
            System.out.println("0 - Sair");

            try {

                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();

            } catch (InputMismatchException e) {

                System.out.println("Digite apenas números!");

                scanner.nextLine();

                opcao = -1;
            }

            switch (opcao) {
                case 1:

                    System.out.println("\n=== Criar Conta ===");

                    int numero = lerInteiro(scanner, "Número da conta: ");

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

                    int numeroConta = lerInteiro(scanner, "Número da conta: ");

                    double valorDeposito = lerDouble(scanner, "Valor do depósito: ");

                    if (banco.depositar(numeroConta, valorDeposito)) {
                        System.out.println("Depósito realizado com sucesso!");
                    } else {
                        System.out.println("Conta não encontrada ou valor inválido!");
                    }

                    break;

                case 4:

                    System.out.println("\n=== Saque ===");

                    int numeroContaSaque = lerInteiro(scanner, "Número da conta: ");

                    double valorSaque = lerDouble(scanner, "Valor do saque: ");

                    if (banco.sacar(numeroContaSaque, valorSaque)) {
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Conta não encontrada, saldo insuficiente ou valor inválido!");
                    }

                    break;

                case 5:

                    System.out.println("\n=== Transferência ===");

                    int origem = lerInteiro(scanner, "Conta de origem: ");

                    int destino = lerInteiro(scanner, "Conta de destino: ");

                    double valorTransferencia = lerDouble(scanner, "Valor da transferência: ");

                    if (banco.transferir(origem, destino, valorTransferencia)) {
                        System.out.println("Transferência realizada com sucesso!");
                    } else {
                        System.out.println("Transferência não realizada!");
                    }

                    break;

                case 6:

                    System.out.println("\n=== Extrato ===");

                    int numeroExtrato = lerInteiro(scanner, "Número da conta: ");

                    Conta contaExtrato = banco.buscarConta(numeroExtrato);

                    if (contaExtrato != null) {
                        contaExtrato.mostrarDados();
                        contaExtrato.mostrarHistorico();
                    } else {
                        System.out.println("Conta não encontrada!");
                    }

                    break;

                case 0:
                    banco.salvarContas();

                    System.out.println("Encerrando o sistema...");

                    break;

                default:
                    System.out.println("\nOpção inválida");
            }

        } while (opcao != 0);

        scanner.close();

    }

    public static int lerInteiro(Scanner scanner, String mensagem) {

        while (true) {
            try {
                System.out.print(mensagem);
                return scanner.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Digite um número inteiro válido!");
                scanner.nextLine();
            }
        }
    }

    public static double lerDouble(Scanner scanner, String mensagem) {

        while (true) {
            try {
                System.out.print(mensagem);
                return scanner.nextDouble();

            } catch (InputMismatchException e) {
                System.out.println("Digite um número válido!");
                scanner.nextLine();
            }
        }
    }

}