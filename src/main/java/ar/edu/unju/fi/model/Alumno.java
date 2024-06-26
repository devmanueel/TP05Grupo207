package ar.edu.unju.fi.model;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Component
@Data
@Entity
public class Alumno {
	@Id
	private String dni;
	
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaNacimiento;
    private String domicilio;
    private String LU;
    private String foto;
    private Boolean estado;
}
