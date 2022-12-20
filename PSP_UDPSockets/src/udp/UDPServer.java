package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
	public static void main(String[] args) throws IOException {
	
		DatagramSocket dSock= new DatagramSocket(
				3001,InetAddress.getByName("localhost"));//puerto y direccion ip servidor
		
	//El servidor enviía informacion
		//Clase ÇDatagram packet rellena con la info del cliente
		
		String mensaje= "Hola mundóo";
		//Datos de la conexion referidos al receptor
		//en este caso coinciden
		DatagramPacket info= new DatagramPacket(mensaje.getBytes("UTF-8"),
												mensaje.getBytes().length, 
												InetAddress.getByName("localhost"), 
												3000);
	
		dSock.send(info);
	}
}
