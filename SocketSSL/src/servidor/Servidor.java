package servidor;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.net.ssl.SSLServerSocketFactory;

//https://chuidiang.org/index.php?title=Socket_SSL_con_Java
public class Servidor {
	public static final int PUERTO = 3333;

	public static void main(String[] args) throws IOException {

		System.setProperty("javax.net.ssl.keyStore", "./almacenes/almacenServidor");
		System.setProperty("javax.net.ssl.keyStorePassword", "123456");
//		System.setProperty("javax.net.ssl.trustStore", "./almacenes/almacenServidor"); NO ES NECESARIO CONFIAR EN EL CLIENTE
//		System.setProperty("javax.net.ssl.trustStorePassword", "123456");

		SSLServerSocketFactory sslFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
		ServerSocket servSock = sslFactory.createServerSocket(PUERTO);

		Socket sock = servSock.accept();

		DataInputStream entrada = new DataInputStream(sock.getInputStream());
		System.out.println(entrada.readUTF());
		entrada.close();
		sock.close();
	}
}
