package ej_repaso_Sorteo;

public class Participante extends Thread {
	ResultadoSorteo resultado;
	int numeroBoleto;

	public Participante(ResultadoSorteo resultado, int numeroBoleto) {
		super();
		this.resultado = resultado;
		this.numeroBoleto = numeroBoleto;
	}
	
	
	@Override
	public void run() {
		
		synchronized (this) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(numeroBoleto==resultado.consultarNumeroPremiado()) {
				System.out.println("Soy el hilo "+ this.getName() + " ¡He ganado el sorteo!");
			}else {
				System.out.println("Soy el hilo "+ this.getName() + " no ha habido suerte");
			}
		}
	}
	

}
