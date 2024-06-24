package ar.edu.unju.fi.map;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import ar.edu.unju.fi.DTO.MateriaDTO;
import ar.edu.unju.fi.model.Materia;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)

public interface MateriaMapDTO {
	
	@Mapping(source = "codigo",target = "codigo")
	@Mapping(source = "nombre",target = "nombre") 
	@Mapping(source = "curso",target = "curso")
	@Mapping(source = "cantidadHoras",target = "cantidadHoras")
	@Mapping(source = "modalidad",target = "modalidad")
	@Mapping(source = "estado",target = "estado")
	
	MateriaDTO toMateriaDTO(Materia m);
	
	@InheritInverseConfiguration
	Materia toMateria(MateriaDTO mdto); 
		
	List<MateriaDTO> toMateriaDTOList (List<Materia> listaM);
	
	List<Materia> toMateriaList (List<MateriaDTO> listaMDTO);
	
}
