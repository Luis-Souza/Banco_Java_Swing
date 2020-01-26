package br.com.ifpi.view.painel.usuario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import br.com.ifpi.controller.ControladoraConta;
import br.com.ifpi.exception.ControladoraColecoesAtualizarContaCorrenteException;
import br.com.ifpi.exception.ControladoraColecoesAtualizarContaPoupancaException;
import br.com.ifpi.exception.ControladoraColecoesPreenchimentoDeCampoObrigatorioException;
import br.com.ifpi.utils.EnumEstado;
import br.com.ifpi.utils.EnumUF;

@SuppressWarnings("serial")
public class TelaAtualizarDados extends JPanel {
	private JTextField tfNomeClienteCorre;
	private JTextField tfEmail_Corrente;
	private JTextField tfEnd_Corrente;
	private JTextField tfNumCasa_Corrente;
	private JTextField tfBairro_Corrente;
	private JTextField tfComplemento_Corrente;
	private JTextField tfCidade_Corrente;
	private JTextField tfAgenciaCorrente;
	private JTextField tfRenda_Corrente;
	private JTextField tfRG_Corre;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private String sexo = "";
	/**
	 * Create the panel.
	 */
	public TelaAtualizarDados() throws ParseException{
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblAtualizarDados = new JLabel("Atualizar Dados");
		lblAtualizarDados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblAtualizarDados, BorderLayout.NORTH);
		
