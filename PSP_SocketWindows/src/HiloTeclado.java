import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class HiloTeclado extends Thread {
	Socket sock;

	
	
	public HiloTeclado(Socket sock) {
		super();
		this.sock = sock;
	}



	@Override
	public void run() {
		Scanner teclado =new Scanner(System.in);
		DataOutputStream salida = null;
		try {
			salida=new DataOutputStream(sock.getOutputStream());
		} catch (IOException e) {
			System.err.println("Error abriendo el canal de salida");
			e.printStackTrace();
		}
		String mensaje= teclado.nextLine();
		while (!mensaje.equals("Q")){
			try {
				salida.writeUTF(mensaje);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mensaje= teclado.nextLine();
		}
		System.out.println("Recibido mensaje de salida");
		try {
			salida.close();
		} catch (IOException e) {
			System.err.println("Error cerrando el canal de salida");
			e.printStackTrace();
		}
		try {
			sock.close();
		} catch (IOException e) {
			System.err.println("Error cerrando el socket");
			e.printStackTrace();
		}
		
	}
	

}
