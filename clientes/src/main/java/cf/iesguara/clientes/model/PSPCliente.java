package cf.iesguara.clientes.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name= "pspcliente")
public class PSPCliente {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String nombre;
	@Column(name= "primer_apellido", nullable = false)
	private String primerApellido;
	@Column(name= "segundo_apellido", nullable = true)
	private String segundoApellido;
	@Column(unique = true)
	private String email;
	
}
