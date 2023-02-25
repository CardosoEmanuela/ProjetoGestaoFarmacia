package br.com.gestaofarmacia.core.service;

import java.util.List;

import br.com.gestaofarmacia.core.bo.FornecedorBO;
import br.com.gestaofarmacia.core.bo.UsuarioBO;
import br.com.gestaofarmacia.core.entity.FornecedorEntity;
import br.com.gestaofarmacia.core.entity.UsuarioEntity;
import br.com.gestaofarmacia.core.util.exception.NegocioException;

public class FornecedorService {

	public String salvarFornecedor(FornecedorEntity fornecedor) throws NegocioException {
		FornecedorBO fbo = new FornecedorBO();
		return fbo.salvarFornecedor(fornecedor);
	}

	public List<FornecedorEntity> ListarFornecedor() throws NegocioException {
		return new FornecedorBO().ListarFornecedor();
	}

	public void excluirFornecedor(Long codigoFornecedor) throws NegocioException {
		new FornecedorBO().excluirFornecedor(codigoFornecedor);
	}

	public FornecedorEntity buscarFornecedorPorID(Long codigoFornecedor) throws NegocioException {
		return new FornecedorBO().buscarFornecedorPorID(codigoFornecedor);
	}

	public boolean fornecedorExiste(String razaoSocial) throws NegocioException {
		return new FornecedorBO().fornecedorExiste(razaoSocial);
	}

	public String alterarFornecedor(FornecedorEntity fornecedor) throws NegocioException {
		return new FornecedorBO().alterarFornecedor(fornecedor);
	}

	public List<FornecedorEntity> buscarFornecedorFiltrado(FornecedorEntity fornecedor) throws NegocioException {
		return new FornecedorBO().buscarFornecedorFiltrado(fornecedor);
	}

}
