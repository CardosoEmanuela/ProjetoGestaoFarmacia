package br.com.gestaofarmacia.core.entity;

import java.util.Objects;

public class GrupoUsuarioEntity {
	
	private Long codigo;
	private String nomeGrupo;
	
	public GrupoUsuarioEntity(long long1, String string) {
		// TODO Auto-generated constructor stub
	}
	public GrupoUsuarioEntity(Long codigo, String nomeGrupo) {
		super();
		this.codigo = codigo;
		this.nomeGrupo = nomeGrupo;
	}
	public GrupoUsuarioEntity() {
		// TODO Auto-generated constructor stub
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNomeGrupo() {
		return nomeGrupo;
	}
	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrupoUsuarioEntity other = (GrupoUsuarioEntity) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	
}


