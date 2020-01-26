package br.com.ifpi.controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.ifpi.exception.ContaDepositaException;
import br.com.ifpi.exception.ContaSacarException;
import br.com.ifpi.exception.ControladoraColecoesAtualizarContaCorrenteException;
import br.com.ifpi.exception.ControladoraColecoesAtualizarContaPoupancaException;
import br.com.ifpi.exception.ControladoraColecoesBancoNaoPossuiContaCadasTradaException;
import br.com.ifpi.exception.ControladoraColecoesCadastroException;
import br.com.ifpi.exception.ControladoraColecoesPesquisaContaException;
import br.com.ifpi.exception.ControladoraColecoesPreenchimentoDeCampoObrigatorioException;
import br.com.ifpi.exception.ControladoraColecoesRemoverContaException;
import br.com.ifpi.exception.ControladoraColecoesTransferenciaDeContaException;
import br.com.ifpi.model.Conta;
import br.com.ifpi.model.ContaCorrente;
import br.com.ifpi.model.ContaPoupanca;
import br.com.ifpi.utils.EnumEstado;
import br.com.ifpi.utils.EnumUF;

public class ControladoraColecoes {

	/*  COLECAO ULTILIZADA ARRAYLIST*/
	protected static ArrayList<ContaCorrente> contaCorrente = new ArrayList<ContaCorrente>();
	protected static ArrayList<ContaPoupanca> contaPoupanca = new ArrayList<ContaPoupanca>();
	
	/*  METODO PARA CADASTRAR CONTA POUPAN�A  */
	protected static void cadastroContaPoupanca(ContaPoupanca nova)throws ControladoraColecoesCadastroException, ControladoraColecoesPreenchimentoDeCampoObrigatorioException
	{
		if(validarCPFContaPoupanca(nova.getCpf())){		// VERIFICA SE O CPF INFORMADO ESTA VALIDO
			throw new ControladoraColecoesCadastroException("O cliente de cpf: " + nova.getCpf() + " n�o pode conter mais de uma conta cadastrada!");
			
		}else if(nova.getCpf().equals("   .   .   -  ")){	//VERIFICA SE O CAMPO CPF ESTA PREENCHIDO
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O preenchimento do campo CPF � obrigatorio!");
			
		}else if(nova.getNomeUsuario().equals("")){		//VERIFICA SE O CAMPO NOMECOMPLETO ESTA PREENCHIDO
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O preenchimento do campo Nome Completo � obrigatorio!");
			
		}else if(nova.getAgencia().equals("")){		//VERIFICA SE O CAMPO AGENCIA ESTA PREENCHIDO
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O preenchimento do campo Agencia � obrigatorio!");
			
		}else if(nova.getRg().equals("")){		//VERIFICA SE O CAMPO RG ESTA PREENCHIDO
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O preenchimento do campo RG � obrigatorio!");
			
		}else{
			contaPoupanca.add(nova);		//CADASTRA A CONTA SE ELA ESTIVER APTA AO CADASTRO
			throw new ControladoraColecoesCadastroException("Conta cadastrada!");						
		}	
	}

