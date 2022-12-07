import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
	
	
		Socket sock = new Socket("192.168.101.11", 3000);
		
		
		System.out.println("[Cliente] conectado con " + sock.getInetAddress());
		
		HiloTeclado ht= new HiloTeclado(sock);
		ht.start();

		DataInputStream entrada = new DataInputStream(sock.getInputStream());
		
		String mensaje=entrada.readUTF();
		while (!mensaje.equals("Q")) {
			System.out.println(mensaje);		
			mensaje=entrada.readUTF();
			}
			entrada.close();
			sock.close();
			
			
		
	}

}
