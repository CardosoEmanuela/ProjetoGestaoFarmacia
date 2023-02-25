package br.com.gestaofarmacia.core.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gestaofarmacia.core.dao.connection.ConexaoMySQL;
import br.com.gestaofarmacia.core.entity.EntradaEntity;
import br.com.gestaofarmacia.core.util.exception.NegocioException;

public class EntradaDAO {

		public String salvarEntrada(EntradaEntity Entrada) throws NegocioException {
			String sql = "INSERT INTO ENTRADA(DT_ENTRADA,RS_FORNECEDOR,ID_PRODUTO,NM_PRODUTO, QUANT_ENTRADA,CUSTOUNI_ENTRADA, CUSTOTOTAL_ENTRADA, VALORVEND_ENTRADA)VALUES(?,?,?,?,?)";
			PreparedStatement ps = null;
		
			try {
				ps = ConexaoMySQL.getConexao().prepareStatement(sql);
					ps.setString(1, Entrada.getDataEntrada());
					ps.setString(2, Entrada.getRazaoSocial());
					ps.setLong(3, Entrada.getCodigoProduto());
					ps.setString(4, Entrada.getNomeProduto());
					ps.setInt(5, Entrada.getQuantidade());
					ps.setDouble(6, Entrada.getCustoUnitario());
					ps.setDouble(7, Entrada.getCustoTotal());
					ps.setDouble(8, Entrada.getValorVenda());
				
					ps.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new NegocioException("Erro ao cadastrar Entrada");
			} finally {
				if(ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
			}
			
			
			//Quando aprender implementar o cadastro dessa informação no banco de dados
			return "Entrada cadastrado com sucesso no banco de dados";
				}
			}
			return sql;
			//INICIO LISTA DE EntradaS
	}
		public List<EntradaEntity>ListarEntrada() throws NegocioException{
			String sql = "SELECT ID_ENTRADA,DT_ENTRADA,RS_FOENECEDOR,ID_PRODUTO,NM_PRODUTO,QUANT_ENTRADA,CUSTOUNI_ENTRADA, CUSTOTOTAL_ENTRADA, VALORVEND_ENTRADA FROM ENTRADA";
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<EntradaEntity>Entradas= new ArrayList<EntradaEntity>();
			try {
				ps = ConexaoMySQL.getConexao().prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()) {
				EntradaEntity ent = new EntradaEntity();
				ent.setCodigoEntrada(rs.getLong("ID_ENTRADA"));
				ent.setDataEntrada(rs.getString("DT_ENTRADA"));
				ent.setRazaoSocial(rs.getString("RS_FORNECEDOR"));
				ent.setCodigoProduto(rs.getLong("ID_PRODUTO"));
				ent.setNomeProduto(rs.getString("NM_PRODUTO"));
				ent.setQuantidade(rs.getInt("QUANT_ENTRADA"));
				ent.setCustoUnitario(rs.getDouble("CUSTOUNI_ENTRADA"));
				ent.setCustoTotal(rs.getDouble("CUSTOTOTAL_ENTRADA"));
				ent.setValorVenda(rs.getDouble("VALORVEND_ENTRADA"));
				Entradas.add(ent);
				
				//next cada vez que executa retorna uma linha do banco de dados
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			throw new NegocioException("Erro ao listar as Entradas");
		} finally {
			try {
			ps.close();
		//	rs.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
			return Entradas;	
//		INICIO EXCLUIR Entrada
	}
		public void excluirEntrada(Long codigoEntrada) throws NegocioException{
			
			String sql = "DELETE FROM ENTRADA WHERE ID_ENTRADA = ?";
			
			PreparedStatement ps = null;
			
			try {
				ps = ConexaoMySQL.getConexao().prepareStatement(sql);
				ps.setLong(1, codigoEntrada);
				
				ps.execute();
				
			} catch (SQLException e) {
				throw new NegocioException("Não foi possível excluir a Entrada");
			} finally {
				try {
					ps.close();
				}catch (SQLException e) {
					e.printStackTrace();

				}
			
		}
	}
		//INICIO BUSCAR Entrada
			
			public EntradaEntity buscarEntradaPorID(Long codigoEntrada) throws NegocioException {
			
			String sql = "SELECT ID_ENTRADA,DT_ENTRADA,RS_FORNECEDOR,ID_PRODUTO, NM_PRODUTO, QUANT_ENTRADA,CUSTOUNI_ENTRADA, CUSTOTOTAL_ENTRADA, VALORVEND_ENTRADA  FROM ENTRADA WHERE ID_ENTRADA = ?";
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = ConexaoMySQL.getConexao().prepareStatement(sql);
				//SUBSTITUIÇÃO ? PARA O PARAMETRO DO METODO DO COMANDO SQL
				ps.setLong(1,codigoEntrada);
				rs = ps.executeQuery();
				
				EntradaEntity EntradaEncontrada = null;
				
				if(rs.next()); {
					EntradaEncontrada = new EntradaEntity();
					EntradaEncontrada.setDataEntrada(rs.getString("DT_ENTRADA"));
					EntradaEncontrada.setRazaoSocial(rs.getString("RS_FORNECEDOR"));
					EntradaEncontrada.setCodigoProduto(rs.getLong("ID_PRODUTO"));
					EntradaEncontrada.setNomeProduto(rs.getString("NM_PRODUTO"));					
					EntradaEncontrada.setQuantidade(rs.getInt("QUANT_ENTRADA"));
					EntradaEncontrada.setCustoUnitario(rs.getDouble("CUSTOUNI_ENTRADA"));
					EntradaEncontrada.setCustoTotal(rs.getDouble("CUSTOTOTAL_ENTRADA"));
					EntradaEncontrada.setValorVenda(rs.getDouble("VALORVEND_ENTRADA"));
					
					
				}
				return EntradaEncontrada;
				
			} catch (SQLException e) {
			throw new NegocioException("Houve um erro ao buscar Entrada");
			
		} finally {
			try {
				ps.close();
				rs.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
			}
		//INICIO EDITAR Entrada
			
			public String alterarEntrada(EntradaEntity Entrada) throws NegocioException{
				
				String sql = "UPDATE ENTRADA SET DS_Entrada = ?, RS_FONECEDOR, ID_PRODUTO, NM_PRODUTO,QUANT_ENTRADA,CUSTOUNI_ENTRADA, CUSTOTOTAL_ENTRADA, VALORVEND_ENTRADA  = ? WHERE ID_ENTRADA = ?";
				PreparedStatement ps = null;
				
				try {
					ps = ConexaoMySQL.getConexao().prepareStatement(sql);
					ps.setString(1, Entrada.getDataEntrada());
					ps.setString(2, Entrada.getRazaoSocial());
					ps.setLong(3, Entrada.getCodigoProduto());
					ps.setString(4, Entrada.getNomeProduto());
					ps.setInt(5, Entrada.getQuantidade());
					ps.setDouble(6, Entrada.getCustoUnitario());
					ps.setDouble(7, Entrada.getCustoTotal());
					ps.setDouble(8, Entrada.getValorVenda());
					
					
					ps.execute();
					
				} catch (SQLException e) {
					throw new NegocioException("Ocorreu um erro ao atualizar os dados do Entrada");
				} finally {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				return "O Entrada foi alterado com sucesso";
			
		}
			public List<EntradaEntity> buscarEntradaFiltrado(EntradaEntity Entrada) throws NegocioException{
				
				String sql = "SELECT ID_ENTRADA,DS_ENTRADA FROM ENTRADA";
				
				boolean adicionaWhere = true;
				
				List<EntradaEntity> resultado = new ArrayList<EntradaEntity>();
				
				if(Entrada != null) {
					if(Entrada.getCodigoEntrada() != null) {
						adicionaWhere = false;
						sql += " WHERE ";
						sql += "ID_Entrada = ? ";
					}
					if(Entrada.getDataEntrada() != null && !Entrada.getDataEntrada().equals("")) {
						if(adicionaWhere) {
							sql+= " WHERE ";
							adicionaWhere = false;
						}else {
							sql+= " AND ";
						}
						sql += "DT_ENTRADA LIKE ? ";
					}
					
				}
				
				System.out.println(sql);
				
				PreparedStatement ps = null;
				ResultSet rs = null;
				
				try {
					ps = ConexaoMySQL.getConexao().prepareStatement(sql);
					
					int indice = 0;
					
					if(Entrada.getCodigoEntrada() != null && !Entrada.getCodigoEntrada().equals("")) {
						indice = indice + 1;
						ps.setString(indice, Entrada.getCodigoEntrada() + "%");
					
				}
						if(Entrada.getDataEntrada() != null && !Entrada.getDataEntrada().equals("")) {
							indice = indice + 1;
							ps.setString(indice, Entrada.getDataEntrada() + "%");
					
					}
					
					rs = ps.executeQuery();
					
					while(rs.next()) {
						EntradaEntity EntradaResultado = new EntradaEntity();
						EntradaResultado.setDataEntrada(rs.getString("DT_ENTRADA"));
						EntradaResultado.setRazaoSocial(rs.getString("RS_FORNECEDOR"));
						EntradaResultado.setCodigoProduto(rs.getLong("ID_PRODUTO"));
						EntradaResultado.setNomeProduto(rs.getString("NM_PRODUTO"));		
						EntradaResultado.setQuantidade(rs.getInt("QUANT_ENTRADA"));
						EntradaResultado.setCustoUnitario(rs.getDouble("CUSTOUNI_ENTRADA"));
						EntradaResultado.setCustoTotal(rs.getDouble("CUSTOTOTAL_ENTRADA"));
						EntradaResultado.setValorVenda(rs.getDouble("VALORVEND_ENTRADA"));
						resultado.add(EntradaResultado);				
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

			
			
		

		





