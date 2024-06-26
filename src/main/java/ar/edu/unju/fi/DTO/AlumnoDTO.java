package ar.edu.unju.fi.DTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Component
public class AlumnoDTO {
	private String dni;

    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    private LocalDate fechaNacimiento;
    private String domicilio;
    private String LU;
    private String foto;
    private Boolean estado;
    
    
    public String getFechaNacimientoForHtml() {
        return fechaNacimiento != null ? fechaNacimiento.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) : "";
        
    }
    
    
}

