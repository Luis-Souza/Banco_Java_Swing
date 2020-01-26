package br.com.ifpi.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.ifpi.exception.AutenticacaoDoLoginException;
import br.com.ifpi.model.Cliente;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsuario;
	private JPasswordField pfSenha;
	public static Login frameLogin = new Login();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Tela de Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 291);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 416, 241);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(50, 77, 62, 14);
		panel.add(lblUsuario);

		tfUsuario = new JTextField();
		tfUsuario.setBounds(122, 74, 178, 20);
		panel.add(tfUsuario);
		tfUsuario.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(50, 114, 62, 14);
		panel.add(lblSenha);

		pfSenha = new JPasswordField();
		pfSenha.setBounds(122, 111, 178, 20);
		panel.add(pfSenha);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				/*ACESSANDO MEDOTO AUTENTICARLOGIN DE USUARIO*/
					try{
						Cliente.autenticarLogin(tfUsuario.getText(), pfSenha.getText());
					}catch(AutenticacaoDoLoginException e){
						//e.printStackTrace();
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				
			}
		});
		btnEntrar.setBounds(122, 163, 89, 23);
		panel.add(btnEntrar);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSair.setBounds(221, 163, 89, 23);
		panel.add(btnSair);
	}

}
