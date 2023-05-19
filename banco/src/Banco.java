import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Banco implements Serializable {
    private List<Conta> contas;
    private double taxa;

    public Banco() {
        contas = new ArrayList<>();
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

    public void salvarDados(String arquivo) {
        try {
            FileOutputStream fileOut = new FileOutputStream(arquivo);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    public static Banco lerDados(String arquivo) {
        try {
            FileInputStream fileIn = new FileInputStream(arquivo);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Banco banco = (Banco) in.readObject();
            in.close();
            fileIn.close();
            return banco;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao ler os dados: " + e.getMessage());
            return null;
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

