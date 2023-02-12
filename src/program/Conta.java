package program;

import utils.Utils;
public class Conta {

    private  static  int accountCounter =1;
    private int numeroConta;
    private  Pessoa pessoa;
    private  Double saldo = 0.0;

    public Conta( Pessoa pessoa) {
        this.numeroConta = Conta.accountCounter;
        this.pessoa = pessoa;
        this.updateSaldo();
        Conta.accountCounter += 1;
    }
    public int getNumeroConta() {

        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {

        this.numeroConta = numeroConta;
    }

    public Pessoa getPessoa() {

        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {

        this.pessoa = pessoa;
    }

    public Double getSaldo() {

        return saldo;
    }

    public void setSaldo(Double saldo) {

        this.saldo = saldo;
    }
    private void updateSaldo() {
        this.saldo = this.getSaldo();
    }



    public String toString() {

        return "\nBank account: " + this.getNumeroConta() +
                "\nCliente: " + this.pessoa.getName() +
                "\nCPF: " + this.pessoa.getCpf() +
                "\nEmail: " + this.pessoa.getEmail() +
                "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
                "\n" ;
    }


    public void  depositar (double valor){

        if (valor > 0){
            setSaldo(getSaldo()+valor);
            System.out.println("Deposito realizado com sucesso!");
        }else {
            System.out.println("Saldo Insuficiente!");
        }
    }
    public void  sacar (double valor){

        if (valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() -valor);
            System.out.println("Saque" + valor + "realizado com sucesso!");
        }else{
            System.out.println(" Não foi possivel realizar o saque, saldo Insuficiente!");
        }
    }

    public void  transferir (Conta contaParaDeposito,Double valor){

        if (valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() -valor);

            contaParaDeposito.saldo = contaParaDeposito.getSaldo() +valor;
            System.out.println("Transferencia" + valor + "realizado com sucesso!");
        }else{
            System.out.println(" Não foi possivel realizar a transferencia, saldo Insuficiente!");
        }
    }
}
