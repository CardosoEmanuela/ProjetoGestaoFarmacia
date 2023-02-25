package br.com.gestaofarmacia.core.service;

import java.util.List;

import br.com.gestaofarmacia.core.bo.ProdutoBO;
import br.com.gestaofarmacia.core.bo.UsuarioBO;
import br.com.gestaofarmacia.core.entity.ProdutoEntity;
import br.com.gestaofarmacia.core.entity.UsuarioEntity;
import br.com.gestaofarmacia.core.util.exception.NegocioException;

public class ProdutoService {

		
		public String salvarProduto(ProdutoEntity produto) throws NegocioException  {
			ProdutoBO bo = new ProdutoBO();
			return bo.salvarProduto(produto);
}

		public List<ProdutoEntity>ListarProduto() throws NegocioException{
			return new ProdutoBO().ListarProduto();
}
		public void excluirProduto(Long codigoProduto) throws NegocioException{
			new ProdutoBO().excluirProduto(codigoProduto);
	}
		//BUSCAR PRODUTO ID
		public ProdutoEntity buscarProdutoPorID(Long codigoProduto) throws NegocioException{
					return new ProdutoBO().buscarProdutoPorID(codigoProduto);
}
		//BUSCAR PRODUTO NOME
		public boolean produtoExiste(String nomeProduto) throws NegocioException{
					return new ProdutoBO().produtoExiste(nomeProduto);
		}
		public String alterarProduto(ProdutoEntity produto) throws NegocioException{
			return new ProdutoBO().alterarProduto(produto);
	}
		public List<ProdutoEntity> buscarProdutoFiltrado(ProdutoEntity produto) throws NegocioException{
			return new ProdutoBO().buscarProdutoFiltrado(produto);
}

	
}