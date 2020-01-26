package br.com.ifpi.model;

import javax.swing.JOptionPane;

import br.com.ifpi.exception.AutenticacaoDoLoginException;
import br.com.ifpi.view.Login;
import br.com.ifpi.view.AreaAdmin;

public class Cliente {

	private String nomeUsuario;
	private String cpf;
	private String rg;
	private Object uf;
	private String dataDeNascimento;
	private Object estadoCivil;
	private String email;
	private String telefone;		
	private String sexo;
	private String end;
	private String complemento;
	private String numeroDaCasa;
	private String bairro;
	private String cidade;
	private Object estado;
	private String cepResidencial;
	
	/*	METODOS CONSTRUTORES	*/
	public Cliente(String nomeUsuario, String cpf, String rg, Object uf, String dataDeNascimento, Object estadoCivil,
			String email, String telefone, String sexo, String end, String complemento, String numeroDaCasa,
			String bairro, String cidade, Object estado, String cepResidencial) {
		super();
		this.nomeUsuario = nomeUsuario;
		this.cpf = cpf;
		this.rg = rg;
		this.uf = uf;
		this.dataDeNascimento = dataDeNascimento;
		this.estadoCivil = estadoCivil;
		this.email = email;
		this.telefone = telefone;
		this.sexo = sexo;
		this.end = end;
		this.complemento = complemento;
		this.numeroDaCasa = numeroDaCasa;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cepResidencial = cepResidencial;
	}
	
	public Cliente(String nomeUsuario, String cpf, String rg){
		this.nomeUsuario = nomeUsuario;
		this.cpf = cpf;
		this.rg = rg;
	}
	
	public Cliente(){}

	/*	METODOS GETTERS E SETTERS	*/
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Object getUf() {
		return uf;
	}

	public void setUf(Object uf) {
		this.uf = uf;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public Object getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(Object estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumeroDaCasa() {
		return numeroDaCasa;
	}

	public void setNumeroDaCasa(String numeroDaCasa) {
		this.numeroDaCasa = numeroDaCasa;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Object getEstado() {
		return estado;
	}

	public void setEstado(Object estado) {
		this.estado = estado;
	}

	public String getCepResidencial() {
		return cepResidencial;
	}

	public void setCepResidencial(String cepResidencial) {
		this.cepResidencial = cepResidencial;
	}
	
	
	/*METODO PARA AUTENTICAR LOGIN*/
	public static void autenticarLogin(String usuario, String senha)throws AutenticacaoDoLoginException
	{		
		if("admin".equals(usuario) && "123".equals(senha)){
			JOptionPane.showMessageDialog(null, "Login autenticado com sucesso!");
			
			String args[] = {};
			AreaAdmin.main(args);	/*ABRINDO JANELA PRINCIPAL*/
			Login.frameLogin.dispose();		/*FECHANDO TELA DE LOGIN*/ 
			
			
		}else{
			/*VALIDAÇÃO FAIL*/
			throw new AutenticacaoDoLoginException("Login não autenticado, Tente novamente!");
		}
	}

}
