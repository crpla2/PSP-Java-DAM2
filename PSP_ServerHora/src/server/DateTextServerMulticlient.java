package server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateTextServerMulticlient {

	public final static int PORT = 3001;

	public static void main(String[] args) throws IOException {

		ServerSocket servSock = new ServerSocket(PORT);

		Socket sock;
		while (true) {

			sock = servSock.accept();
			DataOutputStream salida = new DataOutputStream(sock.getOutputStream());
			Date fecha = new Date();
			//Simulamos un retardo en el cálculo
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			
			salida.writeUTF(String.valueOf(fecha.toString()));
			salida.close();
			sock.close();
			
		}

	}
}
