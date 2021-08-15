package dev.ramide.tarefas.modelo;

public class Usuario {

	private Integer id;
	private String primeiroNome;
	private String ultimoNome;
	private String usuario;
	private String senha;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String segundoNome) {
		this.ultimoNome = segundoNome;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean ehIgual(String usuario, String senha) {
		if (!this.usuario.equals(usuario)) {
			return false;
		}

		if (!this.senha.equals(senha)) {
			return false;
		}

		return true;
	}

}
