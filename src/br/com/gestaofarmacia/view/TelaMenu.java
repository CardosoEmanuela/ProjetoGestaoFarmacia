package br.com.gestaofarmacia.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TelaMenu extends JFrame {

	private JPanel contentPane;
	private JButton btnUsurio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenu frame = new TelaMenu();
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
	public TelaMenu() {
		setTitle("Gest\u00E3o Farm\u00E1cia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 323);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setForeground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("VENDA");
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaVenda tv = new TelaVenda ();
				tv.setVisible(true);
			}
		});
		
		JButton btnNewButton_1 = new JButton("ENTRADA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaEntrada te = new TelaListaEntrada();
				te.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(new Color(0, 0, 128));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnEstoque = new JButton("ESTOQUE");
		btnEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaEstoque tle = new TelaListaEstoque();
				tle.setVisible(true);
			}
		});
		btnEstoque.setForeground(new Color(0, 0, 128));
		btnEstoque.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btnUsurio = new JButton("USU\u00C1RIO");
		btnUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaUsuario tlu = new TelaListaUsuario();
				tlu.setVisible(true); 
			}
		});
		btnUsurio.setForeground(new Color(0, 0, 128));
		btnUsurio.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial ti = new TelaInicial();
				ti.setVisible(true);
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBackground(SystemColor.activeCaption);
		
		JButton btnFornecedor = new JButton("FORNECEDOR");
		btnFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaFornecedor tlf = new TelaListaFornecedor();
				tlf.setVisible(true);
			}
		});
		btnFornecedor.setForeground(new Color(0, 0, 128));
		btnFornecedor.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnProduto = new JButton("PRODUTO");
		btnProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaProduto tlp = new TelaListaProduto();
				tlp.setVisible(true);
			}
		});
		btnProduto.setForeground(new Color(0, 0, 128));
		btnProduto.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnCliente = new JButton("CLIENTE");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaCliente tlc = new TelaListaCliente();
				tlc.setVisible(true);
			}
		});
		btnCliente.setForeground(new Color(0, 0, 128));
		btnCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(156, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCliente, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnProduto, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnFornecedor, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEstoque, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnUsurio, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
							.addGap(60)
							.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnEstoque, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(btnFornecedor, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnProduto, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCliente)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnUsurio)
					.addGap(9))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(239, Short.MAX_VALUE)
					.addComponent(btnVoltar))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
