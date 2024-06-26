package ar.edu.unju.fi.DTO;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Component
@NoArgsConstructor
public class CarreraDTO {
	private String codigo;
	private String nombre;
	private Integer cantidadAnios;
	private boolean estado;
}