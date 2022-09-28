package soap;

import javax.xml.ws.Endpoint;

public class UsuarioTweetPublisher {
	
	public static void main(String[] args) {
		Endpoint.publish("http://127.0.0.1:8080/soap", new UsuarioTweetServerImpl());
	}
}
