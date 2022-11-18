package ej11_coleccionConcurrente;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class Programa {

	public static void main(String[] args) throws InterruptedException {
		ConcurrentHashMap<String, String> mapa= new ConcurrentHashMap<>();
	
		Hilo h;
		ArrayList<Hilo>hijos= new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			h= new Hilo(mapa);
			h.start();
			hijos.add(h);
		}

		for(Hilo hilo:hijos) {
			hilo.join();
		}
		System.out.println(mapa);
	}

}
