public class Conta {

    // ATRIBUTOS
    private int numero;
    private String titular;
    private double saldo;

    // CONSTRUTOR
    public Conta(int numero, String titular){
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0;
    }

    // MÉTODOS
    public void mostrarDados(){
        System.out.println("Numero: " + this.numero);
        System.out.println("Titular: " + this.titular);
        System.out.println("Saldo: R$ " + this.saldo);
    }

    public void depositar(double valor){
        saldo = saldo + valor;
    }

    public boolean sacar(double valor){
        if(valor <= saldo){
            saldo = saldo - valor;
            return true;
        }
        return false;
    }
    public boolean transferir(Conta destino, double valor){
        if(this.sacar(valor)){
            destino.depositar(valor);
            return true;
        }
        return false;
    }
}
