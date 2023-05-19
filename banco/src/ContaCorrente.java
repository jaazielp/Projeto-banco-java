public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(String numeroConta, String usuario, double saldo, double limite) {
        super(numeroConta, usuario, saldo);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public void depositar(double valor) {
        double taxaServico = valor * 0.005;
        double valorDeposito = valor - taxaServico;
        setSaldo(getSaldo() + valorDeposito);
    }

    @Override
    public void sacar(double valor) {
        double taxaSaque = valor * 0.02;
        double valorSaque = valor + taxaSaque;
        double saldoTotal = getSaldo() + limite;
        
        if (valorSaque <= saldoTotal) {
            setSaldo(getSaldo() - valorSaque);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "numeroConta='" + getNumeroConta() + '\'' +
                ", usuario='" + getUsuario() + '\'' +
                ", saldo=" + getSaldo() +
                ", limite=" + limite +
                '}';
    }
}

