package br.com.ifpi.view.painel.usuario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import br.com.ifpi.controller.ControladoraConta;
import br.com.ifpi.exception.ContaDepositaException;
import br.com.ifpi.exception.ControladoraColecoesBancoNaoPossuiContaCadasTradaException;
import br.com.ifpi.exception.ControladoraColecoesPreenchimentoDeCampoObrigatorioException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class TelaDeDeposito extends JPanel {
	private TextField tfNumConta;
	private TextField tfValor;
	
	/**
	 * Create the panel.
	 */
	public TelaDeDeposito() throws ParseException{
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblDeposito = new JLabel("Deposito");
		lblDeposito.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblDeposito, BorderLayout.NORTH);
		
		JPanel panel_6 = new JPanel();
		add(panel_6, BorderLayout.CENTER);
		panel_6.setBorder(new LineBorder(Color.GRAY, 1, true));
		
		Label label = new Label("Numero da Conta:");
		label.setAlignment(Label.CENTER);
		
		tfNumConta = new TextField();
		
		Label label_1 = new Label("Valor do Deposito:");
		
		tfValor = new TextField();
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(7)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(tfNumConta, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(tfValor, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addGap(357))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addComponent(tfValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfNumConta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(311))
		);
		panel_6.setLayout(gl_panel_6);
		
		JPanel panel_7 = new JPanel();
		add(panel_7, BorderLayout.SOUTH);
		panel_7.setBorder(new LineBorder(Color.GRAY, 1, true));
		panel_7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnDepositar = new JButton("Depositar Em Conta Poupan\u00E7a");
		btnDepositar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					ControladoraConta.depositaContaPoupanca(tfNumConta.getText(), tfValor.getText());
				} catch (ControladoraColecoesPreenchimentoDeCampoObrigatorioException | ContaDepositaException
						| ControladoraColecoesBancoNaoPossuiContaCadasTradaException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		panel_7.add(btnDepositar);
		
		JButton btnDepositarEmConta = new JButton("Depositar em Conta Corrente");
		btnDepositarEmConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					ControladoraConta.depositaContaCorrente(tfNumConta.getText(), tfValor.getText());
				} catch (ControladoraColecoesPreenchimentoDeCampoObrigatorioException | ContaDepositaException
						| ControladoraColecoesBancoNaoPossuiContaCadasTradaException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					
				}
				
			}
		});
		panel_7.add(btnDepositarEmConta);

	}

}
