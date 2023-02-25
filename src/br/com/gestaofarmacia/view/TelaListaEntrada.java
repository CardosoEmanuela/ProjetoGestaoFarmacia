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
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import br.com.gestaofarmacia.core.entity.EntradaEntity;
import br.com.gestaofarmacia.core.entity.FornecedorEntity;
import br.com.gestaofarmacia.core.entity.ProdutoEntity;
import br.com.gestaofarmacia.core.entity.UsuarioEntity;
import br.com.gestaofarmacia.core.entity.EntradaEntity;
import br.com.gestaofarmacia.core.service.EntradaService;
import br.com.gestaofarmacia.core.service.FornecedorService;
import br.com.gestaofarmacia.core.service.ProdutoService;
import br.com.gestaofarmacia.core.util.exception.NegocioException;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaListaEntrada<entradas> extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<FornecedorEntity> fornecedores;
	private List<ProdutoEntity> produtos;
	private List<EntradaEntity> entradas;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JTextField textFieldCodigoFiltro;
	private JLabel lblData;
	private JTextField textFieldDataFiltro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaEntrada frame = new TelaListaEntrada();
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
	public TelaListaEntrada() {
		setTitle("Gest\u00E3o Farm\u00E1cia - Entrada");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 400);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("Menu");
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Produto");
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Fornecedor");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_2 = new JMenuItem("Cliente");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		mntmNewMenuItem_3 = new JMenuItem("Estoque");
		mnNewMenu.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setToolTipText("Menu");
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setForeground(Color.WHITE);
		
		textFieldCodigoFiltro = new JTextField();
		textFieldCodigoFiltro.setColumns(10);
		
		lblData = new JLabel("Data");
		lblData.setForeground(Color.WHITE);
		
		textFieldDataFiltro = new JTextField();
		textFieldDataFiltro.setColumns(10);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EntradaEntity entradaFiltro = new EntradaEntity();
				entradaFiltro.setDataEntrada(textFieldDataFiltro.getText());
				
				try {
					if(!textFieldCodigoFiltro.getText().equals("")) {
						Long codigo = Long.parseLong(textFieldCodigoFiltro.getText());
						entradaFiltro.setCodigoEntrada(codigo);
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "O valor no campo código precisa ser númerico.");
				}
				popularTabelaFiltrada(entradaFiltro);
			}
			
		});
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroEntrada tce =  new TelaCadastroEntrada();
					tce.setVisible(true);
					dispose();
			}
		});
		btnAdicionar.setEnabled(false);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EntradaEntity entradaSelecionado = entradas.get(table.getSelectedRow());
				TelaCadastroEntrada tce = new TelaCadastroEntrada();
				tce.carregarEntradaPorID(entradaSelecionado.getCodigoEntrada());
				tce.setVisible(true);
				dispose();
				
			try {
				new EntradaService().buscarEntradaPorID(entradaSelecionado.getCodigoEntrada());
				popularTabela();
			} catch (NegocioException e1) {
				JOptionPane.showMessageDialog(null, e1.getMensagemDeErro());;
			}
			}
		});
		btnEditar.setEnabled(false);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluir.setEnabled(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(lblCdigo, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textFieldCodigoFiltro, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblData, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textFieldDataFiltro, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnAdicionar, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 324, Short.MAX_VALUE)
							.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGap(2))))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCdigo)
						.addComponent(lblData)
						.addComponent(textFieldDataFiltro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton)
						.addComponent(textFieldCodigoFiltro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdicionar)
						.addComponent(btnEditar)
						.addComponent(btnExcluir))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
					.addGap(6))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo Entrada", "Data ", "Fornecedor", "C\u00F3digo Produto", "Produto", "$ Unit\u00E1rio", "$ Total", "$ Venda"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(92);
		table.getColumnModel().getColumn(1).setPreferredWidth(68);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		table.getColumnModel().getColumn(6).setPreferredWidth(85);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
	private void popularTabela() {
		try {
		entradas = new EntradaService().ListarEntrada();
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.getDataVector().removeAllElements();
				for(EntradaEntity EntradaEntity : entradas) {
					model.addRow(new Object[] {EntradaEntity.getCodigoEntrada(),
												EntradaEntity.getDataEntrada(),
												EntradaEntity.getQuantidade(),
												EntradaEntity.getCustoUnitario(),
												EntradaEntity.getCustoTotal(),
												EntradaEntity.getValorVenda()});
				}
					fornecedores = new FornecedorService().ListarFornecedor();
					DefaultTableModel mode2 = (DefaultTableModel)table.getModel();
					mode2.getDataVector().removeAllElements();
							for(FornecedorEntity FornecedorEntity : fornecedores) {
								mode2.addRow(new Object[] {FornecedorEntity.getRazaoSocial()});
								
							}
							produtos = new ProdutoService().ListarProduto();
							DefaultTableModel mode3 = (DefaultTableModel)table.getModel();
							mode3.getDataVector().removeAllElements();
									for(ProdutoEntity ProdutoEntity : produtos) {
										mode3.addRow(new Object[] {ProdutoEntity.getCodigoProduto(),
																ProdutoEntity.getNomeProduto()});
												
										}
							
								
		} catch (NegocioException e) {
			e.printStackTrace();
		JOptionPane.showMessageDialog(null,"Erro ao buscar entrada do banco de dados" + e.getMensagemDeErro());
		}
		}
	
		private void popularTabelaFiltrada(EntradaEntity EntradaFiltro) {
			try {
				entradas = new EntradaService().buscarEntradaFiltrado(EntradaFiltro);
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.getDataVector().removeAllElements();
				
				for (EntradaEntity EntradaEntity : entradas) {
					model.addRow(new Object[] {EntradaEntity.getCodigoEntrada(),
												EntradaEntity.getDataEntrada(),
												EntradaEntity.getQuantidade(),
												EntradaEntity.getCustoUnitario(),
												EntradaEntity.getCustoTotal(),
												EntradaEntity.getValorVenda()});
				}
				fornecedores = new FornecedorService().ListarFornecedor();
				DefaultTableModel mode2 = (DefaultTableModel)table.getModel();
				mode2.getDataVector().removeAllElements();
						for(FornecedorEntity FornecedorEntity : fornecedores) {
							mode2.addRow(new Object[] {FornecedorEntity.getRazaoSocial()});
							
						}
						produtos = new ProdutoService().ListarProduto();
						DefaultTableModel mode3 = (DefaultTableModel)table.getModel();
						mode3.getDataVector().removeAllElements();
								for(ProdutoEntity ProdutoEntity : produtos) {
									mode3.addRow(new Object[] {ProdutoEntity.getCodigoProduto(),
															ProdutoEntity.getNomeProduto()});
											
									}
	
			
				
			} catch (NegocioException e) {
				JOptionPane.showMessageDialog(null, "Erro ao buscar entradas do banco de dados " + e.getMensagemDeErro());
			}
		}
}
