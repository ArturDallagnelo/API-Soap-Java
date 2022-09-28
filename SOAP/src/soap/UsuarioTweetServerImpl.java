package soap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.jws.WebService;

import soap.model.Tweet;
import soap.model.Usuario;

@WebService(endpointInterface = "soap.UsuarioTweetServer")
public class UsuarioTweetServerImpl implements UsuarioTweetServer {

	
	private Map<String, Usuario> usuarios = new HashMap<>();
	private ArrayList<Tweet> tweets = new ArrayList<>();
	

	@Override
	public void createUsuario(String nome, String login, String senha) {
		Usuario usuario = new Usuario(nome, login, senha);
		usuarios.put(login, usuario);
	}

	@Override
	public Usuario getUsuario(String login) {
		return usuarios.get(login);
	}

	@Override
	public String getAllUsuarios() {
		String usuariosStr = "";
		for (Usuario usuario : this.usuarios.values()) {
			usuariosStr += usuario + "\n";
		}
		return usuariosStr;
	}

	@Override
	public void updateUsuario(String loginUsuario, String nome, String login, String senha) {
		if (this.usuarios != null && !this.usuarios.isEmpty()) {

			Usuario usuarioArmazenado = this.getUsuario(loginUsuario);

			if (usuarioArmazenado != null) {
				if (nome != null) {
					usuarioArmazenado.setNome(nome);
				}

				if (login != null) {
					usuarioArmazenado.setLogin(login);
				}

				if (senha != null) {
					usuarioArmazenado.setSenha(senha);
				}
			}
		}
	}

	@Override
	public void deleteUsuario(String loginUsuario) {
		this.usuarios.remove(loginUsuario);
	}

	@Override
	public void createTweet(String texto, Usuario usuario) {
		Tweet tweet = new Tweet(usuario, texto);
		tweet.setDataCriacao();
		tweets.add(tweet);
	}

	@Override
	public Tweet getTweet(String texto, Usuario usuario) {
		if (!texto.isEmpty() && usuario != null) {
			for (int i = 0; i <= tweets.size(); i++) {
				Tweet tweet = tweets.get(i);
				if (Objects.equals(tweet.getTexto(), texto)
						&& Objects.equals(tweet.getUsuario().getLogin(), usuario.getLogin())) {
					return tweet;
				}
			}
//			for (Tweet tweet : this.tweets) {
//				if (Objects.equals(tweet.getTexto(), texto)
//						&& Objects.equals(tweet.getUsuario().getLogin(), usuario.getLogin())) {
//					return tweet;
//				}
//			}
		}
		return null;
	}

	@Override
	public String getAllTweets() {
		String tweetsStr = "";
		for (Tweet tweet : this.tweets) {
			tweetsStr += tweet + "\n";
		}
		return tweetsStr;
	}

	@Override
	public void updateTweet(String texto, Usuario usuario) {
		if (!texto.isEmpty() && usuario != null) {
			for (Tweet tweet : this.tweets) {
				if (Objects.equals(tweet.getTexto(), texto)
						&& Objects.equals(tweet.getUsuario().getLogin(), usuario.getLogin())) {
					tweet.setTexto(texto);
				}
			}
		}
	}

	@Override
	public void deleteTweet(String texto, Usuario usuario) {
		if (!texto.isEmpty()) {
			for (int index = 0; index < this.tweets.size(); index++) {
				if (Objects.equals(tweets.get(index).getTexto(), texto)
						&& Objects.equals(tweets.get(index).getUsuario().getLogin(), usuario.getLogin())) {
					this.tweets.remove(index);
				}
			}
//			for (Tweet tweet : this.tweets) {
//				if (Objects.equals(tweet.getTexto(), texto)
//						&& Objects.equals(tweet.getUsuario().getLogin(), usuario.getLogin())) {
//					this.tweets.remove(tweet);
//				}
//			}
		}
	}

}
