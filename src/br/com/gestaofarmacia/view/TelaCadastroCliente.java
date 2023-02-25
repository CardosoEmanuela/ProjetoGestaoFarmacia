package br.com.gestaofarmacia.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.gestaofarmacia.core.entity.ClienteEntity;
import br.com.gestaofarmacia.core.entity.FornecedorEntity;
import br.com.gestaofarmacia.core.service.ClienteService;
import br.com.gestaofarmacia.core.service.FornecedorService;
import br.com.gestaofarmacia.core.util.exception.NegocioException;

import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField LabelTitulo;
	private JTextField textField;
	private JTextField textFieldCodigo;
	private JTextField txtNome;
	private JTextField textFieldNome;
	private JTextField txtCpf;
	private JTextField textFieldCPF;
	private JTextField txtTelefone;
	private JTextField textFieldTelefone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
		
			public void run() {
				try {
					TelaCadastroCliente frame = new TelaCadastroCliente();
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
	public TelaCadastroCliente() {
		setTitle("Gest\u00E3o Farm\u00E1cia - Cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		LabelTitulo = new JTextField();
		LabelTitulo.setText("Formul\u00E1rio Cliente");
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
		
		txtNome = new JTextField();
		txtNome.setText("Nome");
		txtNome.setForeground(Color.WHITE);
		txtNome.setFont(new Font("Sitka Text", Font.BOLD, 12));
		txtNome.setEditable(false);
		txtNome.setColumns(10);
		txtNome.setBackground(SystemColor.activeCaption);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setText("CPF");
		txtCpf.setForeground(Color.WHITE);
		txtCpf.setFont(new Font("Sitka Text", Font.BOLD, 12));
		txtCpf.setEditable(false);
		txtCpf.setColumns(10);
		txtCpf.setBackground(SystemColor.activeCaption);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setText("Telefone");
		txtTelefone.setForeground(Color.WHITE);
		txtTelefone.setFont(new Font("Sitka Text", Font.BOLD, 12));
		txtTelefone.setEditable(false);
		txtTelefone.setColumns(10);
		txtTelefone.setBackground(SystemColor.activeCaption);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaCliente tlc = new TelaListaCliente();
				tlc.setVisible(true);
				dispose();
			}
		});
		
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBackground(SystemColor.activeCaption);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(textFieldNome.getText().equals("")) {
						textFieldNome.setText("Nome não preenchido");
					}else {			
						ClienteEntity cli = new ClienteEntity();
						cli.setNome(textFieldNome.getText());
						cli.setCpf(textFieldCPF.getText());
						cli.setTelefone(textFieldTelefone.getText());
						cli.setTelefone(textFieldTelefone.getText());
						
						String msg = null;
						try {						
							if(textFieldCodigo.getText().equals("")) {
								msg = new ClienteService().salvarCliente(cli);
							}else {
								cli.setCodigoCliente(Long.parseLong(textFieldCodigo.getText()));
								msg = new ClienteService().alterarCliente(cli);
							}
//							limparCampos();
//							JOptionPane.showMessageDialog(null, msg);	
							
							TelaListaCliente tlc = new TelaListaCliente();
							tlc.setVisible(true);
							dispose();
						}catch(NegocioException e1) {
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
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(149, Short.MAX_VALUE)
					.addComponent(LabelTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(139))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textFieldCPF, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textFieldTelefone, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(134)
					.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(132, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(LabelTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVoltar)
						.addComponent(btnSalvar))
					.addGap(19))
		);
		contentPane.setLayout(gl_contentPane);
	}
	public void carregarClientePorID(Long codigoCliente) {
		try {
			ClienteEntity clienteEncontrado = new ClienteService().buscarClientePorID(codigoCliente);

			if(clienteEncontrado == null) {
				JOptionPane.showMessageDialog(null, "O cliente não foi localizado", "Erro", JOptionPane.ERROR_MESSAGE);
			}else {
				textFieldCodigo.setText(""+ clienteEncontrado.getCodigoCliente());
				textFieldNome.setText(clienteEncontrado.getNome());
				textFieldCPF.setText(clienteEncontrado.getCpf());
				textFieldTelefone.setText(clienteEncontrado.getTelefone());
			}
			LabelTitulo.setText("Alteração de Fornecedor");
			
		} catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, e.getMensagemDeErro(), "Erro", JOptionPane.ERROR_MESSAGE);
	}
}
}