	/*	METODO PARA CADASTRAR CONTA CORRENTE*/
	protected static void cadastroContaCorrente(ContaCorrente nova)throws ControladoraColecoesCadastroException, ControladoraColecoesPreenchimentoDeCampoObrigatorioException
	{
		if(validarCPFContaCorrente(nova.getCpf())){		// VERIFICA SE O CPF INFORMADO ESTA VALIDO
			throw new ControladoraColecoesCadastroException("O cliente de cpf: " + nova.getCpf() + " n�o pode conter mais de uma conta cadastrada!");
			
		}else if(nova.getCpf().equals("   .   .   -  ")){	//VERIFICA SE O CAMPO CPF ESTA PREENCHIDO
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O preenchimento do campo CPF � obrigatorio!");
			
		}else if(nova.getNomeUsuario().equals("")){		//VERIFICA SE O CAMPO NOMECOMPLETO ESTA PREENCHIDO
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O preenchimento do campo Nome Completo � obrigatorio!");
			
		}else if(nova.getAgencia().equals("")){		//VERIFICA SE O CAMPO AGENCIA ESTA PREENCHIDO
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O preenchimento do campo Agencia � obrigatorio!");
			
		}else if(nova.getRg().equals("")){		//VERIFICA SE O CAMPO RG ESTA PREENCHIDO
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O preenchimento do campo RG � obrigatorio!");
			
		}else if(nova.getCepResidencial().equals("     -   ")){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O preenchimento do campo CEP Residencial � obrigatorio!");
			
		}else if(nova.getBairro().equals("")){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O preenchimento do campo Bairro � obrigatorio");
			
		}else if(nova.getDataDeNascimento().equals("  /  /    ")){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O preenchimento do campo Data de Nascimento � obrigatorio");
			
		}else if(nova.getCidade().equals("")){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O preenchimento do campo Cidade � obrigatorio");
			
		}else if(nova.getEmail().equals("")){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O preenchimento do campo E-mail � obrigatorio");
			
		}else if(nova.getEnd().equals("")){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O preenchimento do campo Endere�o � obrigatorio");
			
		}else if(nova.getComplemento().equals("")){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O preenchimento do campo Complemento � obrigatorio");
			
		}else if(nova.getEstado().equals(EnumEstado.Selecione)){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O Selecione o seu Estado");
			
		}else if(nova.getEstadoCivil().equals("Selecione")){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O Selecione o seu Estado Civil");
			
		}else if(nova.getNumeroDaCasa().equals("")){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O preenchimento do campo Numero da Casa � obrigatorio");
			
		}else if(nova.getTelefone().equals("(  )     -    ")){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O preenchimento do campo Telefone � obrigatorio");
			
		}else if(nova.getSexo().equals("")){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("Selecione o seu sexo!");
			
		}else if(nova.getUf().equals(EnumUF.Selecione)){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O Campo UF � Obrigatorio!");
			
		}else if((nova.getSaldo() <= 0.0) || (nova.getSaldo() < 50.0) || (String.valueOf(nova.getSaldo()).equals("")) ){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("� necessario o deposito inicial de R$:50,00 ");
			
		}else if((nova.getRendaMensal() <= 0.0) || (nova.getRendaMensal() < 788.0) || (String.valueOf(nova.getRendaMensal()).equals("")) ){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("A sua renda necessaria de cadastro � de um salario minimo R$:788.00 ");
			
		}else{
			contaCorrente.add(nova);		//CADASTRA A CONTA SE ELA ESTIVER APTA AO CADASTRO
			throw new ControladoraColecoesCadastroException("Conta cadastrada!");						
		}	
	}
	
	/*  PESQUISAR POR CONTA POUPANCA ATRAVEZ DO CPF*/
	protected static String pesquisarIndexContaPoupanca(String cpf)throws ControladoraColecoesPesquisaContaException, ControladoraColecoesPreenchimentoDeCampoObrigatorioException
	{
		if(cpf.equals("   .   .   -  ")){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("Informe o CPF!");	//  CONTA N�O EXISTE NO BANCO DE DADOS

		}else {
			for (Conta contaPoupanca : contaPoupanca) {					
				if(cpf.equals(contaPoupanca.getCpf())){		// SE CONTA ENCONTRADA, RETORNA AS INFORMA��ES PARA O CLIENTE					
					return contaPoupanca.exibirDadosConta(); 
				}
			}
		}
		throw new ControladoraColecoesPesquisaContaException("A conta poupan�a cuja o cpf: " + cpf + " n�o esta cadastrada!");	//  CONTA N�O EXISTE NO BANCO DE DADOS				
	}		

	/*  PESQUISAR POR CONTA CORRENTE ATRAVEZ DO CPF */
	protected static String pesquisarIndexContaCorrente(String cpf)throws ControladoraColecoesPesquisaContaException, ControladoraColecoesPreenchimentoDeCampoObrigatorioException
	{
		if(cpf.equals("   .   .   -  ")){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("Informe o CPF!");	//  CONTA N�O EXISTE NO BANCO DE DADOS
			
		}else {
			for (Conta contaCorrente : contaCorrente) {					
				if(cpf.equals(contaCorrente.getCpf())){		// SE CONTA ENCONTRADA, RETORNA AS INFORMA��ES PARA O CLIENTE					
					return contaCorrente.toString(); 
				}
			}
		}
		throw new ControladoraColecoesPesquisaContaException("A conta corrente cuja o cpf: " + cpf + " n�o esta cadastrada!");	//  CONTA N�O EXISTE NO BANCO DE DADOS				
	}		

