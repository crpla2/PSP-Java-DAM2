package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
	public static void main(String[] args) throws IOException {

		DatagramSocket dSock = new DatagramSocket(
				3000, InetAddress.getByName("localhost"));// puerto y direccion ip del cliente

		 
		// Creo un paquete vacio en el que quepan 1000 bytes
		DatagramPacket info = new DatagramPacket(new byte[1000], 1000);

		dSock.receive(info);

			System.out.println("Recibido de: "+info.getAddress());
			System.out.println("Por el puerto: "+info.getPort());
			System.out.println("Datos: "+ new String(info.getData()));
	}
}
