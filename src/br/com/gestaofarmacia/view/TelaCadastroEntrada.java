package br.com.gestaofarmacia.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.gestaofarmacia.core.entity.ClienteEntity;
import br.com.gestaofarmacia.core.entity.EntradaEntity;
import br.com.gestaofarmacia.core.entity.FornecedorEntity;
import br.com.gestaofarmacia.core.entity.ProdutoEntity;
import br.com.gestaofarmacia.core.entity.UsuarioEntity;
import br.com.gestaofarmacia.core.service.EntradaService;
import br.com.gestaofarmacia.core.service.FornecedorService;
import br.com.gestaofarmacia.core.service.UsuarioService;
import br.com.gestaofarmacia.core.util.exception.NegocioException;

import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class TelaCadastroEntrada extends JFrame {

	private JPanel contentPane;
	private JTextField txtFornecedor;
	JTextField textFieldFornecedor;
	private JTextField txtProduto;
	private JTextField txtQuantidade;
	private JTextField txtValorUnitrio;
	private JTextField txtValorTotal;
	private JTextField textFieldCustoTotal;
	private JTextField textFieldCustoUnitario;
	private JTextField textFieldQuantidade;
	private JTextField txtValorVendaUni;
	private JTextField textFieldValorVenda;
	private JButton btnVoltar;
	private JButton btnSalvar;
	private JTextField labelTitulo;
	private JButton btnFornecedorPesquisar;
	private JButton btnFornecedorAdd;
	private JButton btnProdutoPesquisar;
	private JButton btnProdutoSalvar;
	private JTextField txtData;
	private JTextField textFieldData;
	private JTextField textFieldCodigoEntrada;
	private JTextField txtCodigo;
	private List<FornecedorEntity> fornecedores;
	JTextField textFieldProduto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroEntrada frame = new TelaCadastroEntrada();
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
	public TelaCadastroEntrada() {
		setTitle("Gest\u00E3o Farm\u00E1cia - Entrada");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 310);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		txtFornecedor = new JTextField();
		txtFornecedor.setText("Fornecedor");
		txtFornecedor.setForeground(Color.WHITE);
		txtFornecedor.setFont(new Font("Sitka Text", Font.BOLD, 12));
		txtFornecedor.setEditable(false);
		txtFornecedor.setColumns(10);
		txtFornecedor.setBackground(SystemColor.activeCaption);
		
		textFieldFornecedor = new JTextField();
		textFieldFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textFieldFornecedor.setColumns(10);
		
		txtProduto = new JTextField();
		txtProduto.setText("Produto");
		txtProduto.setForeground(Color.WHITE);
		txtProduto.setFont(new Font("Sitka Text", Font.BOLD, 12));
		txtProduto.setEditable(false);
		txtProduto.setColumns(10);
		txtProduto.setBackground(SystemColor.activeCaption);
			
		
		txtQuantidade = new JTextField();
		txtQuantidade.setText("Quantidade");
		txtQuantidade.setForeground(Color.WHITE);
		txtQuantidade.setFont(new Font("Sitka Text", Font.BOLD, 12));
		txtQuantidade.setEditable(false);
		txtQuantidade.setColumns(10);
		txtQuantidade.setBackground(SystemColor.activeCaption);
		
		txtValorUnitrio = new JTextField();
		txtValorUnitrio.setText("Custo Unit\u00E1rio");
		txtValorUnitrio.setForeground(Color.WHITE);
		txtValorUnitrio.setFont(new Font("Sitka Text", Font.BOLD, 12));
		txtValorUnitrio.setEditable(false);
		txtValorUnitrio.setColumns(10);
		txtValorUnitrio.setBackground(SystemColor.activeCaption);
		
		txtValorTotal = new JTextField();
		txtValorTotal.setText("Custo Total");
		txtValorTotal.setForeground(Color.WHITE);
		txtValorTotal.setFont(new Font("Sitka Text", Font.BOLD, 12));
		txtValorTotal.setEditable(false);
		txtValorTotal.setColumns(10);
		txtValorTotal.setBackground(SystemColor.activeCaption);
		
		textFieldCustoTotal = new JTextField();
		textFieldCustoTotal.setColumns(10);
		
		textFieldCustoUnitario = new JTextField();
		textFieldCustoUnitario.setColumns(10);
		
		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setColumns(10);
		
		txtValorVendaUni = new JTextField();
		txtValorVendaUni.setText("Valor Venda Uni");
		txtValorVendaUni.setForeground(Color.WHITE);
		txtValorVendaUni.setFont(new Font("Sitka Text", Font.BOLD, 12));
		txtValorVendaUni.setEditable(false);
		txtValorVendaUni.setColumns(10);
		txtValorVendaUni.setBackground(SystemColor.activeCaption);
		
		textFieldValorVenda = new JTextField();
		textFieldValorVenda.setColumns(10);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenu tm = new TelaMenu();
				tm.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBackground(SystemColor.activeCaption);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					EntradaEntity ent = new EntradaEntity();
					ent.setDataEntrada(textFieldData.getText());
					ent.setQuantidade(Integer.parseInt(textFieldQuantidade.getText()));
					ent.setCustoUnitario(Double.parseDouble(textFieldCustoUnitario.getText()));
					ent.setCustoTotal(Double.parseDouble(textFieldCustoTotal.getText()));
					ent.setValorVenda(Double.parseDouble(textFieldValorVenda.getText()));
					
					FornecedorEntity forn = new FornecedorEntity();
					forn.setRazaoSocial(textFieldFornecedor.getText());
					
					ProdutoEntity pro = new ProdutoEntity();
					pro.setNomeProduto(textFieldProduto.getText());
					
			
					String msg = null;
					
					try {						
						if(textFieldCodigoEntrada.getText().equals("")) {
							msg = new EntradaService().salvarEntrada(ent);
						}else {
							ent.setCodigoEntrada(Long.parseLong(textFieldCodigoEntrada.getText()));
							msg = new EntradaService().alterarEntrada(ent);
						}
				
//						limparCampos();
//						JOptionPane.showMessageDialog(null, msg);	
						
						TelaListaEntrada tle = new TelaListaEntrada();
						tle.setVisible(true);
						dispose();
		
			}catch(NegocioException e1) {
				JOptionPane.showMessageDialog(null, e1.getMensagemDeErro(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
			}
		}
	
		);
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setBackground(SystemColor.activeCaption);
		
		labelTitulo = new JTextField();
		labelTitulo.setText("Formul\u00E1rio Entrada Produto");
		labelTitulo.setForeground(Color.WHITE);
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelTitulo.setEditable(false);
		labelTitulo.setColumns(10);
		labelTitulo.setBackground(SystemColor.activeCaption);
		
		btnFornecedorPesquisar = new JButton("");
		btnFornecedorPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chamaTelaListaFornecedor();
		
			}
		});
		btnFornecedorPesquisar.setBackground(SystemColor.activeCaption);
		btnFornecedorPesquisar.setIcon(new ImageIcon("C:\\Users\\Emanuela\\Downloads\\icons8-pesquisar-15.png"));
		
		btnFornecedorAdd = new JButton("");
		btnFornecedorAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			TelaCadastroFornecedor tcf =  new TelaCadastroFornecedor();
					tcf.setVisible(true);
		
			}
		});
		btnFornecedorAdd.setForeground(SystemColor.activeCaption);
		btnFornecedorAdd.setIcon(new ImageIcon("C:\\Users\\Emanuela\\Downloads\\icons8-adicionar-usu\u00E1rio-masculino-15.png"));
		btnFornecedorAdd.setBackground(SystemColor.activeCaption);
		
		btnProdutoPesquisar = new JButton("");
		btnProdutoPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chamaTelaListaProduto();
				
			}
		});
		btnProdutoPesquisar.setIcon(new ImageIcon("C:\\Users\\Emanuela\\Downloads\\icons8-pesquisar-15.png"));
		btnProdutoPesquisar.setBackground(SystemColor.activeCaption);
		
		btnProdutoSalvar = new JButton("");
		btnProdutoSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroProduto tcp = new TelaCadastroProduto();
				tcp.setVisible(true);
				dispose();
				
			}
		});
		btnProdutoSalvar.setIcon(new ImageIcon("C:\\Users\\Emanuela\\Downloads\\icons8-adicionar-usu\u00E1rio-masculino-15.png"));
		btnProdutoSalvar.setForeground(SystemColor.activeCaption);
		btnProdutoSalvar.setBackground(SystemColor.activeCaption);
		
		txtData = new JTextField();
		txtData.setText("Data");
		txtData.setForeground(Color.WHITE);
		txtData.setFont(new Font("Sitka Text", Font.BOLD, 12));
		txtData.setEditable(false);
		txtData.setColumns(10);
		txtData.setBackground(SystemColor.activeCaption);
		
		textFieldData = new JTextField();
		textFieldData.setColumns(10);
		
		textFieldCodigoEntrada = new JTextField();
		textFieldCodigoEntrada.setEditable(false);
		textFieldCodigoEntrada.setColumns(10);
		
		txtCodigo = new JTextField();
		txtCodigo.setText("C\u00F3digo");
		txtCodigo.setForeground(Color.WHITE);
		txtCodigo.setFont(new Font("Sitka Text", Font.BOLD, 12));
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBackground(SystemColor.activeCaption);
		
		textFieldProduto = new JTextField();
		textFieldProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textFieldProduto.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(132)
							.addComponent(labelTitulo, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(txtQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldQuantidade, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtValorUnitrio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textFieldCustoUnitario, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(txtProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textFieldProduto, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnProdutoPesquisar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnProdutoSalvar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(118)
							.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addGap(58)
							.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtValorTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldCustoTotal, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtValorVendaUni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textFieldValorVenda, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textFieldCodigoEntrada, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txtData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textFieldData, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(txtFornecedor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldFornecedor, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnFornecedorPesquisar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnFornecedorAdd, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addComponent(labelTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldData, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldCodigoEntrada, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtFornecedor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(textFieldFornecedor, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnFornecedorPesquisar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnFornecedorAdd, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnProdutoSalvar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(textFieldProduto, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnProdutoPesquisar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldQuantidade, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtValorUnitrio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldCustoUnitario, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtValorTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldCustoTotal, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldValorVenda, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtValorVendaUni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVoltar)
						.addComponent(btnSalvar))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	public void carregarEntradaPorID(Long codigoEntrada) {
		try {
			EntradaEntity entradaEncontrada = new EntradaService().buscarEntradaPorID(codigoEntrada);
			if(entradaEncontrada == null) {
				JOptionPane.showMessageDialog(null, "A entrada não foi localizado","Erro",JOptionPane.ERROR_MESSAGE);
			}else {
				//conversão de long para string "" +
				textFieldCodigoEntrada.setText(""+entradaEncontrada.getCodigoEntrada());
				textFieldData.setText(entradaEncontrada.getDataEntrada());
				textFieldQuantidade.setText(""+entradaEncontrada.getQuantidade());
				textFieldCustoUnitario.setText(""+entradaEncontrada.getCustoUnitario());
				textFieldCustoTotal.setText(""+entradaEncontrada.getCustoTotal());
				textFieldValorVenda.setText(""+entradaEncontrada.getValorVenda());
			}		
			labelTitulo.setText("Alteração de Usuário");
				
		} catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, e.getMensagemDeErro(),"Erro",JOptionPane.ERROR_MESSAGE);
		}
	
	}	
	
	
	private void chamaTelaListaFornecedor() {
		TelaListaFornecedor tlf = new TelaListaFornecedor(this);
		tlf.setVisible(true);
		dispose();
	}
	private void chamaTelaListaProduto() {
		TelaListaProduto tlp = new TelaListaProduto(this);
		tlp.setVisible(true);
		dispose();
	}
}
	

	


