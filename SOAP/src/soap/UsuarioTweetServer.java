package soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import soap.model.Tweet;
import soap.model.Usuario;

@WebService
@SOAPBinding(style = Style.RPC)
public interface UsuarioTweetServer {

	@WebMethod
	void createUsuario(String nome, String login, String senha);

	@WebMethod
	Usuario getUsuario(String login);

	@WebMethod
	String getAllUsuarios();

	@WebMethod
	void updateUsuario(String loginUsuario, String nome, String login, String senha);

	@WebMethod
	void deleteUsuario(String login);

	@WebMethod
	void createTweet(String texto, Usuario usuario);

	@WebMethod
	Tweet getTweet(String texto, Usuario usuario);

	@WebMethod
	String getAllTweets();

	@WebMethod
	void updateTweet(String texto, Usuario usuario);

	@WebMethod
	void deleteTweet(String texto, Usuario usuario);

}