package br.com.gestaofarmacia.core.dao;


	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;
	import br.com.gestaofarmacia.core.dao.connection.ConexaoMySQL;
	import br.com.gestaofarmacia.core.entity.FornecedorEntity;
import br.com.gestaofarmacia.core.entity.UsuarioEntity;
import br.com.gestaofarmacia.core.entity.FornecedorEntity;
import br.com.gestaofarmacia.core.util.exception.NegocioException;


	public class FornecedorDAO {
		//INICIO CADASTRO Fornecedor
		
		public String salvarFornecedor(FornecedorEntity fornecedor) throws NegocioException {
			String sql = "INSERT INTO Fornecedor(RS_FORNECEDOR,CNPJ_FORNECEDOR,TEL_FORNECEDOR, EMAIL_FORNECEDOR, END_FORNECEDOR)VALUES(?,?,?,?,?)";
			PreparedStatement ps = null;
			try {
				ps = ConexaoMySQL.getConexao().prepareStatement(sql);
					ps.setString(1, fornecedor.getRazaoSocial());
					ps.setString(2, fornecedor.getCnpj());
					ps.setString(3, fornecedor.getTelefone());
					ps.setString(4, fornecedor.getEmail());
					ps.setString(5, fornecedor.getEndereco());
				
					ps.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new NegocioException("Erro ao cadastrar Fornecedor");
			} finally {
				if(ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
			}
			
			return "Fornecedor cadastrado com sucesso no banco de dados";
				}
			}
			return sql;
			
			//INICIO LISTA DE Fornecedor
	}
		public List<FornecedorEntity>ListarFornecedor() throws NegocioException{
			String sql = "SELECT ID_FORNECEDOR,RS_FORNECEDOR,CNPJ_FORNECEDOR,TEL_FORNECEDOR, EMAIL_FORNECEDOR, END_FORNECEDOR FROM FORNECEDOR";
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<FornecedorEntity>fornecedores= new ArrayList<FornecedorEntity>();
			try {
				ps = ConexaoMySQL.getConexao().prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()) {
				FornecedorEntity f = new FornecedorEntity();
				f.setCodigoFornecedor(rs.getLong("ID_FORNECEDOR"));
				f.setRazaoSocial(rs.getString("RS_FORNECEDOR"));
				f.setCnpj(rs.getString("CNPJ_FORNECEDOR"));
				f.setTelefone(rs.getString("TEL_FORNECEDOR"));
				f.setEmail(rs.getString("EMAIL_FORNECEDOR"));
				f.setEndereco(rs.getString("END_FORNECEDOR"));
						
				fornecedores.add(f);
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			throw new NegocioException("Erro ao listar os Fornecedores");
		} finally {
			try {
			ps.close();
			rs.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
			return fornecedores;	
//		INICIO EXCLUIR Fornecedor
	}
		public void excluirFornecedor(Long codigoFornecedor) throws NegocioException{
			
			String sql = "DELETE FROM FORNECEDOR WHERE ID_FORNECEDOR = ?";
			
			PreparedStatement ps = null;
			
			try {
				ps = ConexaoMySQL.getConexao().prepareStatement(sql);
				ps.setLong(1, codigoFornecedor);
				
				ps.execute();
				
			} catch (SQLException e) {
				throw new NegocioException("Não foi possível excluir o Fornecedor");
			} finally {
				try {
					ps.close();
				}catch (SQLException e) {
					e.printStackTrace();

				}
			
		}
	}
		//INICIO BUSCAR Fornecedor
		public FornecedorEntity buscarFornecedorPorID(Long codigoFornecedor) throws NegocioException {
			
			String sql = "SELECT ID_FORNECEDOR, RS_FORNECEDOR,CNPJ_FORNECEDOR,TEL_FORNECEDOR, EMAIL_FORNECEDOR, END_FORNECEDOR FROM FORNECEDOR WHERE ID_FORNECEDOR = ?";
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				ps = ConexaoMySQL.getConexao().prepareStatement(sql);
				ps.setLong(1,codigoFornecedor);
				rs = ps.executeQuery();
				
				FornecedorEntity fornecedorEncontrado = null;
				
				if(rs.next()); {
					fornecedorEncontrado = new FornecedorEntity();
					fornecedorEncontrado.setCodigoFornecedor(rs.getLong("ID_FORNECEDOR"));
					fornecedorEncontrado.setRazaoSocial(rs.getString("RS_FORNECEDOR"));
					fornecedorEncontrado.setCnpj(rs.getString("CNPJ_FORNECEDOR"));
					fornecedorEncontrado.setTelefone(rs.getString("TEL_FORNECEDOR"));
					fornecedorEncontrado.setEmail(rs.getString("EMAIL_Fornecedor"));
					fornecedorEncontrado.setEndereco(rs.getString("END_FORNECEDOR"));
				}
				return fornecedorEncontrado;
				
			} catch (SQLException e) {
			throw new NegocioException("Houve um erro ao buscar Fornecedor");
			
		} finally {
			try {
				ps.close();
				//rs.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
			}
		//INICIO EDITAR Fornecedor
			
			public String alterarFornecedor(FornecedorEntity fornecedor) throws NegocioException{
				
				String sql = "UPDATE FORNECEDOR SET RS_FORNECEDOR = ?, CNPJ_FORNECEDOR = ?, TEL_FORNECEDOR = ?, EMAIL_FORNECEDOR = ?, END_FORNECEDOR = ? WHERE ID_FORNECEDOR = ?";
				PreparedStatement ps = null;
				
				try {
					ps = ConexaoMySQL.getConexao().prepareStatement(sql);
					ps.setString(1, fornecedor.getRazaoSocial());
					ps.setString(2, fornecedor.getCnpj());
					ps.setString(3, fornecedor.getTelefone());
					ps.setString(4, fornecedor.getEmail());
					ps.setString(5, fornecedor.getEndereco());
					ps.setLong(6, fornecedor.getCodigoFornecedor());
					
					ps.execute();
					
				} catch (SQLException e) {
			//		throw new NegocioException("Ocorreu um erro ao atualizar os dados de Fornecedor");
				} finally {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				return "O Fornecedor foi alterado com sucesso";
			
		}
			//BUSCA FILTRADA FORNECEDOR
			public List<FornecedorEntity> buscarFornecedorFiltrado(FornecedorEntity fornecedor) throws NegocioException{
				
				String sql = "SELECT ID_FORNECEDOR, RS_FORNECEDOR, CNPJ_FORNECEDOR,TEL_FORNECEDOR, EMAIL_FORNECEDOR FROM FORNECEDOR";
				
				boolean adicionaWhere = true;
				
				List<FornecedorEntity> resultado = new ArrayList<FornecedorEntity>();
				
				if(fornecedor != null) {
					if(fornecedor.getCodigoFornecedor() != null) {
						adicionaWhere = false;
						sql += " WHERE ";
						sql += "ID_FORNECEDOR = ? ";
					}
					if(fornecedor.getRazaoSocial() != null && !fornecedor.getRazaoSocial().equals("")) {
						if(adicionaWhere) {
							sql+= " WHERE ";
							adicionaWhere = false;
						}else {
							sql+= " AND ";
						}
						sql += "RS_FORNECEDOR LIKE ? ";
					}
					if(fornecedor.getCnpj() != null && !fornecedor.getCnpj().equals("")) {
						if(adicionaWhere) {
							sql+= " WHERE ";
							adicionaWhere = false;
						}else {
							sql+= " AND ";
						}
						sql += "CNPJ_FORNECEDOR LIKE ? ";
					}
					if(fornecedor.getTelefone() != null && !fornecedor.getTelefone().equals("")) {
						if(adicionaWhere) {
							sql+= " WHERE ";
							adicionaWhere = false;
						}else {
							sql+= " AND ";
						}
						sql += "TEL_FORNECEDOR LIKE ? ";
					}
					if(fornecedor.getEmail() != null && !fornecedor.getEmail().equals("")) {
						if(adicionaWhere) {
							sql+= " WHERE ";
							adicionaWhere = false;
						}else {
							sql+= " AND ";
						}
						sql += "EMAIL_FORNECEDOR LIKE ? ";
					}
				}
				
				System.out.println(sql);
				
				PreparedStatement ps = null;
				ResultSet rs = null;
				
				try {
					ps = ConexaoMySQL.getConexao().prepareStatement(sql);
					
					int indice = 0;
					
					if(fornecedor != null) {
						if(fornecedor.getCodigoFornecedor() != null) {
							indice = indice + 1;
							ps.setLong(indice, fornecedor.getCodigoFornecedor());
						}
						if(fornecedor.getRazaoSocial() != null && !fornecedor.getRazaoSocial().equals("")) {
							indice = indice + 1;
							ps.setString(indice, fornecedor.getRazaoSocial() + "%");
						}
						if(fornecedor.getCnpj() != null && !fornecedor.getCnpj().equals("")) {
							indice = indice + 1;
							ps.setString(indice, fornecedor.getCnpj() + "%");
						}
						if(fornecedor.getEmail() != null && !fornecedor.getEmail().equals("")) {
							indice = indice + 1;
							ps.setString(indice, fornecedor.getEmail() + "%");
						}
					}
					
					rs = ps.executeQuery();
					
					while(rs.next()) {
						FornecedorEntity FornecedorResultado = new FornecedorEntity();
						FornecedorResultado.setCodigoFornecedor(rs.getLong("ID_FORNECEDOR"));
						FornecedorResultado.setRazaoSocial(rs.getString("RS_FORNECEDOR"));
						FornecedorResultado.setCnpj(rs.getString("CNPJ_FORNECEDOR"));
						FornecedorResultado.setTelefone(rs.getString("TEL_FORNECEDOR"));
						FornecedorResultado.setEmail(rs.getString("EMAIL_FORNECEDOR"));
						resultado.add(FornecedorResultado);				
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
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
			//INICIO VALIDACAO FORNECEDOR
			
			public FornecedorEntity buscarFornecedorPorRazaoSocial(String razaoSocial) throws NegocioException {
				
				String sql = "SELECT * FROM FORNECEDOR WHERE RS_FORNECEDOR = ?";
				PreparedStatement ps = null;
				ResultSet rs = null;
					try {
						ps = ConexaoMySQL.getConexao().prepareStatement(sql);
						ps.setString(1,razaoSocial);
						rs = ps.executeQuery();
					
					FornecedorEntity fornecedorEncontrado = null;
					
					if(rs.next()){
						fornecedorEncontrado = new FornecedorEntity();
						fornecedorEncontrado.setCodigoFornecedor(rs.getLong("ID_FORNECEDOR"));
						fornecedorEncontrado.setRazaoSocial(rs.getString("RS_FORNECEDOR"));
						fornecedorEncontrado.setCnpj(rs.getString("CNPJ_FORNECEDOR"));
						fornecedorEncontrado.setTelefone(rs.getString("TEL_FORNECEDOR"));
						fornecedorEncontrado.setEmail(rs.getString("EMAIL_FORNECEDOR"));
						
					}
					return fornecedorEncontrado;
			
				}catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
					
		}
			{
	}
		
	}