		JTabbedPane tabbedPane_DadosConta = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane_DadosConta, BorderLayout.CENTER);
		
		JPanel panel_DadosPoupanca = new JPanel();
		tabbedPane_DadosConta.addTab("Conta Poupança", null, panel_DadosPoupanca, null);
		panel_DadosPoupanca.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(Color.GRAY, 1, true));
		panel_DadosPoupanca.add(panel_3, BorderLayout.CENTER);
		
		Label label_NomeCliente = new Label("*Nome do Cliente:");
		
		final TextField tfNomeClientePoupa = new TextField();
		
		Label label_Agencia = new Label("*Agencia:");
		
		final TextField tfAgenciaPoupa = new TextField();
		
		Label label = new Label("*Cpf da Conta:");
		
		final JFormattedTextField ftFCPF_Poupanca = new JFormattedTextField();
		ftFCPF_Poupanca.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ftFCPF_Poupanca.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
		
		JLabel lblobsONumero = new JLabel("*Obs: o numero da conta n\u00E3o sera modificado!");
		lblobsONumero.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap(51, Short.MAX_VALUE)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_3.createSequentialGroup()
									.addGap(52)
									.addComponent(label_NomeCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfNomeClientePoupa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_panel_3.createSequentialGroup()
									.addGap(51)
									.addComponent(label_Agencia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(7)
									.addComponent(tfAgenciaPoupa, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_3.createSequentialGroup()
									.addGap(52)
									.addComponent(label, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(ftFCPF_Poupanca, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)))
							.addGap(555))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(lblobsONumero, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
							.addGap(258))))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(48)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(label_NomeCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfNomeClientePoupa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(label_Agencia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfAgenciaPoupa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(2)
							.addComponent(ftFCPF_Poupanca, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
					.addComponent(lblobsONumero)
					.addContainerGap())
		);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(Color.GRAY, 1, true));
		panel_DadosPoupanca.add(panel_4, BorderLayout.SOUTH);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					ControladoraConta.atualizarContaPoupanca(tfNomeClientePoupa.getText(), tfAgenciaPoupa.getText(), ftFCPF_Poupanca.getText());
				} catch (ControladoraColecoesAtualizarContaPoupancaException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
			}
		});
		panel_4.add(btnAtualizar);
		
		JPanel panel_DadosCorrente = new JPanel();
		tabbedPane_DadosConta.addTab("Conta Corrente", null, panel_DadosCorrente, null);
		panel_DadosCorrente.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		panel_DadosCorrente.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_7.setBounds(52, 41, 388, 187);
		panel_5.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNomeDoCliente = new JLabel("*Nome do Cliente:");
		lblNomeDoCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNomeDoCliente.setBounds(10, 11, 99, 14);
		panel_7.add(lblNomeDoCliente);
		
		tfNomeClienteCorre = new JTextField();
		tfNomeClienteCorre.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfNomeClienteCorre.setBounds(113, 8, 212, 20);
		panel_7.add(tfNomeClienteCorre);
		tfNomeClienteCorre.setColumns(10);
		
		JLabel lblEstadoCivil = new JLabel("*Estado Civil:");
		lblEstadoCivil.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEstadoCivil.setBounds(180, 87, 74, 14);
		panel_7.add(lblEstadoCivil);
		
		final JComboBox comboBox_EstadoCivilCorrente = new JComboBox();
		comboBox_EstadoCivilCorrente.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Solteiro", "Conjuge", "Casado", "V\u00EDuvo", "Separado", "Divorciado"}));
		comboBox_EstadoCivilCorrente.setBounds(251, 84, 99, 20);
		panel_7.add(comboBox_EstadoCivilCorrente);
		
		JLabel lblTelefone = new JLabel("*Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefone.setBounds(10, 87, 55, 14);
		panel_7.add(lblTelefone);
		
		final JFormattedTextField ftFTelefoneCorrente = new JFormattedTextField();
		ftFTelefoneCorrente.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ftFTelefoneCorrente.setToolTipText("(DDD)9xxxx-xxxx");
		ftFTelefoneCorrente.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##)#####-####")));
		ftFTelefoneCorrente.setBounds(66, 84, 104, 20);
		panel_7.add(ftFTelefoneCorrente);
		
		JLabel lblEmail = new JLabel("*E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmail.setBounds(10, 113, 46, 14);
		panel_7.add(lblEmail);
		
		tfEmail_Corrente = new JTextField();
		tfEmail_Corrente.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfEmail_Corrente.setBounds(53, 112, 146, 20);
		panel_7.add(tfEmail_Corrente);
		tfEmail_Corrente.setColumns(10);
		
		JLabel lblCpf = new JLabel("*CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCpf.setBounds(10, 33, 46, 14);
		panel_7.add(lblCpf);
		
		final JFormattedTextField ftFCPF_Corrente = new JFormattedTextField();
		ftFCPF_Corrente.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ftFCPF_Corrente.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
		ftFCPF_Corrente.setBounds(53, 30, 123, 20);
		panel_7.add(ftFCPF_Corrente);
		
		JLabel lblRg = new JLabel("*RG:");
		lblRg.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRg.setBounds(186, 33, 37, 14);
		panel_7.add(lblRg);
		
		tfRG_Corre = new JTextField();
		tfRG_Corre.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfRG_Corre.setBounds(207, 30, 104, 20);
		panel_7.add(tfRG_Corre);
		tfRG_Corre.setColumns(10);
		
		JLabel lblUf = new JLabel("*UF:");
		lblUf.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUf.setBounds(233, 61, 30, 14);
		panel_7.add(lblUf);
		
		final JComboBox comboBox_UFCorre = new JComboBox();
		comboBox_UFCorre.setModel(new DefaultComboBoxModel(EnumUF.values()));
		comboBox_UFCorre.setBounds(265, 58, 85, 20);
		panel_7.add(comboBox_UFCorre);
		
		JLabel lblDataDeNascimento = new JLabel("*Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDataDeNascimento.setBounds(10, 62, 109, 14);
		panel_7.add(lblDataDeNascimento);
		
		final JFormattedTextField ftFDataDeNasc_Corre = new JFormattedTextField();
		ftFDataDeNasc_Corre.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ftFDataDeNasc_Corre.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
		ftFDataDeNasc_Corre.setBounds(113, 59, 110, 20);
		panel_7.add(ftFDataDeNasc_Corre);
		
		JLabel lblSexo = new JLabel("*Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSexo.setBounds(10, 136, 37, 14);
		panel_7.add(lblSexo);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sexo = "Masculino";
			}
		});
		buttonGroup.add(rdbtnMasculino);
		rdbtnMasculino.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnMasculino.setBounds(10, 157, 80, 23);
		panel_7.add(rdbtnMasculino);
		
		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sexo = "Feminino";
			}
		});
		buttonGroup.add(rdbtnFeminino);
		rdbtnFeminino.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdbtnFeminino.setBounds(92, 157, 85, 23);
		panel_7.add(rdbtnFeminino);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		panel_8.setBounds(52, 239, 388, 179);
		panel_5.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblEndereco = new JLabel("*Endereco");
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEndereco.setBounds(10, 11, 57, 14);
		panel_8.add(lblEndereco);
		
		tfEnd_Corrente = new JTextField();
		tfEnd_Corrente.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfEnd_Corrente.setBounds(10, 28, 181, 20);
		panel_8.add(tfEnd_Corrente);
		tfEnd_Corrente.setColumns(10);
		
		JLabel lblNumero = new JLabel("*Numero");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNumero.setBounds(201, 11, 46, 14);
		panel_8.add(lblNumero);
		
		tfNumCasa_Corrente = new JTextField();
		tfNumCasa_Corrente.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfNumCasa_Corrente.setBounds(201, 28, 86, 20);
		panel_8.add(tfNumCasa_Corrente);
		tfNumCasa_Corrente.setColumns(10);
		
		JLabel lblBairro = new JLabel("*Bairro");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBairro.setBounds(10, 53, 46, 14);
		panel_8.add(lblBairro);
		
		tfBairro_Corrente = new JTextField();
		tfBairro_Corrente.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfBairro_Corrente.setBounds(10, 66, 181, 20);
		panel_8.add(tfBairro_Corrente);
		tfBairro_Corrente.setColumns(10);
		
		JLabel lblComplemento = new JLabel("*Complemento");
		lblComplemento.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblComplemento.setBounds(201, 53, 86, 14);
		panel_8.add(lblComplemento);
		
		tfComplemento_Corrente = new JTextField();
		tfComplemento_Corrente.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfComplemento_Corrente.setBounds(201, 66, 177, 20);
		panel_8.add(tfComplemento_Corrente);
		tfComplemento_Corrente.setColumns(10);
		
		JLabel lblCidade = new JLabel("*Cidade");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCidade.setBounds(10, 89, 46, 14);
		panel_8.add(lblCidade);
		
		tfCidade_Corrente = new JTextField();
		tfCidade_Corrente.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfCidade_Corrente.setBounds(10, 104, 164, 20);
		panel_8.add(tfCidade_Corrente);
		tfCidade_Corrente.setColumns(10);
		
		JLabel lblCep = new JLabel("*CEP");
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCep.setBounds(183, 89, 46, 14);
		panel_8.add(lblCep);
		
		final JFormattedTextField ftFCEP_Corrente = new JFormattedTextField();
		ftFCEP_Corrente.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ftFCEP_Corrente.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("#####-###")));
		ftFCEP_Corrente.setBounds(185, 104, 102, 20);
		panel_8.add(ftFCEP_Corrente);
		
		JLabel lblEstado = new JLabel("*Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEstado.setBounds(10, 126, 46, 14);
		panel_8.add(lblEstado);
		
		final JComboBox comboBox_EstadoCorrente = new JComboBox();
		comboBox_EstadoCorrente.setModel(new DefaultComboBoxModel(EnumEstado.values()));
		comboBox_EstadoCorrente.setBounds(10, 144, 122, 20);
		panel_8.add(comboBox_EstadoCorrente);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_9.setBounds(450, 41, 349, 115);
		panel_5.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblAgencia = new JLabel("*Agencia");
		lblAgencia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAgencia.setBounds(10, 11, 46, 14);
		panel_9.add(lblAgencia);
		
		tfAgenciaCorrente = new JTextField();
		tfAgenciaCorrente.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfAgenciaCorrente.setBounds(10, 25, 86, 20);
		panel_9.add(tfAgenciaCorrente);
		tfAgenciaCorrente.setColumns(10);
		
		JLabel lblRenda = new JLabel("*Renda Mensal");
		lblRenda.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRenda.setBounds(107, 11, 85, 14);
		panel_9.add(lblRenda);
		
		tfRenda_Corrente = new JTextField();
		tfRenda_Corrente.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfRenda_Corrente.setText("0.0");
		tfRenda_Corrente.setBounds(106, 25, 86, 20);
		panel_9.add(tfRenda_Corrente);
		tfRenda_Corrente.setColumns(10);
		
		JLabel label_1 = new JLabel("*Renda Mensal necessaria para cadastro de um salario minimo R$:788,00");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_1.setBounds(10, 90, 313, 14);
		panel_9.add(label_1);
		
		JLabel lblobsONumero_1 = new JLabel("*Obs: o numero da Conta n\u00E3o sera modificado!");
		lblobsONumero_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblobsONumero_1.setBounds(10, 73, 224, 14);
		panel_9.add(lblobsONumero_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(Color.GRAY, 1, true));
		panel_DadosCorrente.add(panel_6, BorderLayout.SOUTH);
		
		JButton btnAtualizar_1 = new JButton("Atualizar");
		btnAtualizar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					ControladoraConta.atualizarContaCorrente(tfNomeClienteCorre.getText(), ftFCPF_Corrente.getText(), tfRG_Corre.getText(), comboBox_UFCorre.getSelectedItem(), ftFDataDeNasc_Corre.getText(), ftFTelefoneCorrente.getText(),
							comboBox_EstadoCivilCorrente.getSelectedItem(), tfEmail_Corrente.getText(), sexo, tfEnd_Corrente.getText(), tfNumCasa_Corrente.getText(), tfBairro_Corrente.getText(), tfComplemento_Corrente.getText(), tfCidade_Corrente.getText(), ftFCEP_Corrente.getText(), comboBox_EstadoCorrente.getSelectedItem(), tfAgenciaCorrente.getText(), tfRenda_Corrente.getText());
				} catch (ControladoraColecoesAtualizarContaCorrenteException | ControladoraColecoesPreenchimentoDeCampoObrigatorioException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		panel_6.add(btnAtualizar_1);

	}
}
