package br.com.gestaofarmacia.core.service;

import java.util.List;

import br.com.gestaofarmacia.core.bo.GrupoUsuarioBO;
import br.com.gestaofarmacia.core.entity.GrupoUsuarioEntity;
import br.com.gestaofarmacia.core.util.exception.NegocioException;


public class GrupoUsuarioService {
	
	public String salvarGrupoUsuario(GrupoUsuarioEntity grupoUsuario)throws NegocioException {
		return new GrupoUsuarioBO().salvarGrupoUsuarioEntity(grupoUsuario);
}
	public List<GrupoUsuarioEntity> listarGrupoUsuario() throws NegocioException{
		return new GrupoUsuarioBO().listarGrupoUsuario();
	}
	public void excluirGrupoUsuario(Long codigoGrupoUsuario) throws NegocioException{
		new GrupoUsuarioBO().excluirGrupoUsuario(codigoGrupoUsuario);
	}
	
	public GrupoUsuarioEntity buscarGrupoUsuarioPorID(Long codigoGrupoUsuario) throws NegocioException{
		return new GrupoUsuarioBO().buscarGrupoUsuarioPorID(codigoGrupoUsuario);
	}
	
	public String alterarGrupoUsuario(GrupoUsuarioEntity grupoUsuario) throws NegocioException{
		return new GrupoUsuarioBO().alterarGrupoUsuario(grupoUsuario);
	}
}

