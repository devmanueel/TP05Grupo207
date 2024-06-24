package ar.edu.unju.fi.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.DTO.MateriaDTO;
import ar.edu.unju.fi.model.Materia;

@Service
public interface MateriaService {
		public List<MateriaDTO> MostrarMateria(); 
		MateriaDTO findByCodigo(String codigo); 
		boolean save (MateriaDTO materiaDTO);
		void deleteByCodigo(String codigo);
		void edit(MateriaDTO materiaDTO);
		public Materia buscaMateria(String codigo);		
}
