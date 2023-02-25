package br.com.gestaofarmacia.core.service;

import java.util.List;

import br.com.gestaofarmacia.core.bo.EntradaBO;
import br.com.gestaofarmacia.core.entity.EntradaEntity;
import br.com.gestaofarmacia.core.util.exception.NegocioException;

public class EntradaService {
	
	public String salvarEntrada(EntradaEntity Entrada) throws NegocioException  {
		EntradaBO bo = new EntradaBO();
		return bo.salvarEntrada(Entrada);
}

	public List<EntradaEntity>ListarEntrada() throws NegocioException{
		return new EntradaBO().ListarEntrada();
}
	public void excluirEntrada(Long codigoEntrada) throws NegocioException{
		new EntradaBO().excluirEntrada(codigoEntrada);
}
	//BUSCAR Entrada ID
	public EntradaEntity buscarEntradaPorID(Long codigoEntrada) throws NegocioException{
				return new EntradaBO().buscarEntradaPorID(codigoEntrada);
}
	public String alterarEntrada(EntradaEntity Entrada) throws NegocioException{
		return new EntradaBO().alterarEntrada(Entrada);
}
	public List<EntradaEntity> buscarEntradaFiltrado(EntradaEntity Entrada) throws NegocioException{
		return new EntradaBO().buscarEntradaFiltrado(Entrada);
}


}
	
	

