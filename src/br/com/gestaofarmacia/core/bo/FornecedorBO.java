package br.com.gestaofarmacia.core.bo;

import java.util.List;

import br.com.gestaofarmacia.core.dao.FornecedorDAO;
import br.com.gestaofarmacia.core.dao.UsuarioDAO;
import br.com.gestaofarmacia.core.entity.FornecedorEntity;
import br.com.gestaofarmacia.core.entity.UsuarioEntity;
import br.com.gestaofarmacia.core.entity.FornecedorEntity;
import br.com.gestaofarmacia.core.util.exception.NegocioException;

public class FornecedorBO {

	public String salvarFornecedor(FornecedorEntity fornecedor) throws NegocioException {
		if (fornecedor.getRazaoSocial() != null && fornecedor.getRazaoSocial().equals("")) {
			if (fornecedor.getCnpj() != null && fornecedor.getCnpj().equals("")) {
				if (fornecedor.getTelefone() != null && fornecedor.getTelefone().equals("")) {
					if (fornecedor.getEmail() != null && fornecedor.getEmail().equals("")) {
						if (fornecedor.getEndereco() != null && fornecedor.getEndereco().equals("")) {
							throw new NegocioException("Todos os dados do fornecedor precisam ser preenchido");
						}
					}
				}
			}
		}

		if (!fornecedor.getEmail().contains("@")) {
			throw new NegocioException("O e-mail está em um formato inválido, favor verificar");
		}

		validarFornecedor(fornecedor);
		FornecedorDAO fdao = new FornecedorDAO();
		return fdao.salvarFornecedor(fornecedor);

	}

	public List<FornecedorEntity> ListarFornecedor() throws NegocioException {
		return new FornecedorDAO().ListarFornecedor();
	}

	public void excluirFornecedor(Long codigoFornecedor) throws NegocioException {
		new FornecedorDAO().excluirFornecedor(codigoFornecedor);
	}

	// BUSCAR Fornecedor ID
	public FornecedorEntity buscarFornecedorPorID(Long codigoFornecedor) throws NegocioException {
		return new FornecedorDAO().buscarFornecedorPorID(codigoFornecedor);
	}

	// BUSCAR FORNECEDOR NOME
	public boolean fornecedorExiste(String razaoSocial) throws NegocioException {
		FornecedorEntity fornecedor = new FornecedorDAO().buscarFornecedorPorRazaoSocial(razaoSocial);
		if (fornecedor != null) {
			return true;

		}
		return false;
	}
	

	//EDITAR Fornecedor
	public String alterarFornecedor(FornecedorEntity fornecedor) throws NegocioException {
		validarFornecedor(fornecedor);
		return new FornecedorDAO().alterarFornecedor(fornecedor);
	}

	private void validarFornecedor(FornecedorEntity fornecedor) throws NegocioException {
		if (!fornecedor.getEmail().contains("@")) {
			throw new NegocioException("O e-mail está em um formato inválido, favor verificar");
		}
	}

	public List<FornecedorEntity> buscarFornecedorFiltrado(FornecedorEntity fornecedor) throws NegocioException {
		return new FornecedorDAO().buscarFornecedorFiltrado(fornecedor);

	}
}
