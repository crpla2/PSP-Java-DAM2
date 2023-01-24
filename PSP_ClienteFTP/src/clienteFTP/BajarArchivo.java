package clienteFTP;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class BajarArchivo {

	public static void main(String[] args) throws IOException {
		FTPClient cliente= new FTPClient();
		cliente.connect("127.0.0.1");
		boolean conectado=cliente.login("user", "password");
		cliente.setFileType(FTP.BINARY_FILE_TYPE);
		
		if(conectado) {
			System.out.println("Login correcto");
			File archivoLocal = new File("./ficheroteo2.txt");
			BufferedOutputStream streamLocal = new BufferedOutputStream(new FileOutputStream(archivoLocal));
			if(cliente.retrieveFile("/carpeta/bb.txt", streamLocal)) {
				System.out.println("Fichero descargado");
			}else {
				System.out.println("Error en la descarga");
				
			}streamLocal.close();
			
		}else {
			System.err.println("Error en el login");
		}
		cliente.disconnect();
	}

}
