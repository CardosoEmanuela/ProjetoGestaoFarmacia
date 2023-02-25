package br.com.gestaofarmacia.core.bo;

import java.sql.SQLException;

import java.util.List;

import br.com.gestaofarmacia.core.dao.GrupoUsuarioDAO;
import br.com.gestaofarmacia.core.entity.GrupoUsuarioEntity;
import br.com.gestaofarmacia.core.util.exception.NegocioException;


public class GrupoUsuarioBO {
	
	public String salvarGrupoUsuarioEntity(GrupoUsuarioEntity grupoUsuario) throws NegocioException {
		if(grupoUsuario == null) {
			throw new NegocioException("O grupo do usuário é nulo");
		}
		if(grupoUsuario.getNomeGrupo() == null) {
			throw new NegocioException("O nome do grupo é nulo");
		}
		if(grupoUsuario.getNomeGrupo().equals("")) {
			throw new NegocioException("O nome do grupo precisa ser preenchido");
		}
	
		try {
			GrupoUsuarioDAO gudao = new GrupoUsuarioDAO();
			return gudao.salvarGrupoUsuario(grupoUsuario);
			
			} catch (SQLException e) {
			e.printStackTrace();
			return "Erro ao cadastrar grupo usuário";
		}
			
	}		
	public List<GrupoUsuarioEntity>listarGrupoUsuario() throws NegocioException{
			return new GrupoUsuarioDAO().listarGrupoUsuario();
}
	public void excluirGrupoUsuario(Long codigoGrupoUsuario) throws NegocioException{
		new GrupoUsuarioDAO().excluirGrupoUsuario(codigoGrupoUsuario);
	}
	
	public GrupoUsuarioEntity buscarGrupoUsuarioPorID(Long codigoGrupoUsuario) throws NegocioException{
		return new GrupoUsuarioDAO().buscarGrupoUsuarioPorID(codigoGrupoUsuario);
	}
	
	public String alterarGrupoUsuario(GrupoUsuarioEntity grupoUsuario) throws NegocioException{
		return new GrupoUsuarioDAO().alterarGrupoUsuario(grupoUsuario);
	}
	}




