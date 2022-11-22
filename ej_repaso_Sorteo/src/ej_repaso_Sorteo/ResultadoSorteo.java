package ej_repaso_Sorteo;

public class ResultadoSorteo {
	private int numeroPremiado;

	public ResultadoSorteo() {
		super();
	}

	public synchronized int consultarNumeroPremiado() {
		return numeroPremiado;
	}

	public synchronized void establecerNumeroPremiado(int numeroPremiado) {
		this.numeroPremiado = numeroPremiado;
	}

}
