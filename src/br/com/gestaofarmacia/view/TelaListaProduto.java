package br.com.gestaofarmacia.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.gestaofarmacia.core.entity.FornecedorEntity;
import br.com.gestaofarmacia.core.entity.ProdutoEntity;
import br.com.gestaofarmacia.core.entity.UsuarioEntity;
import br.com.gestaofarmacia.core.service.ProdutoService;
import br.com.gestaofarmacia.core.service.UsuarioService;
import br.com.gestaofarmacia.core.util.exception.NegocioException;


import javax.swing.JList;
import javax.swing.JOptionPane;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class TelaListaProduto extends JFrame {

	private JPanel contentPane;
	private List<ProdutoEntity> produtos;
	private JTextField textFieldCodigoFiltro;
	private JTextField textFieldNomeFiltro;
	private JTextField textFieldDoseFiltro;
	private JTextField textFieldViaFiltro;
	private JTable tableProduto;
	private TelaCadastroEntrada tce;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaProduto frame = new TelaListaProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaListaProduto(TelaCadastroEntrada tce ) {
		this();
		this.tce = tce;
	}
	/**
	 * Create the frame.
	 */
	public TelaListaProduto() {
		setTitle("Gest\u00E3o Farm\u00E1cia - Produto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 618, 414);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Usu\u00E1rio");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaUsuario tlu = new TelaListaUsuario();
				tlu.setVisible(true);
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
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
			
		TelaCadastroProduto tep =  new TelaCadastroProduto();
			tep.setVisible(true);
			dispose();
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnEditar.addActionListener(new ActionListener() {
		
		
		public void actionPerformed(ActionEvent e) {
			ProdutoEntity produtoSelecionado = produtos.get(tableProduto.getSelectedRow());
			TelaCadastroProduto tcp = new TelaCadastroProduto();
			tcp.carregarProdutoPorID(produtoSelecionado.getCodigoProduto());
			tcp.setVisible(true);
			dispose();
			
		try {
			new ProdutoService().buscarProdutoPorID(produtoSelecionado.getCodigoProduto());
			popularTabela();
		} catch (NegocioException e1) {
			JOptionPane.showMessageDialog(null, e1.getMensagemDeErro());;
		}
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
			ProdutoEntity produtoSelecionado = produtos.get(tableProduto.getSelectedRow());
				if(JOptionPane.showConfirmDialog(null, "Você realmente deseja excluir o Produto de código "
													+ produtoSelecionado.getCodigoProduto())==JOptionPane.OK_OPTION){
			try {
				new ProdutoService().excluirProduto(produtoSelecionado.getCodigoProduto());
				popularTabela();
			} catch (NegocioException e1) {
				JOptionPane.showMessageDialog(null, e1.getMensagemDeErro());;
			}
				}
			}
		});
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setForeground(Color.WHITE);
		
		textFieldCodigoFiltro = new JTextField();
		textFieldCodigoFiltro.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(Color.WHITE);
		
		textFieldNomeFiltro = new JTextField();
		textFieldNomeFiltro.setColumns(10);
		
		JLabel lblDosagem = new JLabel("Dose");
		lblDosagem.setForeground(Color.WHITE);
		
		textFieldDoseFiltro = new JTextField();
		textFieldDoseFiltro.setColumns(10);
		
		textFieldViaFiltro = new JTextField();
		textFieldViaFiltro.setColumns(10);
		
		JLabel lblViaMed = new JLabel("Via Med");
		lblViaMed.setForeground(Color.WHITE);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdutoEntity produtoFiltro = new ProdutoEntity();
				produtoFiltro.setNomeProduto(textFieldNomeFiltro.getText());
				produtoFiltro.setDosagem(textFieldDoseFiltro.getText());
				produtoFiltro.setViaMedicacao(textFieldViaFiltro.getText());
					
					try {
						if(!textFieldCodigoFiltro.getText().equals("")) {
							Long codigo = Long.parseLong(textFieldCodigoFiltro.getText());
							produtoFiltro.setCodigoProduto(codigo);
						}
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "O valor no campo código precisa ser númerico.");
					}
					popularTabelaFiltrada(produtoFiltro);
				}
		});
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdutoEntity produtoSelecionado = produtos.get((tableProduto).getSelectedRow());
				tce.textFieldProduto.setText(produtoSelecionado.getNomeProduto());
				tce.setVisible(true);
				
			}
		});
		
		JScrollPane JScrollPane = new JScrollPane();
		JScrollPane.setEnabled(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblCdigo, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldCodigoFiltro, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblDosagem, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldDoseFiltro, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(lblViaMed, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnSelecionar, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
										.addComponent(textFieldViaFiltro, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(30)
											.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(18)
											.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))))
								.addComponent(textFieldNomeFiltro, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(JScrollPane, GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
								.addComponent(btnAdicionar, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))))
					.addGap(3))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCdigo)
						.addComponent(textFieldCodigoFiltro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNome)
						.addComponent(textFieldNomeFiltro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDosagem)
								.addComponent(textFieldDoseFiltro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(22))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblViaMed)
								.addComponent(btnNewButton)
								.addComponent(textFieldViaFiltro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdicionar)
						.addComponent(btnEditar)
						.addComponent(btnExcluir)
						.addComponent(btnSelecionar))
					.addGap(18)
					.addComponent(JScrollPane, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tableProduto = new JTable();
		tableProduto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableProduto.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Produto", "Dose", "Via med."
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		JScrollPane.setViewportView(tableProduto);
		contentPane.setLayout(gl_contentPane);
		popularTabela();
	}
		private void popularTabela() {
		
		try {
			produtos = new ProdutoService().ListarProduto();
			DefaultTableModel model = (DefaultTableModel)tableProduto.getModel();
			model.getDataVector().removeAllElements();
			for(ProdutoEntity produtoEntity : produtos) {
				model.addRow(new Object[] {produtoEntity.getCodigoProduto(),
										produtoEntity.getNomeProduto(),
										produtoEntity.getDosagem(),
										produtoEntity.getViaMedicacao()});
										
				}
			}catch (NegocioException e) {
			JOptionPane.showMessageDialog(null,"Erro ao buscar produto no banco de dados" + e.getMensagemDeErro());
}
		}
		private void popularTabelaFiltrada(ProdutoEntity produtoFiltro) {
			try {
				produtos = new ProdutoService().buscarProdutoFiltrado(produtoFiltro);
				DefaultTableModel model = (DefaultTableModel)tableProduto.getModel();
				model.getDataVector().removeAllElements();
				
				for (ProdutoEntity produtoEntity : produtos) {
					model.addRow(new Object[] {produtoEntity.getCodigoProduto(), 
											   produtoEntity.getNomeProduto(),
											   produtoEntity.getDosagem(),
											   produtoEntity.getViaMedicacao()});
					}
				
			} catch (NegocioException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao buscar produtos no banco de dados " + e.getMensagemDeErro());
			}
			
		}
}


	