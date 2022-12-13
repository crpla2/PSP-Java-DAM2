package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

import model.Persona;

public class DateObjectClientPersona {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		Socket sock= new Socket("192.168.101.100", 3001);
		
		ObjectInputStream entradaObject= new  ObjectInputStream(sock.getInputStream());
		
		Persona p=(Persona) entradaObject.readObject();
		System.out.println(p);
		
	}

}
