package br.com.ifpi.view.cadastro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import br.com.ifpi.controller.ControladoraConta;
import br.com.ifpi.exception.ControladoraColecoesCadastroException;
import br.com.ifpi.exception.ControladoraColecoesPreenchimentoDeCampoObrigatorioException;
import br.com.ifpi.utils.EnumEstado;
import br.com.ifpi.utils.EnumUF;
import br.com.ifpi.view.AreaAdmin;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class CadastroContaCorrente extends JFrame {

	private JPanel contentPane;
	private JTextField tfNomeCliente;
	private JTextField tfRG;
	private JTextField tfEmail;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField tfEndereco;
	private JTextField tfNumeroDaCasa;
	private JTextField tfComplemento;
	private JTextField tfBairro;
	private JTextField tfCidade;
	private JTextField tfSaldo;
	private JTextField tfAgencia;
	private JTextField tfRendaMns;
	private JTextField tfNumConta;
	private String sexo = "";
	private double saldo = 0.0;
	private int numero = 0;
	private double renda = 0.0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroContaCorrente frame = new CadastroContaCorrente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CadastroContaCorrente() throws ParseException {
		setTitle("Cadastro de Conta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1150, 629);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Panel.background"));
		panel.setBorder(new LineBorder(Color.GRAY, 1, true));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_Contato = new JPanel();
		panel_Contato.setBackground(UIManager.getColor("Panel.background"));
		panel_Contato.setBounds(126, 293, 473, 189);
		panel.add(panel_Contato);
		panel_Contato.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		panel_Contato.setLayout(null);
		
		JLabel lblEndereco = new JLabel("*Endereco:");
		lblEndereco.setToolTipText("Campo Obrigatorio!");
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblEndereco.setBounds(70, 11, 53, 14);
		panel_Contato.add(lblEndereco);
		
		tfEndereco = new JTextField();
		tfEndereco.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfEndereco.setBounds(70, 25, 355, 20);
		panel_Contato.add(tfEndereco);
		tfEndereco.setColumns(10);
		
		JLabel lblNumero = new JLabel("*Numero:");
		lblNumero.setToolTipText("Campo Obrigatorio!");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNumero.setBounds(70, 45, 74, 14);
		panel_Contato.add(lblNumero);
		
		tfNumeroDaCasa = new JTextField();
		tfNumeroDaCasa.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfNumeroDaCasa.setBounds(70, 61, 74, 20);
		panel_Contato.add(tfNumeroDaCasa);
		tfNumeroDaCasa.setColumns(10);
		
		JLabel lblComplemento = new JLabel("*Complemento:");
		lblComplemento.setToolTipText("Campo Obrigatorio!");
		lblComplemento.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblComplemento.setBounds(190, 45, 91, 14);
		panel_Contato.add(lblComplemento);
		
		tfComplemento = new JTextField();
		tfComplemento.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfComplemento.setBounds(190, 61, 235, 20);
		panel_Contato.add(tfComplemento);
		tfComplemento.setColumns(10);
		
		JLabel lblBairro = new JLabel("*Bairro:");
		lblBairro.setToolTipText("Campo Obrigatorio!");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblBairro.setBounds(70, 84, 53, 14);
		panel_Contato.add(lblBairro);
		
		tfBairro = new JTextField();
		tfBairro.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfBairro.setBounds(70, 100, 229, 20);
		panel_Contato.add(tfBairro);
		tfBairro.setColumns(10);
		
		JLabel lblCidade = new JLabel("*Cidade:");
		lblCidade.setToolTipText("Campo Obrigatorio!");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCidade.setBounds(70, 123, 102, 14);
		panel_Contato.add(lblCidade);
		
		final JComboBox comboBox_ESTADO = new JComboBox();
		comboBox_ESTADO.setBorder(null);
		comboBox_ESTADO.setModel(new DefaultComboBoxModel(EnumEstado.values()));
		comboBox_ESTADO.setBounds(293, 140, 147, 20);
		panel_Contato.add(comboBox_ESTADO);
		
		tfCidade = new JTextField();
		tfCidade.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfCidade.setBounds(70, 140, 211, 20);
		panel_Contato.add(tfCidade);
		tfCidade.setColumns(10);
		
		JLabel lblEstado = new JLabel("*Estado:");
		lblEstado.setToolTipText("Campo Obrigatorio!");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblEstado.setBounds(293, 123, 72, 14);
		panel_Contato.add(lblEstado);
		
		JLabel lblCep = new JLabel("*CEP:");
		lblCep.setToolTipText("Campo Obrigatorio!");
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCep.setBounds(319, 84, 46, 14);
		panel_Contato.add(lblCep);
		
		final JFormattedTextField fTFCEP = new JFormattedTextField();
		fTFCEP.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fTFCEP.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("#####-###")));
		fTFCEP.setBounds(319, 100, 91, 20);
		panel_Contato.add(fTFCEP);
		
		JPanel panel_InfoPessoais = new JPanel();
		panel_InfoPessoais.setBackground(UIManager.getColor("Panel.background"));
		panel_InfoPessoais.setBounds(126, 29, 495, 237);
		panel.add(panel_InfoPessoais);
		panel_InfoPessoais.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		panel_InfoPessoais.setLayout(null);
		
		JLabel lblNomeDoCliente = new JLabel("*Nome do Cliente");
		lblNomeDoCliente.setToolTipText("Campo Obrigatorio!");
		lblNomeDoCliente.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNomeDoCliente.setBounds(68, 11, 88, 14);
		panel_InfoPessoais.add(lblNomeDoCliente);
		
		tfNomeCliente = new JTextField();
		tfNomeCliente.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfNomeCliente.setBounds(68, 23, 280, 20);
		panel_InfoPessoais.add(tfNomeCliente);
		tfNomeCliente.setColumns(10);
		
		JLabel lblCpf = new JLabel("*CPF:");
		lblCpf.setToolTipText("Campo Obrigatorio!");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCpf.setBounds(68, 45, 46, 14);
		panel_InfoPessoais.add(lblCpf);
		
		final JFormattedTextField fTFCPF = new JFormattedTextField();
		fTFCPF.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fTFCPF.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
		fTFCPF.setBounds(68, 58, 132, 20);
		panel_InfoPessoais.add(fTFCPF);
		
		JLabel lblRg = new JLabel("*RG:");
		lblRg.setToolTipText("Campo Obrigatorio!");
		lblRg.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblRg.setBounds(210, 45, 46, 14);
		panel_InfoPessoais.add(lblRg);
		
		tfRG = new JTextField();
		tfRG.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfRG.setBounds(210, 58, 110, 20);
		panel_InfoPessoais.add(tfRG);
		tfRG.setColumns(10);
		
		JLabel lblEmail = new JLabel("*E-mail:");
		lblEmail.setToolTipText("Campo Obrigatorio!");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblEmail.setBounds(68, 121, 64, 14);
		panel_InfoPessoais.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfEmail.setToolTipText("@gmail");
		tfEmail.setBounds(68, 135, 166, 20);
		panel_InfoPessoais.add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lblUF = new JLabel("UF:");
		lblUF.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblUF.setBounds(330, 45, 46, 14);
		panel_InfoPessoais.add(lblUF);
		
		final JComboBox comboBox_UF = new JComboBox();
		comboBox_UF.setModel(new DefaultComboBoxModel(EnumUF.values()));
		comboBox_UF.setBounds(330, 58, 102, 20);
		panel_InfoPessoais.add(comboBox_UF);
		
		JLabel lblDataDeNascimento = new JLabel("*Data de Nascimento:");
		lblDataDeNascimento.setToolTipText("Campo Obrigatorio!");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblDataDeNascimento.setBounds(68, 79, 110, 14);
		panel_InfoPessoais.add(lblDataDeNascimento);
		
		final JFormattedTextField fTFDataNasc = new JFormattedTextField();
		fTFDataNasc.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fTFDataNasc.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
		fTFDataNasc.setBounds(68, 95, 96, 20);
		panel_InfoPessoais.add(fTFDataNasc);
		
		JLabel lblSexo = new JLabel("*Sexo:");
		lblSexo.setToolTipText("Campo Obrigatorio!");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblSexo.setBounds(68, 159, 46, 14);
		panel_InfoPessoais.add(lblSexo);
		
		JRadioButton rdbtnMan = new JRadioButton("Masculino");
		rdbtnMan.setBackground(UIManager.getColor("Panel.background"));
		rdbtnMan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sexo = "Masculino";
			}
		});
		rdbtnMan.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonGroup.add(rdbtnMan);
		rdbtnMan.setBounds(78, 174, 75, 23);
		panel_InfoPessoais.add(rdbtnMan);
		
		JRadioButton rdbtnFemale = new JRadioButton("Feminino");
		rdbtnFemale.setBackground(UIManager.getColor("Panel.background"));
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				sexo = "Feminino";
			}
		});
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setBounds(78, 200, 78, 23);
		panel_InfoPessoais.add(rdbtnFemale);
		
		JLabel lblEstadoCivil = new JLabel("*Estado Civil:");
		lblEstadoCivil.setToolTipText("Campo Obrigatorio!");
		lblEstadoCivil.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblEstadoCivil.setBounds(188, 79, 75, 14);
		panel_InfoPessoais.add(lblEstadoCivil);
		
		final JComboBox comboBox_ESTADO_CIVIL = new JComboBox();
		comboBox_ESTADO_CIVIL.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Solteiro", "Conjuge", "Casado", "V\u00EDuvo", "Separado", "Divorciado"}));
		comboBox_ESTADO_CIVIL.setBounds(188, 95, 110, 20);
		panel_InfoPessoais.add(comboBox_ESTADO_CIVIL);
		
		JLabel lblTelefone = new JLabel("*Celular:");
		lblTelefone.setToolTipText("Campo Obrigatorio!");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTelefone.setBounds(244, 121, 68, 14);
		panel_InfoPessoais.add(lblTelefone);
		
		final JFormattedTextField fTFTelefone = new JFormattedTextField();
		fTFTelefone.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fTFTelefone.setToolTipText("(DDD)9xxxx-xxxx");
		fTFTelefone.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##)#####-####")));
		fTFTelefone.setBounds(244, 135, 102, 20);
		panel_InfoPessoais.add(fTFTelefone);
		
		JLabel lblLocalizao = new JLabel("Localiza\u00E7\u00E3o");
		lblLocalizao.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblLocalizao.setBounds(128, 279, 76, 14);
		panel.add(lblLocalizao);
		
		JLabel lblInformaesPessoais = new JLabel("Informa\u00E7\u00F5es Pessoais");
		lblInformaesPessoais.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblInformaesPessoais.setBounds(126, 11, 113, 14);
		panel.add(lblInformaesPessoais);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(UIManager.getColor("Panel.background"));
		panel_5.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		panel_5.setBounds(633, 29, 424, 207);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblSaldo = new JLabel("*Saldo:");
		lblSaldo.setToolTipText("Campo Obrigatorio!");
		lblSaldo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblSaldo.setBounds(38, 31, 46, 14);
		panel_5.add(lblSaldo);
		
		tfSaldo = new JTextField();
		tfSaldo.setText("0.0");
		tfSaldo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfSaldo.setBounds(38, 48, 86, 20);
		panel_5.add(tfSaldo);
		tfSaldo.setColumns(10);
		
		JLabel lblAgencia = new JLabel("*Agencia:");
		lblAgencia.setToolTipText("Campo Obrigatorio!");
		lblAgencia.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblAgencia.setBounds(148, 31, 46, 14);
		panel_5.add(lblAgencia);
		
		tfAgencia = new JTextField();
		tfAgencia.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfAgencia.setBounds(147, 48, 86, 20);
		panel_5.add(tfAgencia);
		tfAgencia.setColumns(10);
		
		JLabel lblRendaMensal = new JLabel("*Renda Mensal:");
		lblRendaMensal.setToolTipText("Campo Obrigatorio!");
		lblRendaMensal.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblRendaMensal.setBounds(38, 93, 86, 14);
		panel_5.add(lblRendaMensal);
		
		tfRendaMns = new JTextField();
		tfRendaMns.setText("0.0");
		tfRendaMns.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfRendaMns.setBounds(38, 110, 86, 20);
		panel_5.add(tfRendaMns);
		tfRendaMns.setColumns(10);
		
		JLabel lblcontaRequerUm = new JLabel("*Conta requer um deposito inicial de R$:50,00");
		lblcontaRequerUm.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblcontaRequerUm.setBounds(10, 162, 217, 14);
		panel_5.add(lblcontaRequerUm);
		
		JLabel lblNumeroDaConta = new JLabel("*Numero da Conta:");
		lblNumeroDaConta.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNumeroDaConta.setToolTipText("Campo Obrigatorio!");
		lblNumeroDaConta.setBounds(148, 93, 98, 14);
		panel_5.add(lblNumeroDaConta);
		
		tfNumConta = new JTextField();
		tfNumConta.setText("0");
		tfNumConta.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tfNumConta.setBounds(148, 110, 98, 20);
		panel_5.add(tfNumConta);
		tfNumConta.setColumns(10);
		
		JLabel lblconfirmeRendaMensal = new JLabel("*Renda Mensal necessaria para cadastro de um salario minimo R$:788,00");
		lblconfirmeRendaMensal.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblconfirmeRendaMensal.setBounds(10, 177, 313, 14);
		panel_5.add(lblconfirmeRendaMensal);
		
		JLabel lblInformaesDeConta = new JLabel("Informa\u00E7\u00F5es de Conta");
		lblInformaesDeConta.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblInformaesDeConta.setBounds(635, 11, 113, 14);
		panel.add(lblInformaesDeConta);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(Color.GRAY, 1, true));
		panel_4.setBackground(UIManager.getColor("Panel.background"));
		contentPane.add(panel_4, BorderLayout.SOUTH);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saldo = Double.parseDouble(tfSaldo.getText());
				numero = Integer.parseInt(tfNumConta.getText());
				renda = Double.parseDouble(tfRendaMns.getText());
				
				try {
					ControladoraConta.criarContaCorrente(tfNomeCliente.getText(),
							fTFCPF.getText(), tfRG.getText(), comboBox_UF.getSelectedItem(), fTFDataNasc.getText(), comboBox_ESTADO_CIVIL.getSelectedItem(),
							tfEmail.getText(), fTFTelefone.getText(), sexo, tfEndereco.getText(), tfComplemento.getText(), tfNumeroDaCasa.getText(), tfBairro.getText(), tfCidade.getText(),
							comboBox_ESTADO.getSelectedItem(), fTFCEP.getText(), saldo, tfAgencia.getText(), numero, renda);
				} catch (ControladoraColecoesCadastroException | ControladoraColecoesPreenchimentoDeCampoObrigatorioException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
		});
		panel_4.add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String args[] = {};
				AreaAdmin.main(args);
				dispose();
			}
		});
		panel_4.add(btnVoltar);
		
		JLabel lblCadastroContaCorrente = new JLabel("Cadastro Conta Corrente");
		lblCadastroContaCorrente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblCadastroContaCorrente, BorderLayout.NORTH);
		
		
	}
}

