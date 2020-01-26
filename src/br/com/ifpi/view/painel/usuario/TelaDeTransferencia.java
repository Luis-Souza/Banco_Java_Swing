package br.com.ifpi.view.painel.usuario;

import java.awt.BorderLayout;
import java.awt.Color;
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
import br.com.ifpi.exception.ContaSacarException;
import br.com.ifpi.exception.ContaTransferirException;
import br.com.ifpi.exception.ControladoraColecoesBancoNaoPossuiContaCadasTradaException;
import br.com.ifpi.exception.ControladoraColecoesPreenchimentoDeCampoObrigatorioException;
import br.com.ifpi.exception.ControladoraColecoesTransferenciaDeContaException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class TelaDeTransferencia extends JPanel {
	private TextField tfNumConta;
	private TextField tfNumConta2;
	private TextField tfValor;
	/**
	 * Create the panel.
	 */
	public TelaDeTransferencia() throws ParseException{
		setLayout(new BorderLayout(0, 0));
		
		Label label = new Label("Transfer\u00EAncia de Conta Corrente");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(label, BorderLayout.NORTH);
		
		JPanel panel_Botao = new JPanel();
		add(panel_Botao, BorderLayout.SOUTH);
		panel_Botao.setBorder(new LineBorder(Color.GRAY, 1, true));
		
		JButton btnTransferir = new JButton("Transferir");
		btnTransferir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
						ControladoraConta.transferirContaCorrente(tfNumConta.getText(), tfNumConta2.getText(), tfValor.getText());
				} catch (ControladoraColecoesPreenchimentoDeCampoObrigatorioException | ContaSacarException
						| ControladoraColecoesBancoNaoPossuiContaCadasTradaException
						| ContaDepositaException | ContaTransferirException | ControladoraColecoesTransferenciaDeContaException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
			}
		});
		panel_Botao.add(btnTransferir);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_Dados = new JPanel();
		panel_Dados.setBorder(new LineBorder(Color.GRAY, 1, true));
		panel_Dados.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_5.setBounds(111, 45, 382, 125);
		panel_Dados.add(panel_5);
		
		Label lblNumeroDaConta = new Label("Numero da Conta:");
		
		tfNumConta = new TextField();
		
		Label lblValorATransferir = new Label("Valor a Transferir:");
		
		tfValor = new TextField();
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addComponent(lblValorATransferir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumeroDaConta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING, false)
						.addComponent(tfValor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(tfNumConta, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
					.addGap(104))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNumeroDaConta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfNumConta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addComponent(tfValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblValorATransferir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		panel_5.setLayout(gl_panel_5);
		
		JLabel lblContaDeTransferncia = new JLabel("Transfere de Conta");
		lblContaDeTransferncia.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblContaDeTransferncia.setBounds(111, 31, 123, 14);
		panel_Dados.add(lblContaDeTransferncia);
		
		JLabel lblParaConta = new JLabel("Para Conta");
		lblParaConta.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblParaConta.setBounds(111, 176, 78, 14);
		panel_Dados.add(lblParaConta);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_6.setBounds(111, 191, 382, 85);
		panel_Dados.add(panel_6);
		
		Label lblNumeroDaConta2 = new Label("Numero da Conta:");
		
		tfNumConta2 = new TextField();
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(51)
					.addComponent(lblNumeroDaConta2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tfNumConta2, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addGap(105))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addComponent(tfNumConta2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumeroDaConta2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34))
		);
		panel_6.setLayout(gl_panel_6);
		panel.add(panel_Dados);

	}
}
