package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Component
@Data
@Entity

public class Materia {
	@Id
	private String codigo;
	
	private String nombre;
	private String curso;
	private int cantidadHoras;
	private Modalidad modalidad;
	private Boolean estado;

}