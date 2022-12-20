package multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MCastSender {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket= new DatagramSocket();
		
		InetAddress ipGrupo= InetAddress.getByName("224.0.0.1");
		
		String mensaje = "Hola grupo multicast Carlos";
		
		DatagramPacket info= new DatagramPacket(mensaje.getBytes(), mensaje.length(), ipGrupo, 3000);
		socket.send(info);
		socket.close();
	}
}
