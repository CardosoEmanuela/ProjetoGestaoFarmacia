package br.com.gestaofarmacia.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.gestaofarmacia.core.dao.connection.ConexaoMySQL;
import br.com.gestaofarmacia.core.entity.UsuarioEntity;
import br.com.gestaofarmacia.core.util.exception.NegocioException;

public class UsuarioDAO {
	//INICIO CADASTRO USUARIO
	
	public String salvarUsuario(UsuarioEntity usuario) throws NegocioException {
		String sql = "INSERT INTO USUARIO(NM_USUARIO,LG_USUARIO,SENHA_USUARIO, EMAIL_USUARIO)VALUES(?,?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
				ps.setString(1, usuario.getNome());
				ps.setString(2, usuario.getLogin());
				ps.setString(3, usuario.getSenha());
				ps.setString(4, usuario.getEmail());
			
				ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao cadastrar usuario");
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
		}
		
		
		//Quando aprender implementar o cadastro dessa informação no banco de dados
		return "Usuário cadastrado com sucesso no banco de dados";
			}
		}
		return sql;
		//INICIO LISTA DE USUARIOS
}
	public List<UsuarioEntity>ListarUsuario() throws NegocioException{
		String sql = "SELECT ID_USUARIO, NM_USUARIO, LG_USUARIO, SENHA_USUARIO, EMAIL_USUARIO FROM USUARIO";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<UsuarioEntity>usuarios= new ArrayList<UsuarioEntity>();
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
			UsuarioEntity usu = new UsuarioEntity();
			usu.setCodigo(rs.getLong("ID_USUARIO"));
			usu.setNome(rs.getString("NM_USUARIO"));
			usu.setLogin(rs.getString("LG_USUARIO"));
			usu.setSenha(rs.getString("SENHA_USUARIO"));
			usu.setEmail(rs.getString("EMAIL_USUARIO"));
			usuarios.add(usu);
			
			//next cada vez que executa retorna uma linha do banco de dados
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	//		e.printStackTrace();
		throw new NegocioException("Erro ao listar os usuários");
	} finally {
		try {
		ps.close();
		rs.close();
		} catch (SQLException e) {				
			e.printStackTrace();
		}
	}
		return usuarios;	