	/*  METODO PARA REMOVER CONTA POUPANCA*/
	protected static void removerContaPoupanca(String cpf, String numeroConta)throws ControladoraColecoesRemoverContaException, ControladoraColecoesBancoNaoPossuiContaCadasTradaException
	{				
		if(cpf.equals("") || cpf.equals("   .   .   -  ")){ 	// VERIFICA O SE O CAMPO OBRIGATORIO ESTA PREENCHIDO
			throw new ControladoraColecoesRemoverContaException("Preencha o campo CPF!");

		}else if( numeroConta.equals("") ){		// VERIFICA O SE O CAMPO OBRIGATORIO ESTA PREENCHIDO
			throw new ControladoraColecoesRemoverContaException("Preencha o campo numero da conta corretamente!");

		}else if(contaPoupanca.size() > 0){
			//REMOVENDO CONTA SE EXISTENTE
			int numero = Integer.parseInt(numeroConta);
			
			int cont = 0;
			while(cont < contaPoupanca.size()){
				for(Conta contaPoupa : contaPoupanca){	//	PERCORRE O ARRAYLIST<CONTA>
					if( (cpf.equals(contaPoupa.getCpf())) && (numero == contaPoupa.getNumero()) ){	//  VERIFICA CPF, AGENCIA E NUMERO DA CONTA INFORMADOS
						if(contaPoupa.getSaldo() != 0){	//VERIFICA SALDO ATUAL DA CONTA
							throw new ControladoraColecoesRemoverContaException("Opera��o n�o pode ser realizada, verifique o saldo da sua conta Poupan�a!");
						}else{	//REMOVENDO CONTA
							contaPoupanca.remove(contaPoupa);
							throw new ControladoraColecoesRemoverContaException("Conta finalizada com sucesso, Obrigada por ter utilizado nossos servi�os!");
						}
					}
				}
				cont++;	// INCREMENTA O LUPE UTILIZADO PARA PERCORRER O TAMANHO DO ARRAYLIST
				throw new ControladoraColecoesRemoverContaException("As informa��es fornecidas est�o incorreta ou a Conta n�o esta cadastrada!");   // CASO ALGUMA INFORMACAO ESTEJA INCORRETA

			}	

		}else{	//CASO NAO HAJA CONTAS NO ARRAYLIST
			throw new ControladoraColecoesBancoNaoPossuiContaCadasTradaException("N�o existe nenhuma Conta Poupan�a Cadastrada!");

		}

	}
	
	/*  METODO PARA REMOVER CONTA CORRENTE*/
	protected static void removerContaCorrente(String cpf, String numeroConta)throws ControladoraColecoesRemoverContaException, ControladoraColecoesBancoNaoPossuiContaCadasTradaException
	{		
		if(cpf.equals("") || cpf.equals("   .   .   -  ")){ 	// VERIFICA O SE O CAMPO OBRIGATORIO ESTA PREENCHIDO
			throw new ControladoraColecoesRemoverContaException("Preencha o campo CPF!");
			
		}else if( numeroConta.equals("") ){		// VERIFICA O SE O CAMPO OBRIGATORIO ESTA PREENCHIDO
			throw new ControladoraColecoesRemoverContaException("Preencha o campo numero da conta corretamente!");
			
		}else if(contaCorrente.size() > 0){
			//REMOVENDO CONTA SE EXISTENTE
			int numero = Integer.parseInt(numeroConta);
			
			int cont = 0;
			while(cont < contaCorrente.size()){
				for(Conta contaCorre : contaCorrente){	//	PERCORRE O ARRAYLIST<CONTA>
					if( (cpf.equals(contaCorre.getCpf())) && (numero == contaCorre.getNumero()) ){	//  VERIFICA CPF, AGENCIA E NUMERO DA CONTA INFORMADOS
						if(contaCorre.getSaldo() != 0){	//VERIFICA SALDO ATUAL DA CONTA
							throw new ControladoraColecoesRemoverContaException("Opera��o n�o pode ser realizada, verifique o saldo da sua conta Corrente!");
						}else{	//REMOVENDO CONTA
							contaCorrente.remove(contaCorre);
							throw new ControladoraColecoesRemoverContaException("Conta finalizada com sucesso, Obrigada por ter utilizado nossos servi�os!");
						}
					}
				}
				cont++;	// INCREMENTA O LUPE UTILIZADO PARA PERCORRER O TAMANHO DO ARRAYLIST
				throw new ControladoraColecoesRemoverContaException("As informa��es fornecidas est�o incorreta ou a Conta n�o esta cadastrada!"); // CASO ALGUMA INFORMACAO ESTEJA INCORRETA

			}	

		}else{	//CASO NAO HAJA CONTAS NO ARRAYLIST
			throw new ControladoraColecoesBancoNaoPossuiContaCadasTradaException("N�o existe nenhuma Conta Corrente Cadastrada!");

		}		
	}

	
	/*	MOSTRAR CONTAS POUPANCAS CADASTRADAS	*/
	protected static String historicoContaPoupanca(){
		while(contaPoupanca.size() != 0){
			return contaPoupanca.toString();
		}
		
		return "O Banco n�o possui nenhuma conta poupan�a cadastrada!";
	}
	
