package ar.edu.unju.fi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor

public class Carrera {

	private String codigo;
	@NonNull
	private String nombre;
	@NonNull
	private Integer cantidadAnios;
	private Boolean estado;
	
	
}
