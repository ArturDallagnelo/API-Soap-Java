package soap.model;

import java.util.Date;

public class Tweet {

	private Usuario usuario;
	private String texto;
	private Date dataCriacao;

	public Tweet() {};
	
	public Tweet(Usuario usuario, String texto) {
		super();
		this.usuario = usuario;
		this.texto = texto;
		this.dataCriacao = new Date();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getDataCriacao() {
		if (this.dataCriacao == null) {
			setDataCriacao();
		}
		return dataCriacao;
	}

	public void setDataCriacao() {
		Date data = new Date();
		this.dataCriacao = data;
	}

	@Override
	public String toString() {
		return "Tweet: " +  this.getTexto()
				+ " do " + this.getUsuario()
				+ " Criado em: " + this.getDataCriacao();
	}
	
}
