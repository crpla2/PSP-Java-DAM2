package servidor;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import modelo.Mensaje;

public class Emisor extends Thread {
	private Socket sock;
	private ArrayList<Mensaje> listaMensajes;

	public Emisor(Socket sock, ArrayList<Mensaje> listaMensajes) {
		super();
		this.sock = sock;
		this.listaMensajes = listaMensajes;
	}

	@Override
	public void run() {
		// inicializar la salida
		ObjectOutputStream salida = null;

		try {
			salida = new ObjectOutputStream(sock.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// while true
		Mensaje m = null;
		while (true) {
			synchronized (listaMensajes) {
				// esperar notificacion(sincronizadamente)
				try {
					listaMensajes.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// coger el ultimo mensaje(sincronizadamente)
				m = listaMensajes.get(listaMensajes.size() - 1);
			}
			// enviarlo por la salida
			try {
				salida.writeObject(m);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
