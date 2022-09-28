package soap.model;

import java.util.ArrayList;

public class Usuario {

	private String nome;
	private String login;
	private String senha;
	private ArrayList<Tweet> tweets = new ArrayList<>();
	
	public Usuario() {};
	
	public Usuario(String nome, String login, String senha) {
		super();
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome == null || nome.isEmpty()) {
			throw new IllegalArgumentException("Nome deve ser diferente de nulo e não vazio.");
		}
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		if (login == null || login.isEmpty()) {
			throw new IllegalArgumentException("Login deve ser diferente de nulo e não vazio.");
		}
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if (senha == null || senha.isEmpty()) {
			throw new IllegalArgumentException("Senha deve ser diferente de nulo e não vazio.");
		}
		this.senha = senha;
	}

	public ArrayList<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(ArrayList<Tweet> tweets) {
		this.tweets = tweets;
	}
	
	public void addTweet(Tweet tweet) {
		if (tweet != null) {
			this.tweets.add(tweet);
		}
	}
	
	@Override
	public String toString() {
		return "Nome: " + this.nome
				+ " " + "Login:" + " " + this.login;
	}

}
