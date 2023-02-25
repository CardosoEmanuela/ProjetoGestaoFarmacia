package br.com.gestaofarmacia.view;

import br.com.gestaofarmacia.core.entity.UsuarioEntity;


import br.com.gestaofarmacia.core.service.UsuarioService;
import br.com.gestaofarmacia.core.util.exception.NegocioException;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.gestaofarmacia.core.entity.ClienteEntity;
import br.com.gestaofarmacia.core.entity.FornecedorEntity;
import br.com.gestaofarmacia.core.entity.GrupoUsuarioEntity;
import br.com.gestaofarmacia.core.entity.ProdutoEntity;
import br.com.gestaofarmacia.core.service.ClienteService;
import br.com.gestaofarmacia.core.service.FornecedorService;
import br.com.gestaofarmacia.core.service.GrupoUsuarioService;
import br.com.gestaofarmacia.core.service.ProdutoService;


public class Principal {


	public static void main(String[] args) throws NegocioException {
		// TODO Auto-generated method stub
		//Montando o objeto com as informações da tela
		
	UsuarioEntity usuario = new UsuarioEntity ();
		usuario.setCodigo(1L);
		usuario.setNome("teste Rogério");
		usuario.setLogin("rogeriorj");
		usuario.setSenha("1234");
		usuario.setEmail("rogerio@gmail.com");
		
		new UsuarioService().alterarUsuario(usuario);
		
		ProdutoEntity produto = new ProdutoEntity ();
		produto.setCodigoProduto(1L);
		produto.setNomeProduto("Paracetamol");
		produto.setDosagem ("50mg");
		produto.setViaMedicacao ("oral");
		
		new ProdutoService().alterarProduto(produto);
		
		FornecedorEntity fornecedor = new FornecedorEntity ();
		fornecedor.setCodigoFornecedor(1L);
		fornecedor.setRazaoSocial("Medicamentos LTDA");
		fornecedor.setCnpj ("00.112.112/0001-39");
		fornecedor.setTelefone ("48 36265504");
		fornecedor.setEmail("medicamentos@gmail.com");
		fornecedor.setEndereco("Rua Jardim, Carvoreira, n 10 - Florianópolis");
		
		new FornecedorService().alterarFornecedor(fornecedor);
		
		
		ClienteEntity cliente = new ClienteEntity ();
			cliente.setCodigoCliente(1L);
			cliente.setNome("Maria");
			cliente.setCpf("168.589.336-35");
			cliente.setTelefone("48 99187544");
			
			new ClienteService().alterarCliente(cliente);
		
		//Estouu chamando meu CORE/Backend para salvar o usuario em questao
	
		UsuarioService us = new UsuarioService();
		try {
			System.out.println (us.salvarUsuario(usuario));
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		ProdutoService ps = new ProdutoService();
		try {
		System.out.println (ps.salvarProduto(produto));
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	GrupoUsuarioEntity grupoUsuario = new GrupoUsuarioEntity();
		grupoUsuario.setNomeGrupo("RH");
	GrupoUsuarioService gus = new GrupoUsuarioService();
		try {
		System.out.println(gus.salvarGrupoUsuario(grupoUsuario));
		} catch (NegocioException e) {
		e.printStackTrace();
		}
	FornecedorService f = new FornecedorService();
		try {
		System.out.println (f.salvarFornecedor(fornecedor));
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ClienteService cli = new ClienteService();
		try {
			System.out.println (cli.salvarCliente(cliente));
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	//new UsuarioService().excluirUsuario(5L);TESTE EXCLUSÃO L é de long
	List<UsuarioEntity>usuarios = new UsuarioService().ListarUsuario();
	for (UsuarioEntity usuarioEntity : usuarios) {
		System.out.println("Nome" + usuarioEntity.getNome()+ "Código" + usuarioEntity.getCodigo());
	}
	List<ProdutoEntity>produtos = new ProdutoService().ListarProduto();
	for (ProdutoEntity produtoEntity : produtos) {
		System.out.println("Nome " + produtoEntity.getNomeProduto()+ " Código" + produtoEntity.getCodigoProduto());
	}	
	List<GrupoUsuarioEntity>grupoUsuarios = new GrupoUsuarioService().listarGrupoUsuario();
	for (GrupoUsuarioEntity GrupoUsuarioEntity : grupoUsuarios) {
		System.out.println("Nome " + GrupoUsuarioEntity.getNomeGrupo()+ " Código" + GrupoUsuarioEntity.getCodigo());
	}
	List<FornecedorEntity>fornecedores = new FornecedorService().ListarFornecedor();
	for (FornecedorEntity FornecedorEntity : fornecedores) {
		System.out.println("Razão social:  " + FornecedorEntity.getRazaoSocial()+ " Código: " + FornecedorEntity.getCodigoFornecedor());
	}
	List<ClienteEntity>clientes = new ClienteService().ListarCliente();
	for (ClienteEntity ClienteEntity : clientes) {
		System.out.println("Nome:  " + ClienteEntity.getNome()+ " Código: " + ClienteEntity.getCodigoCliente());
	}
	//BUSCAR USUARIO
	try {
		UsuarioEntity usuarioEncontrado = new UsuarioService().buscarUsuarioPorID(null);
		if(usuarioEncontrado == null) {
			JOptionPane.showMessageDialog(null,"Não encontrou o usuário");
		}else
		JOptionPane.showMessageDialog(null,"O usuário encontrado foi " + usuarioEncontrado.getNome());
		
	} catch (NegocioException e) {
		e.printStackTrace();
	}	
	
	try {
		ProdutoEntity produtoEncontrado = new ProdutoService().buscarProdutoPorID(null);
		if(produtoEncontrado == null) {
			JOptionPane.showMessageDialog(null,"Não encontrou o produto");
		}else
		JOptionPane.showMessageDialog(null,"O produto encontrado foi " + produtoEncontrado.getNomeProduto());
		
	} catch (NegocioException e) {
		e.printStackTrace();
	}	
	try {
		GrupoUsuarioEntity grupoUsuarioEncontrado = new GrupoUsuarioService().buscarGrupoUsuarioPorID(null);
		if(grupoUsuarioEncontrado == null) {
			JOptionPane.showMessageDialog(null,"Não encontrou o grupo de usuário");
		}else
		JOptionPane.showMessageDialog(null,"O grupo de usuário encontrado foi " + grupoUsuarioEncontrado.getNomeGrupo());
		
	} catch (NegocioException e) {
		e.printStackTrace();
	}
	try {
		FornecedorEntity fornecedorEncontrado = new FornecedorService().buscarFornecedorPorID(null);
		if(fornecedorEncontrado == null) {
			JOptionPane.showMessageDialog(null,"Não encontrou o fornecedor");
		}else 
		JOptionPane.showMessageDialog(null,"O fornecedor encontrado foi " + fornecedorEncontrado.getRazaoSocial());
	} catch (NegocioException e) {
		e.printStackTrace();
		
	}
	try {
		ClienteEntity clienteEncontrado = new ClienteService().buscarClientePorID(null);
		if(clienteEncontrado == null) {
			JOptionPane.showMessageDialog(null,"Não encontrou o cliente");
		}else 
		JOptionPane.showMessageDialog(null,"O cliente encontrado foi " + clienteEncontrado.getNome());
	} catch (NegocioException e) {
		e.printStackTrace();
	}
}
}






