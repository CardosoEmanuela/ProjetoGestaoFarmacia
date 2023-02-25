package br.com.gestaofarmacia.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.gestaofarmacia.core.entity.FornecedorEntity;
import br.com.gestaofarmacia.core.service.FornecedorService;
import br.com.gestaofarmacia.core.service.UsuarioService;
import br.com.gestaofarmacia.core.dao.FornecedorDAO;
import br.com.gestaofarmacia.core.util.exception.NegocioException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroFornecedor extends JFrame {
	private JTextField LabelTitulo;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textFieldCodigo;
	private JTextField txtRazoSocial;
	private JTextField textFieldRazaoSocial;
	private JTextField txtCnpj;
	private JTextField textFieldCNPJ;
	private JTextField txtTelefone;
	private JTextField textFieldTelefone;
	private JTextField txtEmail;
	private JTextField textFieldEmail;
	private JTextField txtEndereo;
	private JTextField textFieldEndereco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroFornecedor frame = new TelaCadastroFornecedor();
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
	public TelaCadastroFornecedor() {
		setTitle("Gest\u00E3o Farm\u00E1cia - Fornecedor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 316);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		LabelTitulo = new JTextField();
		LabelTitulo.setText("Formul\u00E1rio Fornecedor");
		LabelTitulo.setForeground(Color.WHITE);
		LabelTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		LabelTitulo.setEditable(false);
		LabelTitulo.setColumns(10);
		LabelTitulo.setBackground(SystemColor.activeCaption);
		
		textField = new JTextField();
		textField.setText("C\u00F3digo");
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(SystemColor.activeCaption);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setEditable(false);
		textFieldCodigo.setColumns(10);
		
		txtRazoSocial = new JTextField();
		txtRazoSocial.setText("Raz\u00E3o Social");
		txtRazoSocial.setForeground(Color.WHITE);
		txtRazoSocial.setFont(new Font("Sitka Text", Font.BOLD, 12));
		txtRazoSocial.setEditable(false);
		txtRazoSocial.setColumns(10);
		txtRazoSocial.setBackground(SystemColor.activeCaption);
		
		textFieldRazaoSocial = new JTextField();
		textFieldRazaoSocial.setColumns(10);
		
		txtCnpj = new JTextField();
		txtCnpj.setText("CNPJ");
		txtCnpj.setForeground(Color.WHITE);
		txtCnpj.setFont(new Font("Sitka Text", Font.BOLD, 12));
		txtCnpj.setEditable(false);
		txtCnpj.setColumns(10);
		txtCnpj.setBackground(SystemColor.activeCaption);
		
		textFieldCNPJ = new JTextField();
		textFieldCNPJ.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setText("Telefone");
		txtTelefone.setForeground(Color.WHITE);
		txtTelefone.setFont(new Font("Sitka Text", Font.BOLD, 12));
		txtTelefone.setEditable(false);
		txtTelefone.setColumns(10);
		txtTelefone.setBackground(SystemColor.activeCaption);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setText("E-mail");
		txtEmail.setForeground(Color.WHITE);
		txtEmail.setFont(new Font("Sitka Text", Font.BOLD, 12));
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBackground(SystemColor.activeCaption);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		
		txtEndereo = new JTextField();
		txtEndereo.setText("Endere\u00E7o");
		txtEndereo.setForeground(Color.WHITE);
		txtEndereo.setFont(new Font("Sitka Text", Font.BOLD, 12));
		txtEndereo.setEditable(false);
		txtEndereo.setColumns(10);
		txtEndereo.setBackground(SystemColor.activeCaption);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaFornecedor tlp = new TelaListaFornecedor();
				tlp.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBackground(SystemColor.activeCaption);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				if(validar()) {
								
					FornecedorEntity f = new FornecedorEntity();
					f.setRazaoSocial(textFieldRazaoSocial.getText());
					f.setCnpj(textFieldCNPJ.getText());
					f.setTelefone(textFieldTelefone.getText());
					f.setEmail(textFieldEmail.getText());
					f.setEndereco(textFieldEndereco.getText());
					
					String msg = null;
					try {						
						if(textFieldCodigo.getText().equals("")) {
							if (!new FornecedorService().fornecedorExiste(f.getRazaoSocial()) ) {
								msg = new FornecedorService().salvarFornecedor(f);
							}else {
								throw new NegocioException("Fornecedor " + f.getRazaoSocial() + "já cadastrado");
							}		
						}else {
							f.setCodigoFornecedor(Long.parseLong(textFieldCodigo.getText()));
							msg = new FornecedorService().alterarFornecedor(f);
						}
//						limparCampos();
//						JOptionPane.showMessageDialog(null, msg);	
						
						TelaListaFornecedor tlf = new TelaListaFornecedor();
						tlf.setVisible(true);
						dispose();
						
					}catch(NegocioException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.getMensagemDeErro(), "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		

		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setBackground(SystemColor.activeCaption);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(12, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtRazoSocial, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldRazaoSocial, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtCnpj, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldCNPJ, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldTelefone, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtEndereo, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldEndereco, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(129)
					.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(137, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(126, Short.MAX_VALUE)
					.addComponent(LabelTitulo, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
					.addGap(116))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(LabelTitulo, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldRazaoSocial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtRazoSocial, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtCnpj, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldCNPJ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtEndereo, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVoltar)
						.addComponent(btnSalvar)))
		);
		contentPane.setLayout(gl_contentPane);
	}
		
		public void carregarFornecedorPorID(Long codigoFornecedor) {
			try {
				FornecedorEntity fornecedorEncontrado = new FornecedorService().buscarFornecedorPorID(codigoFornecedor);
	
				if(fornecedorEncontrado == null) {
					JOptionPane.showMessageDialog(null, "O fornecedor não foi localizado", "Erro", JOptionPane.ERROR_MESSAGE);
				}else {
					textFieldCodigo.setText(""+fornecedorEncontrado.getCodigoFornecedor());
					textFieldRazaoSocial.setText(fornecedorEncontrado.getRazaoSocial());
					textFieldCNPJ.setText(fornecedorEncontrado.getCnpj());
					textFieldTelefone.setText(fornecedorEncontrado.getTelefone());
					textFieldEmail.setText(fornecedorEncontrado.getEmail());
					textFieldEndereco.setText(fornecedorEncontrado.getEndereco());
					
				}
				
				LabelTitulo.setText("Alteração de Fornecedor");
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			} catch (NegocioException e) {
				JOptionPane.showMessageDialog(null, e.getMensagemDeErro(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		private boolean validar() {
			boolean r = true;
			if(textFieldRazaoSocial.getText().equals("")) {
				r = false;
				JOptionPane.showMessageDialog(null, "A razão social precisa ser preenchida");
			}
			if(txtCnpj.getText().equals("")) {
				r = false;
				JOptionPane.showMessageDialog(null, "O CNPJ precisa ser preenchida");
			}
			if(textFieldTelefone.getText().equals("")) {
				r = false;
				JOptionPane.showMessageDialog(null, "O telefone precisa ser preenchida");
			}
			if(textFieldEmail.getText().equals("")) {
				r = false;
				JOptionPane.showMessageDialog(null, "O e-mail precisa ser preenchida");
			}
			
			
			
			return r;
		}
	
	}

