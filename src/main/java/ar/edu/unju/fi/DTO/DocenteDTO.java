package ar.edu.unju.fi.DTO;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Component

public class DocenteDTO {
	
	private String legajo;
	private String nombre;
	private String apellido;
    private String email;
    private String telefono;
    private Boolean estado;
    private String foto;
}
