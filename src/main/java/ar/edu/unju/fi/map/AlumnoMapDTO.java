 	package ar.edu.unju.fi.map;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.DTO.AlumnoDTO;
import ar.edu.unju.fi.model.Alumno;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AlumnoMapDTO {
	@Mapping(source = "dni",target = "dni")
	@Mapping(source = "nombre",target = "nombre")
	@Mapping(source = "apellido",target = "apellido")
	@Mapping(source = "email",target = "email")
	@Mapping(source = "telefono",target = "telefono")
	@Mapping(source = "fechaNacimiento", target = "fechaNacimiento", dateFormat = "dd/MM/yyyy")
	@Mapping(source = "domicilio",target = "domicilio")
	@Mapping(source = "LU",target = "LU")
	@Mapping(source = "foto",target = "foto")
	@Mapping(source = "estado",target = "estado")
	
	
	
	
	
	AlumnoDTO toAlumnoDTO(Alumno a);
	@InheritInverseConfiguration
	Alumno toAlumno(AlumnoDTO adto); 
		
	List<AlumnoDTO> toAlumnoDTOList (List<Alumno> listaA);
	
	List<Alumno> ToDocenteList (List<AlumnoDTO> listaADTO);
}
