package br.com.gestaofarmacia.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gestaofarmacia.core.dao.connection.ConexaoMySQL;
import br.com.gestaofarmacia.core.entity.GrupoUsuarioEntity;
import br.com.gestaofarmacia.core.util.exception.NegocioException;

public class GrupoUsuarioDAO {
	
	public String salvarGrupoUsuario(GrupoUsuarioEntity usuario) throws SQLException {
		
		Connection con = ConexaoMySQL.getConexao();
		
		String sql = "INSERT INTO GRUPOUSUARIO(NM_GRUPO)VALUES(?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, usuario.getNomeGrupo());
		ps.executeUpdate();
		
		return "Grupo cadastrado com sucesso";

}
	public List<GrupoUsuarioEntity> listarGrupoUsuario() throws NegocioException {
		
		String sql = "SELECT ID_GRUPO,NM_GRUPO FROM GRUPOUSUARIO";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<GrupoUsuarioEntity> resultado = new ArrayList<GrupoUsuarioEntity>();
		try {
		ps = ConexaoMySQL.getConexao().prepareStatement(sql);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			GrupoUsuarioEntity gu = new GrupoUsuarioEntity(rs.getLong("ID_GRUPO"),
															rs.getString("NM_GRUPO"));
			resultado.add(gu);
		}
		} catch (SQLException e) {
		e.printStackTrace();
		throw new NegocioException("Erro ao listar Grupo de Usuários");	

		}finally {
		try {
			ps.close();
			rs.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
			return resultado;	
	}
		
		public void excluirGrupoUsuario(Long codigoGrupo) throws NegocioException{
			 String sql = "DELETE FROM GRUPOUSUARIO WHERE ID_GRUPO=?";
			 
			 PreparedStatement ps = null;
			 
			 try {
			 ps= ConexaoMySQL.getConexao().prepareStatement(sql);
			 ps.setLong(1,codigoGrupo);
			 
			 ps.execute();
			 
			 } catch (SQLException e) {
				 throw new NegocioException("Erro ao exluir usuário"); 
			 	
		}finally {
			try {
				ps.close();
				} catch (SQLException e) {				
					e.printStackTrace();
				}
		}
						
					}

		public GrupoUsuarioEntity buscarGrupoUsuarioPorID(Long codigoGrupo) throws NegocioException{
			
			String sql = "SELECT ID_GRUPO, NM_GRUPO FROM GRUPOUSUARIO WHERE ID_GRUPO,?";
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				ps= ConexaoMySQL.getConexao().prepareStatement(sql);
				ps.setLong(1, codigoGrupo);

				rs = ps.executeQuery();
				
				GrupoUsuarioEntity grupoEncontrado = null;
			
			if(rs.next()) {
				grupoEncontrado = new GrupoUsuarioEntity();
				grupoEncontrado.setCodigo(rs.getLong("ID_GRUPO"));
				grupoEncontrado.setNomeGrupo(rs.getString("NM_GRUPO"));
			}
			return grupoEncontrado;
			
			} catch (SQLException e) {
				throw new NegocioException("Houve um erro ao buscar o grupo de usuário");
		
			}finally {
				try {
					ps.close();
					rs.close();
					} catch (SQLException e) {				
						e.printStackTrace();
					
					}
			}
			}
		
		public String alterarGrupoUsuario(GrupoUsuarioEntity grupoUsuario) throws NegocioException{
			
			String sql = "UPDATE GRUPOUSUARIO SET NM_GRUPO = WHERE ID_GRUPO = ?";
			
			PreparedStatement ps = null;
			
			try {
				ps= ConexaoMySQL.getConexao().prepareStatement(sql);
				ps.setString(1, grupoUsuario.getNomeGrupo());
				ps.setLong(2,grupoUsuario.getCodigo());
				
				ps.execute();
			}catch (SQLException e) {
				e.printStackTrace();
				throw new NegocioException("Erro ao atualizar Grupo Usuário");
			}finally {
				try {
					ps.close();
				}catch(SQLException e) {
					e.printStackTrace();
					
				}
				return "O Usuário foi alterado com sucesso";
				}
			}
			
		
		}
