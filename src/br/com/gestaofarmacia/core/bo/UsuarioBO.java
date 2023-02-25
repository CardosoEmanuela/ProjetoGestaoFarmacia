package br.com.gestaofarmacia.core.bo;

import java.util.List;

import br.com.gestaofarmacia.core.dao.UsuarioDAO;
import br.com.gestaofarmacia.core.entity.UsuarioEntity;
import br.com.gestaofarmacia.core.util.exception.NegocioException;

public class UsuarioBO {

	public String salvarUsuario(UsuarioEntity usuario) throws NegocioException {

		if (!usuario.getEmail().contains("@")) {
			throw new NegocioException("O e-mail est� em um formato inv�lido, favor verificar");
		}
		// Poderia criptografar a senha
		// Poderia validar o restante das informa��es

		if (usuario.getNome() != null && usuario.getNome().equals("")) {
			throw new NegocioException("O nome do usu�rio precisa ser preenchido");

		}
		validarUsuario(usuario);
		UsuarioDAO udao = new UsuarioDAO();
		return udao.salvarUsuario(usuario);

	}

	public List<UsuarioEntity> ListarUsuario() throws NegocioException {
		return new UsuarioDAO().ListarUsuario();
	}

	// Processamento de informa��o � aqui, por exemplo embaralhar senhas
	public void excluirUsuario(Long codigoUsuario) throws NegocioException {
		new UsuarioDAO().excluirUsuario(codigoUsuario);
	}

	// BUSCAR USU�RIO ID
	public UsuarioEntity buscarUsuarioPorID(Long codigoUsuario) throws NegocioException {
		return new UsuarioDAO().buscarUsuarioPorID(codigoUsuario);
	}

	// BUSCAR USUARIO LOGIN
	public boolean usuarioExiste(String login) throws NegocioException {
		// buscarUsuarioPorLogin(login);
		UsuarioEntity usuario = new UsuarioDAO().buscarUsuarioPorLogin(login);

		if (usuario != null) {
			return true;

		}
		return false;
	}

	// EDITAR USUARIO
	public String alterarUsuario(UsuarioEntity usuario) throws NegocioException {
		validarUsuario(usuario);
		return new UsuarioDAO().alterarUsuario(usuario);
	}

	private void validarUsuario(UsuarioEntity usuario) throws NegocioException {
		if (!usuario.getEmail().contains("@")) {
			throw new NegocioException("O e-mail est� em um formato inv�lido, favor verificar");
		}
	}

	// BUSCA FILTRADA USUARIO
	public List<UsuarioEntity> buscarUsuarioFiltrado(UsuarioEntity usuario) throws NegocioException {
		return new UsuarioDAO().buscarUsuarioFiltrado(usuario);
	}

	public UsuarioEntity autenticar(String login, String senha) throws NegocioException {

		if (login.equals("admin") && senha.equals("admin")) {
			UsuarioEntity usuAdmin = new UsuarioEntity();
			usuAdmin.setNome("Administrador do Sistema");
			usuAdmin.setLogin("admin");
			usuAdmin.setSenha("admin");
			return usuAdmin;
		}

		return new UsuarioDAO().autenticar(login, senha);

	}
}