	/*	MOSTRAR CONTAS CORRENTES CADASTRADAS	*/
	protected static String historicoContaCorrente(){
		while(contaCorrente.size() != 0){
			return contaCorrente.toString();
		}
		
		return "O Banco n�o possui nenhuma conta corrente cadastrada!";
	}

	/*  METODO RESPONSAVEL PELA VALIDA��O DO CPF  CONTA POUPAN�A	*/
	private static boolean validarCPFContaPoupanca(final String cpf){
		for (Conta contaPoupanca : contaPoupanca) {	//	PERCORRE O ARRAYLIST<CONTA>
			
			if(cpf.equals(contaPoupanca.getCpf())){		//  VERIFICA SE UMA CONTA JA ESTA CADASTRADA ATRAVEZ DO CPF INFORMADO
				return true;
			}
		}
		return false;
	}

	/*	METODO RESPONDAVEL PELA VALIDA��O DO CPF CONTA CORRENTE		*/
	private static boolean validarCPFContaCorrente(final String cpf){
		for (Conta contaCorrente : contaCorrente) {	//	PERCORRE O ARRAYLIST<CONTA>
			
			if(cpf.equals(contaCorrente.getCpf())){		//  VERIFICA SE UMA CONTA JA ESTA CADASTRADA ATRAVEZ DO CPF INFORMADO
				return true;
			}	
		}
		return false;
	}	

	/*	MEDOTO CONTA EFETUA SAQUE CONTA POUPAN�A	*/	
	protected static void SacarContaPoupanca(String numeroConta, String valor) throws ContaSacarException, ControladoraColecoesPreenchimentoDeCampoObrigatorioException, ControladoraColecoesBancoNaoPossuiContaCadasTradaException
	{		
		if( (numeroConta.equals("")) || (valor.equals("")) ){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O preenchimento dos campos � Obrigatorio!");
			
		}else if(contaPoupanca.size() > 0){
			int numero = Integer.parseInt(numeroConta);
			
			valor = valor.replaceAll(",", ".");//ULTILIZANDO ',' AND '.'
			double valorDoSaque = Double.parseDouble(valor);

			int i = 0;			
			while(i < contaPoupanca.size()){//LUPE DE CONTROLE DO METODO SACAR
				for (ContaPoupanca contaPoupa : contaPoupanca) {
					if( numero == contaPoupa.getNumero() ){
						
						if(valorDoSaque < 0){			// VALOR DO SAQUE MENOR QUE ZERO			
							throw new ContaSacarException("Nao e possivel sacar um valor negativo!!");
							
						}else if(valorDoSaque > contaPoupa.getSaldo()){		// VALOR DO SAQUE MAIOR DO QUE O SALDO DA CONTA
							throw new ContaSacarException("Saldo atual � incompativel, Verifique seu saldo!!");
							
						}else{			// VALOR DO SAQUE MAIO DO QUE O SALDO DA CONTA
							contaPoupa.setSaldo( contaPoupa.getSaldo() - valorDoSaque );						
							throw new ContaSacarException("Saque Realizado com Sucesso!!");
						}
					}
				}
				i++;//LUPE DE CONTROLE DO METODO SACAR
				throw new ContaSacarException("Verifique se as informa��es est�o corretas!");
			}			
		}else{
			throw new ControladoraColecoesBancoNaoPossuiContaCadasTradaException("N�o existe nenhuma Conta Poupan�a Cadastrada!");

		}
	}

