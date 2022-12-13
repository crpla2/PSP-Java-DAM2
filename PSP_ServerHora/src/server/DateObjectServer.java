package server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import model.Persona;

public class DateObjectServer {

	public static void main(String[] args) throws IOException {
		ServerSocket servSock= new ServerSocket(3001);
		Socket sock= servSock.accept();
		
		ObjectOutputStream salidaobjeto= new ObjectOutputStream(sock.getOutputStream());
		
		//salidaobjeto.writeObject(new Date());
		salidaobjeto.writeObject(new Persona("Juan",33));
		
		
		salidaobjeto.close();
		sock.close();
		servSock.close();
	}

}
