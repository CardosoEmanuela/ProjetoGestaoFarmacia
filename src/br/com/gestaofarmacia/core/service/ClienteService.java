package br.com.gestaofarmacia.core.service;

import java.util.List;

import br.com.gestaofarmacia.core.bo.ClienteBO;
import br.com.gestaofarmacia.core.bo.UsuarioBO;
import br.com.gestaofarmacia.core.entity.ClienteEntity;
import br.com.gestaofarmacia.core.entity.UsuarioEntity;
import br.com.gestaofarmacia.core.util.exception.NegocioException;

public class ClienteService {
	
	public String salvarCliente(ClienteEntity cliente) throws NegocioException  {
		ClienteBO bo = new ClienteBO();
		return bo.salvarCliente(cliente);
}

	public List<ClienteEntity>ListarCliente() throws NegocioException{
		return new ClienteBO().ListarCliente();
}
	public void excluirCliente(Long codigoCliente) throws NegocioException{
		new ClienteBO().excluirCliente(codigoCliente);
}
	//BUSCAR Cliente ID
	public ClienteEntity buscarClientePorID(Long codigoCliente) throws NegocioException{
				return new ClienteBO().buscarClientePorID(codigoCliente);
}
	public String alterarCliente(ClienteEntity cliente) throws NegocioException{
		return new ClienteBO().alterarCliente(cliente);
}
	public List<ClienteEntity> buscarClienteFiltrado(ClienteEntity cliente) throws NegocioException{
		return new ClienteBO().buscarClienteFiltrado(cliente);
	}
}


