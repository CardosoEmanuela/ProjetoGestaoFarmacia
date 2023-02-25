package br.com.gestaofarmacia.view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import br.com.gestaofarmacia.core.dao.UsuarioDAO;
import br.com.gestaofarmacia.core.entity.ProdutoEntity;
import br.com.gestaofarmacia.core.entity.UsuarioEntity;
import br.com.gestaofarmacia.core.service.ProdutoService;
import br.com.gestaofarmacia.core.service.UsuarioService;
import br.com.gestaofarmacia.core.util.exception.NegocioException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Label;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textEmail;
	private JTextField textSenha;
	private JTextField textConfirmeASenha;
	private JTextField textLogin;
	private JTextField labelTitulo;
	private JButton btnSalvar;
	private JTextComponent fieldCodigo;
	private JTextComponent fieldNome;
	private JTextComponent fieldLogin;
	private JTextComponent fieldEmail;
	private JTextComponent fieldSenha;
	private JTextField textCodigo;
	private JTextField textFieldLogin;
	private JTextField textFieldNome;
	private JTextField textFieldCodigo;
	private JTextField textFieldEmail;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldSenha;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroUsuario frame = new TelaCadastroUsuario();
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
	public TelaCadastroUsuario() {
		setTitle("Gest\u00E3o Farm\u00E1cia - Usu\u00E1rio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 519, 395);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textNome = new JTextField();
		textNome.setEditable(false);
		textNome.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textNome.setForeground(SystemColor.text);
		textNome.setBackground(SystemColor.activeCaption);
		textNome.setText("Nome");
		textNome.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setEditable(false);
		textEmail.setFont(new Font("Sylfaen", Font.BOLD, 12));
		textEmail.setForeground(SystemColor.text);
		textEmail.setText("E-mail");
		textEmail.setBackground(SystemColor.activeCaption);
		textEmail.setColumns(10);
		
		textSenha = new JTextField();
		textSenha.setEditable(false);
		textSenha.setText("Senha");
		textSenha.setForeground(Color.WHITE);
		textSenha.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textSenha.setColumns(10);
		textSenha.setBackground(SystemColor.activeCaption);
		
		textConfirmeASenha = new JTextField();
		textConfirmeASenha.setEditable(false);
		textConfirmeASenha.setText("Confirme senha");
		textConfirmeASenha.setForeground(Color.WHITE);
		textConfirmeASenha.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textConfirmeASenha.setColumns(10);
		textConfirmeASenha.setBackground(SystemColor.activeCaption);
		
		textLogin = new JTextField();
		textLogin.setEditable(false);
		textLogin.setText("Login");
		textLogin.setForeground(Color.WHITE);
		textLogin.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textLogin.setColumns(10);
		textLogin.setBackground(SystemColor.activeCaption);
		
		labelTitulo = new JTextField();
		labelTitulo.setEditable(false);
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelTitulo.setForeground(SystemColor.text);
		labelTitulo.setText("Formul\u00E1rio Usu\u00E1rio");
		labelTitulo.setBackground(SystemColor.activeCaption);
		labelTitulo.setColumns(10);
		
		
		
		btnSalvar = new JButton("Salvar");		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(textFieldNome.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Usuário não pode ser em branco");
			
				}else {
					UsuarioEntity usu = new UsuarioEntity();
					usu.setNome(textFieldNome.getText());
					usu.setLogin(textFieldLogin.getText());
					usu.setSenha(new String(passwordFieldSenha.getPassword()));
					usu.setEmail(textFieldEmail.getText());
					
					String msg = null;
					
					try {						
						if(textFieldCodigo.getText().equals("")) {
							if (!new UsuarioService().usuarioExiste(usu.getLogin()) ) {
								msg = new UsuarioService().salvarUsuario(usu);
							}else {
								throw new NegocioException("Usuário " + usu.getLogin() + "já cadastrado");
							}
						}else {
							usu.setCodigo(Long.parseLong(textFieldCodigo.getText()));
							msg = new UsuarioService().alterarUsuario(usu);
						}
//						limparCampos();
//						JOptionPane.showMessageDialog(null, msg);	
						
						TelaListaUsuario tlu = new TelaListaUsuario();
						tlu.setVisible(true);
						dispose();
					}catch(NegocioException e1) {
						JOptionPane.showMessageDialog(null, e1.getMensagemDeErro(), "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
			}	
			
});
			
		
					
			
		
		btnSalvar.setForeground(SystemColor.text);
		btnSalvar.setBackground(SystemColor.activeCaption);
		
		textCodigo = new JTextField();
		textCodigo.setText("C\u00F3digo");
		textCodigo.setForeground(Color.WHITE);
		textCodigo.setFont(new Font("Sitka Text", Font.BOLD, 12));
		textCodigo.setEditable(false);
		textCodigo.setColumns(10);
		textCodigo.setBackground(SystemColor.activeCaption);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setColumns(10);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setEditable(false);
		textFieldCodigo.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		
		passwordField = new JPasswordField();
		
		passwordFieldSenha = new JPasswordField();
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaUsuario tlu = new TelaListaUsuario();
				tlu.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBackground(SystemColor.activeCaption);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textCodigo, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addComponent(textNome, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addComponent(textLogin, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addComponent(textEmail, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addComponent(textConfirmeASenha, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addComponent(textSenha, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(textFieldLogin, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordFieldSenha, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(201, Short.MAX_VALUE)
					.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(122))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(174, Short.MAX_VALUE)
					.addComponent(labelTitulo, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
					.addGap(165))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(labelTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(2))
						.addComponent(textCodigo, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textLogin, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textSenha, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordFieldSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(textConfirmeASenha, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVoltar)
						.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
//	private void limparCampos() {
//	//fieldCodigo.setText("");
//	fieldNome.setText("");
//	fieldLogin.setText("");
//	fieldEmail.setText("");
//	}
	public void carregarUsuarioPorID(Long codigoUsuario) {
		try {
			UsuarioEntity usuarioEncontrado = new UsuarioService().buscarUsuarioPorID(codigoUsuario);
			if(usuarioEncontrado == null) {
				JOptionPane.showMessageDialog(null, "O usuário não foi localizado","Erro",JOptionPane.ERROR_MESSAGE);
			}else {
				//conversão de long para string "" +
				textFieldCodigo.setText(""+usuarioEncontrado.getCodigo());
				textFieldNome.setText(usuarioEncontrado.getNome());
				textFieldLogin.setText(usuarioEncontrado.getLogin());
				passwordFieldSenha.setText(usuarioEncontrado.getSenha());
				textFieldEmail.setText(usuarioEncontrado.getEmail());
			}
			labelTitulo.setText("Alteração de Usuário");
			
		} catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, e.getMensagemDeErro(),"Erro",JOptionPane.ERROR_MESSAGE);
		}
	
		}
}
		





