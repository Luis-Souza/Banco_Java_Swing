package br.com.ifpi.model;

public class Conta extends Cliente{

	protected double saldo = 0.0;
	private String agencia;
	private int numeroDaConta = 0;	
	
	/*CONSTRUTORIS DA CLASSE*/
	public Conta(String nomeUsuario, String cpf, String rg, Object uf, String dataDeNascimento, Object estadoCivil,
			String email, String telefone, String sexo, String end, String complemento, String numeroDaCasa,
			String bairro, String cidade, Object estado, String cepResidencial, double saldo, String agencia,
			int numeroDaConta) {
		super(nomeUsuario, cpf, rg, uf, dataDeNascimento, estadoCivil, email, telefone, sexo, end, complemento,
				numeroDaCasa, bairro, cidade, estado, cepResidencial);
		this.saldo = saldo;
		this.agencia = agencia;
		this.numeroDaConta = numeroDaConta;
	}

	
	public Conta(String nomeUsuario, String cpf, String rg, String agencia, double saldo, int numeroCont){
		super(nomeUsuario, cpf, rg);
		this.agencia = agencia;
		this.saldo = saldo;
		this.numeroDaConta = numeroCont;
	}

	public Conta(){}
	
	/*METODOS GETTERS E SETTERS*/	
	public double getSaldo() {
		return saldo;
	}
	public double setSaldo(double saldo) {
		return this.saldo = saldo;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public int getNumero() {
		return numeroDaConta;
	}
	public void setNumero(int numero2) {
		this.numeroDaConta = numero2;
	}
	
	public String exibirDadosConta(){		//  VERIFICA O SALDA DA CONTA
		return ("Cliente: " + getNomeUsuario() + "\n" 
				+ "Cpf: " + getCpf() + "\n"
				+ "Agencia: " + agencia + "\n"
				+ "Numero da Conta:  " + numeroDaConta + "\n"
				+ "Saldo atual: " + saldo);
	}
			
	
/*	public void transferirPara(Conta destino, double valor) throws ContaSacarException, ContaNaoDepositaValorNegativoException{   //REALIZAÇÃO DE TRANSFERENCIA DE CONTA
		this.saca(valor);		//  PRIMEIRO SACA SALDO DA CONTA ATUAL /  VALOR A SER TRANSFERIDO
		destino.deposita(valor);	//  SEGUNDO DEPOSITA NA CONTA A RECEBER A TRANSFERENCIA DE CREDITO
	}*/

	@Override
	public String toString() {
		return "Conta " + "\n"
				+ "saldo =" + saldo + "\n"
				+ "Agencia =" + agencia + "\n"
				+ "Numero da Conta=" + numeroDaConta + "\n"
				+ "Cliente =" + getNomeUsuario() + "\n"
				+ "Cpf =" + getCpf() + "\n"
				+ "DataDeNascimento =" + getDataDeNascimento() + "\n"
				+ "CepResidencial =" + getCepResidencial() + "\n"
				+ "Sexo =" + getSexo() + "\n"
				+ "Telefone =" + getTelefone();
	}	

}
