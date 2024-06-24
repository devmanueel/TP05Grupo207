package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Component
@Data
@Entity

public class Docente {
	@Id
	private String legajo;
	
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private Boolean estado;
    private String foto;
}
