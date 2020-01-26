package br.com.ifpi.view.painel.administracao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import br.com.ifpi.controller.ControladoraConta;
import br.com.ifpi.exception.ControladoraColecoesPesquisaContaException;
import br.com.ifpi.exception.ControladoraColecoesPreenchimentoDeCampoObrigatorioException;

@SuppressWarnings("serial")
public class PesquisarCliente extends JPanel {

	/**
	 * Create the panel. 
	 * @throws ParseException 
	 */
	public PesquisarCliente() throws ParseException {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		add(panel, BorderLayout.NORTH);
		
		JLabel lblCpf = new JLabel("CPF:");
		panel.add(lblCpf);
		
		final JFormattedTextField ftFCPF = new JFormattedTextField();
		ftFCPF.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
		panel.add(ftFCPF);
		
		
		final JTextArea tfAreaDadosCliente = new JTextArea();
		add(tfAreaDadosCliente, BorderLayout.CENTER);
		
		JButton btnPesquisar = new JButton("Pesquisar Conta Poupan\u00E7a");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					try {
						tfAreaDadosCliente.setText(ControladoraConta.pesquisarContaPoupanca(ftFCPF.getText()));
					} catch (ControladoraColecoesPesquisaContaException | ControladoraColecoesPreenchimentoDeCampoObrigatorioException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				
			}
		});
		panel.add(btnPesquisar);
		
		JButton btnPesquisarContaCorrente = new JButton("Pesquisar Conta Corrente");
		btnPesquisarContaCorrente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					tfAreaDadosCliente.setText(ControladoraConta.pesquisarContaCorrente(ftFCPF.getText()));
				} catch (ControladoraColecoesPesquisaContaException | ControladoraColecoesPreenchimentoDeCampoObrigatorioException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
			}
		});
		panel.add(btnPesquisarContaCorrente);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		add(panel_1, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		add(panel_2, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		add(panel_3, BorderLayout.SOUTH);

	}

}
