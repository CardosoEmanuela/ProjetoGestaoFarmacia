package br.com.gestaofarmacia.core.service;

import java.util.List;

import br.com.gestaofarmacia.core.bo.VendaBO;
import br.com.gestaofarmacia.core.entity.VendaEntity;
import br.com.gestaofarmacia.core.util.exception.NegocioException;

public class VendaService {
	
	public String salvarVenda(VendaEntity Venda) throws NegocioException  {
		VendaBO bo = new VendaBO();
		return bo.salvarVenda(Venda);
}

	public List<VendaEntity>ListarVenda() throws NegocioException{
		return new VendaBO().ListarVenda();

}

}
