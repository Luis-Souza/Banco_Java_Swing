package br.com.ifpi.view.cadastro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import br.com.ifpi.controller.ControladoraConta;
import br.com.ifpi.exception.ControladoraColecoesCadastroException;
import br.com.ifpi.exception.ControladoraColecoesPreenchimentoDeCampoObrigatorioException;
import br.com.ifpi.view.AreaAdmin;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class CadastroContaPoupanca extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfRG;
	private JFormattedTextField ftFCPF;
	private JTextField tfSaldo;
	private JTextField tfAgencia;
	private JTextField tfNumCont;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroContaPoupanca frame = new CadastroContaPoupanca();
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
	public CadastroContaPoupanca() throws ParseException {
		setResizable(false);
		setTitle("Cadastro de Conta Poupan\u00E7a");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		panel_4.setBackground(UIManager.getColor("Panel.background"));
		contentPane.add(panel_4, BorderLayout.SOUTH);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double saldo = Double.parseDouble(tfSaldo.getText());
				int numero = Integer.parseInt(tfNumCont.getText());
				
				try {
					ControladoraConta.criarContaPoupança(tfNome.getText(), ftFCPF.getText(), tfRG.getText(), tfAgencia.getText(), saldo, numero);
				} catch (ControladoraColecoesCadastroException | ControladoraColecoesPreenchimentoDeCampoObrigatorioException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					//e.printStackTrace();
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
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.GRAY, 1, true));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNomeCompleto = new JLabel("*Nome Completo:");
		lblNomeCompleto.setToolTipText("Campo Obrigatorio!");
		lblNomeCompleto.setDoubleBuffered(true);
		lblNomeCompleto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNomeCompleto.setBounds(187, 56, 85, 14);
		panel.add(lblNomeCompleto);
		
		tfNome = new JTextField();
		tfNome.setDoubleBuffered(true);
		tfNome.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfNome.setBounds(187, 72, 255, 20);
		panel.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("*CPF:");
		lblCpf.setToolTipText("Campo Obrigatorio!");
		lblCpf.setDoubleBuffered(true);
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCpf.setBounds(187, 97, 46, 14);
		panel.add(lblCpf);
		
		ftFCPF = new JFormattedTextField();
		ftFCPF.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
		ftFCPF.setDoubleBuffered(true);
		ftFCPF.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ftFCPF.setBounds(187, 112, 123, 20);
		panel.add(ftFCPF);
		
		JLabel lblRg = new JLabel("*RG:");
		lblRg.setToolTipText("Campo Obrigatorio!");
		lblRg.setDoubleBuffered(true);
		lblRg.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRg.setBounds(320, 97, 46, 14);
		panel.add(lblRg);
		
		tfRG = new JTextField();
		tfRG.setDoubleBuffered(true);
		tfRG.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfRG.setBounds(320, 112, 122, 20);
		panel.add(tfRG);
		tfRG.setColumns(10);
		
		JLabel lblSaldo = new JLabel("Saldo:");
		lblSaldo.setDoubleBuffered(true);
		lblSaldo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSaldo.setBounds(187, 135, 46, 14);
		panel.add(lblSaldo);
		
		tfSaldo = new JTextField();
		tfSaldo.setText("0.0");
		tfSaldo.setDoubleBuffered(true);
		tfSaldo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfSaldo.setToolTipText("R$:");
		tfSaldo.setBounds(187, 150, 101, 20);
		panel.add(tfSaldo);
		tfSaldo.setColumns(10);
		
		JLabel lblAgencia = new JLabel("*Agencia:");
		lblAgencia.setToolTipText("Campo Obrigatorio!");
		lblAgencia.setDoubleBuffered(true);
		lblAgencia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAgencia.setBounds(300, 135, 57, 14);
		panel.add(lblAgencia);
		
		tfAgencia = new JTextField();
		tfAgencia.setDoubleBuffered(true);
		tfAgencia.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfAgencia.setBounds(300, 150, 123, 20);
		panel.add(tfAgencia);
		tfAgencia.setColumns(10);
		
		JLabel lblNumeroDaConta = new JLabel("Numero da Conta:");
		lblNumeroDaConta.setDoubleBuffered(true);
		lblNumeroDaConta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNumeroDaConta.setBounds(187, 175, 95, 14);
		panel.add(lblNumeroDaConta);
		
		tfNumCont = new JTextField();
		tfNumCont.setText("0");
		tfNumCont.setDoubleBuffered(true);
		tfNumCont.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tfNumCont.setBounds(187, 191, 102, 20);
		panel.add(tfNumCont);
		tfNumCont.setColumns(10);
		
		JLabel lblCadastroContaPoupanca = new JLabel("Cadastro Conta Poupan\u00E7a");
		lblCadastroContaPoupanca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblCadastroContaPoupanca, BorderLayout.NORTH);
	}
}
