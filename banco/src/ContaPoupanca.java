public class ContaPoupanca extends Conta {
    public ContaPoupanca(String numeroConta, String usuario, double saldo) {
        super(numeroConta, usuario, saldo);
    }

    @Override
    public void depositar(double valor) {
        double taxaJuros = valor * 0.005;
        double valorDeposito = valor + taxaJuros;
        setSaldo(getSaldo() + valorDeposito);
    }

    @Override
    public void sacar(double valor) {
        if (valor <= getSaldo()) {
            setSaldo(getSaldo() - valor);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "numeroConta='" + getNumeroConta() + '\'' +
                ", usuario='" + getUsuario() + '\'' +
                ", saldo=" + getSaldo() +
                '}';
    }
}

