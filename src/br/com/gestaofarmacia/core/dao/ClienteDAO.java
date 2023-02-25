package br.com.gestaofarmacia.core.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gestaofarmacia.core.dao.connection.ConexaoMySQL;
import br.com.gestaofarmacia.core.entity.ClienteEntity;
import br.com.gestaofarmacia.core.entity.UsuarioEntity;
import br.com.gestaofarmacia.core.entity.ClienteEntity;
import br.com.gestaofarmacia.core.util.exception.NegocioException;

public class ClienteDAO {
	
	public String salvarCliente(ClienteEntity cliente) throws NegocioException {
		String sql = "INSERT INTO CLIENTE(NM_CLIENTE,CPF_CLIENTE,TEL_CLIENTE)VALUES(?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
				ps.setString(1, cliente.getNome());
				ps.setString(2, cliente.getCpf());
				ps.setString(3, cliente.getTelefone());
				
			
				ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao cadastrar Cliente");
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
		}
		
		return "Cliente cadastrado com sucesso no banco de dados";
			}
		}
		return sql;
		
		//INICIO LISTA DE ClienteS
}
	public List<ClienteEntity>listarCliente() throws NegocioException{
		String sql = "SELECT ID_CLIENTE, NM_CLIENTE, CPF_CLIENTE, TEL_CLIENTE FROM CLIENTE";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<ClienteEntity>Clientes= new ArrayList<ClienteEntity>();
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
			ClienteEntity cli = new ClienteEntity();
			cli.setCodigoCliente(rs.getLong("ID_CLIENTE"));
			cli.setNome(rs.getString("NM_CLIENTE"));
			cli.setCpf(rs.getString("CPF_CLIENTE"));
			cli.setTelefone(rs.getString("TEL_CLIENTE"));
			Clientes.add(cli);
			
			//next cada vez que executa retorna uma linha do banco de dados
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		throw new NegocioException("Erro ao listar os Clientes");
	} finally {
		try {
		ps.close();
	//	rs.close();
		} catch (SQLException e) {				
			e.printStackTrace();
		}
	}
		return Clientes;	
