package br.com.ifpi.model;

public class ContaCorrente extends Conta{


	private double rendaMensal = 0.0;
	
	public double getRendaMensal() {
		return rendaMensal;
	}

	public void setRendaMensal(double rendaMensal) {
		this.rendaMensal = rendaMensal;
	}

	public ContaCorrente(){}


	public ContaCorrente(String nomeUsuario, String cpf, String rg, Object uf, String dataDeNascimento,
			Object estadoCivil, String email, String telefone, String sexo, String end, String complemento,
			String numeroDaCasa, String bairro, String cidade, Object estado, String cepResidencial, double saldo,
			String agencia, int numeroDaConta, double rendaMensal) {
		super(nomeUsuario, cpf, rg, uf, dataDeNascimento, estadoCivil, email, telefone, sexo, end, complemento, numeroDaCasa,
				bairro, cidade, estado, cepResidencial, saldo, agencia, numeroDaConta);
		// TODO Auto-generated constructor stub
		this.rendaMensal = rendaMensal;
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
			return setSaldo(getSaldo() - valor);			
		}
	}
	*/


	@Override
	public String toString() {
		return "ContaCorrente [Nome do Cliente: " + getNomeUsuario() + "\n"
				+ "Saldo:" + getSaldo() + "\n"
				+ "Agencia: " + getAgencia() + "\n"
				+ "Numero: " + getNumero() +  "\n"
				+ "rendaMensal :" + rendaMensal + "\n"
				+ "Cpf: " + getCpf() +  "\n"
				+ "Rg: " + getRg() +  "\n"
				+ "Uf: " + getUf()	+  "\n"
				+ "DataDeNascimento: " + getDataDeNascimento() +  "\n"
				+ "EstadoCivil: " + getEstadoCivil() + "\n"
				+ "Email: " + getEmail() +  "\n"
				+ "Telefone: " + getTelefone() +  "\n"
				+ "Sexo: " + getSexo()+  "\n"
				+ "End: " + getEnd() +  "\n"
				+ "Complemento: " + getComplemento() + "\n"
				+ "NumeroDaCasa: "	+ getNumeroDaCasa() +  "\n"
				+ "Bairro: " + getBairro() +  "\n"
				+ "Cidade: " + getCidade() +  "\n"
				+ "Estado: " + getEstado() +  "\n"
				+ "CepResidencial: " + getCepResidencial() + "]" + "\n" + "\n";
	}

	/*public void transferirPara(Conta destino, double valor) throws ContaSacarException, ContaNaoDepositaValorNegativoException{   //REALIZAÇÃO DE TRANSFERENCIA DE CONTA
		this.saca(valor);		//  PRIMEIRO SACA SALDO DA CONTA ATUAL /  VALOR A SER TRANSFERIDO
		destino.deposita(valor);	//  SEGUNDO DEPOSITA NA CONTA A RECEBER A TRANSFERENCIA DE CREDITO
	}*/

}
