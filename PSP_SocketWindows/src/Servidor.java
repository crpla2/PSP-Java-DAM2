import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException, InterruptedException {
		ServerSocket servSock = new ServerSocket(3000);
		Socket sock = servSock.accept();
		System.out.println("[Servidor] Esperando conexion...");
		System.out.println("[Servidor] Conectado con" + sock.getInetAddress());
		
		HiloTeclado ht= new HiloTeclado(sock);
		ht.start();
		
		DataInputStream entrada= new DataInputStream(sock.getInputStream());
		
		String mensaje=entrada.readUTF();
		while (!mensaje.equals("Q")) {
			System.out.println("[Cliente]:"+mensaje);		
			mensaje=entrada.readUTF();
			}
			entrada.close();
			sock.close();
	}

}
