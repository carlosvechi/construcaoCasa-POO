package modelo;

public abstract class Aberturas {

	protected String descricao;
	protected String estado;
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado (String novoEstado)	{
		this.estado = novoEstado;
	}

	
}
