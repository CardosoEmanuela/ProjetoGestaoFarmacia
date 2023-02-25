package br.com.gestaofarmacia.view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.gestaofarmacia.core.entity.UsuarioEntity;
import br.com.gestaofarmacia.core.service.UsuarioService;
import br.com.gestaofarmacia.core.util.exception.NegocioException;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.DropMode;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;

public class TelaInicial extends JFrame {
	private JTextField textFieldLogin;
	private JButton btnCadastrarNovoUsurio;
	private JLabel lblNewLabel;
	private JEditorPane dtrpnSenha;
	private JLabel lblNewLabel_1;
	private JPasswordField passwordFieldSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		getContentPane().setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setBackground(new Color(70, 130, 180));
		setTitle("GEST\u00C3O FARM\u00C1CIA");
		getContentPane().setBackground(new Color(70, 130, 180));
		
		textFieldLogin = new JTextField();
		textFieldLogin.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = textFieldLogin.getText();
				String senha = new String(passwordFieldSenha.getPassword());
				
			try {
				UsuarioEntity usuarioAutenticado = new UsuarioService().autenticar(login,senha);
				if(usuarioAutenticado != null) {
					TelaMenu tm = new TelaMenu();
					tm.setVisible(true);
					dispose();
				}else {	
					JOptionPane.showMessageDialog(null,"Usuário ou Senha inválidos", "Erro", JOptionPane.ERROR_MESSAGE);
					
				}
			} catch (NegocioException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			}
		});
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setBackground(new Color(70, 130, 180));
		
		btnCadastrarNovoUsurio = new JButton("Cadastrar novo usu\u00E1rio");
		btnCadastrarNovoUsurio.setForeground(Color.WHITE);
		btnCadastrarNovoUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroUsuario tcu = new TelaCadastroUsuario();
					tcu.setVisible(true);
			}
		});
		btnCadastrarNovoUsurio.setBackground(new Color(70, 130, 180));
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Emanuela\\Downloads\\gestaofarmacia03.png"));
		
		JEditorPane dtrpnLogin = new JEditorPane();
		dtrpnLogin.setEditable(false);
		dtrpnLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dtrpnLogin.setForeground(Color.WHITE);
		dtrpnLogin.setText("Login");
		dtrpnLogin.setBackground(new Color(70, 130, 180));
		
		dtrpnSenha = new JEditorPane();
		dtrpnSenha.setEditable(false);
		dtrpnSenha.setText("Senha");
		dtrpnSenha.setForeground(Color.WHITE);
		dtrpnSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dtrpnSenha.setBackground(new Color(70, 130, 180));
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Emanuela\\Downloads\\icons8-usu\u00E1rio-homem-com-c\u00EDrculo-50.png"));
		
		passwordFieldSenha = new JPasswordField();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(dtrpnSenha, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(passwordFieldSenha))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(dtrpnLogin, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldLogin, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(122)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(56)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnEntrar, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
								.addComponent(btnCadastrarNovoUsurio))))
					.addGap(279))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(dtrpnLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(dtrpnSenha, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordFieldSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addComponent(btnEntrar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCadastrarNovoUsurio)
					.addContainerGap(37, Short.MAX_VALUE))
				.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
		);
		getContentPane().setLayout(groupLayout);
	}
}
