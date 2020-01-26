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
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import br.com.ifpi.controller.ControladoraConta;
import br.com.ifpi.exception.ControladoraColecoesBancoNaoPossuiContaCadasTradaException;
import br.com.ifpi.exception.ControladoraColecoesRemoverContaException;

@SuppressWarnings("serial")
public class FecharConta extends JPanel {
	private JTextField tfNumConta;

	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public FecharConta() throws ParseException {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		add(panel_1, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		add(panel_2, BorderLayout.SOUTH);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		add(panel_3, BorderLayout.EAST);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.LIGHT_GRAY);
		add(panel_4, BorderLayout.NORTH);
		
		JLabel lblCpf = new JLabel("CPF:");
		panel_4.add(lblCpf);
		
		final JFormattedTextField ftFCPF = new JFormattedTextField();
		ftFCPF.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
		panel_4.add(ftFCPF);
		
		JLabel lblNumeroDaConta = new JLabel("Numero da Conta:");
		panel_4.add(lblNumeroDaConta);
		
		tfNumConta = new JTextField();
		tfNumConta.setToolTipText("");
		panel_4.add(tfNumConta);
		tfNumConta.setColumns(10);
		
		JButton btnFecharConta = new JButton("Fechar Conta Poupan\u00E7a");
		btnFecharConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					ControladoraConta.fecharContaPoupanca(ftFCPF.getText(), tfNumConta.getText());
				} catch (ControladoraColecoesRemoverContaException | ControladoraColecoesBancoNaoPossuiContaCadasTradaException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
			}
		});
		panel_4.add(btnFecharConta);
		
		JButton btnFecharContaCorrente = new JButton("Fechar Conta Corrente");
		btnFecharContaCorrente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					ControladoraConta.fecharContaCorrente(ftFCPF.getText(), tfNumConta.getText());
				} catch (ControladoraColecoesRemoverContaException | ControladoraColecoesBancoNaoPossuiContaCadasTradaException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
			}
		});
		panel_4.add(btnFecharContaCorrente);

	}
}
