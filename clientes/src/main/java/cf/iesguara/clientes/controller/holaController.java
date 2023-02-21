package cf.iesguara.clientes.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class holaController {
	
	private String plantilla= "¡Hola!";
	
	@GetMapping("/hola")
	public @ResponseBody
	String getResponsString() {
		return plantilla;
	}
	
	@GetMapping("/hola2")
	public ResponseEntity<String> Message(){
		return new ResponseEntity<>(plantilla+"2",HttpStatus.OK);	
	}
}
