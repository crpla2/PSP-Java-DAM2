package ej01_lanzarPrograma;

import java.io.IOException;

public class LanzarFirefox {

	public static void main(String[] args) throws IOException {
		Process proceso= new ProcessBuilder("/usr/bin/firefox","https://educa.aragon.es").start();
	}

}