	/*	METODO CONTA EFETUA SAQUE CONTA CORRENTE	*/
	protected static void SacarContaCorrente(String numeroConta, String valor) throws ContaSacarException, ControladoraColecoesPreenchimentoDeCampoObrigatorioException, ControladoraColecoesBancoNaoPossuiContaCadasTradaException
	{		
		if( (numeroConta.equals("")) || (valor.equals("")) ){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O preenchimento dos campos � Obrigatorio!");
			
		}else if(contaCorrente.size() > 0){
			int numero = Integer.parseInt(numeroConta);
			valor = valor.replaceAll("," , ".");			
			double valorDoSaque = Double.parseDouble(valor);
			
			int i = 0;			
			while(i < contaCorrente.size()){
				for (ContaCorrente contaCorre : contaCorrente) {
					if(numero == contaCorre.getNumero()){
						
						if(valorDoSaque < 0){			// VALOR DO SAQUE MENOR QUE ZERO			
							throw new ContaSacarException("Nao e possivel sacar um valor negativo!!");
							
						}else if(valorDoSaque > contaCorre.getSaldo()){		// VALOR DO SAQUE MAIOR DO QUE O SALDO DA CONTA
							throw new ContaSacarException("Saldo atual � incompativel, Verifique seu saldo!!");
							
						}else{			// VALOR DO SAQUE MAIO DO QUE O SALDO DA CONTA
							contaCorre.setSaldo( contaCorre.getSaldo() - valorDoSaque );		
							throw new ContaSacarException("Saque Realizado com Sucesso!!");
						}
					}
				}
				i++;
				throw new ContaSacarException("Verifique o numero da conta, ou se sua conta esta cadastrada!");
			}			
		}else{
			throw new ControladoraColecoesBancoNaoPossuiContaCadasTradaException("N�o existe nenhuma Conta Corrente Cadastrada!");
			
		}
	}
	
	/*	METODO CONTA EFETUA DEPOSITO CONTA POUPANCA		*/
	protected static void DepositaContaPoupanca(String numeroConta, String valor) throws ControladoraColecoesPreenchimentoDeCampoObrigatorioException, ContaDepositaException, ControladoraColecoesBancoNaoPossuiContaCadasTradaException
	{
		if( (numeroConta.equals("")) || (valor.equals("")) ){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O Preenchemento dos campos � Obrigatorio!!");
			
		}else if(contaPoupanca.size() > 0){
			int numero = Integer.parseInt(numeroConta);	
			
			valor = valor.replaceAll("," , ".");	//TODO VALOR PASSADO SEJA ELE COM ',' OR '.' SERA TRANSFORMADO EM PONTO FLUTUANTE
			double valorDoDeposito = Double.parseDouble(valor);
			
			int j = 0;
			while(j < contaPoupanca.size()){
				for (ContaPoupanca contaPoupa : contaPoupanca) {
					if(numero == contaPoupa.getNumero()){						
						if(valorDoDeposito <= 0){			// VALOR DO DEPOSITO MENOR DO QUE ZERO
							throw new ContaDepositaException("Nao e possivel realizar essa operacao!!");
							
						}else{
							contaPoupa.setSaldo(contaPoupa.getSaldo() + valorDoDeposito);			// VALOR DO DEPOSITO MAIOR QUE ZERO
							throw new ContaDepositaException("Deposito realizado com sucesso!");
						}
						
					}
				}
				j++;
				throw new ContaDepositaException("Verifique o numero da conta, ou se sua conta esta cadastrada!");
			}
		}
		throw new ControladoraColecoesBancoNaoPossuiContaCadasTradaException("O Banco n�o possui nenhuma conta Poupan�a cadastrada!");
	}
	
