package br.com.ifpi.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class JanelaSobre extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaSobre frame = new JanelaSobre();
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
	public JanelaSobre() {
		setResizable(false);
		setTitle("Sobre o Sistema");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 516, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon("C:\\Users\\JorgeLuis\\workspace\\Projeto\\Imagens\\sobre.gif"));
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblEduardaIngredDe = new JLabel("Eduarda Ingred de Andrade Oliveira");
		lblEduardaIngredDe.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel lblJorgeLusSiqueira = new JLabel("Jorge Lu\u00EDs Siqueira de Souza");
		lblJorgeLusSiqueira.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblAnos = new JLabel("18 anos");
		lblAnos.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel lblAnos_1 = new JLabel("19 anos");
		lblAnos_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblNewLabel_1 = new JLabel("eduardaingred1@gmail.com");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel lblJorgeluis = new JLabel("jorgeluis0796@gmail.com");
		lblJorgeluis.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel label = new JLabel("(86)99402-0019");
		label.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel label_1 = new JLabel("(86)99527-5791");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel lblInformaoDoSistema = new JLabel("Informa\u00E7\u00E3o do Sistema:");
		lblInformaoDoSistema.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblSistemaDesenvolvidoPor = new JLabel("Sistema desenvolvido por alunos do 3\u00B0 ano de Softaware");
		lblSistemaDesenvolvidoPor.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel lblInstitutoFederalDe = new JLabel("INSTITUTO FEDERAL DE EDUCA\u00C7\u00C3O, CI\u00CANCIAS E TECNOLOGIA DO P\u00CDAUI CAMPOS PARNA\u00CDBA");
		lblInstitutoFederalDe.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AreaAdmin.frame.setEnabled(true);
				dispose();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblImagem)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNome)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblJorgeluis)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblNewLabel_1)
											.addGap(36)
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblTelefone)
												.addGroup(gl_panel.createSequentialGroup()
													.addGap(10)
													.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(label_1)
														.addComponent(label)))))
										.addGroup(gl_panel.createSequentialGroup()
											.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_panel.createSequentialGroup()
													.addComponent(lblEduardaIngredDe)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(lblIdade)
													.addPreferredGap(ComponentPlacement.RELATED))
												.addGroup(gl_panel.createSequentialGroup()
													.addComponent(lblJorgeLusSiqueira)
													.addGap(85)))
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblAnos_1)
												.addComponent(lblAnos)))))
								.addComponent(lblEmail)
								.addComponent(lblInformaoDoSistema)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblInstitutoFederalDe)
										.addComponent(lblSistemaDesenvolvidoPor)))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(208)
							.addComponent(btnFechar)))
					.addContainerGap(66, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblImagem)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(12)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEduardaIngredDe)
								.addComponent(lblAnos))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblJorgeLusSiqueira)
								.addComponent(lblAnos_1)))
						.addComponent(lblNome)
						.addComponent(lblIdade))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblEmail)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(label))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblJorgeluis)
								.addComponent(label_1)))
						.addComponent(lblTelefone))
					.addGap(26)
					.addComponent(lblInformaoDoSistema)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSistemaDesenvolvidoPor)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblInstitutoFederalDe)
					.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
					.addComponent(btnFechar)
					.addGap(22))
		);
		panel.setLayout(gl_panel);
	}
}
