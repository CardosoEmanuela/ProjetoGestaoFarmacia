package br.com.gestaofarmacia.core.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gestaofarmacia.core.bo.VendaBO;
import br.com.gestaofarmacia.core.dao.connection.ConexaoMySQL;
import br.com.gestaofarmacia.core.entity.VendaEntity;
import br.com.gestaofarmacia.core.util.exception.NegocioException;

public class VendaDAO {
	
		public String salvarVenda(VendaEntity Venda) throws NegocioException {
			String sql = "INSERT INTO VENDA(ID_PRODUTO,CLIENTE_VENDA, NM_PRODUTO,QUANT_PRODUTO, VALORVENDA_ENTRADA, VALORTOTALITEM_VENDA,DESC_VENDA,TOTALPG_VENDA, FORMA_VENDA, RECEBIDO_VENDA, TROCO_VENDA)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = null;
		
			try {
				ps = ConexaoMySQL.getConexao().prepareStatement(sql);
					ps.setLong(1, Venda.getCodigoProduto());
					ps.setString(2, Venda.getCliente());
					ps.setString(3, Venda.getNomeProduto());
					ps.setInt(4, Venda.getQuantidade());
					ps.setDouble(5, Venda.getValorVenda());
					ps.setDouble(6, Venda.getValorItem());
					ps.setDouble(7, Venda.getTotalCompra());
					ps.setInt(8, Venda.getDesconto());
					ps.setDouble(8, Venda.getTotalPagar());
					ps.setString(10, Venda.getFormaPagamento());
					ps.setDouble(11, Venda.getValorRecebido());
					ps.setDouble(12, Venda.getTroco());
					
					
					
				
					ps.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new NegocioException("Erro ao cadastrar Venda");
			} finally {
				if(ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
			}
			
			
			//Quando aprender implementar o cadastro dessa informação no banco de dados
			return "Venda cadastrado com sucesso no banco de dados";
				}
			}
			return sql;
			//INICIO LISTA DE VendaS
	}
		public List<VendaEntity>ListarVenda() throws NegocioException{
			String sql = "SELECT ID_VENDA, ID_PRODUTO,CLIENTE_VENDA,NM_PRODUTO,QUANT_PRODUTO, VALORVENDA_ENTRADA, VALORTOTALITEM_VENDA,DESC_VENDA,TOTALPG_VENDA, FORMA_VENDA, RECEBIDO_VENDA, TROCO_VENDA FROM VENDA";
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<VendaEntity>Vendas= new ArrayList<VendaEntity>();
			try {
				ps = ConexaoMySQL.getConexao().prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()) {
				VendaEntity vend = new VendaEntity();
				vend.setCodigoVenda(rs.getLong("ID_VENDA"));
				vend.setCodigoProduto(rs.getLong("ID_PRODUTO"));
				vend.setNomeProduto(rs.getString("NM_PRODUTO"));
				vend.setQuantidade(rs.getInt("QUANT_PRODUTO"));
				vend.setValorVenda(rs.getDouble("VALORVENDA_ENTRADA"));
				vend.setValorItem(rs.getDouble("VALORTOTALITEM_VENDA"));
				vend.setTotalCompra(rs.getDouble("TOTALCOMP_VENCIDA"));
				vend.setDesconto(rs.getInt("DESC_VENDA"));
				vend.setTotalPagar(rs.getDouble("TOTALPG_VENDA"));
				vend.setFormaPagamento(rs.getString("FORMA_VENDA"));
				vend.setValorRecebido(rs.getDouble("RECEBIDO_VENDA"));
				vend.setTroco(rs.getDouble("TROCO_VENDA"));
				Vendas.add(vend);
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			throw new NegocioException("Erro ao listar os Vendas");
		} finally {
			try {
			ps.close();
		//	rs.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
			return Vendas;	
		}
}
