package br.com.ifpi.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import br.com.ifpi.view.painel.usuario.TelaAtualizarDados;
import br.com.ifpi.view.painel.usuario.TelaDeDeposito;
import br.com.ifpi.view.painel.usuario.TelaDeSaque;
import br.com.ifpi.view.painel.usuario.TelaDeTransferencia;

@SuppressWarnings("serial")
public class AreaDoCliente extends JFrame {

	private JPanel contentPane;
	private JPanel panel_Hello;
	private Container controlerPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AreaDoCliente frame = new AreaDoCliente();
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
	public AreaDoCliente() {
		setTitle("Area do Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 630);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmVoltar = new JMenuItem("Voltar");
		mntmVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//VOLTANDO A JANELA DE ADMINISTRADOR
				String args[] = {};
				AreaAdmin.main(args);
				dispose();
			}
		});
		mnFile.add(mntmVoltar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		final JPanel panelMenuToolBar = new JPanel();
		panelMenuToolBar.setBackground(UIManager.getColor("Panel.background"));
		contentPane.add(panelMenuToolBar, BorderLayout.NORTH);
		panelMenuToolBar.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(UIManager.getColor("ToolBar.background"));
		panelMenuToolBar.add(toolBar, BorderLayout.CENTER);
		
		JButton btnSacar = new JButton("Saque de Conta");
		btnSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlerPanel.setVisible(false);
				
					try {
						controlerPanel = new TelaDeSaque();
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
				
				contentPane.add(controlerPanel, BorderLayout.CENTER);
				
			}
		});
		toolBar.add(btnSacar);
		
		JButton btnDeposita = new JButton("Deposita de Conta");
		btnDeposita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlerPanel.setVisible(false);
				
				try {
					controlerPanel = new TelaDeDeposito();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				contentPane.add(controlerPanel, BorderLayout.CENTER);
			}
		});
		toolBar.add(btnDeposita);
		
		JButton btnTransferir = new JButton("Transfer\u00EAncia Bancaria");
		btnTransferir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlerPanel.setVisible(false);
				
				try {
					controlerPanel = new TelaDeTransferencia();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				contentPane.add(controlerPanel, BorderLayout.CENTER);
			}
		});
		toolBar.add(btnTransferir);
		
		JButton btnAtualizar = new JButton("Atualizar Dados");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlerPanel.setVisible(false);
				
				try {
					controlerPanel = new TelaAtualizarDados();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				contentPane.add(controlerPanel, BorderLayout.CENTER);
			}
		});
		toolBar.add(btnAtualizar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				System.exit(0);
			}
		});
		toolBar.add(btnSair);
		
		controlerPanel = panel_Hello = new JPanel();
		panel_Hello.setBackground(Color.LIGHT_GRAY);
		contentPane.add(controlerPanel, BorderLayout.CENTER);
		panel_Hello.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_Hello.add(panel, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		panel_Hello.add(panel_1, BorderLayout.EAST);
		
		JPanel panel_2 = new JPanel();
		panel_Hello.add(panel_2, BorderLayout.SOUTH);
		
		JPanel panel_3 = new JPanel();
		panel_Hello.add(panel_3, BorderLayout.NORTH);
	}

}
