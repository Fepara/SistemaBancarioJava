import java.util.ArrayList;

public class Banco {
    private final ArrayList<Conta> contas = new ArrayList<>();

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void listarContas() {
        for (Conta conta : contas) {
            conta.mostrarDados();
            System.out.println("---------------------");
        }
    }

    public Conta buscarConta(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }

        return null;
    }

    public boolean contaExiste(int numero) {

        return buscarConta(numero) != null;

    }

    public boolean criarConta(int numero, String titular) {

        if (contaExiste(numero)) {
            return false;
        }

        Conta conta = new Conta(numero, titular);
        adicionarConta(conta);

        return true;
    }

    public boolean depositar(int numeroConta, double valor) {

        Conta conta = buscarConta(numeroConta);

        if (conta == null || valor <= 0) {
            return false;
        }

        return conta.depositar(valor);
    }

    public boolean sacar(int numeroConta, double valor) {

        Conta conta = buscarConta(numeroConta);

        if (conta == null || valor <= 0) {
            return false;
        }

        return conta.sacar(valor);
    }

    public boolean transferir(int origem, int destino, double valorTransferencia) {

        Conta contaOrigem = buscarConta(origem);
        Conta contaDestino = buscarConta(destino);

        if (contaOrigem == null || contaDestino == null) return false;

        if (contaOrigem == contaDestino) return false;

        if (valorTransferencia <= 0) return false;

        if (contaOrigem.enviarTransferencia(valorTransferencia, destino)) {
            contaDestino.receberTransferencia(valorTransferencia, origem);
            return true;
        }

        return false;
    }
}
