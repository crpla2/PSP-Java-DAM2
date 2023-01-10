package servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

import modelo.Mensaje;

public class Receptor extends Thread {
	private Socket sock;
	private ArrayList<Mensaje> listaMensajes;
	public Receptor(Socket sock, ArrayList<Mensaje> listaMensajes) {
		super();
		this.sock = sock;
		this.listaMensajes = listaMensajes;
	}
	@Override
	public void run() {
		ObjectInputStream entrada= null;
		try {
			 entrada= new ObjectInputStream(sock.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true) {
			Mensaje m=null;
		
				try {
					m=(Mensaje) entrada.readObject();
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			synchronized (listaMensajes) {
				listaMensajes.add(m);
				listaMensajes.notifyAll();
			}
		}
	}
	
}
