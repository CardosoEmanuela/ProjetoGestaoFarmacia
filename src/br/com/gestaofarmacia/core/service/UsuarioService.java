package br.com.gestaofarmacia.core.service;

import java.util.List;

import br.com.gestaofarmacia.core.bo.UsuarioBO;
import br.com.gestaofarmacia.core.entity.UsuarioEntity;
import br.com.gestaofarmacia.core.util.exception.NegocioException;


public class UsuarioService {
	
	public String salvarUsuario(UsuarioEntity usuario) throws NegocioException {
		UsuarioBO bo = new UsuarioBO();
		return bo.salvarUsuario(usuario);
	}
	public List<UsuarioEntity>ListarUsuario() throws NegocioException{
		return new UsuarioBO().ListarUsuario();
}
	public void excluirUsuario(Long codigoUsuario) throws NegocioException{
		new UsuarioBO().excluirUsuario(codigoUsuario);
	}
		//BUSCAR USUÁRIO ID
	public UsuarioEntity buscarUsuarioPorID(Long codigoUsuario) throws NegocioException{
					return new UsuarioBO().buscarUsuarioPorID(codigoUsuario);
	}
	//BUSCAR USUÁRIO login
	public boolean usuarioExiste(String login) throws NegocioException{
				return new UsuarioBO().usuarioExiste(login);
}
	//ALTERAR USUARIO
	public String alterarUsuario(UsuarioEntity usuario) throws NegocioException{
		return new UsuarioBO().alterarUsuario(usuario);
	//FILTRAR USUARIO
	}
	public List<UsuarioEntity> buscarUsuarioFiltrado(UsuarioEntity usuario) throws NegocioException{
		return new UsuarioBO().buscarUsuarioFiltrado(usuario);
	}
	
	public UsuarioEntity autenticar(String login, String senha) throws NegocioException{
		return new UsuarioBO().autenticar(login, senha);
	
}
}
