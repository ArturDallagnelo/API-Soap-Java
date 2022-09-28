package soap;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class UsuarioTweetClient {

	public static void main(String[] args) throws Exception {
		URL url = new URL("http://127.0.0.1:8080/soap?wsdl");
		QName qname = new QName("http://soap/", "UsuarioTweetServerImplService");
		Service ws = Service.create(url, qname);
		UsuarioTweetServer usuarioTweet = ws.getPort(UsuarioTweetServer.class);

		usuarioTweet.createUsuario("Ana", "AnaC", "52a2!");
		usuarioTweet.createUsuario("Maria", "MariaC", "12@34");
		usuarioTweet.createUsuario("Artur", "ArturD", "abg!1");

		System.out.println("Buscando Maria");
		System.out.println(usuarioTweet.getUsuario("MariaC"));
		System.out.println("Buscando Artur");
		System.out.println(usuarioTweet.getUsuario("ArturD"));
	
		System.out.println("Todos os us�rios");
		System.out.println(usuarioTweet.getAllUsuarios());
		
		System.out.println("Deletando Maria");
		usuarioTweet.deleteUsuario("MariaC");
		
		System.out.println("Todos os usu�rios");
		System.out.println(usuarioTweet.getAllUsuarios());
		
		System.out.println("Atualizando Artur");
		usuarioTweet.updateUsuario("ArturD", "Artur D D", "teste2", "teste2");
		
		usuarioTweet.createTweet("aaaa", usuarioTweet.getUsuario("AnaC"));

		System.out.println("Buscando o tweet aaaa");
		System.out.println(usuarioTweet.getTweet("aaaa", usuarioTweet.getUsuario("AnaC")));
		
		System.out.println("Todos os Tweets");
		System.out.println(usuarioTweet.getAllTweets());
		
		System.out.println("Deletando o tweet aaaa");
		usuarioTweet.deleteTweet("aaaa", usuarioTweet.getUsuario("AnaC"));
		
		System.out.println("Todos os Tweets");
		System.out.println(usuarioTweet.getAllTweets());
		

	}
}
