package br.com.ifpi.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import br.com.ifpi.view.cadastro.CadastroContaCorrente;
import br.com.ifpi.view.cadastro.CadastroContaPoupanca;
import br.com.ifpi.view.painel.administracao.FecharConta;
import br.com.ifpi.view.painel.administracao.HistoricoDeConta;
import br.com.ifpi.view.painel.administracao.PesquisarCliente;

@SuppressWarnings("serial")
public class AreaAdmin extends JFrame {

	private JPanel contentPane;	
	private JPanel panelBemVindo;
	private Container controllerPanel;

	/**
	 * Launch the application.
	 */
	protected static AreaAdmin frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AreaAdmin();
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
	public AreaAdmin() {
		setTitle("Ferramenta Administrativa Banco");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 842, 630);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(192, 192, 192));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Cadastro de Conta");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmContaCorrente = new JMenuItem("Conta Corrente");
		mntmContaCorrente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mntmContaCorrente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String args[] = {};
				CadastroContaCorrente.main(args);
				dispose();
			}
		});
		mnNewMenu.add(mntmContaCorrente);
		
		JMenuItem mntmContaPoupana = new JMenuItem("Conta Poupan\u00E7a");
		mntmContaPoupana.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mntmContaPoupana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String args[] = {};
				CadastroContaPoupanca.main(args);
				dispose();
			}
		});
		mnNewMenu.add(mntmContaPoupana);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		final JPanel panelMenuTooLBar = new JPanel();
		contentPane.add(panelMenuTooLBar, BorderLayout.NORTH);
		panelMenuTooLBar.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(UIManager.getColor("ToolBar.background"));
		panelMenuTooLBar.add(toolBar, BorderLayout.CENTER);
		
		JButton btnHistorico = new JButton("Historico");
		btnHistorico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controllerPanel.setVisible(false);
				controllerPanel = new HistoricoDeConta();
				contentPane.add(controllerPanel, BorderLayout.CENTER);
			}
		});
		toolBar.add(btnHistorico);
		
		JButton btnPesquisarCliente = new JButton("Pesquisar Cliente");
		btnPesquisarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					controllerPanel.setVisible(false);
					
						try {
							controllerPanel = new PesquisarCliente();
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					contentPane.add(controllerPanel, BorderLayout.CENTER);
				
				
			}
		});
		toolBar.add(btnPesquisarCliente);
		
		JButton btnAcessarConta = new JButton("Acessar Conta");
		btnAcessarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//CHAMANDO JANELA DO CLIENTE
				String args[] = {};
				AreaDoCliente.main(args);
				dispose();
				
			}
		});
		toolBar.add(btnAcessarConta);
		
		JButton btnFecharConta = new JButton("Fechar Conta");
		btnFecharConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
					controllerPanel.setVisible(false);
					try {
						controllerPanel = new FecharConta();
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					contentPane.add(controllerPanel, BorderLayout.CENTER);
				
			}
		});
		toolBar.add(btnFecharConta);
		
		JButton btnSobre = new JButton("Sobre");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String args[] = {};
				JanelaSobre.main(args);
				AreaAdmin.this.setEnabled(false);
			}
		});
		toolBar.add(btnSobre);
		
		controllerPanel = panelBemVindo = new JPanel();
		contentPane.add(panelBemVindo, BorderLayout.CENTER);
		panelBemVindo.setLayout(new BorderLayout(0, 0));
		
		JLabel lblBemVindo = new JLabel("Bem Vindo");
		lblBemVindo.setForeground(SystemColor.controlDkShadow);
		lblBemVindo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemVindo.setFont(new Font("Californian FB", Font.PLAIN, 99));
		panelBemVindo.add(lblBemVindo, BorderLayout.CENTER);

	}
}