//	INICIO EXCLUIR USUARIO
}
	public void excluirUsuario(Long codigoUsuario) throws NegocioException{
		
		String sql = "DELETE FROM USUARIO WHERE ID_USUARIO = ?";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setLong(1, codigoUsuario);
			
			ps.execute();
			
		} catch (SQLException e) {
			throw new NegocioException("Não foi possível excluir o Usuário");
		} finally {
			try {
				ps.close();
			}catch (SQLException e) {
				e.printStackTrace();

			}
		
	}
}
	//INICIO BUSCAR USUÁRIO
	public UsuarioEntity buscarUsuarioPorID(Long codigoUsuario) throws NegocioException {
		
		String sql = "SELECT ID_USUARIO, NM_USUARIO,LG_USUARIO,SENHA_USUARIO,EMAIL_USUARIO FROM USUARIO WHERE ID_USUARIO = ?";
		//tinha um ID_USUARIO = ?
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			//SUBSTITUIÇÃO ? PARA O PARAMETRO DO METODO DO COMANDO SQL
			ps.setLong(1,codigoUsuario);
			rs = ps.executeQuery();
			
			UsuarioEntity usuarioEncontrado = null;
			
			if(rs.next()); {
				usuarioEncontrado = new UsuarioEntity();
				usuarioEncontrado.setCodigo(rs.getLong("ID_USUARIO"));
				usuarioEncontrado.setNome(rs.getString("NM_USUARIO"));
				usuarioEncontrado.setLogin(rs.getString("LG_USUARIO"));
				usuarioEncontrado.setSenha(rs.getString("SENHA_USUARIO"));
				usuarioEncontrado.setEmail(rs.getString("EMAIL_USUARIO"));
				
			}
			return usuarioEncontrado;
			
		} catch (SQLException e) {
		throw new NegocioException("Houve um erro ao buscar usuário");
		
	} finally {
		try {
			ps.close();
			//rs.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	}
	//INICIO VALIDACAO USUARIO
	
	public UsuarioEntity buscarUsuarioPorLogin(String login) throws NegocioException {
		
		String sql = "SELECT * FROM USUARIO WHERE LG_USUARIO = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
			try {
				ps = ConexaoMySQL.getConexao().prepareStatement(sql);
				ps.setString(1,login);
				rs = ps.executeQuery();
			
			UsuarioEntity usuarioEncontrado = null;
			
			if(rs.next()){
				usuarioEncontrado = new UsuarioEntity();
				usuarioEncontrado.setCodigo(rs.getLong("ID_USUARIO"));
				usuarioEncontrado.setNome(rs.getString("NM_USUARIO"));
				usuarioEncontrado.setLogin(rs.getString("LG_USUARIO"));
				usuarioEncontrado.setSenha(rs.getString("SENHA_USUARIO"));
				usuarioEncontrado.setEmail(rs.getString("EMAIL_USUARIO"));
				
			}
			return usuarioEncontrado;
	
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
			
}
	


		
	//INICIO EDITAR USUARIO



		public String alterarUsuario(UsuarioEntity usuario) throws NegocioException{
			
			String sql = "UPDATE USUARIO SET NM_USUARIO = ?, LG_USUARIO = ?, SENHA_USUARIO = ?, EMAIL_USUARIO = ? WHERE ID_USUARIO = ?";
			
			PreparedStatement ps = null;
			
			try {
				ps = ConexaoMySQL.getConexao().prepareStatement(sql);
				ps.setString(1, usuario.getNome());
				ps.setString(2, usuario.getLogin());
				ps.setString(3, usuario.getSenha());
				ps.setString(4, usuario.getEmail());
				ps.setLong(5, usuario.getCodigo());
				
				ps.execute();
				
			} catch (SQLException e) {
				throw new NegocioException("Ocorreu um erro ao atualizar os dados de Usuário");
			} finally {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			return "O Usuário foi alterado com sucesso";
		}
		
		public List<UsuarioEntity> buscarUsuarioFiltrado(UsuarioEntity usuario) throws NegocioException{
			
			String sql = "SELECT ID_USUARIO, NM_USUARIO, LG_USUARIO, SENHA_USUARIO, EMAIL_USUARIO FROM USUARIO";
			
			boolean adicionaWhere = true;
			
			List<UsuarioEntity> resultado = new ArrayList<UsuarioEntity>();
			
			if(usuario != null) {
				if(usuario.getCodigo() != null) {
					adicionaWhere = false;
					sql += " WHERE ";
					sql += "ID_USUARIO = ? ";
				}
				if(usuario.getNome() != null && !usuario.getNome().equals("")) {
					if(adicionaWhere) {
						sql+= " WHERE ";
						adicionaWhere = false;
					}else {
						sql+= " AND ";
					}
					sql += "NM_USUARIO LIKE ? ";
				}
				if(usuario.getLogin() != null && !usuario.getLogin().equals("")) {
					if(adicionaWhere) {
						sql+= " WHERE ";
						adicionaWhere = false;
					}else {
						sql+= " AND ";
					}
					sql += "LG_USUARIO LIKE ? ";
				}
				if(usuario.getEmail() != null && !usuario.getEmail().equals("")) {
					if(adicionaWhere) {
						sql+= " WHERE ";
						adicionaWhere = false;
					}else {
						sql+= " AND ";
					}
					sql += "EMAIL_USUARIO LIKE ? ";
				}
			}
			
			System.out.println(sql);
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				ps = ConexaoMySQL.getConexao().prepareStatement(sql);
				
				int indice = 0;
				
				if(usuario != null) {
					if(usuario.getCodigo() != null) {
						indice = indice + 1;
						ps.setLong(indice, usuario.getCodigo());
					}
					if(usuario.getNome() != null && !usuario.getNome().equals("")) {
						indice = indice + 1;
						ps.setString(indice, usuario.getNome() + "%");
					}
					if(usuario.getLogin() != null && !usuario.getLogin().equals("")) {
						indice = indice + 1;
						ps.setString(indice, usuario.getLogin() + "%");
					}
					if(usuario.getEmail() != null && !usuario.getEmail().equals("")) {
						indice = indice + 1;
						ps.setString(indice, usuario.getEmail() + "%");
					}
				}
				
				rs = ps.executeQuery();
				
				while(rs.next()) {
					UsuarioEntity usuarioResultado = new UsuarioEntity();
					usuarioResultado.setCodigo(rs.getLong("ID_USUARIO"));
					usuarioResultado.setNome(rs.getString("NM_USUARIO"));
					usuarioResultado.setLogin(rs.getString("LG_USUARIO"));
					usuarioResultado.setSenha(rs.getString("SENHA_USUARIO"));
					usuarioResultado.setEmail(rs.getString("EMAIL_USUARIO"));
					resultado.add(usuarioResultado);				
				}
				
			} catch (SQLException e) {
				throw new NegocioException("Busca filtrada com problema");
			} finally {
				try {
					ps.close();
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
					
			return resultado;
		}
		
		public UsuarioEntity autenticar(String login, String senha) throws NegocioException{
			
			String sql = "SELECT ID_USUARIO, NM_USUARIO, LG_USUARIO, SENHA_USUARIO, EMAIL_USUARIO FROM USUARIO "
					+ "WHERE LG_USUARIO = ? AND SENHA_USUARIO = ?";
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				ps = ConexaoMySQL.getConexao().prepareStatement(sql);
				ps.setString(1, login);
				ps.setString(2, senha);
				
				rs = ps.executeQuery();
				
				UsuarioEntity usuarioAutenticado = null;
							
				if(rs.next()) {
					usuarioAutenticado = new UsuarioEntity();
					usuarioAutenticado.setCodigo(rs.getLong("ID_USUARIO"));
					usuarioAutenticado.setNome(rs.getString("NM_USUARIO"));
					usuarioAutenticado.setLogin(rs.getString("LG_USUARIO"));
					usuarioAutenticado.setSenha(rs.getString("SENHA_USUARIO"));
					usuarioAutenticado.setEmail(rs.getString("EMAIL_USUARIO"));
				}
				
				return usuarioAutenticado;
				
			} catch (SQLException e) {
				throw new NegocioException("Erro ao tentar autenticar");
			} finally {
				try {
					ps.close();
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
