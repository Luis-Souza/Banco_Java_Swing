package br.com.ifpi.view.painel.administracao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.ifpi.controller.ControladoraConta;

@SuppressWarnings("serial")
public class HistoricoDeConta extends JPanel {
	
	private TextArea tfADados;
	/**
	 * Create the panel.
	 */
	public HistoricoDeConta() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblHistoricoBancario = new JLabel("Historico Bancario");
		lblHistoricoBancario.setBackground(Color.LIGHT_GRAY);
		lblHistoricoBancario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblHistoricoBancario, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		add(panel, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		add(panel_2, BorderLayout.SOUTH);
		
		JButton btnMostrarHistorico = new JButton("Mostrar Historico Conta Poupan\u00E7a");
		panel_2.add(btnMostrarHistorico);
		
		JButton btnMostraHistoricoConta = new JButton("Mostra historico Conta Corrente");
		btnMostraHistoricoConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				tfADados.setText(ControladoraConta.mostrarHistoricoContaCorrente());
				
			}
		});
		panel_2.add(btnMostraHistoricoConta);
		btnMostrarHistorico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tfADados.setText(ControladoraConta.mostrarHistoricoContaPoupanca());
			}
		});
		
		JPanel panel_3 = new JPanel();
		add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		tfADados = new TextArea();
		panel_3.add(tfADados, BorderLayout.CENTER);

	}

}
