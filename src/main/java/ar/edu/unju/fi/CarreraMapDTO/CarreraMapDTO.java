package ar.edu.unju.fi.CarreraMapDTO;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.DTO.CarreraDTO;
import ar.edu.unju.fi.model.Carrera;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CarreraMapDTO {
	
	@Mapping(source = "codigo" , target = "codigo")
	@Mapping(source = "nombre",target = "nombre")
	@Mapping(source = "cantidadAnios",target = "cantidadAnios")
	@Mapping(source = "estado", target = "estado")
	
	CarreraDTO toCarreraDTO(Carrera d);

	@InheritInverseConfiguration
	Carrera toCarrera(CarreraDTO ddto);
	
	List<CarreraDTO> toCarreraDTOList (List<Carrera> listaC); //object
	List<Carrera> ToCarreraList (List<CarreraDTO> listaDDTO); //list
}
