package br.com.gestaofarmacia.core.bo;

import java.util.List;


import br.com.gestaofarmacia.core.dao.ProdutoDAO;
import br.com.gestaofarmacia.core.dao.UsuarioDAO;
import br.com.gestaofarmacia.core.dao.ProdutoDAO;
import br.com.gestaofarmacia.core.entity.ProdutoEntity;
import br.com.gestaofarmacia.core.entity.UsuarioEntity;
import br.com.gestaofarmacia.core.util.exception.NegocioException;


public class ProdutoBO {

	public String salvarProduto(ProdutoEntity produto)  throws NegocioException {

	
		if(produto.getNomeProduto()!= null && produto.getNomeProduto().equals("")) { 
			if (produto.getDosagem()!= null && produto.getDosagem().equals("")) {
				if	(produto.getViaMedicacao()!= null && produto.getViaMedicacao().equals("")) {
					
			throw new NegocioException("Todos os dados do medicamento precisa ser preenchido"); 
				}
			}
		}
		
		ProdutoDAO pdao = new ProdutoDAO();
			return pdao.salvarProduto(produto);
				
					
	}
			public List<ProdutoEntity>ListarProduto() throws NegocioException{
				return new ProdutoDAO().ListarProduto();
}
			public void excluirProduto(Long codigoProduto) throws NegocioException{
				new ProdutoDAO().excluirProduto(codigoProduto);
}
//BUSCAR PRODUTO ID
			public ProdutoEntity buscarProdutoPorID(Long codigoProduto) throws NegocioException{
				return new ProdutoDAO().buscarProdutoPorID(codigoProduto);
}
// BUSCAR PRODUTO NOME
			
			public boolean produtoExiste(String nomeProduto) throws NegocioException {
				// buscarUsuarioPorLogin(login);
				ProdutoEntity produto = new ProdutoDAO().buscarUsuarioPorLogin(nomeProduto);

				if (produto != null) {
					return true;

				}
				return false;
			}

//EDITAR PRODUTO
			public String alterarProduto(ProdutoEntity produto) throws NegocioException{
				return new ProdutoDAO().alterarProduto(produto);
}
			public List<ProdutoEntity> buscarProdutoFiltrado(ProdutoEntity produto) throws NegocioException{
				return new ProdutoDAO().buscarProdutoFiltrado(produto);
						}
}
	
	
		


		

