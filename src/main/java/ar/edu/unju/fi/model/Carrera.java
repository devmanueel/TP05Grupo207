package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Component
public class Carrera {
	
	@Id
	private String codigo;
	@NonNull
	private String nombre;
	@NonNull
	private Integer cantidadAnios;
	@NonNull
	private boolean estado;
}
