package br.com.gestaofarmacia.core.bo;

import java.util.List;

import br.com.gestaofarmacia.core.dao.EntradaDAO;
import br.com.gestaofarmacia.core.entity.EntradaEntity;
import br.com.gestaofarmacia.core.util.exception.NegocioException;

public class EntradaBO {

		public String salvarEntrada(EntradaEntity Entrada)  throws NegocioException {

		
			if(Entrada.getDataEntrada()!= null && Entrada.getDataEntrada().equals("")) { 
//				if (Entrada.getQuantidade()!= null && Entrada.getQuantidade().equals("")) {
//					if	(Entrada.getCustoUnitario()!= null && Entrada.getCustoUnitario().equals("")) {
//							if	(Entrada.getValorVenda()!= null && Entrada.getValorVenda().equals("")) {
//						}
							
						
				throw new NegocioException("Todos os dados da Entrada precisam ser preenchido"); 
					}
		
//			}
			
			EntradaDAO edao = new EntradaDAO();
				return edao.salvarEntrada(Entrada);
}
				public List<EntradaEntity>ListarEntrada() throws NegocioException{
					return new EntradaDAO().ListarEntrada();
	}
				public void excluirEntrada(Long codigoEntrada) throws NegocioException{
					new EntradaDAO().excluirEntrada(codigoEntrada);
	}
	//BUSCAR Entrada ID
				public EntradaEntity buscarEntradaPorID(Long codigoEntrada) throws NegocioException{
					return new EntradaDAO().buscarEntradaPorID(codigoEntrada);
	}

	//EDITAR Entrada
				public String alterarEntrada(EntradaEntity Entrada) throws NegocioException{
					return new EntradaDAO().alterarEntrada(Entrada);
	}
				public List<EntradaEntity> buscarEntradaFiltrado(EntradaEntity Entrada) throws NegocioException{
					return new EntradaDAO().buscarEntradaFiltrado(Entrada);
							}
	}
		


