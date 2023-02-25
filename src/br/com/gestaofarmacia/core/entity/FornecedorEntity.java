package br.com.gestaofarmacia.core.entity;

public class FornecedorEntity {

	private Long codigoFornecedor;
	private String razaoSocial;
	private String cnpj;
	private String telefone;
	private String email;
	private String endereco;
	
	public Long getCodigoFornecedor() {
		return codigoFornecedor;
	}
	public void setCodigoFornecedor(Long codigoFornecedor) {
		this.codigoFornecedor = codigoFornecedor;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
