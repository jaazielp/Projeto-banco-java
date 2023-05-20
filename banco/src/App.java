public class App {
    public static void main(String[] args) {
        Banco banco = new Banco();
        if(Salvar.lerArquivo() != null) banco = (Banco) Salvar.lerArquivo();
        


        ContaCorrente contaCorrente1 = new ContaCorrente("1450", "Usuário 1", 1000.0, 500.0);
        ContaCorrente contaCorrente2 = new ContaCorrente("5600", "Usuário 2", 2000.0, 1000.0);
        ContaPoupanca contaPoupanca1 = new ContaPoupanca("9030", "Usuário 3", 5000.0);
        ContaPoupanca contaPoupanca2 = new ContaPoupanca("3512", "Usuário 4", 3000.0);

        banco.adicionarConta(contaCorrente1);
        banco.adicionarConta(contaCorrente2);
        banco.adicionarConta(contaPoupanca1);
        banco.adicionarConta(contaPoupanca2);

        banco.exibirSaldoConta("1234");

        banco.exibirSaldoBanco();

        banco.removerConta(contaCorrente1);

        Salvar.salvarArquivo(banco);

        
    }
}
