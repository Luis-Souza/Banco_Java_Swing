package br.com.ifpi.controller;

import br.com.ifpi.exception.ContaDepositaException;
import br.com.ifpi.exception.ContaSacarException;
import br.com.ifpi.exception.ContaTransferirException;
import br.com.ifpi.exception.ControladoraColecoesAtualizarContaCorrenteException;
import br.com.ifpi.exception.ControladoraColecoesAtualizarContaPoupancaException;
import br.com.ifpi.exception.ControladoraColecoesBancoNaoPossuiContaCadasTradaException;
import br.com.ifpi.exception.ControladoraColecoesCadastroException;
import br.com.ifpi.exception.ControladoraColecoesPesquisaContaException;
import br.com.ifpi.exception.ControladoraColecoesPreenchimentoDeCampoObrigatorioException;
import br.com.ifpi.exception.ControladoraColecoesRemoverContaException;
import br.com.ifpi.exception.ControladoraColecoesTransferenciaDeContaException;
import br.com.ifpi.model.ContaCorrente;
import br.com.ifpi.model.ContaPoupanca;

public class ControladoraConta {
	static ContaPoupanca cP = new ContaPoupanca(null, null, null, null, 0, 0);
	static ContaCorrente cC = new ContaCorrente();

	/*	CADASTRAR CONTA CORRENTE	 */
	public static  void criarContaCorrente(String nomeUsuario, String cpf, String rg, Object uf, String dataDeNascimento,
			Object estadoCivil, String email, String telefone, String sexo, String end, String complemento,
			String numeroDaCasa, String bairro, String cidade, Object estado, String cepResidencial, double saldo,
			String agencia, int numeroDaConta, double rendaMensal) throws ControladoraColecoesCadastroException, ControladoraColecoesPreenchimentoDeCampoObrigatorioException
	{
		
		cC = new ContaCorrente( nomeUsuario, cpf, rg, uf, dataDeNascimento, estadoCivil, email, telefone, sexo, end, complemento,
				 numeroDaCasa, bairro, cidade, estado, cepResidencial, saldo, agencia, numeroDaConta, rendaMensal );
		ControladoraColecoes.cadastroContaCorrente(cC);
	}
	
	/*	CADASTRAR CONTA POUPANCA 	*/
	public static  void criarContaPoupança(String nomeCliente, String cpf, String rg, String agencia, double saldo,  int numero) throws ControladoraColecoesCadastroException, ControladoraColecoesPreenchimentoDeCampoObrigatorioException
	{		
		cP = new ContaPoupanca(nomeCliente, cpf, rg, agencia, saldo, numero);
		ControladoraColecoes.cadastroContaPoupanca(cP);
	}
	
	/*	REMOVER CONTA 	*/
	public static void fecharContaPoupanca(String cpf, String numeroConta) throws ControladoraColecoesRemoverContaException, ControladoraColecoesBancoNaoPossuiContaCadasTradaException
	{
		ControladoraColecoes.removerContaPoupanca(cpf, numeroConta);
	}
	
	public static void fecharContaCorrente(String cpf, String numeroConta) throws ControladoraColecoesRemoverContaException, ControladoraColecoesBancoNaoPossuiContaCadasTradaException
	{
		ControladoraColecoes.removerContaCorrente(cpf, numeroConta);
	}
	
	/*	PESQUISAR CONTA POR CPF*/
	public static String pesquisarContaPoupanca(String cpf) throws ControladoraColecoesPesquisaContaException, ControladoraColecoesPreenchimentoDeCampoObrigatorioException
	{
		return ControladoraColecoes.pesquisarIndexContaPoupanca(cpf);
	}
	
	
	public static String pesquisarContaCorrente(String cpf) throws ControladoraColecoesPesquisaContaException, ControladoraColecoesPreenchimentoDeCampoObrigatorioException
	{
		return ControladoraColecoes.pesquisarIndexContaCorrente(cpf);
	}
	
	/*	MOSTRAR HISTORICO DE CONTA CADASTRADAS	*/
	public static String mostrarHistoricoContaPoupanca()
	{
		return ControladoraColecoes.historicoContaPoupanca();
	}
	
	public static String mostrarHistoricoContaCorrente()
	{
		return ControladoraColecoes.historicoContaCorrente();
	}
	
	/*	METODOS RESPONSAVEIS PELO SAQUE DE CONTA	*/
	public static void sacarDeContaPoupanca(String numeroConta, String valor) throws ContaSacarException, ControladoraColecoesPreenchimentoDeCampoObrigatorioException, ControladoraColecoesBancoNaoPossuiContaCadasTradaException
	{
		ControladoraColecoes.SacarContaPoupanca(numeroConta, valor);
	}

	public static void sacarDeContaCorrente(String numeroConta, String valor) throws ContaSacarException, ControladoraColecoesPreenchimentoDeCampoObrigatorioException, ControladoraColecoesBancoNaoPossuiContaCadasTradaException
	{
		ControladoraColecoes.SacarContaCorrente(numeroConta, valor);
	}
	
	/*	METODOS RESPONSAVEIS PELO DEPOSITO DE CONTA		*/
	public static void depositaContaPoupanca(String numeroConta, String valor) throws ControladoraColecoesPreenchimentoDeCampoObrigatorioException, ContaDepositaException, ControladoraColecoesBancoNaoPossuiContaCadasTradaException
	{
		ControladoraColecoes.DepositaContaPoupanca(numeroConta, valor);
	}
	
	public static void depositaContaCorrente(String numeroConta, String valor) throws ControladoraColecoesPreenchimentoDeCampoObrigatorioException, ContaDepositaException, ControladoraColecoesBancoNaoPossuiContaCadasTradaException
	{
		ControladoraColecoes.DepositaContaCorrente(numeroConta, valor);
	}
	
	/*	METODO RESPONSAVEL PELA TRANSFERENCIA DE CONTA CORRENTE		*/
	public static void transferirContaCorrente(String numeroConta, String numeroConta2, String valor) throws ControladoraColecoesPreenchimentoDeCampoObrigatorioException, ContaSacarException, ControladoraColecoesBancoNaoPossuiContaCadasTradaException, ContaDepositaException, ContaTransferirException, ControladoraColecoesTransferenciaDeContaException
	{
		ControladoraColecoes.TranferenciaContaCorrente(numeroConta, numeroConta2, valor);
	}
	
	/*	METODO PARA ATUALIZAR OS DADOS DA CONTA POUPANCA 	*/
	public static void atualizarContaPoupanca(String nomeCliente, String agencia, String cpf) throws ControladoraColecoesAtualizarContaPoupancaException{
		ControladoraColecoes.AtualizarDadosPoupanca(nomeCliente, agencia, cpf);
	}
	
	/*	METODO PARA ATUALIZAR OS DADOS DA CONTA CORRENTE 	*/
	public static void atualizarContaCorrente(String nomeCliente, String cpf, String rg, Object uf, String dataDeNasc, String telefone, Object estadoCivil, String email, String sexo, String endereco, String numeroCasa, String bairro, String complemento
			, String cidade, String cep, Object estado, String agencia, String rendaMensal) throws ControladoraColecoesAtualizarContaCorrenteException, ControladoraColecoesPreenchimentoDeCampoObrigatorioException{
		ControladoraColecoes.AtualizarDadosCorrente(nomeCliente, cpf, rg, uf, dataDeNasc, telefone, estadoCivil, email, sexo, endereco, numeroCasa, bairro, complemento
				, cidade, cep, estado, agencia, rendaMensal);
	}
	
	
	
	
	
	
}
