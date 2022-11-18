package ej11_coleccionConcurrente;

import java.util.concurrent.ConcurrentHashMap;

public class Hilo extends Thread {
	ConcurrentHashMap<String, String>mapa;
	
	
	public Hilo(ConcurrentHashMap<String, String> mapa) {
		super();
		this.mapa = mapa;
	}


	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			mapa.put("Barcelona", "España");
			System.out.println("Insertando Barcelona");
			mapa.put("Madrid", "España");
			System.out.println("Insertando Madrid");
			mapa.put("Valencia", "España");
			System.out.println("Insertando Valencia");
			mapa.put("Paris", "Francia");
			System.out.println("Insertando Paris");
		}
	}

	
}
