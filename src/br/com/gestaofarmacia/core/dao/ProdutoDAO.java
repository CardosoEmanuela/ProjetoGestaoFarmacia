package br.com.gestaofarmacia.core.dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gestaofarmacia.core.dao.connection.ConexaoMySQL;
import br.com.gestaofarmacia.core.entity.ProdutoEntity;
import br.com.gestaofarmacia.core.entity.UsuarioEntity;
import br.com.gestaofarmacia.core.entity.ProdutoEntity;
import br.com.gestaofarmacia.core.util.exception.NegocioException;


public class ProdutoDAO {

	public String salvarProduto(ProdutoEntity produto) throws NegocioException {
		String sql = "INSERT INTO PRODUTO(NM_PRODUTO,DS_PRODUTO,VIA_PRODUTO)VALUES(?,?,?)";
		PreparedStatement ps = null;
	
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
				ps.setString(1, produto.getNomeProduto());
				ps.setString(2, produto.getDosagem());
				ps.setString(3, produto.getViaMedicacao());
				
			
				ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao cadastrar produto");
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
		}
		
		
		//Quando aprender implementar o cadastro dessa informação no banco de dados
		return "Produto cadastrado com sucesso no banco de dados";
			}
		}
		return sql;
		//INICIO LISTA DE PRODUTOS
}
	public List<ProdutoEntity>ListarProduto() throws NegocioException{
		String sql = "SELECT ID_PRODUTO, NM_PRODUTO, DS_PRODUTO, VIA_PRODUTO FROM PRODUTO";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProdutoEntity>produtos= new ArrayList<ProdutoEntity>();
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
			ProdutoEntity pro = new ProdutoEntity();
			pro.setCodigoProduto(rs.getLong("ID_PRODUTO"));
			pro.setNomeProduto(rs.getString("NM_PRODUTO"));
			pro.setDosagem(rs.getString("DS_PRODUTO"));
			pro.setViaMedicacao(rs.getString("VIA_PRODUTO"));
			produtos.add(pro);
			
			//next cada vez que executa retorna uma linha do banco de dados
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		throw new NegocioException("Erro ao listar os produtos");
	} finally {
		try {
		ps.close();
	//	rs.close();
		} catch (SQLException e) {				
			e.printStackTrace();
		}
	}
		return produtos;
	}
		//INICIO VALIDACAO USUARIO
		
		public ProdutoEntity buscarUsuarioPorLogin(String nomeProduto) throws NegocioException {
			
			String sql = "SELECT * FROM USUARIO WHERE NM_PRODUTO = ?";
			PreparedStatement ps = null;
			ResultSet rs = null;
				try {
					ps = ConexaoMySQL.getConexao().prepareStatement(sql);
					ps.setString(1,nomeProduto);
					rs = ps.executeQuery();
				
				ProdutoEntity produtoEncontrado = null;
				
				if(rs.next()){
					produtoEncontrado = new ProdutoEntity();
					produtoEncontrado.setCodigoProduto(rs.getLong("ID_PRODUTO"));
					produtoEncontrado.setNomeProduto(rs.getString("NM_PRODUTO"));
					produtoEncontrado.setDosagem(rs.getString("DS_PRODUTO"));
					produtoEncontrado.setViaMedicacao(rs.getString("VIA_MEDICACAO"));
					
				}
				return produtoEncontrado;
		
			}catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			
//	INICIO EXCLUIR PRODUTO
}
	public void excluirProduto(Long codigoProduto) throws NegocioException{
		
		String sql = "DELETE FROM PRODUTO WHERE ID_PRODUTO = ?";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setLong(1, codigoProduto);
			
			ps.execute();
			
		} catch (SQLException e) {
			throw new NegocioException("Não foi possível excluir o Produto");
		} finally {
			try {
				ps.close();
			}catch (SQLException e) {
				e.printStackTrace();

			}
		
	}
}
	//INICIO BUSCAR PRODUTO
		
		public ProdutoEntity buscarProdutoPorID(Long codigoProduto) throws NegocioException {
		
		String sql = "SELECT ID_PRODUTO, NM_PRODUTO,DS_PRODUTO,VIA_PRODUTO FROM PRODUTO WHERE ID_PRODUTO = ?";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			//SUBSTITUIÇÃO ? PARA O PARAMETRO DO METODO DO COMANDO SQL
			ps.setLong(1,codigoProduto);
			rs = ps.executeQuery();
			
			ProdutoEntity produtoEncontrado = null;
			
			if(rs.next()); {
				produtoEncontrado = new ProdutoEntity();
				produtoEncontrado.setCodigoProduto(rs.getLong("ID_PRODUTO"));
				produtoEncontrado.setNomeProduto(rs.getString("NM_PRODUTO"));
				produtoEncontrado.setDosagem(rs.getString("DS_PRODUTO"));
				produtoEncontrado.setViaMedicacao(rs.getString("VIA_PRODUTO"));
				
			}
			return produtoEncontrado;
			
		} catch (SQLException e) {
		throw new NegocioException("Houve um erro ao buscar produto");
		
	} finally {
		try {
			ps.close();
			rs.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
		}
	//INICIO EDITAR PRODUTO
		
		public String alterarProduto(ProdutoEntity produto) throws NegocioException{
			
			String sql = "UPDATE PRODUTO SET NM_PRODUTO = ?, DS_PRODUTO = ?, VIA_PRODUTO = ? WHERE ID_PRODUTO = ?";
			PreparedStatement ps = null;
			
			try {
				ps = ConexaoMySQL.getConexao().prepareStatement(sql);
				ps.setString(1, produto.getNomeProduto());
				ps.setString(2, produto.getDosagem());
				ps.setString(3, produto.getViaMedicacao());
				ps.setLong(4, produto.getCodigoProduto());
				
				
				ps.execute();
				
			} catch (SQLException e) {
				throw new NegocioException("Ocorreu um erro ao atualizar os dados do Produto");
			} finally {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			return "O produto foi alterado com sucesso";
		
	}
		public List<ProdutoEntity> buscarProdutoFiltrado(ProdutoEntity Produto) throws NegocioException{
			
			String sql = "SELECT ID_PRODUTO, NM_PRODUTO, DS_PRODUTO, VIA_PRODUTO FROM PRODUTO";
			
			boolean adicionaWhere = true;
			
			List<ProdutoEntity> resultado = new ArrayList<ProdutoEntity>();
			
			if(Produto != null) {
				if(Produto.getCodigoProduto() != null) {
					adicionaWhere = false;
					sql += " WHERE ";
					sql += "ID_PRODUTO = ? ";
				}
				if(Produto.getNomeProduto() != null && !Produto.getNomeProduto().equals("")) {
					if(adicionaWhere) {
						sql+= " WHERE ";
						adicionaWhere = false;
					}else {
						sql+= " AND ";
					}
					sql += "NM_PRODUTO LIKE ? ";
				}
				if(Produto.getDosagem() != null && !Produto.getDosagem().equals("")) {
					if(adicionaWhere) {
						sql+= " WHERE ";
						adicionaWhere = false;
					}else {
						sql+= " AND ";
					}
					sql += "DS_PRODUTO LIKE ? ";
				}
				if(Produto.getViaMedicacao() != null && !Produto.getViaMedicacao().equals("")) {
					if(adicionaWhere) {
						sql+= " WHERE ";
						adicionaWhere = false;
					}else {
						sql+= " AND ";
					}
					sql += "VIA_PRODUTO LIKE ? ";
				}
			}
			
			System.out.println(sql);
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				ps = ConexaoMySQL.getConexao().prepareStatement(sql);
				
				int indice = 0;
				
				if(Produto != null) {
					if(Produto.getCodigoProduto() != null) {
						indice = indice + 1;
						ps.setLong(indice, Produto.getCodigoProduto());
					}
					if(Produto.getNomeProduto() != null && !Produto.getNomeProduto().equals("")) {
						indice = indice + 1;
						ps.setString(indice, Produto.getNomeProduto() + "%");
					}
					if(Produto.getDosagem() != null && !Produto.getDosagem().equals("")) {
						indice = indice + 1;
						ps.setString(indice, Produto.getDosagem() + "%");
					}
					if(Produto.getViaMedicacao() != null && !Produto.getViaMedicacao().equals("")) {
						indice = indice + 1;
						ps.setString(indice, Produto.getViaMedicacao() + "%");
					}
				}
				
				rs = ps.executeQuery();
				
				while(rs.next()) {
					ProdutoEntity ProdutoResultado = new ProdutoEntity();
					ProdutoResultado.setCodigoProduto(rs.getLong("ID_PRODUTO"));
					ProdutoResultado.setNomeProduto(rs.getString("NM_PRODUTO"));
					ProdutoResultado.setDosagem(rs.getString("DS_PRODUTO"));
					ProdutoResultado.setViaMedicacao(rs.getString("VIA_PRODUTO"));
					resultado.add(ProdutoResultado);				
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

		
		
	

	


