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

	@Mapping(source="nombre", target="nombre")
	@Mapping(source="apellido", target="apellido")
	@Mapping(source="email", target="email")
	@Mapping(source="telefono", target="telefono")
	@Mapping(target="fechaNacimiento", ignore=true)
	@Mapping(target="domicilio", ignore=true)
	@Mapping(target="LU", ignore=true)
	@Mapping(source="estado", target="estado")
	@Mapping(target="domicilio", ignore=true)
	
	AlumnoDTO toAlumnoDTO(Alumno d);
	
	@InheritInverseConfiguration
	AlumnoDTO convertirAlumnoDTOAAlumno(AlumnoDTO ddto);
	
	List<AlumnoDTO> toAlumnoDTOList (List<Alumno> ListaA);
	
	List<Alumno> toAlumnoList (List<AlumnoDTO> listaADTO);
	
}
