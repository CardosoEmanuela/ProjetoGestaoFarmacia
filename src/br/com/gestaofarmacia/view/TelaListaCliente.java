package br.com.gestaofarmacia.view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.gestaofarmacia.core.entity.ClienteEntity;
import br.com.gestaofarmacia.core.service.ClienteService;
import br.com.gestaofarmacia.core.util.exception.NegocioException;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;

public class TelaListaCliente extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnAdicionar;
	private JButton btnEditar;
	private JButton btnExcluir;
	private List<ClienteEntity> clientes;
	private JTextField textFieldCodigoFiltro;
	private JTextField textFieldNomeFiltro;
	private JTextField textFieldCPFFiltro;
	private JTextField textFieldTelefoneFiltro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaCliente frame = new TelaListaCliente();
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
	public TelaListaCliente() {
		setTitle("Gest\u00E3o Farm\u00E1cia - Cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 601, 387);
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
				TelaCadastroCliente tlc =  new TelaCadastroCliente();
				tlc.setVisible(true);
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

				ClienteEntity clienteSelecionado = clientes.get(table.getSelectedRow());
				TelaCadastroCliente tlc = new TelaCadastroCliente();
				tlc.carregarClientePorID(clienteSelecionado.getCodigoCliente());
				tlc.setVisible(true);
				dispose();
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					ClienteEntity clienteSelecionado = clientes.get(table.getSelectedRow());
						if(JOptionPane.showConfirmDialog(null, "Você realmente deseja excluir o Cliente de código "
															+ clienteSelecionado.getCodigoCliente())==JOptionPane.OK_OPTION){
					try {
						new ClienteService().excluirCliente(clienteSelecionado.getCodigoCliente());
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
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(Color.WHITE);
		
		textFieldNomeFiltro = new JTextField();
		textFieldNomeFiltro.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setForeground(Color.WHITE);
		
		textFieldCPFFiltro = new JTextField();
		textFieldCPFFiltro.setColumns(10);
		
		JLabel lblTel = new JLabel("Tel");
		lblTel.setForeground(Color.WHITE);
		
		textFieldTelefoneFiltro = new JTextField();
		textFieldTelefoneFiltro.setColumns(10);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteEntity clienteFiltro = new ClienteEntity();
				clienteFiltro.setNome(textFieldNomeFiltro.getText());
				clienteFiltro.setCpf(textFieldCPFFiltro.getText());
				clienteFiltro.setTelefone(textFieldTelefoneFiltro.getText());
				
				try {
					if(!textFieldCodigoFiltro.getText().equals("")) {
						Long codigo = Long.parseLong(textFieldCodigoFiltro.getText());
						clienteFiltro.setCodigoCliente(codigo);
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "O valor no campo código precisa ser númerico.");
				}
				popularTabelaFiltrada(clienteFiltro);
			
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnAdicionar, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 300, Short.MAX_VALUE)
							.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCpf, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCdigo, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textFieldCodigoFiltro, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
									.addGap(23)
									.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldNomeFiltro, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textFieldCPFFiltro, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
									.addGap(24)
									.addComponent(lblTel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldTelefoneFiltro, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCdigo)
						.addComponent(lblNome)
						.addComponent(textFieldNomeFiltro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldCodigoFiltro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCpf)
						.addComponent(btnNewButton)
						.addComponent(lblTel)
						.addComponent(textFieldCPFFiltro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldTelefoneFiltro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdicionar)
						.addComponent(btnExcluir)
						.addComponent(btnEditar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ClienteEntity cliente = clientes.get(table.getSelectedRow());
				
				btnExcluir.setEnabled(true);
				btnEditar.setEnabled(true);
				btnAdicionar.setEnabled(true);
			}
		});
		table.setModel(new DefaultTableModel(
		
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome", "CPF", "Telefone"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		popularTabela();
	}	
	private void popularTabela() {
		try {
		clientes = new ClienteService().ListarCliente();
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.getDataVector().removeAllElements();
				for(ClienteEntity clienteEntity : clientes) {
					model.addRow(new Object[] {clienteEntity.getCodigoCliente(),
												clienteEntity.getNome(),
												clienteEntity.getCpf(),
												clienteEntity.getTelefone(),
												});
				}
		} catch (NegocioException e) {
		JOptionPane.showMessageDialog(null,"Erro ao buscar clientes do banco de dados" + e.getMensagemDeErro());
	
			}
		}

			private void popularTabelaFiltrada(ClienteEntity clienteFiltro) {
				try {
					clientes = new ClienteService().buscarClienteFiltrado(clienteFiltro);
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					model.getDataVector().removeAllElements();
					
					for (ClienteEntity clienteEntity : clientes) {
						model.addRow(new Object[] {clienteEntity.getCodigoCliente(), 
												   clienteEntity.getNome(),
												   clienteEntity.getCpf(),
												   clienteEntity.getTelefone()});
					}
					
				} catch (NegocioException e) {
					JOptionPane.showMessageDialog(null, "Erro ao buscar usuários do banco de dados " + e.getMensagemDeErro());
				}
			}
	}

