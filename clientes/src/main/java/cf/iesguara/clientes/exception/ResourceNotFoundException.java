package cf.iesguara.clientes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombreRecurso;
	private String nombreCampo;
	private Object valorCampo;
	
	public ResourceNotFoundException(String nombreRecurso, String nombreCampo, Object valorCampo) {
		super(String.format("recurso '%s' no encontrado con %s = %s", nombreRecurso,nombreCampo,valorCampo));
		this.nombreRecurso = nombreRecurso;
		this.nombreCampo = nombreCampo;
		this.valorCampo = valorCampo;
	}

	public String getNombreRecurso() {
		return nombreRecurso;
	}

	public String getNombreCampo() {
		return nombreCampo;
	}

	public Object getValorCampo() {
		return valorCampo;
	}

	

	
	
	
	
	
	

}
