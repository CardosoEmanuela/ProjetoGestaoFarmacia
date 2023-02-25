package br.com.gestaofarmacia.core.entity;

public class EntradaEntity {
	
	private Long codigoEntrada;
	private String dataEntrada;
	private String razaoSocial;
	private Long codigoProduto;
	private String nomeProduto;
	private int quantidade;
	private double custoUnitario;
	private double custoTotal;
	private double valorVenda;
	
	
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public Long getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProdutoString) {
		this.nomeProduto = nomeProdutoString;
	}
	public Long getCodigoEntrada() {
		return codigoEntrada;
	}
	public void setCodigoEntrada(Long codigoEntrada) {
		this.codigoEntrada = codigoEntrada;
	}
	public String getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getCustoUnitario() {
		return custoUnitario;
	}
	public void setCustoUnitario(double custoUnitario) {
		this.custoUnitario = custoUnitario;
	}
	public double getCustoTotal() {
		return custoTotal;
	}
	public void setCustoTotal(double custoTotal) {
		this.custoTotal = custoTotal;
	}
	public double getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	} 
	
	
		}
	
	

