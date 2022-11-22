package ej_repaso_Sorteo;

public class Sorteo extends Thread {
	ResultadoSorteo resultado;
	int participantes;
	
	public Sorteo(ResultadoSorteo resultado, int participantes) {
		super();
		this.resultado = resultado;
		this.participantes = participantes;
	}

	@Override
	public void run() {
		try {
			this.sleep(3000);
			resultado.establecerNumeroPremiado((int)(Math.random()*participantes + 1));
			System.out.println("Sorteo realizado: El número premiado ha sido el "+resultado.consultarNumeroPremiado());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	

}
