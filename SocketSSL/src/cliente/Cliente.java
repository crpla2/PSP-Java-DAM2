package cliente;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.net.ssl.SSLSocketFactory;

import servidor.Servidor;

//https://chuidiang.org/index.php?title=Socket_SSL_con_Java
public class Cliente {
	
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		
//		System.setProperty("javax.net.ssl.keyStore", "./almacenes/almacenCliente");
//		System.setProperty("javax.net.ssl.keyStorePassword","123456");
		System.setProperty("javax.net.ssl.trustStore", "./almacenes/almacenCliente");//EL CLIENTE TIENE QUE CONFIAR EN EL SERVIDOR
		System.setProperty("javax.net.ssl.trustStorePassword", "123456");
		
		SSLSocketFactory sslFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
//		Socket sock = sslFactory.createSocket("localhost",Servidor.PUERTO);
//		Socket sock = sslFactory.createSocket("192.168.101.11",Servidor.PUERTO); //DANI
		Socket sock = sslFactory.createSocket("192.168.101.100",4321); //TEO
		
		
		DataOutputStream salida= new DataOutputStream(sock.getOutputStream());
		salida.writeUTF("Hola Servidor Carlos");
		Thread.sleep(1000);
		salida.close();
	//	sock.close();
		
	}

}
