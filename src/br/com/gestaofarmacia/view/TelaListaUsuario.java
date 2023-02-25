package br.com.gestaofarmacia.view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.gestaofarmacia.core.service.UsuarioService;
import br.com.gestaofarmacia.core.util.exception.NegocioException;
import br.com.gestaofarmacia.core.entity.UsuarioEntity;

import java.awt.SystemColor;
import java.util.List;

import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class TelaListaUsuario<usuarios> extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<UsuarioEntity> usuarios;
	private JTextField textFieldCodigoFiltro;
	private JTextField textFieldNomeFiltro;
	private JTextField textFieldLoginFiltro;
	private JTextField textFieldEmailFiltro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					TelaListaUsuario frame = new TelaListaUsuario();
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
	public TelaListaUsuario() {
		setBackground(new Color(192, 192, 192));
		setTitle("Gest\u00E3o Farm\u00E1cia - Usu\u00E1rio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 619, 400);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("Grupo Usu\u00E1rio");
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Produto");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			TelaListaProduto tlp = new TelaListaProduto();
			tlp.setVisible(true);
			
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Fornecedor");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			TelaListaFornecedor tlf = new TelaListaFornecedor();
			tlf.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Cliente");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			TelaListaCliente tlc = new TelaListaCliente();
			tlc.setVisible(true);
			
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Estoque");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			TelaListaEstoque tle = new TelaListaEstoque();
			tle.setVisible(true);
			
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			UsuarioEntity usuarioSelecionado = usuarios.get(table.getSelectedRow());
				if(JOptionPane.showConfirmDialog(null, "Você realmente deseja excluir o Usuário de código "
													+ usuarioSelecionado.getCodigo())==JOptionPane.OK_OPTION){
			try {
				new UsuarioService().excluirUsuario(usuarioSelecionado.getCodigo());
				popularTabela();
			} catch (NegocioException e1) {
				JOptionPane.showMessageDialog(null, e1.getMensagemDeErro());;
			}
				}
			}
		});
		btnExcluir.setEnabled(false);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnEditar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				UsuarioEntity usuarioSelecionado = usuarios.get(table.getSelectedRow());
				TelaCadastroUsuario tcu = new TelaCadastroUsuario();
				tcu.carregarUsuarioPorID(usuarioSelecionado.getCodigo());
				tcu.setVisible(true);
				dispose();
				
			try {
				new UsuarioService().buscarUsuarioPorID(usuarioSelecionado.getCodigo());
				popularTabela();
			} catch (NegocioException e1) {
				JOptionPane.showMessageDialog(null, e1.getMensagemDeErro());;
			}
			}
		});
		btnEditar.setEnabled(false);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
			
		TelaCadastroUsuario tcu =  new TelaCadastroUsuario();
			tcu.setVisible(true);
			dispose();
			}
		});
		btnAdicionar.setEnabled(false);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setForeground(Color.WHITE);
		
		textFieldCodigoFiltro = new JTextField();
		textFieldCodigoFiltro.setColumns(10);
		
		table = new JTable();
		table.setBackground(SystemColor.inactiveCaption);
		//AULA 46 PARTE 3 CLICAR LINHA E HABILITAR BOTÃO
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				UsuarioEntity usuario = usuarios.get(table.getSelectedRow());
			//	JOptionPane.showMessageDialog(null,"O nome do usuário selecionado foi " + usuario.getNome());
				
				btnExcluir.setEnabled(true);
				btnEditar.setEnabled(true);
				btnAdicionar.setEnabled(true);
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo ", "Nome", "Login", "Senha", "E-mail"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(Color.WHITE);
		
		textFieldNomeFiltro = new JTextField();
		textFieldNomeFiltro.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.WHITE);
		
		textFieldLoginFiltro = new JTextField();
		textFieldLoginFiltro.setColumns(10);
		
		textFieldEmailFiltro = new JTextField();
		textFieldEmailFiltro.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setForeground(Color.WHITE);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						UsuarioEntity usuarioFiltro = new UsuarioEntity();
						usuarioFiltro.setNome(textFieldNomeFiltro.getText());
						usuarioFiltro.setLogin(textFieldLoginFiltro.getText());
						usuarioFiltro.setEmail(textFieldEmailFiltro.getText());
						
						try {
							if(!textFieldCodigoFiltro.getText().equals("")) {
								Long codigo = Long.parseLong(textFieldCodigoFiltro.getText());
								usuarioFiltro.setCodigo(codigo);
							}
						}catch(Exception ex) {
							JOptionPane.showMessageDialog(null, "O valor no campo código precisa ser númerico.");
						}
						popularTabelaFiltrada(usuarioFiltro);
					}
		
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textFieldLoginFiltro, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addComponent(lblCdigo)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldCodigoFiltro, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
									.addGap(40)
									.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textFieldEmailFiltro, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnNewButton))
								.addComponent(textFieldNomeFiltro, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 573, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnAdicionar)
									.addGap(330)
									.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldNomeFiltro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNome)
						.addComponent(lblCdigo)
						.addComponent(textFieldCodigoFiltro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLogin)
						.addComponent(lblEmail)
						.addComponent(textFieldEmailFiltro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton)
						.addComponent(textFieldLoginFiltro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAdicionar)
						.addComponent(btnEditar)
						.addComponent(btnExcluir))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addGap(22))
		);
		contentPane.setLayout(gl_contentPane);
		popularTabela();
	}
	
	private void popularTabela() {
		try {
		usuarios = new UsuarioService().ListarUsuario();
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.getDataVector().removeAllElements();
				for(UsuarioEntity usuarioEntity : usuarios) {
					model.addRow(new Object[] {usuarioEntity.getCodigo(),
												usuarioEntity.getNome(),
												usuarioEntity.getLogin(),
												usuarioEntity.getSenha(),
												usuarioEntity.getEmail()});
				}
		} catch (NegocioException e) {
			e.printStackTrace();
		JOptionPane.showMessageDialog(null,"Erro ao buscar usuários do banco de dados" + e.getMensagemDeErro());
		}
	}
		private void popularTabelaFiltrada(UsuarioEntity usuarioFiltro) {
			try {
				usuarios = new UsuarioService().buscarUsuarioFiltrado(usuarioFiltro);
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.getDataVector().removeAllElements();
				
				for (UsuarioEntity usuarioEntity : usuarios) {
					model.addRow(new Object[] {usuarioEntity.getCodigo(), 
											   usuarioEntity.getNome(),
											   usuarioEntity.getLogin(),
											   usuarioEntity.getSenha(),
											   usuarioEntity.getEmail()});
				}
				
			} catch (NegocioException e) {
				JOptionPane.showMessageDialog(null, "Erro ao buscar usuários do banco de dados " + e.getMensagemDeErro());
			}
		}
}