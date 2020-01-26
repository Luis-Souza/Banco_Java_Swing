package br.com.ifpi.persistense;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class TestaConexao extends JFrame {

	private JPanel contentPane;
	private Connection conexao;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestaConexao frame = new TestaConexao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestaConexao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setBounds(64, 86, 46, 14);
		contentPane.add(lblUsurio);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(64, 129, 46, 14);
		contentPane.add(lblSenha);
		
		textField = new JTextField();
		textField.setBounds(120, 83, 134, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(120, 126, 134, 20);
		contentPane.add(passwordField);
		
		JButton btnConecta = new JButton("Conecta");
		btnConecta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conexao = new FabricaDeConexoes().getConnection(textField.getText(), passwordField.getText());
				System.out.println("Conectou com sucesso");
			}
		});
		btnConecta.setBounds(120, 179, 91, 23);
		contentPane.add(btnConecta);
		
		
	}
}
