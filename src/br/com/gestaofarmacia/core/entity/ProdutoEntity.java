package br.com.gestaofarmacia.core.entity;

import java.util.Objects;

public class ProdutoEntity {
	
	private Long codigoProduto;
	private String nomeProduto;
	private String dosagem;
	private String viaMedicacao;
	
	public Long getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getDosagem() {
		return dosagem;
	}
	public void setDosagem(String miligrama) {
		this.dosagem = miligrama;
	}
	public String getViaMedicacao() {
		return viaMedicacao;
	}
	public void setViaMedicacao(String viaMedicacao) {
		this.viaMedicacao = viaMedicacao;
	}
	@Override
	public int hashCode() {
		return Objects.hash(codigoProduto);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoEntity other = (ProdutoEntity) obj;
		return Objects.equals(codigoProduto, other.codigoProduto);
	}
	
	

}
