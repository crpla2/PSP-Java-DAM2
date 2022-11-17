package ej10_minaPuertoCuartel;

import java.util.ArrayList;

public class Programa {
	public static void main(String[] args) throws InterruptedException {
		ArrayList<Thread>lista=new ArrayList<>();
		Mina mina = new Mina(0);
		Puerto puertoAlgeciras = new Puerto(0, mina, "Algeciras");
		Puerto puertoBarcelona = new Puerto(0, mina, "Barcelona");
		Puerto puertoBilbao = new Puerto(0, mina, "Bilbao");
		PuertoSubcontratado puertoTanger = new PuertoSubcontratado(0, "Tanger", mina);
		PuertoSubcontratado puertoMarsella = new PuertoSubcontratado(0, "Marsella", mina);
		PuertoSubcontratado puertoGenova = new PuertoSubcontratado(0, "Genova", mina);
		
		System.out.println(mina);
		Thread hiloMinero = new Thread(new Minero(mina));
		Thread hiloMinero2 = new Thread(new Minero(mina, 2000));
		hiloMinero.start();
		hiloMinero2.start();
		
		System.out.println(mina);
		
	//Construccion secuencial:
		puertoAlgeciras.construirEnCola();
		puertoBarcelona.construirEnCola();
		puertoBilbao.construirEnCola();
	//Recuento:
		System.out.println(puertoAlgeciras);
		System.out.println(puertoBarcelona);
		System.out.println(puertoBilbao);
		
	//Construcción  multihilo:
		//Mis puertos
		Thread hiloAlgeciras1= new Thread(puertoAlgeciras);
		Thread hiloAlgeciras2= new Thread(puertoAlgeciras);
		Thread hiloAlgeciras3= new Thread(puertoAlgeciras);
		Thread hiloAlgeciras4= new Thread(puertoAlgeciras);
		lista.add(hiloAlgeciras1);
		lista.add(hiloAlgeciras2);
		lista.add(hiloAlgeciras3);
		lista.add(hiloAlgeciras4);
		Thread hiloBarcelona1= new Thread(puertoBarcelona);
		Thread hiloBarcelona2= new Thread(puertoBarcelona);
		Thread hiloBarcelona3= new Thread(puertoBarcelona);
		lista.add(hiloBarcelona1);
		lista.add(hiloBarcelona2);
		lista.add(hiloBarcelona3);
		Thread hiloBilbao1= new Thread(puertoBilbao);
		Thread hiloBilbao2= new Thread(puertoBilbao);
		lista.add(hiloBilbao1);
		lista.add(hiloBilbao2);
		//Subcontratas
		lista.add(puertoMarsella);
		lista.add(puertoTanger);
		lista.add(puertoGenova);
		//Esperando financiación...
		lista.forEach(x->x.start());
		
	//Recuento:
		lista.forEach(x->{
			try {
				x.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		//Imprime stock
		System.out.println(puertoAlgeciras);
		System.out.println(puertoBarcelona);
		System.out.println(puertoBilbao);
		System.out.println(puertoTanger);
		System.out.println(puertoMarsella);

		System.out.println(mina);
	}
}
