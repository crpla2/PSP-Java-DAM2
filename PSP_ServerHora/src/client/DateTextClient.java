package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

public class DateTextClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//Socket directo sin timeout
		//Socket sock= new Socket("localhost", server.DateTextServer.PORT);
		
		//Socket paso a paso
		//Preparo el socket
		Socket sock= new Socket();
		SocketAddress sockAddr = new InetSocketAddress("192.168.101.100",server.DateTextServer.PORT);
		//Intento conexion estableciendo un timeout de 6 segundos
		sock.connect(sockAddr,6000);
		
		DataInputStream entrada= new DataInputStream(sock.getInputStream());
		
		String fecha= entrada.readUTF();
		System.out.println(fecha);
		entrada.close();
		sock.close();
	
	}

}
