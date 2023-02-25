package br.com.gestaofarmacia.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.gestaofarmacia.core.entity.ProdutoEntity;
import br.com.gestaofarmacia.core.service.ProdutoService;
import br.com.gestaofarmacia.core.service.UsuarioService;
import br.com.gestaofarmacia.core.util.exception.NegocioException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaCadastroProduto extends JFrame {

	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=123,-31
	 */
	private final JTextField textField = new JTextField();
	private JTextField labelTitulo;
	private JTextField textFieldNomeProduto;
	private JTextField textFildDosagem;
	private JTextField textFieldViaMedicao;
	private JTextField textFieldNome;
	private JTextField textFieldDS;
	private JTextField textFieldCodigoProduto;
	private JTextField textFieldCodigo;
	private JComboBox textFieldVia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroProduto frame = new TelaCadastroProduto();
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
	public TelaCadastroProduto() {
		textField.setText("Formul\u00E1rio Usu\u00E1rio");
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(SystemColor.activeCaption);
		setTitle("Gest\u00E3o Farm\u00E1cia - Produto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		labelTitulo = new JTextField();
		labelTitulo.setText("Formul\u00E1rio Produto");
		labelTitulo.setForeground(Color.WHITE);
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelTitulo.setEditable(false);
		labelTitulo.setColumns(10);
		labelTitulo.setBackground(SystemColor.activeCaption);
		
		textFieldNomeProduto = new JTextField();
		textFieldNomeProduto.setText("Nome");
		textFieldNomeProduto.setForeground(Color.WHITE);
		textFieldNomeProduto.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textFieldNomeProduto.setEditable(false);
		textFieldNomeProduto.setColumns(10);
		textFieldNomeProduto.setBackground(SystemColor.activeCaption);
		
		textFildDosagem = new JTextField();
		textFildDosagem.setText("Dosagem");
		textFildDosagem.setForeground(Color.WHITE);
		textFildDosagem.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textFildDosagem.setEditable(false);
		textFildDosagem.setColumns(10);
		textFildDosagem.setBackground(SystemColor.activeCaption);
		
		textFieldViaMedicao = new JTextField();
		textFieldViaMedicao.setText("Via medica\u00E7\u00E3o");
		textFieldViaMedicao.setForeground(Color.WHITE);
		textFieldViaMedicao.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textFieldViaMedicao.setEditable(false);
		textFieldViaMedicao.setColumns(10);
		textFieldViaMedicao.setBackground(SystemColor.activeCaption);
		
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		
		textFieldDS = new JTextField();
		textFieldDS.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaProduto tlp = new TelaListaProduto();
				tlp.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBackground(SystemColor.activeCaption);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textFieldNome.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Produto não pode ser em branco");
				}else {
					ProdutoEntity pr = new ProdutoEntity();
					pr.setNomeProduto(textFieldNome.getText());
					pr.setDosagem(textFieldDS.getText());
					pr.setViaMedicacao(textFieldVia.getModel().getSelectedItem().toString());
					
					String msg = null;
					
					try {						
						if(textFieldCodigo.getText().equals("")) {
							if (!new ProdutoService().produtoExiste(pr.getNomeProduto()) ) {
								msg = new ProdutoService().salvarProduto(pr);
							}else {
								throw new NegocioException("Produto " + pr.getNomeProduto() + ", já cadastrado");
							}
						}else {
							pr.setCodigoProduto(Long.parseLong(textFieldCodigo.getText()));
							msg = new ProdutoService().alterarProduto(pr);
						}
//						limparCampos();
//						JOptionPane.showMessageDialog(null, msg);	
						
						TelaListaProduto tlp = new TelaListaProduto();
						tlp.setVisible(true);
						dispose();
					}catch(NegocioException e1) {
						JOptionPane.showMessageDialog(null, e1.getMensagemDeErro(), "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
			}	
			
});
		
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setBackground(SystemColor.activeCaption);
		
		textFieldCodigoProduto = new JTextField();
		textFieldCodigoProduto.setText("C\u00F3digo");
		textFieldCodigoProduto.setForeground(Color.WHITE);
		textFieldCodigoProduto.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textFieldCodigoProduto.setEditable(false);
		textFieldCodigoProduto.setColumns(10);
		textFieldCodigoProduto.setBackground(SystemColor.activeCaption);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setEditable(false);
		textFieldCodigo.setColumns(10);
		
        textFieldVia = new JComboBox();
		textFieldVia.setModel(new DefaultComboBoxModel(new String[] {"Oral", "Injet\u00E1vel", "Sublingual e bucal", "Retal", "Vaginal", "Ocular", "Otol\u00F3gica", "Nasal", "Inalat\u00F3ria", "Nebuliza\u00E7\u00E3o", "Cut\u00E2nea", "Transd\u00E9rmica"}));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(140)
							.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(140)
							.addComponent(labelTitulo, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addComponent(textFieldNomeProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(textFieldCodigoProduto, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
							.addGap(42)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textFildDosagem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldViaMedicao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(42)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textFieldVia, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textFieldDS, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))))
					.addGap(10))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addComponent(labelTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldCodigoProduto, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldNomeProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textFildDosagem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(textFieldDS, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
					.addGap(17)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldViaMedicao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldVia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnVoltar)
						.addComponent(btnSalvar)))
		);
		contentPane.setLayout(gl_contentPane);
	}
	public void carregarProdutoPorID(Long codigoProduto) {
		try {
			ProdutoEntity produtoEncontrado = new ProdutoService().buscarProdutoPorID(codigoProduto);
			
			if(produtoEncontrado == null) {
				JOptionPane.showMessageDialog(null, "O produto nao foi localizado", "Erro", JOptionPane.ERROR_MESSAGE);
			}else {
				textFieldCodigo.setText(""+produtoEncontrado.getCodigoProduto());
				textFieldNome.setText(produtoEncontrado.getNomeProduto());
				textFieldDS.setText(produtoEncontrado.getDosagem());
//				textFieldVia.setText(produtoEncontrado.getViaMedicacao());	
				textFieldVia.getModel().setSelectedItem(produtoEncontrado.getViaMedicacao());
}
			
			labelTitulo.setText("Alteração de Produto");
			
		} catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, e.getMensagemDeErro(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}