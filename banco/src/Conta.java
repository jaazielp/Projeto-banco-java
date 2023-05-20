import java.io.Serializable;

public abstract class Conta implements Serializable {
    private String numeroConta;
    private String usuario;
    private double saldo;

    public Conta(String numeroConta, String usuario, double saldo) {
        this.numeroConta = numeroConta;
        this.usuario = usuario;
        this.saldo = saldo;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public abstract void depositar(double valor);

    public abstract void sacar(double valor);

    @Override
    public String toString() {
        return "Conta{" +
                "numeroConta='" + numeroConta + '\'' +
                ", usuario='" + usuario + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}

