package br.com.gestaofarmacia.core.bo;

import java.util.List;

import br.com.gestaofarmacia.core.dao.ClienteDAO;
import br.com.gestaofarmacia.core.dao.UsuarioDAO;
import br.com.gestaofarmacia.core.entity.ClienteEntity;
import br.com.gestaofarmacia.core.entity.UsuarioEntity;
import br.com.gestaofarmacia.core.bo.ClienteBO;
import br.com.gestaofarmacia.core.util.exception.NegocioException;

public class ClienteBO {
	
	public String salvarCliente(ClienteEntity cliente)  throws NegocioException {
		
		if(cliente.getNome()!= null && cliente.getNome().equals("")) {
			if (cliente.getCpf()!= null && cliente.getCpf().equals("")) {
			throw new NegocioException("O nome do Cliente precisa ser preenchido");
			
	}
		}

		ClienteDAO cdao = new ClienteDAO();
			return cdao.salvarCliente(cliente);
}
	
	public List<ClienteEntity>ListarCliente() throws NegocioException{
			return new ClienteDAO().listarCliente();
	//Alterar lista para letra minuscula por conversão 
	}
		
	public void excluirCliente(Long codigoCliente) throws NegocioException{
			new ClienteDAO().excluirCliente(codigoCliente);
}
	//BUSCAR Cliente ID
		public ClienteEntity buscarClientePorID(Long codigoCliente) throws NegocioException{
			return new ClienteDAO().buscarClientePorID(codigoCliente);
		}
		
	//EDITAR Cliente
		public String alterarCliente(ClienteEntity Cliente) throws NegocioException{
			return new ClienteDAO().alterarCliente(Cliente);

}

		public List<ClienteEntity> buscarClienteFiltrado(ClienteEntity cliente) throws NegocioException{
			return new ClienteDAO().buscarClienteFiltrado(cliente);


		}
}
