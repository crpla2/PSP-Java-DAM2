package clienteFTP;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class SubirArchivo {

	public static void main(String[] args) throws IOException {
		FTPClient cliente= new FTPClient();
		cliente.connect("127.0.0.1");
		boolean conectado=cliente.login("user", "password");
		//Para establecer modo pasivo(depende de la configuracion del servidor)
		//cliente.enterLocalPassiveMode();
		
		//Le decimos el tipo de ficheros que vamos a subir
		cliente.setFileType(FTP.BINARY_FILE_TYPE);
		if(conectado) {
			System.out.println("Login correcto");
			File archivosubida= new File("./Archivo/modelo_convalidacion.pdf");
			FileInputStream is= new FileInputStream(archivosubida);
			OutputStream os=cliente.storeFileStream("socketsEnJava4.pdf");
			//Preparar el buffer
			byte[] buffer= new byte[1024];
			int bytesLeidos=0;
			//hacer un bucle para enviar los bytes del archivo
			while((bytesLeidos=is.read(buffer))!=-1) {
				os.write(buffer,0,bytesLeidos);
			}
			is.close();
			os.close();
			if(cliente.completePendingCommand()) {
				System.out.println("Archivo subido correctamente");
			}else {
				System.err.println("Error!");
			}
		}else {
			System.err.println("Error en el login");
		}
		cliente.disconnect();
	}

}
