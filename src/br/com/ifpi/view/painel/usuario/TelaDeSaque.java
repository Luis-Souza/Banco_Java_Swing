package br.com.ifpi.view.painel.usuario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import br.com.ifpi.controller.ControladoraConta;
import br.com.ifpi.exception.ContaSacarException;
import br.com.ifpi.exception.ControladoraColecoesBancoNaoPossuiContaCadasTradaException;
import br.com.ifpi.exception.ControladoraColecoesPreenchimentoDeCampoObrigatorioException;

@SuppressWarnings("serial")
public class TelaDeSaque extends JPanel {
	private TextField tfNumConta;
	private TextField tfValor;
	/**
	 * Create the panel.
	 */
	public TelaDeSaque() throws ParseException{
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblSaque = new JLabel("Saque");
		lblSaque.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblSaque, BorderLayout.NORTH);
		
		JPanel panel_6 = new JPanel();
		add(panel_6, BorderLayout.CENTER);
		panel_6.setBorder(new LineBorder(Color.GRAY, 1, true));
		
		Label label = new Label("Numero da Conta:");
		
		tfNumConta = new TextField();
		
		Label label_1 = new Label("Valor do Saque:");
		
		tfValor = new TextField();
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(7)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(tfNumConta, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(tfValor, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(516))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_6.createSequentialGroup()
							.addComponent(tfNumConta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_panel_6.createSequentialGroup()
								.addComponent(tfValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(gl_panel_6.createSequentialGroup()
								.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING, false)
									.addComponent(label, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(346)))))
		);
		panel_6.setLayout(gl_panel_6);
		
		JPanel panel_7 = new JPanel();
		add(panel_7, BorderLayout.SOUTH);
		panel_7.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		
		JButton btnSacar = new JButton("Sacar de Conta Poupan\u00E7a");
		btnSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*double valor = Double.parseDouble(tfValor.getText());
				int numeroConta = Integer.parseInt(tfNumConta.getText());*/
				
				
					try {
							ControladoraConta.sacarDeContaPoupanca(tfNumConta.getText(), tfValor.getText());
					} catch (ContaSacarException | ControladoraColecoesPreenchimentoDeCampoObrigatorioException
							| ControladoraColecoesBancoNaoPossuiContaCadasTradaException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
			
				
			}
		});
		panel_7.add(btnSacar);
		
		JButton btnSacarDeConta = new JButton("Sacar de Conta Corrente");
		btnSacarDeConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
						ControladoraConta.sacarDeContaCorrente(tfNumConta.getText(), tfValor.getText());
				} catch (ContaSacarException | ControladoraColecoesPreenchimentoDeCampoObrigatorioException
						| ControladoraColecoesBancoNaoPossuiContaCadasTradaException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
			}
		});
		panel_7.add(btnSacarDeConta);

	}
}
