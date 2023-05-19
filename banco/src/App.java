public class App {
    public static void main(String[] args) {
        Banco banco = new Banco();

        // Criando algumas contas
        ContaCorrente contaCorrente1 = new ContaCorrente("1234", "Usuário 1", 1000.0, 500.0);
        ContaCorrente contaCorrente2 = new ContaCorrente("5678", "Usuário 2", 2000.0, 1000.0);
        ContaPoupanca contaPoupanca1 = new ContaPoupanca("9012", "Usuário 3", 5000.0);
        ContaPoupanca contaPoupanca2 = new ContaPoupanca("3456", "Usuário 4", 3000.0);

        // Adicionando as contas ao banco
        banco.adicionarConta(contaCorrente1);
        banco.adicionarConta(contaCorrente2);
        banco.adicionarConta(contaPoupanca1);
        banco.adicionarConta(contaPoupanca2);

        // Exibindo saldo de uma conta específica
        banco.exibirSaldoConta("1234");

        // Exibindo saldo de todas as contas do banco
        banco.exibirSaldoBanco();

        // Removendo uma conta do banco
        banco.removerConta(contaCorrente1);

        // Pesquisando uma conta pelo número
        Conta conta = banco.pesquisarConta("3456");
        if (conta != null) {
            System.out.println("Conta encontrada: " + conta);
        } else {
            System.out.println("Conta não encontrada.");
        }

        // Salvando os dados do banco em um arquivo
        banco.salvarDados("dadosBanco.ser");

        // Lendo os dados do banco a partir do arquivo
        Banco bancoSalvo = Banco.lerDados("dadosBanco.ser");
        if (bancoSalvo != null) {
            System.out.println("Dados do banco salvos: " + bancoSalvo);
        }
    }
}
