package ej_repaso_Sorteo;

import java.util.ArrayList;

public class Programa {

	public static void main(String[] args) {
		ResultadoSorteo resultado= new ResultadoSorteo();
		ArrayList<Participante> lista = new ArrayList<>();
		int participantes=5;
		
		for (int i = 0; i < participantes; i++) {
			Participante p = new Participante(resultado, i);
			lista.add(p);
			p.start();
		}
		Sorteo sorteo = new Sorteo(resultado, participantes);
		sorteo.start();
		try {
			sorteo.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Participante p:lista) {
				synchronized (p) {
					p.notify();
					
					
					}
		}	
		
		lista.forEach(x->{
			try {
				x.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		System.out.println("Hay ganador: El numero premiado ha sido "+resultado.consultarNumeroPremiado());
	}

}