	/*	METODO CONTA EFETUA DEPOSITO CONTA CORRENTE		*/
	protected static void DepositaContaCorrente(String numeroConta, String valor) throws ControladoraColecoesPreenchimentoDeCampoObrigatorioException, ContaDepositaException, ControladoraColecoesBancoNaoPossuiContaCadasTradaException
	{
		if( (numeroConta.equals("")) || (valor.equals("")) ){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O Preenchemento dos campos � Obrigatorio!!");
			
		}else if(contaCorrente.size() > 0){
			int numero = Integer.parseInt(numeroConta);	
			
			valor = valor.replaceAll("," , ".");	//TODO VALOR PASSADO SEJA ELE COM ',' OR '.' SERA TRANSFORMADO EM PONTO FLUTUANTE
			double valorDoDeposito = Double.parseDouble(valor);
			
			int j = 0;
			while(j < contaCorrente.size()){
				for (ContaCorrente contaCorre : contaCorrente) {
					if(numero == contaCorre.getNumero()){						
						if(valorDoDeposito <= 0){			// VALOR DO DEPOSITO MENOR DO QUE ZERO
							throw new ContaDepositaException("Nao e possivel realizar essa operacao!!");
							
						}else{
							contaCorre.setSaldo(contaCorre.getSaldo() + valorDoDeposito);			// VALOR DO DEPOSITO MAIOR QUE ZERO
							throw new ContaDepositaException("Opera��o realizada com sucesso!");
						}
						
					}
				}
				j++;
				throw new ContaDepositaException("Verifique o numero da conta, ou se sua conta esta cadastrada!");
			}
		}
		throw new ControladoraColecoesBancoNaoPossuiContaCadasTradaException("O Banco n�o possui nenhuma conta Corrente cadastrada!");
	}

