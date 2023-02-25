package br.com.gestaofarmacia.view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import br.com.gestaofarmacia.core.entity.FornecedorEntity;
import br.com.gestaofarmacia.core.service.FornecedorService;
import br.com.gestaofarmacia.core.util.exception.NegocioException;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TelaListaFornecedor  extends JFrame {

	private JPanel contentPane;
	private JTable tableFornecedor;
	private JButton btnAdicionar;
	private JButton btnEditar;
	private JButton btnExcluir;
	private List<FornecedorEntity> fornecedores;
	private JTextField textFieldCodigoFiltro;
	private JTextField textFieldRazaoSocialFiltro;
	private JLabel lblCNPJ;
	private JTextField textFieldCNPJFiltro;
	private JLabel lblEmail;
	private JTextField textFieldEmailFiltro;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private TelaCadastroEntrada tce;

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaFornecedor frame = new TelaListaFornecedor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				}
		
		});
	}
	
	public TelaListaFornecedor(TelaCadastroEntrada tce){
		this();
		this.tce = tce;
	}

	/**
	 * Create the frame.
	 */
	public TelaListaFornecedor() {
		setTitle("Gest\u00E3o Farm\u00E1cia - Fornecedor");
		setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 629, 397);
		
		menuBar = new JMenuBar();
		menuBar.setToolTipText("Menu");
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem_1 = new JMenuItem("Produto");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaProduto tlp = new TelaListaProduto();
				tlp.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		
		mntmNewMenuItem = new JMenuItem("Usu\u00E1rio");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaUsuario tlu = new TelaListaUsuario();
				tlu.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_3 = new JMenuItem("Cliente");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaCliente tlc = new TelaListaCliente();
				tlc.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		mntmNewMenuItem_4 = new JMenuItem("Estoque");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaEstoque tle = new TelaListaEstoque();
				tle.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaCadastroFornecedor tlf =  new TelaCadastroFornecedor();
				tlf.setVisible(true);
				dispose();
				}
		});
		
		btnEditar = new JButton("Editar");
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					FornecedorEntity fornecedorSelecionado = fornecedores.get(tableFornecedor.getSelectedRow());
					TelaCadastroFornecedor tlf = new TelaCadastroFornecedor();
					tlf.carregarFornecedorPorID(fornecedorSelecionado.getCodigoFornecedor());
					tlf.setVisible(true);
					dispose();
			}
		});
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					FornecedorEntity fornecedorSelecionado = fornecedores.get(tableFornecedor.getSelectedRow());
						if(JOptionPane.showConfirmDialog(null, "Você realmente deseja excluir o Fornecedor de código "
															+ fornecedorSelecionado.getCodigoFornecedor())==JOptionPane.OK_OPTION){
					try {
						new FornecedorService().excluirFornecedor(fornecedorSelecionado.getCodigoFornecedor());
						popularTabela();
					} catch (NegocioException e1) {
						JOptionPane.showMessageDialog(null, e1.getMensagemDeErro());
					}
						}
				
			}
						
		});
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setForeground(Color.WHITE);
		
		textFieldCodigoFiltro = new JTextField();
		textFieldCodigoFiltro.setColumns(10);
		
		JLabel lblRazoSocial = new JLabel("Raz\u00E3o Social");
		lblRazoSocial.setForeground(Color.WHITE);
		
		textFieldRazaoSocialFiltro = new JTextField();
		textFieldRazaoSocialFiltro.setColumns(10);
		
		tableFornecedor = new JTable();
		tableFornecedor.setBackground(SystemColor.inactiveCaption);
		//AULA 46 PARTE 3 CLICAR LINHA E HABILITAR BOTÃO
	 {

			
			btnExcluir.setEnabled(true);
			btnEditar.setEnabled(true);
			btnAdicionar.setEnabled(true);
			
	 }
		
		tableFornecedor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableFornecedor.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Raz\u00E3o Social", "CNPJ", "Telefone", "E-mail", "Endere\u00E7o"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableFornecedor.getColumnModel().getColumn(1).setPreferredWidth(94);
		scrollPane.setViewportView(tableFornecedor);
		
		lblCNPJ = new JLabel("CNPJ");
		lblCNPJ.setForeground(Color.WHITE);
		
		textFieldCNPJFiltro = new JTextField();
		textFieldCNPJFiltro.setColumns(10);
		
		lblEmail = new JLabel("E-mail");
		lblEmail.setForeground(Color.WHITE);
		
		textFieldEmailFiltro = new JTextField();
		textFieldEmailFiltro.setColumns(10);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FornecedorEntity fornecedorFiltro = new FornecedorEntity();
				fornecedorFiltro.setRazaoSocial(textFieldRazaoSocialFiltro.getText());
				fornecedorFiltro.setCnpj(textFieldCNPJFiltro.getText());
				fornecedorFiltro.setEmail(textFieldEmailFiltro.getText());
				
				try {
					if(!textFieldCodigoFiltro.getText().equals("")) {
						Long codigo = Long.parseLong(textFieldCodigoFiltro.getText());
						fornecedorFiltro.setCodigoFornecedor(codigo);
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "O valor no campo código precisa ser númerico.");
				}
				popularTabelaFiltrada(fornecedorFiltro);
			}
		});
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaCadastroEntrada te = new TelaCadastroEntrada();
				
				
			}
		});
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FornecedorEntity fornecedorSelecionado = fornecedores.get(tableFornecedor.getSelectedRow());
				//TelaCadastroEntrada tce = new TelaCadastroEntrada();
				tce.textFieldFornecedor.setText(fornecedorSelecionado.getRazaoSocial());
				tce.setVisible(true);
				
			}
		});
			
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(2)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnAdicionar, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnSelecionar, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 598, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblCdigo)
									.addGap(18)
									.addComponent(textFieldCodigoFiltro, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblRazoSocial))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblCNPJ, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textFieldCNPJFiltro, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textFieldEmailFiltro, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
								.addComponent(textFieldRazaoSocialFiltro, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(3))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldCodigoFiltro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCdigo)
						.addComponent(lblRazoSocial)
						.addComponent(textFieldRazaoSocialFiltro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCNPJ)
						.addComponent(textFieldCNPJFiltro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail)
						.addComponent(textFieldEmailFiltro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnExcluir)
						.addComponent(btnEditar)
						.addComponent(btnAdicionar)
						.addComponent(btnSelecionar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
		popularTabela();
	}
	
	private void popularTabela() {
		try {
		fornecedores = new FornecedorService().ListarFornecedor();
		DefaultTableModel model = (DefaultTableModel)tableFornecedor.getModel();
		model.getDataVector().removeAllElements();
				for(FornecedorEntity fornecedorEntity : fornecedores) {
					model.addRow(new Object[] {fornecedorEntity.getCodigoFornecedor(),
												fornecedorEntity.getRazaoSocial(),
												fornecedorEntity.getCnpj(),
												fornecedorEntity.getTelefone(),
												fornecedorEntity.getEmail(),
												fornecedorEntity.getEndereco(),});
				}
		} catch (NegocioException e) {
			e.printStackTrace();
		JOptionPane.showMessageDialog(null,"Erro ao buscar fornecedores no banco de dados" + e.getMensagemDeErro());
		}
	}
		
		private void popularTabelaFiltrada(FornecedorEntity fornecedorFiltro) {
			try {
				fornecedores = new FornecedorService().buscarFornecedorFiltrado(fornecedorFiltro);
				DefaultTableModel model = (DefaultTableModel)tableFornecedor.getModel();
				model.getDataVector().removeAllElements();
				
				for (FornecedorEntity fornecedorEntity : fornecedores ) {
					model.addRow(new Object[] {fornecedorEntity.getCodigoFornecedor(), 
											   fornecedorEntity.getRazaoSocial(),
											   fornecedorEntity.getCnpj(),
											   fornecedorEntity.getTelefone(),
											   fornecedorEntity.getEmail()});
				}
				
			} catch (NegocioException e) {
			e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao buscar fornecedores no banco de dados " + e.getMensagemDeErro());
		
	}
		}

		public void carregarFornecedorPorID(String razaoSocial) {
			// TODO Auto-generated method stub
			
		}

		
			
		}
	
	
