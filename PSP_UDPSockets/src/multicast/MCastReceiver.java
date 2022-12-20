package multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MCastReceiver {
	public static void main(String[] args) throws IOException {

		MulticastSocket mCastSock = new MulticastSocket(3000);
		InetAddress ipGrupo = InetAddress.getByName("224.0.0.1");
		mCastSock.joinGroup(ipGrupo);

		while (true) {
			byte[] arrayDeBytes = new byte[1000];
			DatagramPacket info = new DatagramPacket(arrayDeBytes, arrayDeBytes.length);
			mCastSock.receive(info);

			System.out.println("Recibido de: " + info.getAddress());
			System.out.println("Por el puerto: " + info.getPort());
			System.out.println("Datos: " + new String(info.getData()));

		}
	}
}
