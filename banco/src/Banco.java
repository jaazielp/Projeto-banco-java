import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Banco implements Serializable {
    private List<Conta> contas;
    private double taxa;

    public Banco() {
        contas = new ArrayList<Conta>();
        taxa = 0.0;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void removerConta(Conta conta) {
        contas.remove(conta);
    }

    public Conta pesquisarConta(String numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }

    public void exibirSaldoConta(String numeroConta) {
        Conta conta = pesquisarConta(numeroConta);
        if (conta != null) {
            System.out.println("Saldo da conta " + numeroConta + ": " + conta.getSaldo());
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void exibirSaldoBanco() {
        System.out.println("Saldo de todas as contas do banco:");
        for (Conta conta : contas) {
            System.out.println("Conta " + conta.getNumeroConta() + ": " + conta.getSaldo());
        }
    }

    @Override
    public String toString() {
        return "Banco{" +
                "contas=" + contas +
                ", taxa=" + taxa +
                '}';
    }
}

