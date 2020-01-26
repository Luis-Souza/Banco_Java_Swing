package br.com.ifpi.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class JPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPrincipal frame = new JPrincipal();
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
	public JPrincipal() {
		setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		setTitle("Sistema de Controle Banc\u00E1rio");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 511);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Arquivo");
		mnNewMenu.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Abrir");
		mntmNewMenuItem_6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mnNewMenu.add(mntmNewMenuItem_6);
		
		//Criando nova Conta		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Nova Conta");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String args[] = {};
				//new TelaCadastorConta().main(args);
			}
		});
		mntmNewMenuItem_7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mnNewMenu.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_9);
		
		JMenu mnNewMenu_1 = new JMenu("Cadastros");
		mnNewMenu_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		menuBar.add(mnNewMenu_1);
		
		//Cadastrar Cliente novo		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Conta Corrente");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Conta Poupan\u00E7a");
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_2 = new JMenu("Movimentos");
		mnNewMenu_2.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Transferencia");
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Depositos");
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Retiradas");
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_3 = new JMenu("Informa\u00E7\u00F5es");
		mnNewMenu_3.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		menuBar.add(mnNewMenu_3);
		
		JMenu mnNewMenu_4 = new JMenu("Sobre");
		mnNewMenu_4.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Desenvolvedor");
		mnNewMenu_4.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(10, 11, 791, 432);
		contentPane.add(toolBar);
		
		//Botão de sacar operação a ser escolhida		
		JButton btnSacar = new JButton("");
		btnSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnSacar.setToolTipText("Sacar");
		btnSacar.setIcon(new ImageIcon("C:\\Users\\JorgeLuis\\workspace\\Projeto\\Imagens\\Saque.png"));
		toolBar.add(btnSacar);
		
		JButton btnTransferir = new JButton("");
		btnTransferir.setToolTipText("Transferir");
		btnTransferir.setIcon(new ImageIcon("C:\\Users\\JorgeLuis\\workspace\\Projeto\\Imagens\\movimento.png"));
		toolBar.add(btnTransferir);
		
		JButton btnDepositar = new JButton("");
		btnDepositar.setToolTipText("Depositar");
		btnDepositar.setIcon(new ImageIcon("C:\\Users\\JorgeLuis\\workspace\\Projeto\\Imagens\\deposito.png"));
		toolBar.add(btnDepositar);
		
		JButton btnOlharconta = new JButton("");
		btnOlharconta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnOlharconta.setToolTipText("OlharConta");
		btnOlharconta.setIcon(new ImageIcon("C:\\Users\\JorgeLuis\\workspace\\Projeto\\Imagens\\hist\u00F3rico.png"));
		toolBar.add(btnOlharconta);
	}
}
