package ar.edu.unju.fi.map;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.DTO.DocenteDTO;
import ar.edu.unju.fi.model.Docente;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CarreraMapDTO {
	
	@Mapping(source = "nombre",target = "nombre") //De donde viene de CARRERA hasta donde llega DTO 
	@Mapping(source = "apellido",target = "apellido")
	@Mapping(source = "email",target = "email")
	DocenteDTO convertirDocenteADocenteDTO(Docente d);
	
}
