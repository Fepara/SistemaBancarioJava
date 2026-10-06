package model;
import java.util.ArrayList;

public class Conta {


    private final  int numero;
    private final String titular;
    private double saldo;
    private final ArrayList<String> historico;


    public Conta(int numero, String titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0;
        this.historico = new ArrayList<>();
    }

    public int getNumero() {

        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void definirSaldo(double saldo) {
        this.saldo = saldo;
    }


    public void mostrarDados() {
        System.out.println("Numero: " + this.numero);
        System.out.println("Titular: " + this.titular);
        System.out.println("Saldo: R$ " + this.saldo);
    }

    public boolean depositar(double valor) {

        if (valor > 0) {
            saldo += valor;

            adicionarHistorico("+ Depósito: R$ " + valor);

            return true;
        }

        return false;
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;

            adicionarHistorico("- Saque: R$ " + valor);

            return true;
        }
        return false;
    }

    public void adicionarHistorico(String operacao) {
        historico.add(operacao);
    }

    public void mostrarHistorico() {

        System.out.println("\n=== HISTÓRICO DE OPERAÇÕES ===");

        if (historico.isEmpty()) {
            System.out.println("Nenhuma operação realizada.");
            return;
        }

        for (String operacao : historico) {
            System.out.println(operacao);
        }

    }

    public boolean enviarTransferencia(double valor, int contaDestino) {

        if (valor > 0 && valor <= saldo) {
            saldo -= valor;

            adicionarHistorico(
                    "Transferência enviada: R$ " + valor +
                            " para conta " + contaDestino
            );

            return true;
        }

        return false;
    }

    public void receberTransferencia(double valor, int contaOrigem) {

        saldo += valor;

        adicionarHistorico(
                "Transferência recebida: R$ " + valor +
                        " da conta " + contaOrigem
        );
    }
}
