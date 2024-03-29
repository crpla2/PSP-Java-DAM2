package cf.iesguara.clientes.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cf.iesguara.clientes.model.S_Aula;
import cf.iesguara.clientes.service.AulaService;

@RestController
@RequestMapping("/aulas")
public class AulaController {
	
	@Autowired
	private AulaService aulaService;

	public AulaController(AulaService aulaService) {
		super();
		this.aulaService = aulaService;
	}
	
	//GET=> /aulas/23 <-- 23 sería un ejemplo de id
	
	@GetMapping("{id}")
	public ResponseEntity<S_Aula> mostrarAula(@PathVariable("id") long idCliente){
		return new ResponseEntity<S_Aula>(aulaService.mostrarAulaId(idCliente),HttpStatus.OK);	
	}
	
	@PostMapping
	public ResponseEntity<S_Aula> guardarAula(@RequestBody S_Aula aula){
		return new ResponseEntity<S_Aula>(aulaService.guardarAula(aula), HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public ResponseEntity<List <S_Aula>> mostrarAulas(){
		return new ResponseEntity<List<S_Aula>>(aulaService.mostrarAulas(),HttpStatus.OK);
		
	}
}
