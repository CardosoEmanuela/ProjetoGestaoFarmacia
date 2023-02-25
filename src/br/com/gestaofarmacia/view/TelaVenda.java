package br.com.gestaofarmacia.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import java.awt.Choice;
import java.awt.Panel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Label;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class TelaVenda extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTotalCompra;
	private JTextField textFieldDesconto;
	private JTextField textFieldTotalaPagar;
	private JTextField textFieldValorRecebido;
	private JTextField textFieldTroco;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textFieldCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVenda frame = new TelaVenda();
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
	public TelaVenda() {
		setTitle("Gest\u00E3o Farm\u00E1cia - Venda");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 407);
		contentPane = new JPanel();
		contentPane.setToolTipText("tesre");
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textFieldTotalCompra = new JTextField();
		textFieldTotalCompra.setEditable(false);
		textFieldTotalCompra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldTotalCompra.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Total Compra");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBackground(SystemColor.activeCaption);
		
		JLabel lblDescontos = new JLabel("Desconto");
		lblDescontos.setForeground(Color.WHITE);
		lblDescontos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDescontos.setBackground(SystemColor.activeCaption);
		
		textFieldDesconto = new JTextField();
		textFieldDesconto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldDesconto.setColumns(10);
		
		JLabel lblTotalAPagar = new JLabel("Total a Pagar");
		lblTotalAPagar.setForeground(Color.WHITE);
		lblTotalAPagar.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblTotalAPagar.setBackground(SystemColor.activeCaption);
		
		textFieldTotalaPagar = new JTextField();
		textFieldTotalaPagar.setEditable(false);
		textFieldTotalaPagar.setForeground(Color.RED);
		textFieldTotalaPagar.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldTotalaPagar.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Forma de pagamento");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setForeground(Color.WHITE);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(SystemColor.text);
		comboBox.setForeground(SystemColor.inactiveCaptionText);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Dinheiro", "Cart\u00E3o D\u00E9bito", "Cart\u00E3o Cr\u00E9dito"}));
		comboBox.setToolTipText("Forma de pagamento");
		
		JLabel lblValorRecebido = new JLabel("Valor Recebido ");
		lblValorRecebido.setForeground(Color.WHITE);
		lblValorRecebido.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblValorRecebido.setBackground(SystemColor.activeCaption);
		
		textFieldValorRecebido = new JTextField();
		textFieldValorRecebido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldValorRecebido.setColumns(10);
		
		JLabel lblTroco = new JLabel("Troco");
		lblTroco.setForeground(Color.WHITE);
		lblTroco.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTroco.setBackground(SystemColor.activeCaption);
		
		textFieldTroco = new JTextField();
		textFieldTroco.setEditable(false);
		textFieldTroco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldTroco.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("%");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setForeground(Color.WHITE);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setBackground(SystemColor.activeCaption);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBackground(SystemColor.activeCaption);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo Produto");
		lblCodigo.setForeground(Color.WHITE);
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setForeground(Color.WHITE);
		lblQuantidade.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Seq", "C\u00F3digo", "Descri\u00E7\u00E3o", "Quantidade", "Pre\u00E7o Unit.", "Pre\u00E7o Total"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setForeground(Color.WHITE);
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		textFieldCliente = new JTextField();
		textFieldCliente.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 553, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addGap(401)
							.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textFieldTotalCompra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(71)
									.addComponent(textFieldDesconto, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(51)
									.addComponent(lblValorRecebido))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
									.addGap(61)
									.addComponent(textFieldValorRecebido, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)))
							.addGap(31)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldTroco, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTroco, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldTotalaPagar, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(28, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblCliente, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(textFieldCliente, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDescontos, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(54)
							.addComponent(lblTotalAPagar, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField)
								.addComponent(lblCodigo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblQuantidade)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(95))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblQuantidade)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblCodigo)
							.addComponent(lblCliente, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(lblDescontos))
						.addComponent(lblTotalAPagar, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldTotalCompra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldDesconto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(textFieldTotalaPagar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblValorRecebido))
							.addGap(6)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(1)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(textFieldValorRecebido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(textFieldTroco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addComponent(lblTroco))
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnVoltar)
						.addComponent(btnSalvar)))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