//	INICIO EXCLUIR Cliente
}
	public void excluirCliente(Long codigoCliente) throws NegocioException{
		
		String sql = "DELETE FROM CLIENTE WHERE ID_CLIENTE = ?";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setLong(1, codigoCliente);
			
			ps.execute();
			
		} catch (SQLException e) {
			throw new NegocioException("Não foi possível excluir o Cliente");
		} finally {
			try {
				ps.close();
			}catch (SQLException e) {
				e.printStackTrace();

			}
		
	}
}
	//INICIO BUSCAR Cliente
		
		public ClienteEntity buscarClientePorID(Long codigoCliente) throws NegocioException {
		
		String sql = "SELECT ID_CLIENTE, NM_CLIENTE,CPF_CLIENTE,TEL_CLIENTE FROM CLIENTE WHERE ID_CLIENTE = ?";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
		
			ps.setLong(1,codigoCliente);
			rs = ps.executeQuery();
			
			ClienteEntity clienteEncontrado = null;
			
			if(rs.next()); {
				clienteEncontrado = new ClienteEntity();
				clienteEncontrado.setCodigoCliente(rs.getLong("ID_CLIENTE"));
				clienteEncontrado.setNome(rs.getString("NM_CLIENTE"));
				clienteEncontrado.setCpf(rs.getString("CPF_CLIENTE"));
				clienteEncontrado.setTelefone(rs.getString("TEL_CLIENTE"));
				
			}
			return clienteEncontrado;
			
		} catch (SQLException e) {
		throw new NegocioException("Houve um erro ao buscar Cliente");
		
	} finally {
		try {
			ps.close();
			rs.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
		}
		public ClienteEntity buscarClientePorNome(String nome) throws NegocioException {
			
			String sql = "SELECT * FROM CLIENTE WHERE NM_CLIENTE = ?";
			PreparedStatement ps = null;
			ResultSet rs = null;
				try {
					ps = ConexaoMySQL.getConexao().prepareStatement(sql);
					ps.setString(1,nome);
					rs = ps.executeQuery();
				
				ClienteEntity clienteEncontrado = null;
				
				if(rs.next()){
					clienteEncontrado = new ClienteEntity();
					clienteEncontrado.setCodigoCliente(rs.getLong("ID_CLIENTE"));
					clienteEncontrado.setNome(rs.getString("NM_CLIENTE"));
					clienteEncontrado.setCpf(rs.getString("CPF_CLIENTE"));
					clienteEncontrado.setTelefone(rs.getString("TEL_CLIENTE"));
					
				}
				return clienteEncontrado;
		
			}catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
				
	}
	//INICIO EDITAR Cliente
		
		public String alterarCliente(ClienteEntity cliente) throws NegocioException{
			
			String sql = "UPDATE CLIENTE SET NM_CLIENTE = ?, CPF_CLIENTE = ?, TEL_CLIENTE = ? WHERE ID_CLIENTE = ?";
			PreparedStatement ps = null;
			
			try {
				ps = ConexaoMySQL.getConexao().prepareStatement(sql);
				ps.setString(1, cliente.getNome());
				ps.setString(2, cliente.getCpf());
				ps.setString(3, cliente.getTelefone());
				ps.setLong(4, cliente.getCodigoCliente());
				
				
				ps.execute();
				
			} catch (SQLException e) {
				throw new NegocioException("Ocorreu um erro ao atualizar os dados do Cliente");
			} finally {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			return "O Cliente foi alterado com sucesso";
		
	}
		public List<ClienteEntity> buscarClienteFiltrado(ClienteEntity Cliente) throws NegocioException{
			
			String sql = "SELECT ID_CLIENTE, NM_CLIENTE, CPF_CLIENTE, TEL_CLIENTE FROM CLIENTE";
			
			boolean adicionaWhere = true;
			
			List<ClienteEntity> resultado = new ArrayList<ClienteEntity>();
			
			if(Cliente != null) {
				if(Cliente.getCodigoCliente() != null) {
					adicionaWhere = false;
					sql += " WHERE ";
					sql += "ID_CLIENTE = ? ";
				}
				if(Cliente.getNome() != null && !Cliente.getNome().equals("")) {
					if(adicionaWhere) {
						sql+= " WHERE ";
						adicionaWhere = false;
					}else {
						sql+= " AND ";
					}
					sql += "NM_CLIENTE LIKE ? ";
				}
				if(Cliente.getCpf() != null && !Cliente.getCpf().equals("")) {
					if(adicionaWhere) {
						sql+= " WHERE ";
						adicionaWhere = false;
					}else {
						sql+= " AND ";
					}
					sql += "CPF_CLIENTE LIKE ? ";
				}
				if(Cliente.getTelefone() != null && !Cliente.getTelefone().equals("")) {
					if(adicionaWhere) {
						sql+= " WHERE ";
						adicionaWhere = false;
					}else {
						sql+= " AND ";
					}
					sql += "TEL_TELEFONE LIKE ? ";
				}
			}
			
			System.out.println(sql);
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				ps = ConexaoMySQL.getConexao().prepareStatement(sql);
				
				int indice = 0;
				
				if(Cliente != null) {
					if(Cliente.getCodigoCliente() != null) {
						indice = indice + 1;
						ps.setLong(indice, Cliente.getCodigoCliente());
					}
					if(Cliente.getNome() != null && !Cliente.getNome().equals("")) {
						indice = indice + 1;
						ps.setString(indice, Cliente.getNome() + "%");
					}
					if(Cliente.getCpf() != null && !Cliente.getCpf().equals("")) {
						indice = indice + 1;
						ps.setString(indice, Cliente.getCpf() + "%");
					}
					if(Cliente.getTelefone() != null && !Cliente.getTelefone().equals("")) {
						indice = indice + 1;
						ps.setString(indice, Cliente.getTelefone() + "%");
					}
				}
				
				rs = ps.executeQuery();
				
				while(rs.next()) {
					ClienteEntity ClienteResultado = new ClienteEntity();
					ClienteResultado.setCodigoCliente(rs.getLong("ID_Cliente"));
					ClienteResultado.setNome(rs.getString("NM_CLIENTE"));
					ClienteResultado.setCpf(rs.getString("CPF_CLIENTE"));
					ClienteResultado.setTelefone(rs.getString("TEL_CLIENTE"));
					resultado.add(ClienteResultado);				
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
}


	

	





