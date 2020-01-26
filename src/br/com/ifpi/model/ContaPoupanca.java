package br.com.ifpi.model;

public class ContaPoupanca extends Conta{
	
	public ContaPoupanca(){}
	
	public ContaPoupanca(String nomeUsuario, String cpf, String rg, String agencia, double saldo,  int numeroDaConta) {
		super(nomeUsuario, cpf, rg, agencia, saldo, numeroDaConta);
		// TODO Auto-generated constructor stub
	}

	/*METODOS DA CLASSE CONTA
	public void deposita(double valor)throws ContaNaoDepositaValorNegativoException{
		
		if(valor <= 0){			// VALOR DO DEPOSITO MENOR DO QUE ZERO
			throw new ContaNaoDepositaValorNegativoException("Nao e possivel realizar essa operacao!!");
			
		}else{
			this.saldo = saldo + valor;			// VALOR DO DEPOSITO MAIOR QUE ZERO
		}
		
	}
	
	public double saca(double valor)throws ContaSacarException{
		
		if(valor < 0){			// VALOR DO SAQUE MENOR QUE ZERO			
			throw new ContaSacarException("Nao e possivel sacar um valor negativo!!");
			
		}else if(valor > saldo){		// VALOR DO SAQUE MAIOR DO QUE O SALDO DA CONTA
			throw new ContaSacarException("Saldo atual indisponivel!!");
			
		}else{			// VALOR DO SAQUE MAIO DO QUE O SALDO DA CONTA
			return setSaldo(saldo - valor);			
		}
		
	}
*/
	@Override
	public String toString() {
		return "ContaPoupanca [Nome do Cliente: " + getNomeUsuario() + "\n"
				+ "Cpf: " + getCpf() + "\n"
				+ "Numero da Conta: " + getNumero() +  "\n"
				+ "Agencia: " + getAgencia() +  "\n"
				+ "Saldo: " + getSaldo() + "]" + "\n" + "\n";
	}
	
	
}