	/*	METODO CONTA EFETUA TRANSFERENCIA APENAS CONTA CORRENTE		*/
	protected static void TranferenciaContaCorrente(String numeroConta, String numeroConta2, String valor) throws ControladoraColecoesPreenchimentoDeCampoObrigatorioException, ControladoraColecoesBancoNaoPossuiContaCadasTradaException, ControladoraColecoesTransferenciaDeContaException, ContaDepositaException
	{	
		if( (numeroConta.equals("")) || (valor.equals("")) || numeroConta2.equals("")){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O preenchimento dos campos s�o Obrigatorios!!");
		}else if(contaCorrente.size() > 0){			
			int numeroContaTransfere = Integer.parseInt(numeroConta);			
			int numeroContaRecebe = Integer.parseInt(numeroConta2);			
			valor = valor.replaceAll("," , ".");			
			double valorDeTransferencia = Double.parseDouble(valor);
			
			int i = 0;			
			while(i < contaCorrente.size()){
				for (ContaCorrente contaCorre : contaCorrente) {
					if(numeroContaTransfere == contaCorre.getNumero()){
						
						if(valorDeTransferencia < 0){			// VALOR DO SAQUE MENOR QUE ZERO			
							throw new ControladoraColecoesTransferenciaDeContaException("Nao e possivel transferir um valor negativo!!");
							
						}else if(valorDeTransferencia > contaCorre.getSaldo()){		// VALOR DO SAQUE MAIOR DO QUE O SALDO DA CONTA
							throw new ControladoraColecoesTransferenciaDeContaException("Saldo atual � incompativel, Verifique seu saldo!!");
							
						}else{			// VALOR DO SAQUE MAIO DO QUE O SALDO DA CONTA
							if(numeroContaRecebe == contaCorre.getNumero()){
								contaCorre.setSaldo( contaCorre.getSaldo() - valorDeTransferencia );
								DepositaContaCorrente(numeroConta2, valor);								
							}else{
								throw new ControladoraColecoesTransferenciaDeContaException("A Conta a receber a transferencia n�o esta cadastrada!");
								
							}
						}
					}
				}
				i++;
				throw new ControladoraColecoesTransferenciaDeContaException("Verifique o numero da conta, ou se sua conta esta cadastrada!");
			}		
			
		}else{			
			throw new ControladoraColecoesBancoNaoPossuiContaCadasTradaException("O Banco n�o possui conta corrente cadastrada!");
		}
	}

	
	/*	METODO PARA ATUALIZAR OS DADOS 	*/
	protected static void AtualizarDadosPoupanca(String nomeCliente, String agencia, String cpf) throws ControladoraColecoesAtualizarContaPoupancaException{
		if(validarCPFContaPoupanca(cpf)){
			for(ContaPoupanca contaPoupa : contaPoupanca) {
				if(cpf.equals(contaPoupa.getCpf())){
					contaPoupa.setNomeUsuario(nomeCliente);
					contaPoupa.setAgencia(agencia);
					contaPoupa.setCpf(cpf);
					JOptionPane.showMessageDialog(null, "Dados Atualizados com sucesso!!");					
				}			
			}
		}else{
			throw new ControladoraColecoesAtualizarContaPoupancaException("Verifique se a conta poupan�a esta cadastrada!!");			
		}
	}
	
	
	/*	METODO PARA ATUALIZAR OS DADOS 	*/
	protected static void AtualizarDadosCorrente(String nomeCliente, String cpf, String rg, Object uf, String dataDeNasc, String telefone, Object estadoCivil, String sexo, String email, String endereco, String numeroCasa, String bairro, String complemento
			, String cidade, String cep, Object estado, String agencia, String rendaMensal) throws ControladoraColecoesAtualizarContaCorrenteException, ControladoraColecoesPreenchimentoDeCampoObrigatorioException{
		if(cpf.equals("   .   .   -  ")){	//VERIFICA SE O CAMPO CPF ESTA PREENCHIDO
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O preenchimento do campo CPF � obrigatorio!");
			
		}else if(nomeCliente.equals("")){		//VERIFICA SE O CAMPO NOMECOMPLETO ESTA PREENCHIDO
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O preenchimento do campo Nome Completo � obrigatorio!");
			
		}else if(agencia.equals("")){		//VERIFICA SE O CAMPO AGENCIA ESTA PREENCHIDO
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O preenchimento do campo Agencia � obrigatorio!");
			
		}else if(rg.equals("")){		//VERIFICA SE O CAMPO RG ESTA PREENCHIDO
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O preenchimento do campo RG � obrigatorio!");
			
		}else if(cep.equals("     -   ")){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O preenchimento do campo CEP Residencial � obrigatorio!");
			
		}else if(bairro.equals("")){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O preenchimento do campo Bairro � obrigatorio");
			
		}else if(dataDeNasc.equals("  /  /    ")){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O preenchimento do campo Data de Nascimento � obrigatorio");
			
		}else if(cidade.equals("")){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O preenchimento do campo Cidade � obrigatorio");
			
		}else if(email.equals("")){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O preenchimento do campo E-mail � obrigatorio");
			
		}else if(sexo.equals("")){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("Selecione o seu sexo!");
			
		}else if(endereco.equals("")){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O preenchimento do campo Endere�o � obrigatorio");
			
		}else if(complemento.equals("")){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O preenchimento do campo Complemento � obrigatorio");
			
		}else if(estado.equals(EnumEstado.Selecione)){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O Selecione o seu Estado");
			
		}else if(estadoCivil.equals("Selecione")){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O Selecione o seu Estado Civil");
			
		}else if(numeroCasa.equals("")){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O preenchimento do campo Numero da Casa � obrigatorio");
			
		}else if(telefone.equals("(  )     -    ")){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O preenchimento do campo Telefone � obrigatorio");
			
		}else if(uf.equals(EnumUF.Selecione)){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("O Campo UF � Obrigatorio!");
			
		}else if(((rendaMensal.equals("")) || (Double.parseDouble(rendaMensal) < 788.0) || Double.parseDouble(rendaMensal) <= 0.0) ){
			throw new ControladoraColecoesPreenchimentoDeCampoObrigatorioException("A sua renda necessaria de cadastro � de um salario minimo R$:788.00 ");
			
		}else if(validarCPFContaCorrente(cpf)){
			rendaMensal = rendaMensal.replaceAll(",", ".");
			double rendaNova = Double.parseDouble(rendaMensal); 	//TODO VALOR PASSADO SEJA ELE COM ',' OR '.' SERA TRANSFORMADO EM PONTO FLUTUANTE

			for (ContaCorrente contaCorre : contaCorrente) {
				if(cpf.equals(contaCorre.getCpf())){
					contaCorre.setNomeUsuario(nomeCliente);
					contaCorre.setCpf(cpf);
					contaCorre.setRg(rg);
					contaCorre.setUf(uf);
					contaCorre.setDataDeNascimento(dataDeNasc);
					contaCorre.setTelefone(telefone);
					contaCorre.setEstadoCivil(estadoCivil);
					contaCorre.setEmail(email);
					contaCorre.setSexo(sexo);
					contaCorre.setEnd(endereco);
					contaCorre.setNumeroDaCasa(numeroCasa);
					contaCorre.setBairro(bairro);
					contaCorre.setComplemento(complemento);
					contaCorre.setCidade(cidade);
					contaCorre.setCepResidencial(cep);
					contaCorre.setEstado(estado);
					contaCorre.setAgencia(agencia);
					contaCorre.setRendaMensal(rendaNova);					
					JOptionPane.showMessageDialog(null, "Dados Atualizados com sucesso!!");
				}
			}
		}else{
			throw new ControladoraColecoesAtualizarContaCorrenteException("Verifique se a conta corrente esta cadastrada!!");
		}
	}
	
}

