package br.com.gestaofarmacia.core.bo;

import java.util.List;

import br.com.gestaofarmacia.core.dao.VendaDAO;
import br.com.gestaofarmacia.core.entity.VendaEntity;
import br.com.gestaofarmacia.core.util.exception.NegocioException;

public class VendaBO {

		public String salvarVenda(VendaEntity Venda)  throws NegocioException {
			
			VendaDAO pdao = new VendaDAO();
				return pdao.salvarVenda(Venda);
					
						
		}
				public List<VendaEntity>ListarVenda() throws NegocioException{
					return new VendaDAO().ListarVenda();
	}
	
	}
